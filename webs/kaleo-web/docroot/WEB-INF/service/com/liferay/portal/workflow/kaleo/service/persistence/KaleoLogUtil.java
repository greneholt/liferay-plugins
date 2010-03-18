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

package com.liferay.portal.workflow.kaleo.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.workflow.kaleo.model.KaleoLog;

import java.util.List;

/**
 * <a href="KaleoLogUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       KaleoLogPersistence
 * @see       KaleoLogPersistenceImpl
 * @generated
 */
public class KaleoLogUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static KaleoLog remove(KaleoLog kaleoLog) throws SystemException {
		return getPersistence().remove(kaleoLog);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static KaleoLog update(KaleoLog kaleoLog, boolean merge)
		throws SystemException {
		return getPersistence().update(kaleoLog, merge);
	}

	public static void cacheResult(
		com.liferay.portal.workflow.kaleo.model.KaleoLog kaleoLog) {
		getPersistence().cacheResult(kaleoLog);
	}

	public static void cacheResult(
		java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoLog> kaleoLogs) {
		getPersistence().cacheResult(kaleoLogs);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoLog create(
		long kaleoLogId) {
		return getPersistence().create(kaleoLogId);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoLog remove(
		long kaleoLogId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.NoSuchLogException {
		return getPersistence().remove(kaleoLogId);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoLog updateImpl(
		com.liferay.portal.workflow.kaleo.model.KaleoLog kaleoLog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(kaleoLog, merge);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoLog findByPrimaryKey(
		long kaleoLogId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.NoSuchLogException {
		return getPersistence().findByPrimaryKey(kaleoLogId);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoLog fetchByPrimaryKey(
		long kaleoLogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(kaleoLogId);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoLog> findByKaleoTaskInstanceTokenId(
		long kaleoTaskInstanceTokenId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByKaleoTaskInstanceTokenId(kaleoTaskInstanceTokenId);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoLog> findByKaleoTaskInstanceTokenId(
		long kaleoTaskInstanceTokenId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByKaleoTaskInstanceTokenId(kaleoTaskInstanceTokenId,
			start, end);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoLog> findByKaleoTaskInstanceTokenId(
		long kaleoTaskInstanceTokenId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByKaleoTaskInstanceTokenId(kaleoTaskInstanceTokenId,
			start, end, orderByComparator);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoLog findByKaleoTaskInstanceTokenId_First(
		long kaleoTaskInstanceTokenId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.NoSuchLogException {
		return getPersistence()
				   .findByKaleoTaskInstanceTokenId_First(kaleoTaskInstanceTokenId,
			orderByComparator);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoLog findByKaleoTaskInstanceTokenId_Last(
		long kaleoTaskInstanceTokenId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.NoSuchLogException {
		return getPersistence()
				   .findByKaleoTaskInstanceTokenId_Last(kaleoTaskInstanceTokenId,
			orderByComparator);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoLog[] findByKaleoTaskInstanceTokenId_PrevAndNext(
		long kaleoLogId, long kaleoTaskInstanceTokenId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.NoSuchLogException {
		return getPersistence()
				   .findByKaleoTaskInstanceTokenId_PrevAndNext(kaleoLogId,
			kaleoTaskInstanceTokenId, orderByComparator);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoLog> findByKITI_T(
		long kaleoInstanceTokenId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByKITI_T(kaleoInstanceTokenId, type);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoLog> findByKITI_T(
		long kaleoInstanceTokenId, java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByKITI_T(kaleoInstanceTokenId, type, start, end);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoLog> findByKITI_T(
		long kaleoInstanceTokenId, java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByKITI_T(kaleoInstanceTokenId, type, start, end,
			orderByComparator);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoLog findByKITI_T_First(
		long kaleoInstanceTokenId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.NoSuchLogException {
		return getPersistence()
				   .findByKITI_T_First(kaleoInstanceTokenId, type,
			orderByComparator);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoLog findByKITI_T_Last(
		long kaleoInstanceTokenId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.NoSuchLogException {
		return getPersistence()
				   .findByKITI_T_Last(kaleoInstanceTokenId, type,
			orderByComparator);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoLog[] findByKITI_T_PrevAndNext(
		long kaleoLogId, long kaleoInstanceTokenId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.NoSuchLogException {
		return getPersistence()
				   .findByKITI_T_PrevAndNext(kaleoLogId, kaleoInstanceTokenId,
			type, orderByComparator);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoLog> findByKITI_KNI_T(
		long kaleoInstanceTokenId, long kaleoNodeId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByKITI_KNI_T(kaleoInstanceTokenId, kaleoNodeId, type);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoLog> findByKITI_KNI_T(
		long kaleoInstanceTokenId, long kaleoNodeId, java.lang.String type,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByKITI_KNI_T(kaleoInstanceTokenId, kaleoNodeId, type,
			start, end);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoLog> findByKITI_KNI_T(
		long kaleoInstanceTokenId, long kaleoNodeId, java.lang.String type,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByKITI_KNI_T(kaleoInstanceTokenId, kaleoNodeId, type,
			start, end, orderByComparator);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoLog findByKITI_KNI_T_First(
		long kaleoInstanceTokenId, long kaleoNodeId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.NoSuchLogException {
		return getPersistence()
				   .findByKITI_KNI_T_First(kaleoInstanceTokenId, kaleoNodeId,
			type, orderByComparator);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoLog findByKITI_KNI_T_Last(
		long kaleoInstanceTokenId, long kaleoNodeId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.NoSuchLogException {
		return getPersistence()
				   .findByKITI_KNI_T_Last(kaleoInstanceTokenId, kaleoNodeId,
			type, orderByComparator);
	}

	public static com.liferay.portal.workflow.kaleo.model.KaleoLog[] findByKITI_KNI_T_PrevAndNext(
		long kaleoLogId, long kaleoInstanceTokenId, long kaleoNodeId,
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.workflow.kaleo.NoSuchLogException {
		return getPersistence()
				   .findByKITI_KNI_T_PrevAndNext(kaleoLogId,
			kaleoInstanceTokenId, kaleoNodeId, type, orderByComparator);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<com.liferay.portal.workflow.kaleo.model.KaleoLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	public static void removeByKaleoTaskInstanceTokenId(
		long kaleoTaskInstanceTokenId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByKaleoTaskInstanceTokenId(kaleoTaskInstanceTokenId);
	}

	public static void removeByKITI_T(long kaleoInstanceTokenId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByKITI_T(kaleoInstanceTokenId, type);
	}

	public static void removeByKITI_KNI_T(long kaleoInstanceTokenId,
		long kaleoNodeId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByKITI_KNI_T(kaleoInstanceTokenId, kaleoNodeId, type);
	}

	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	public static int countByKaleoTaskInstanceTokenId(
		long kaleoTaskInstanceTokenId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByKaleoTaskInstanceTokenId(kaleoTaskInstanceTokenId);
	}

	public static int countByKITI_T(long kaleoInstanceTokenId,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByKITI_T(kaleoInstanceTokenId, type);
	}

	public static int countByKITI_KNI_T(long kaleoInstanceTokenId,
		long kaleoNodeId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByKITI_KNI_T(kaleoInstanceTokenId, kaleoNodeId, type);
	}

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static KaleoLogPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (KaleoLogPersistence)PortletBeanLocatorUtil.locate(com.liferay.portal.workflow.kaleo.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					KaleoLogPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(KaleoLogPersistence persistence) {
		_persistence = persistence;
	}

	private static KaleoLogPersistence _persistence;
}