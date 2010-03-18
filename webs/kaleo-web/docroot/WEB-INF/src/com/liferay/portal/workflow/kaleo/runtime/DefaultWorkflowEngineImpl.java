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

package com.liferay.portal.workflow.kaleo.runtime;

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.workflow.kaleo.WorkflowInstanceAdapter;
import com.liferay.portal.workflow.kaleo.definition.Definition;
import com.liferay.portal.workflow.kaleo.deployment.WorkflowDeployer;
import com.liferay.portal.workflow.kaleo.model.KaleoInstance;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.model.KaleoNode;
import com.liferay.portal.workflow.kaleo.model.KaleoTransition;
import com.liferay.portal.workflow.kaleo.parser.WorkflowModelParser;
import com.liferay.portal.workflow.kaleo.parser.WorkflowValidator;
import com.liferay.portal.workflow.kaleo.runtime.graph.GraphWalker;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceLocalServiceUtil;

import java.io.InputStream;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <a href="DefaultWorkflowEngineImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Michael C. Han
 */
public class DefaultWorkflowEngineImpl implements WorkflowEngine {

	public void deleteWorkflowInstance(
			long workflowInstanceId, ServiceContext serviceContext)
		throws WorkflowException {

		try {
			KaleoInstanceLocalServiceUtil.deleteKaleoInstance(
				workflowInstanceId);
		}
		catch (Exception e) {
			throw new WorkflowException(e);
		}
	}

	@Transactional(
		isolation = Isolation.PORTAL,
		rollbackFor = {PortalException.class, SystemException.class})
	public WorkflowDefinition deployWorkflowDefinition(
			InputStream inputStream, ServiceContext serviceContext)
		throws WorkflowException {

		try {
			Definition definition = _workflowModelParser.parse(inputStream);

			if (_workflowValidator != null) {
				_workflowValidator.validate(definition);
			}

			WorkflowDefinition workflowDefinition = _workflowDeployer.deploy(
				definition, serviceContext);

			return workflowDefinition;
		}
		catch (Exception e) {
			throw new WorkflowException(e);
		}
	}

	public List<String> getNextTransitionNames(
			long workflowInstanceId, ServiceContext serviceContext)
		throws WorkflowException {

		try {
			KaleoInstance kaleoInstance =
				KaleoInstanceLocalServiceUtil.getKaleoInstance(
					workflowInstanceId);

			KaleoInstanceToken rootKaleoInstanceToken =
				kaleoInstance.getRootKaleoInstanceToken(null, serviceContext);

			List<String> transitionNames = new ArrayList<String>();

			getNextTransitionNames(rootKaleoInstanceToken, transitionNames);

			return transitionNames;
		}
		catch (Exception e) {
			throw new WorkflowException(e);
		}
	}

	public WorkflowInstance getWorkflowInstance(
			long workflowInstanceId, ServiceContext serviceContext)
		throws WorkflowException {

		try {
			KaleoInstance kaleoInstance =
				KaleoInstanceLocalServiceUtil.getKaleoInstance(
					workflowInstanceId);

			KaleoInstanceToken rootKaleoInstanceToken =
				kaleoInstance.getRootKaleoInstanceToken(serviceContext);

			return new WorkflowInstanceAdapter(
				kaleoInstance, rootKaleoInstanceToken);
		}
		catch (Exception e) {
			throw new WorkflowException(e);
		}
	}

	public int getWorkflowInstanceCount(
			String workflowDefinitionName, int workflowDefinitionVersion,
			boolean completed, ServiceContext serviceContext)
		throws WorkflowException {

		try {
			return KaleoInstanceLocalServiceUtil.getKaleoInstancesCount(
				workflowDefinitionName, workflowDefinitionVersion, completed,
				serviceContext);
		}
		catch (Exception e) {
			throw new WorkflowException(e);
		}
	}

	public List<WorkflowInstance> getWorkflowInstances(
			String workflowDefinitionName, int workflowDefinitionVersion,
			boolean completed, int start, int end,
			OrderByComparator orderByComparator, ServiceContext serviceContext)
		throws WorkflowException {

		try {
			List<KaleoInstance> kaleoInstances =
				KaleoInstanceLocalServiceUtil.getKaleoInstances(
					workflowDefinitionName, workflowDefinitionVersion,
					completed, start, end, orderByComparator, serviceContext);

			return toWorkflowInstances(kaleoInstances, serviceContext);
		}
		catch (Exception e) {
			throw new WorkflowException(e);
		}
	}

	public void setGraphWalker(GraphWalker graphWalker) {
		_graphWalker = graphWalker;
	}

	public void setWorkflowDeployer(WorkflowDeployer workflowDeployer) {
		_workflowDeployer = workflowDeployer;
	}

