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

<%@ include file="/html/portlet/blogs/init.jsp" %>

<%
BlogsEntry entry = (BlogsEntry)request.getAttribute("view_entry_content.jsp-entry");

User entryUser = UserLocalServiceUtil.getUser(entry.getUserId());
%>

<div id="<portlet:namespace />entry_<%= entry.getEntryId() %>">
	<liferay-util:include page="/html/portlet/blogs/view_entry_content.portal.jsp" />
</div>

<c:if test="<%= Validator.isNotNull(entryUser.getDisplayURL(themeDisplay)) %>">

	<%
	StringBuilder htmlSB = new StringBuilder();

	htmlSB.append(LanguageUtil.get(pageContext, "written-by"));
	htmlSB.append(StringPool.SPACE);
	htmlSB.append("<a href=\"");
	htmlSB.append(entryUser.getDisplayURL(themeDisplay));
	htmlSB.append("\">");
	htmlSB.append(HtmlUtil.escape(PortalUtil.getUserName(entry.getUserId(), entry.getUserName())));
	htmlSB.append("</a>");
	%>

	<script type="text/javascript">
		var entryAuthor = jQuery('#<portlet:namespace />entry_<%= entry.getEntryId() %> .entry-author:first');

		entryAuthor.html('<%= htmlSB.toString() %>');
	</script>
</c:if>