/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.gadgets.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;

/**
 * <a href="GadgetsEntryLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface GadgetsEntryLocalService {
	public com.liferay.gadgets.model.GadgetsEntry addGadgetsEntry(
		com.liferay.gadgets.model.GadgetsEntry gadgetsEntry)
		throws com.liferay.portal.SystemException;

	public com.liferay.gadgets.model.GadgetsEntry createGadgetsEntry(
		long gadgetEntryId);

	public void deleteGadgetsEntry(long gadgetEntryId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteGadgetsEntry(
		com.liferay.gadgets.model.GadgetsEntry gadgetsEntry)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.gadgets.model.GadgetsEntry getGadgetsEntry(
		long gadgetEntryId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.gadgets.model.GadgetsEntry> getGadgetsEntries(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getGadgetsEntriesCount()
		throws com.liferay.portal.SystemException;

	public com.liferay.gadgets.model.GadgetsEntry updateGadgetsEntry(
		com.liferay.gadgets.model.GadgetsEntry gadgetsEntry)
		throws com.liferay.portal.SystemException;

	public com.liferay.gadgets.model.GadgetsEntry updateGadgetsEntry(
		com.liferay.gadgets.model.GadgetsEntry gadgetsEntry, boolean merge)
		throws com.liferay.portal.SystemException;

	public com.liferay.gadgets.model.GadgetsEntry addGadgetsEntry(
		long companyId, java.lang.String name, java.lang.String url,
		java.lang.String xml)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.gadgets.model.GadgetsEntry> getGadgetsEntries(
		long companyId, int start, int end)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getGadgetsEntriesCount(long companyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public com.liferay.gadgets.model.GadgetsEntry updateGadgetsEntry(
		long gadgetsEntryId, java.lang.String name, java.lang.String xml)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;
}