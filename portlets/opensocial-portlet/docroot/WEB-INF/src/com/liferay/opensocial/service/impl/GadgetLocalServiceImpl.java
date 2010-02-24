/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.liferay.opensocial.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.opensocial.GadgetNameException;
import com.liferay.opensocial.model.Gadget;
import com.liferay.opensocial.portlet.GadgetPortlet;
import com.liferay.opensocial.service.ClpSerializer;
import com.liferay.opensocial.service.base.GadgetLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletBag;
import com.liferay.portal.kernel.portlet.PortletBagPool;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.PortletApp;
import com.liferay.portal.model.PortletInfo;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.InvokerPortlet;
import com.liferay.portlet.PortletInstanceFactoryUtil;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

/**
 * <a href="GadgetLocalServiceImpl.java.html"><b><i>View Source</i></b>
 * </a>
 *
 * @author Michael Young
 * @author Brian Wing Shun Chan
 */
public class GadgetLocalServiceImpl
	extends GadgetLocalServiceBaseImpl {

	public Gadget addGadget(long companyId, String name, String url, String xml)
		throws PortalException, SystemException {

		Date now = new Date();

		validate(name);

		long gadgetId = CounterLocalServiceUtil.increment();

		Gadget gadget = gadgetPersistence.create(gadgetId);

		gadget.setCompanyId(companyId);
		gadget.setCreateDate(now);
		gadget.setModifiedDate(now);
		gadget.setName(name);
		gadget.setUrl(url);
		gadget.setXml(xml);

		gadgetPersistence.update(gadget, false);

		initGadget(gadget);

		return gadget;
	}

	public void deleteGadget(Gadget gadget) throws SystemException {
		gadgetPersistence.remove(gadget);
	}

	public void deleteGadget(long gadgetId)
		throws PortalException, SystemException {

		Gadget gadget = gadgetPersistence.findByPrimaryKey(gadgetId);

		deleteGadget(gadget);
	}

	public void destroyGadgets() throws PortalException, SystemException {
		List<Gadget> gadgets = gadgetPersistence.findAll();

		for (Gadget gadget : gadgets) {
			destroyGadget(gadget);
		}
	}

	public List<Gadget> getGadgets(long companyId, int start, int end)
		throws SystemException {

		return gadgetPersistence.findByCompanyId(companyId, start, end);
	}

	public int getGadgetsCount(long companyId) throws SystemException {
		return gadgetPersistence.countByCompanyId(companyId);
	}

	public void initGadgets()
		throws PortalException, SystemException {

		List<Gadget> gadgets = gadgetPersistence.findAll();

		for (Gadget gadget : gadgets) {
			initGadget(gadget);
		}
	}

	public Gadget updateGadget(long gadgetId, String name, String xml)
		throws PortalException, SystemException {

		Date now = new Date();

		validate(name);

		Gadget gadget = gadgetPersistence.create(gadgetId);

		gadget.setModifiedDate(now);
		gadget.setName(name);
		gadget.setXml(xml);

		gadgetPersistence.update(gadget, false);

		return gadget;
	}

	protected void addPortletExtraInfo(
		Portlet portlet, PortletApp portletApp, String title) {

		Set<String> mimeTypePortletModes = new HashSet<String>();

		mimeTypePortletModes.add(PortletMode.VIEW.toString());

		portlet.getPortletModes().put(
			ContentTypes.TEXT_HTML, mimeTypePortletModes);

		Set<String> mimeTypeWindowStates = new HashSet<String>();

		mimeTypeWindowStates.add(WindowState.MAXIMIZED.toString());
		mimeTypeWindowStates.add(WindowState.MINIMIZED.toString());
		mimeTypeWindowStates.add(WindowState.NORMAL.toString());

		portlet.getWindowStates().put(
			ContentTypes.TEXT_HTML, mimeTypeWindowStates);

		PortletInfo portletInfo = new PortletInfo(title, title, title, title);

		portlet.setPortletInfo(portletInfo);
	}

	protected void destroyGadget(Gadget gadget)
		throws PortalException, SystemException {

		try {
			Portlet portlet = getPortlet(gadget);

			PortletLocalServiceUtil.destroyRemotePortlet(portlet);

			PortletInstanceFactoryUtil.destroy(portlet);
		}
		catch (PortalException pe) {
			throw pe;
		}
		catch (SystemException se) {
			throw se;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	protected Portlet getPortlet(Gadget gadget) throws Exception {
		Portlet portlet = _portletsPool.get(gadget.getGadgetId());

		if (portlet != null) {
			return portlet;
		}

		StringBuilder sb = new StringBuilder();

		sb.append(GadgetPortlet.PORTLET_NAME_PREFIX);
		sb.append(gadget.getCompanyId());
		sb.append(StringPool.UNDERLINE);
		sb.append(gadget.getGadgetId());

		String portletId = PortalUtil.getJsSafePortletId(sb.toString());

		portlet = PortletLocalServiceUtil.newPortlet(
			gadget.getCompanyId(), portletId);

		portlet.setTimestamp(System.currentTimeMillis());

		PortletApp portletApp = PortletLocalServiceUtil.getPortletApp(
			ClpSerializer.SERVLET_CONTEXT_NAME);

		portlet.setPortletApp(portletApp);

		portlet.setPortletName(portletId);
		portlet.setDisplayName(portletId);
		portlet.setPortletClass(GadgetPortlet.class.getName());

		Map<String, String> initParams = portlet.getInitParams();

		initParams.put(
			InvokerPortlet.INIT_INVOKER_PORTLET_NAME, _GADGET_PORTLET_NAME);

		addPortletExtraInfo(portlet, portletApp, gadget.getName());

		_portletsPool.put(gadget.getGadgetId(), portlet);

		PortletBag portletBag = PortletBagPool.get(_GADGET_PORTLET_ID);

		portletBag = (PortletBag)portletBag.clone();

		portletBag.setPortletName(portletId);
		portletBag.setPortletInstance(new GadgetPortlet());

		PortletBagPool.put(portletId, portletBag);

		return portlet;
	}

	protected void initGadget(Gadget gadget)
		throws PortalException, SystemException {

		try {
			Portlet portlet = getPortlet(gadget);

			PortletLocalServiceUtil.deployRemotePortlet(
				portlet, _OPENSOCIAL_CATEGORY);
		}
		catch (PortalException pe) {
			throw pe;
		}
		catch (SystemException se) {
			throw se;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new GadgetNameException();
		}
	}

	private static final String _GADGET_PORTLET_ID = "2_WAR_opensocialportlet";

	private static final String _GADGET_PORTLET_NAME = "2";

	private static final String _OPENSOCIAL_CATEGORY = "category.opensocial";

	private static Map<Long, Portlet> _portletsPool =
		new ConcurrentHashMap<Long, Portlet>();

}