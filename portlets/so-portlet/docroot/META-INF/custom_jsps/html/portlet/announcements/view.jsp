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

<%@ include file="/html/portlet/announcements/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "entries");

String distributionScope = ParamUtil.getString(request, "distributionScope");

Group group = themeDisplay.getScopeGroup();
%>

<liferay-util:buffer var="html">
	<liferay-util:include page="/html/portlet/announcements/view.portal.jsp" />
</liferay-util:buffer>

<c:choose>
	<c:when test='<%= tabs1.equals("manage-entries") %>'>

		<%
		int x = html.indexOf("<td class=\"lfr-label\">");
		int y = html.indexOf("</td>", x);
		%>

		<%= html.substring(0, x) %>

		<td class="lfr-label">
			<liferay-ui:message key="to" />
		</td>

		<%= html.substring(y + 5) %>

		<c:if test="<%= Validator.isNull(distributionScope) && group.isCommunity() %>">
			<script type="text/javascript">
				<portlet:namespace />selectDistributionScope('<%= PortalUtil.getClassNameId(Group.class) + StringPool.COMMA + group.getGroupId() %>');
			</script>
		</c:if>
	</c:when>
	<c:otherwise>
		<%= html %>
	</c:otherwise>
</c:choose>