/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.workflow.kaleo.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.NoSuchLogException;
import com.liferay.portal.workflow.kaleo.definition.LogType;
import com.liferay.portal.workflow.kaleo.model.KaleoAction;
import com.liferay.portal.workflow.kaleo.model.KaleoInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoLog;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceAssignment;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;
import com.liferay.portal.workflow.kaleo.service.base.KaleoLogLocalServiceBaseImpl;
import com.liferay.portal.workflow.kaleo.util.ContextUtil;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <a href="KaleoLogLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 */
public class KaleoLogLocalServiceImpl extends KaleoLogLocalServiceBaseImpl {

	public KaleoLog addActionExecutionKaleoLog(
			KaleoInstanceToken kaleoInstanceToken, KaleoAction kaleoAction,
			long startTime, long endTime, String comment,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoLog kaleoLog = createKaleoLog(
			kaleoInstanceToken, LogType.ACTION_EXECUTION, serviceContext);

		kaleoLog.setKaleoNodeId(kaleoAction.getKaleoNodeId());
		kaleoLog.setKaleoNodeName(kaleoAction.getKaleoNodeName());
		kaleoLog.setComment(comment);
		kaleoLog.setStartDate(new Date(startTime));
		kaleoLog.setEndDate(new Date(endTime));
		kaleoLog.setDuration(endTime - startTime);

		kaleoLogPersistence.update(kaleoLog, false);

		return kaleoLog;
	}

	public KaleoLog addNodeEntryKaleoLog(
			KaleoInstanceToken kaleoInstanceToken, KaleoNode sourceKaleoNode,
			KaleoNode targetKaleoNode, ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoLog kaleoLog = createKaleoLog(
			kaleoInstanceToken, LogType.NODE_ENTRY, serviceContext);

		kaleoLog.setKaleoNodeId(targetKaleoNode.getKaleoNodeId());
		kaleoLog.setKaleoNodeName(targetKaleoNode.getName());
		kaleoLog.setTerminalKaleoNode(targetKaleoNode.isTerminal());

		if (sourceKaleoNode != null) {
			kaleoLog.setPreviousKaleoNodeId(sourceKaleoNode.getKaleoNodeId());
			kaleoLog.setPreviousKaleoNodeName(sourceKaleoNode.getName());
		}

		kaleoLog.setStartDate(kaleoLog.getCreateDate());

		kaleoLogPersistence.update(kaleoLog, false);

		return kaleoLog;
	}

	public KaleoLog addNodeExitKaleoLog(
			KaleoInstanceToken kaleoInstanceToken, KaleoNode departingKaleoNode,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoLog kaleoLog = createKaleoLog(
			kaleoInstanceToken, LogType.NODE_EXIT, serviceContext);

		kaleoLog.setKaleoNodeId(departingKaleoNode.getKaleoNodeId());
		kaleoLog.setKaleoNodeName(departingKaleoNode.getName());
		kaleoLog.setEndDate(kaleoLog.getCreateDate());

		try {
			KaleoLog previousKaleoLog = getPreviousLog(
				kaleoLog.getKaleoInstanceTokenId(), kaleoLog.getKaleoNodeId(),
				LogType.WORKFLOW_INSTANCE_START);

			Date startDate = previousKaleoLog.getStartDate();
			Date endDate = kaleoLog.getEndDate();

			kaleoLog.setDuration(endDate.getTime() - startDate.getTime());
		}
		catch (NoSuchLogException nsle) {
		}

		kaleoLogPersistence.update(kaleoLog, false);

		return kaleoLog;
	}

	public KaleoLog addTaskAssignmentKaleoLog(
			KaleoTaskInstanceToken kaleoTaskInstanceToken,
			KaleoTaskInstanceAssignment previousKaleoTaskAssignment,
			KaleoTaskInstanceAssignment newKaleoTaskAssignment,
			String comment, Map<String, Serializable> context,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoInstanceToken kaleoInstanceToken =
			kaleoTaskInstanceToken.getKaleoInstanceToken();

		KaleoLog kaleoLog = createKaleoLog(
			kaleoInstanceToken, LogType.TASK_ASSIGNMENT, serviceContext);

		kaleoLog.setKaleoTaskInstanceTokenId(
			kaleoTaskInstanceToken.getKaleoTaskInstanceTokenId());

		KaleoNode currentKaleoNode = kaleoInstanceToken.getCurrentKaleoNode();

		kaleoLog.setKaleoNodeId(currentKaleoNode.getKaleoNodeId());
		kaleoLog.setKaleoNodeName(currentKaleoNode.getName());

		if (previousKaleoTaskAssignment != null) {
			kaleoLog.setPreviousAssigneeClassName(
				previousKaleoTaskAssignment.getAssigneeClassName());
			kaleoLog.setPreviousAssigneeClassPK(
				previousKaleoTaskAssignment.getAssigneeClassPK());
		}

		kaleoLog.setCurrentAssigneeClassName(
			newKaleoTaskAssignment.getAssigneeClassName());
		kaleoLog.setCurrentAssigneeClassPK(
			newKaleoTaskAssignment.getAssigneeClassPK());

		kaleoLog.setComment(comment);
		kaleoLog.setContext(ContextUtil.convert(context));

		kaleoLogPersistence.update(kaleoLog, false);

		return kaleoLog;
	}

