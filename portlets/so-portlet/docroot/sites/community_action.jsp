<%
/**
 * Copyright (c) 2008-2010 Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */
%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Group group = (Group)row.getObject();
%>

<div class="actions">
	<c:if test="<%= GroupPermissionUtil.contains(permissionChecker, group.getGroupId(), ActionKeys.UPDATE) %>">
		<liferay-portlet:renderURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" portletName="<%= PortletKeys.COMMUNITIES %>" var="editURL">
			<liferay-portlet:param name="struts_action" value="/communities/edit_community" />
			<liferay-portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(group.getGroupId()) %>" />
		</liferay-portlet:renderURL>

		<a class="edit-site" href="javascript:;" onClick="Liferay.SO.Sites.displayPopup('<%= editURL %>','<liferay-ui:message key="edit-site" />');"><liferay-ui:message key="edit" /></a>
	</c:if>

	<c:choose>
		<c:when test="<%= !GroupLocalServiceUtil.hasUserGroup(user.getUserId(), group.getGroupId()) %>">
			<c:if test="<%= group.getType() == GroupConstants.TYPE_COMMUNITY_OPEN %>">
				<liferay-portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" portletName="<%= PortletKeys.COMMUNITIES %>" var="joinURL">
					<portlet:param name="struts_action" value="/communities/edit_community_assignments" />
					<portlet:param name="<%= Constants.CMD %>" value="group_users" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="groupId" value="<%= String.valueOf(group.getGroupId()) %>" />
					<portlet:param name="addUserIds" value="<%= String.valueOf(user.getUserId()) %>" />
				</liferay-portlet:actionURL>

				<a class="join-site" href="javascript:;" onclick="return (submitForm(document.hrefFm, '<%= joinURL %>'));"><liferay-ui:message key="join" /></a>
			</c:if>
		</c:when>
		<c:when test="<%= !GroupPermissionUtil.contains(permissionChecker, group.getGroupId(), ActionKeys.DELETE) %>">
			<liferay-portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" portletName="<%= PortletKeys.COMMUNITIES %>" var="leaveURL">
				<portlet:param name="struts_action" value="/communities/edit_community_assignments" />
				<portlet:param name="<%= Constants.CMD %>" value="group_users" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="groupId" value="<%= String.valueOf(group.getGroupId()) %>" />
				<portlet:param name="removeUserIds" value="<%= String.valueOf(user.getUserId()) %>" />
			</liferay-portlet:actionURL>

			<a class="leave-site" href="javascript:;" onclick="return (submitForm(document.hrefFm, '<%= leaveURL %>'));"><liferay-ui:message key="leave" /></a>
		</c:when>
	</c:choose>

	<c:if test="<%= GroupPermissionUtil.contains(permissionChecker, group.getGroupId(), ActionKeys.DELETE) %>">
		<liferay-portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" portletName="<%= PortletKeys.COMMUNITIES %>" var="deleteURL">
			<portlet:param name="struts_action" value="/communities/edit_community" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(group.getGroupId()) %>" />
		</liferay-portlet:actionURL>

		<a class="delete-site" href="javascript:;" onclick="return (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />') && submitForm(document.hrefFm, '<%= deleteURL %>'));"><liferay-ui:message key="delete" /></a>
	</c:if>
</div>