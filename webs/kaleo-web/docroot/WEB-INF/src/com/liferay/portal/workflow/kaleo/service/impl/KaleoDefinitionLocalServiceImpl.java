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
import com.liferay.portal.workflow.kaleo.NoSuchDefinitionException;
import com.liferay.portal.workflow.kaleo.model.KaleoDefinition;
import com.liferay.portal.workflow.kaleo.service.base.KaleoDefinitionLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * <a href="KaleoDefinitionLocalServiceImpl.java.html"><b><i>View Source</i></b>
 * </a>
 *
 * @author Brian Wing Shun Chan
 */
public class KaleoDefinitionLocalServiceImpl
	extends KaleoDefinitionLocalServiceBaseImpl {

	public void activateKaleoDefinition(
			long kaleoDefinitionId, long startKaleoNodeId,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDefinition kaleoDefinition =
			kaleoDefinitionPersistence.findByPrimaryKey(kaleoDefinitionId);

		try {
			KaleoDefinition previousKaleoDefinition = getLatestKaleoDefinition(
				kaleoDefinition.getName(), serviceContext);

			previousKaleoDefinition.setModifiedDate(new Date());
			previousKaleoDefinition.setActive(false);

			kaleoDefinitionPersistence.update(previousKaleoDefinition, false);
		}
		catch (NoSuchDefinitionException nsde) {
		}

		kaleoDefinition.setStartKaleoNodeId(startKaleoNodeId);
		kaleoDefinition.setModifiedDate(new Date());
		kaleoDefinition.setActive(true);

		kaleoDefinitionPersistence.update(kaleoDefinition, false);
	}

	public void activateKaleoDefinition(
			long kaleoDefinitionId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDefinition kaleoDefinition =
			kaleoDefinitionPersistence.findByPrimaryKey(kaleoDefinitionId);

		kaleoDefinition.setModifiedDate(new Date());
		kaleoDefinition.setActive(true);

		kaleoDefinitionPersistence.update(kaleoDefinition, false);
	}

	public void activateKaleoDefinition(
			String name, int version, ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDefinition kaleoDefinition =
			kaleoDefinitionPersistence.findByC_N_V(
				serviceContext.getCompanyId(), name, version);

		kaleoDefinition.setModifiedDate(new Date());
		kaleoDefinition.setActive(true);

		kaleoDefinitionPersistence.update(kaleoDefinition, false);
	}

	public KaleoDefinition addKaleoDefinition(
			String name, String description, int version,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(
			serviceContext.getUserId());
		Date now = new Date();

		long kaleoDefinitionId = counterLocalService.increment();

		KaleoDefinition kaleoDefinition = kaleoDefinitionPersistence.create(
			kaleoDefinitionId);

		kaleoDefinition.setCompanyId(user.getCompanyId());
		kaleoDefinition.setUserId(user.getUserId());
		kaleoDefinition.setUserName(user.getScreenName());
		kaleoDefinition.setCreateDate(now);
		kaleoDefinition.setModifiedDate(now);
		kaleoDefinition.setName(name);
		kaleoDefinition.setDescription(description);
		kaleoDefinition.setVersion(version);
		kaleoDefinition.setActive(false);

		kaleoDefinitionPersistence.update(kaleoDefinition, false);

		return kaleoDefinition;
	}

	public void deactivateKaleoDefinition(
			String name, int version, ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDefinition kaleoDefinition =
			kaleoDefinitionPersistence.findByC_N_V(
				serviceContext.getCompanyId(), name, version);

		kaleoDefinition.setModifiedDate(new Date());
		kaleoDefinition.setActive(false);

		kaleoDefinitionPersistence.update(kaleoDefinition, false);
	}

	public KaleoDefinition getKaleoDefinition(
			String name, int version, ServiceContext serviceContext)
		throws PortalException, SystemException {

		return kaleoDefinitionPersistence.findByC_N_V(
			serviceContext.getCompanyId(), name, version);
	}

	public List<KaleoDefinition> getKaleoDefinitions(
			int start, int end, OrderByComparator orderByComparator,
			ServiceContext serviceContext)
		throws SystemException {

		return kaleoDefinitionPersistence.findByCompanyId(
			serviceContext.getCompanyId(), start, end, orderByComparator);
	}

	public List<KaleoDefinition> getKaleoDefinitions(
			String name, int start, int end,
			OrderByComparator orderByComparator, ServiceContext serviceContext)
		throws SystemException {

		return kaleoDefinitionPersistence.findByC_N(
			serviceContext.getCompanyId(), name, start, end, orderByComparator);
	}

	public int getKaleoDefinitionsCount(ServiceContext serviceContext)
		throws SystemException {

		return kaleoDefinitionPersistence.countByCompanyId(
			serviceContext.getCompanyId());
	}

	public int getKaleoDefinitionsCount(
			String name, ServiceContext serviceContext)
		throws SystemException {

		return kaleoDefinitionPersistence.countByC_N(
			serviceContext.getCompanyId(), name);
	}

	public KaleoDefinition incrementKaleoDefinition(
			String name, ServiceContext serviceContext)
		throws PortalException, SystemException {

		KaleoDefinition kaleoDefinition = getLatestKaleoDefinition(
			name, serviceContext);

		return addKaleoDefinition(
			kaleoDefinition.getName(), kaleoDefinition.getDescription(),
			kaleoDefinition.getVersion() + 1, serviceContext);
	}

	protected KaleoDefinition getLatestKaleoDefinition(
			String name, ServiceContext serviceContext)
		throws PortalException, SystemException {

		List<KaleoDefinition> kaleoDefinitions =
			kaleoDefinitionPersistence.findByC_N(
				serviceContext.getCompanyId(), name, 0, 1);

		if (kaleoDefinitions.isEmpty()) {
			throw new NoSuchDefinitionException();
		}

		return kaleoDefinitions.get(0);
	}

}