	public KaleoLog addTaskCompletionKaleoLog(
			KaleoTaskInstanceToken kaleoTaskInstanceToken,
			KaleoTaskInstanceAssignment kaleoTaskInstanceAssignment,
			String comment, Map<String, Serializable> context,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoInstanceToken kaleoInstanceToken =
			kaleoTaskInstanceToken.getKaleoInstanceToken();

		KaleoLog kaleoLog = createKaleoLog(
			kaleoInstanceToken, LogType.TASK_COMPLETION, serviceContext);

		kaleoLog.setKaleoTaskInstanceTokenId(
			kaleoTaskInstanceToken.getKaleoTaskInstanceTokenId());

		KaleoNode currentKaleoNode = kaleoInstanceToken.getCurrentKaleoNode();

		kaleoLog.setKaleoNodeId(currentKaleoNode.getKaleoNodeId());
		kaleoLog.setKaleoNodeName(currentKaleoNode.getName());

		kaleoLog.setCurrentAssigneeClassPK(
			kaleoTaskInstanceAssignment.getAssigneeClassPK());
		kaleoLog.setCurrentAssigneeClassName(
			kaleoTaskInstanceAssignment.getAssigneeClassName());
		kaleoLog.setComment(comment);
		kaleoLog.setContext(ContextUtil.convert(context));

		kaleoLogPersistence.update(kaleoLog, false);

		return kaleoLog;
	}

	public KaleoLog addWorkflowInstanceEndKaleoLog(
			KaleoInstanceToken kaleoInstanceToken,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoLog kaleoLog = createKaleoLog(
			kaleoInstanceToken, LogType.WORKFLOW_INSTANCE_END, serviceContext);

		kaleoLog.setEndDate(kaleoLog.getCreateDate());

		try {
			KaleoLog previousKaleoLog = getPreviousLog(
				kaleoLog.getKaleoInstanceTokenId(), 0,
				LogType.WORKFLOW_INSTANCE_START);

			Date startDate = previousKaleoLog.getStartDate();
			Date endDate = kaleoLog.getEndDate();

			kaleoLog.setDuration(endDate.getTime() - startDate.getTime());
		}
		catch (NoSuchLogException nsle) {
		}

		kaleoLogPersistence.update(kaleoLog, false);

		return kaleoLog;
	}

	public KaleoLog addWorkflowInstanceStartKaleoLog(
			KaleoInstanceToken kaleoInstanceToken,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoLog kaleoLog = createKaleoLog(
			kaleoInstanceToken, LogType.WORKFLOW_INSTANCE_START,
			serviceContext);

		kaleoLog.setStartDate(kaleoLog.getCreateDate());

		KaleoInstance kaleoInstance = kaleoInstanceToken.getKaleoInstance();

		kaleoLog.setContext(kaleoInstance.getContext());

		kaleoLogPersistence.update(kaleoLog, false);

		return kaleoLog;
	}

	public List<KaleoLog> getKaleoLogs(
			long kaleoTaskInstanceTokenId, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return kaleoLogPersistence.findByKaleoTaskInstanceTokenId(
			kaleoTaskInstanceTokenId, start, end, orderByComparator);
	}

	public int getKaleoLogsCount(long kaleoTaskInstanceTokenId)
		throws SystemException {

		return kaleoLogPersistence.countByKaleoTaskInstanceTokenId(
			kaleoTaskInstanceTokenId);
	}

	protected KaleoLog createKaleoLog(
			KaleoInstanceToken kaleoInstanceToken, LogType logType,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getUserId());
		Date now = new Date();

		long kaleoLogId = counterLocalService.increment();

		KaleoLog kaleoLog = kaleoLogPersistence.create(kaleoLogId);

		kaleoLog.setCompanyId(user.getCompanyId());
		kaleoLog.setUserId(user.getUserId());
		kaleoLog.setUserName(user.getScreenName());
		kaleoLog.setCreateDate(now);
		kaleoLog.setModifiedDate(now);
		kaleoLog.setKaleoInstanceId(kaleoInstanceToken.getKaleoInstanceId());
		kaleoLog.setKaleoInstanceTokenId(
			kaleoInstanceToken.getKaleoInstanceTokenId());
		kaleoLog.setType(logType.name());

		return kaleoLog;
	}

	protected KaleoLog getPreviousLog(
			long kaleoInstanceTokenId, long kaleoNodeId, LogType logType)
		throws PortalException, SystemException {

		List<KaleoLog> kaleoLogEntries = null;

		if (kaleoNodeId > 0) {
			kaleoLogEntries = kaleoLogPersistence.findByKITI_KNI_T(
				kaleoInstanceTokenId, kaleoNodeId, logType.name());
		}
		else {
			kaleoLogEntries = kaleoLogPersistence.findByKITI_T(
				kaleoInstanceTokenId, logType.name());
		}

		if (!kaleoLogEntries.isEmpty()) {
			return kaleoLogEntries.get(0);
		}

		throw new NoSuchLogException();
	}

}