	public void setWorkflowModelParser(
		WorkflowModelParser workflowModelParser) {

		_workflowModelParser = workflowModelParser;
	}

	public void setWorkflowValidator(WorkflowValidator workflowValidator) {
		_workflowValidator = workflowValidator;
	}

	public WorkflowInstance signalWorkflowInstance(
			long workflowInstanceId, String transitionName,
			Map<String, Serializable> context, ServiceContext serviceContext)
		throws WorkflowException {

		try {
			KaleoInstance kaleoInstance = doUpdateContext(
				workflowInstanceId, context, serviceContext);

			KaleoInstanceToken kaleoInstanceToken =
				kaleoInstance.getRootKaleoInstanceToken(serviceContext);

			ExecutionContext executionContext = new ExecutionContext(
				kaleoInstanceToken, context, serviceContext);

			_graphWalker.signalExit(transitionName, executionContext);

			return new WorkflowInstanceAdapter(
				kaleoInstance, kaleoInstanceToken, context);
		}
		catch (Exception e) {
			throw new WorkflowException(e);
		}
	}

	public WorkflowInstance startWorkflowInstance(
			String workflowDefinitionName, Integer workflowDefinitionVersion,
			String transitionName, Map<String, Serializable> context,
			ServiceContext serviceContext)
		throws WorkflowException {

		try {
			ExecutionContext executionContext = _graphWalker.initialize(
				workflowDefinitionName, workflowDefinitionVersion, context,
				serviceContext);

			_graphWalker.signalEntry(transitionName, executionContext);

			KaleoInstanceToken kaleoInstanceToken =
				executionContext.getKaleoInstanceToken();
			KaleoInstance kaleoInstance = kaleoInstanceToken.getKaleoInstance();

			return new WorkflowInstanceAdapter(
				kaleoInstance, kaleoInstanceToken, context);
		}
		catch (Exception e) {
			throw new WorkflowException(e);
		}
	}
	
	public WorkflowInstance updateContext(
			long workflowInstanceId, Map<String, Serializable> context,
			ServiceContext serviceContext)
		throws WorkflowException {

		try {
			KaleoInstance kaleoInstance = doUpdateContext(
				workflowInstanceId, context, serviceContext);

			KaleoInstanceToken rootKaleoInstanceToken =
				kaleoInstance.getRootKaleoInstanceToken(serviceContext);

			return new WorkflowInstanceAdapter(
				kaleoInstance, rootKaleoInstanceToken);
		}
		catch (Exception e) {
			throw new WorkflowException(e);
		}
	}

	protected KaleoInstance doUpdateContext(
			long workflowInstanceId, Map<String, Serializable> context,
			ServiceContext serviceContext)
		throws Exception {

		return KaleoInstanceLocalServiceUtil.updateKaleoInstance(
			workflowInstanceId, context, serviceContext);
	}

	protected void getNextTransitionNames(
			KaleoInstanceToken kaleoInstanceToken, List<String> transitionNames)
		throws Exception {

		if (kaleoInstanceToken.hasIncompleteChildrenKaleoInstanceToken()) {
			List<KaleoInstanceToken> incompleteChildrenKaleoInstanceTokens =
				kaleoInstanceToken.getIncompleteChildrenKaleoInstanceTokens();

			for (KaleoInstanceToken incompleteChildrenKaleoInstanceToken :
					incompleteChildrenKaleoInstanceTokens) {

				getNextTransitionNames(
					incompleteChildrenKaleoInstanceToken, transitionNames);
			}
		}
		else {
			KaleoNode kaleoNode = kaleoInstanceToken.getCurrentKaleoNode();

			List<KaleoTransition> kaleoTransitions =
				kaleoNode.getKaleoTransitions();

			for (KaleoTransition kaleoTransition : kaleoTransitions) {
				transitionNames.add(kaleoTransition.getName());
			}
		}
	}

	protected List<WorkflowInstance> toWorkflowInstances(
			List<KaleoInstance> kaleoInstances, ServiceContext serviceContext)
		throws PortalException, SystemException {

		List<WorkflowInstance> workflowInstances =
			new ArrayList<WorkflowInstance>(kaleoInstances.size());

		for (KaleoInstance kaleoInstance : kaleoInstances) {
			KaleoInstanceToken rootKaleoInstanceToken =
				kaleoInstance.getRootKaleoInstanceToken(serviceContext);

			WorkflowInstanceAdapter workflowInstanceAdapter =
				new WorkflowInstanceAdapter(
					kaleoInstance, rootKaleoInstanceToken);

			workflowInstances.add(workflowInstanceAdapter);
		}

		return workflowInstances;
	}

	private GraphWalker _graphWalker;
	private WorkflowDeployer _workflowDeployer;
	private WorkflowModelParser _workflowModelParser;
	private WorkflowValidator _workflowValidator;

}