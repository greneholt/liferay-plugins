/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.ams.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the type local service. This utility wraps {@link com.liferay.ams.service.impl.TypeLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TypeLocalService
 * @see com.liferay.ams.service.base.TypeLocalServiceBaseImpl
 * @see com.liferay.ams.service.impl.TypeLocalServiceImpl
 * @generated
 */
public class TypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.ams.service.impl.TypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the type to the database. Also notifies the appropriate model listeners.
	*
	* @param type the type
	* @return the type that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ams.model.Type addType(
		com.liferay.ams.model.Type type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addType(type);
	}

	/**
	* Creates a new type with the primary key. Does not add the type to the database.
	*
	* @param typeId the primary key for the new type
	* @return the new type
	*/
	public static com.liferay.ams.model.Type createType(long typeId) {
		return getService().createType(typeId);
	}

	/**
	* Deletes the type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeId the primary key of the type
	* @throws PortalException if a type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteType(typeId);
	}

	/**
	* Deletes the type from the database. Also notifies the appropriate model listeners.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteType(com.liferay.ams.model.Type type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteType(type);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the type with the primary key.
	*
	* @param typeId the primary key of the type
	* @return the type
	* @throws PortalException if a type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ams.model.Type getType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getType(typeId);
	}

	/**
	* Returns a range of all the types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of types
	* @param end the upper bound of the range of types (not inclusive)
	* @return the range of types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.ams.model.Type> getTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTypes(start, end);
	}

	/**
	* Returns the number of types.
	*
	* @return the number of types
	* @throws SystemException if a system exception occurred
	*/
	public static int getTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTypesCount();
	}

	/**
	* Updates the type in the database. Also notifies the appropriate model listeners.
	*
	* @param type the type
	* @return the type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ams.model.Type updateType(
		com.liferay.ams.model.Type type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateType(type);
	}

	/**
	* Updates the type in the database. Also notifies the appropriate model listeners.
	*
	* @param type the type
	* @param merge whether to merge the type with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.ams.model.Type updateType(
		com.liferay.ams.model.Type type, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateType(type, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static void clearService() {
		_service = null;
	}

	public static TypeLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TypeLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					TypeLocalService.class.getName(), portletClassLoader);

			_service = new TypeLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(TypeLocalServiceUtil.class,
				"_service");
			MethodCache.remove(TypeLocalService.class);
		}

		return _service;
	}

	public void setService(TypeLocalService service) {
		MethodCache.remove(TypeLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(TypeLocalServiceUtil.class,
			"_service");
		MethodCache.remove(TypeLocalService.class);
	}

	private static TypeLocalService _service;
}