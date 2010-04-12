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

package com.liferay.knowledgebase.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="ArticleLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * {@link ArticleLocalService} bean. The static methods of
 * this class calls the same methods of the bean instance. It's convenient to be
 * able to just write one line to call a method on a bean instead of writing a
 * lookup call and a method call.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ArticleLocalService
 * @generated
 */
public class ArticleLocalServiceUtil {
	public static com.liferay.knowledgebase.model.Article addArticle(
		com.liferay.knowledgebase.model.Article article)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addArticle(article);
	}

	public static com.liferay.knowledgebase.model.Article createArticle(
		long articleId) {
		return getService().createArticle(articleId);
	}

	public static void deleteArticle(long articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteArticle(articleId);
	}

	public static void deleteArticle(
		com.liferay.knowledgebase.model.Article article)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteArticle(article);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static int dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.liferay.knowledgebase.model.Article getArticle(
		long articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getArticle(articleId);
	}

	public static java.util.List<com.liferay.knowledgebase.model.Article> getArticles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArticles(start, end);
	}

	public static int getArticlesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArticlesCount();
	}

	public static com.liferay.knowledgebase.model.Article updateArticle(
		com.liferay.knowledgebase.model.Article article)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateArticle(article);
	}

	public static com.liferay.knowledgebase.model.Article updateArticle(
		com.liferay.knowledgebase.model.Article article, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateArticle(article, merge);
	}

	public static com.liferay.knowledgebase.model.Article addArticle(
		java.lang.String uuid, long userId, long parentResourcePrimKey,
		java.lang.String title, java.lang.String content,
		java.lang.String description, int priority,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addArticle(uuid, userId, parentResourcePrimKey, title,
			content, description, priority, serviceContext);
	}

	public static java.util.List<com.liferay.knowledgebase.model.Article> getCompanyArticles(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCompanyArticles(companyId, start, end, orderByComparator);
	}

	public static int getCompanyArticlesCount(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCompanyArticlesCount(companyId);
	}

	public static java.util.List<com.liferay.knowledgebase.model.Article> getGroupArticles(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getGroupArticles(groupId, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.knowledgebase.model.Article> getGroupArticles(
		long groupId, long parentResourcePrimKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getGroupArticles(groupId, parentResourcePrimKey, start,
			end, orderByComparator);
	}

	public static int getGroupArticlesCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGroupArticlesCount(groupId);
	}

	public static int getGroupArticlesCount(long groupId,
		long parentResourcePrimKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGroupArticlesCount(groupId, parentResourcePrimKey);
	}

	public static com.liferay.knowledgebase.model.Article updateArticle(
		long userId, long resourcePrimKey, long parentResourcePrimKey,
		java.lang.String title, java.lang.String content,
		java.lang.String description, int priority,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateArticle(userId, resourcePrimKey,
			parentResourcePrimKey, title, content, description, priority,
			serviceContext);
	}

	public static com.liferay.knowledgebase.model.Article updateDisplayOrder(
		com.liferay.knowledgebase.model.Article article,
		long parentResourcePrimKey, int priority)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateDisplayOrder(article, parentResourcePrimKey, priority);
	}

	public static void clearService() {
		_service = null;
	}

	public static ArticleLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ArticleLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					ArticleLocalService.class.getName(), portletClassLoader);

			_service = new ArticleLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ArticleLocalService service) {
		_service = service;
	}

	private static ArticleLocalService _service;
}