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

package com.liferay.hr.model.impl;

import com.liferay.hr.model.HRAssetDefinition;
import com.liferay.hr.model.HRAssetDefinitionModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the HRAssetDefinition service. Represents a row in the &quot;HRAssetDefinition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.hr.model.HRAssetDefinitionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HRAssetDefinitionImpl}.
 * </p>
 *
 * @author Wesley Gong
 * @see HRAssetDefinitionImpl
 * @see com.liferay.hr.model.HRAssetDefinition
 * @see com.liferay.hr.model.HRAssetDefinitionModel
 * @generated
 */
public class HRAssetDefinitionModelImpl extends BaseModelImpl<HRAssetDefinition>
	implements HRAssetDefinitionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a h r asset definition model instance should use the {@link com.liferay.hr.model.HRAssetDefinition} interface instead.
	 */
	public static final String TABLE_NAME = "HRAssetDefinition";
	public static final Object[][] TABLE_COLUMNS = {
			{ "hrAssetDefinitionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "hrAssetProductId", Types.VARCHAR },
			{ "hrAssetTypeId", Types.BIGINT },
			{ "hrAssetVendorId", Types.BIGINT },
			{ "definitionNumber", Types.VARCHAR },
			{ "orderId", Types.TIMESTAMP },
			{ "orderDate", Types.TIMESTAMP },
			{ "quantity", Types.INTEGER },
			{ "individualPrice", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table HRAssetDefinition (hrAssetDefinitionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,hrAssetProductId VARCHAR(75) null,hrAssetTypeId LONG,hrAssetVendorId LONG,definitionNumber VARCHAR(75) null,orderId DATE null,orderDate DATE null,quantity INTEGER,individualPrice DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table HRAssetDefinition";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.hr.model.HRAssetDefinition"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.hr.model.HRAssetDefinition"),
			true);

	public Class<?> getModelClass() {
		return HRAssetDefinition.class;
	}

	public String getModelClassName() {
		return HRAssetDefinition.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.hr.model.HRAssetDefinition"));

	public HRAssetDefinitionModelImpl() {
	}

	public long getPrimaryKey() {
		return _hrAssetDefinitionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setHrAssetDefinitionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_hrAssetDefinitionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getHrAssetDefinitionId() {
		return _hrAssetDefinitionId;
	}

	public void setHrAssetDefinitionId(long hrAssetDefinitionId) {
		_hrAssetDefinitionId = hrAssetDefinitionId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getHrAssetProductId() {
		if (_hrAssetProductId == null) {
			return StringPool.BLANK;
		}
		else {
			return _hrAssetProductId;
		}
	}

	public void setHrAssetProductId(String hrAssetProductId) {
		_hrAssetProductId = hrAssetProductId;
	}

	public long getHrAssetTypeId() {
		return _hrAssetTypeId;
	}

	public void setHrAssetTypeId(long hrAssetTypeId) {
		_hrAssetTypeId = hrAssetTypeId;
	}

	public long getHrAssetVendorId() {
		return _hrAssetVendorId;
	}

	public void setHrAssetVendorId(long hrAssetVendorId) {
		_hrAssetVendorId = hrAssetVendorId;
	}

	public String getDefinitionNumber() {
		if (_definitionNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _definitionNumber;
		}
	}

	public void setDefinitionNumber(String definitionNumber) {
		_definitionNumber = definitionNumber;
	}

	public Date getOrderId() {
		return _orderId;
	}

	public void setOrderId(Date orderId) {
		_orderId = orderId;
	}

	public Date getOrderDate() {
		return _orderDate;
	}

	public void setOrderDate(Date orderDate) {
		_orderDate = orderDate;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	public double getIndividualPrice() {
		return _individualPrice;
	}

	public void setIndividualPrice(double individualPrice) {
		_individualPrice = individualPrice;
	}

	@Override
	public HRAssetDefinition toEscapedModel() {
		if (isEscapedModel()) {
			return (HRAssetDefinition)this;
		}
		else {
			return (HRAssetDefinition)Proxy.newProxyInstance(_classLoader,
				_escapedModelProxyInterfaces, new AutoEscapeBeanHandler(this));
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					HRAssetDefinition.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		HRAssetDefinitionImpl hrAssetDefinitionImpl = new HRAssetDefinitionImpl();

		hrAssetDefinitionImpl.setHrAssetDefinitionId(getHrAssetDefinitionId());
		hrAssetDefinitionImpl.setGroupId(getGroupId());
		hrAssetDefinitionImpl.setCompanyId(getCompanyId());
		hrAssetDefinitionImpl.setUserId(getUserId());
		hrAssetDefinitionImpl.setUserName(getUserName());
		hrAssetDefinitionImpl.setCreateDate(getCreateDate());
		hrAssetDefinitionImpl.setModifiedDate(getModifiedDate());
		hrAssetDefinitionImpl.setHrAssetProductId(getHrAssetProductId());
		hrAssetDefinitionImpl.setHrAssetTypeId(getHrAssetTypeId());
		hrAssetDefinitionImpl.setHrAssetVendorId(getHrAssetVendorId());
		hrAssetDefinitionImpl.setDefinitionNumber(getDefinitionNumber());
		hrAssetDefinitionImpl.setOrderId(getOrderId());
		hrAssetDefinitionImpl.setOrderDate(getOrderDate());
		hrAssetDefinitionImpl.setQuantity(getQuantity());
		hrAssetDefinitionImpl.setIndividualPrice(getIndividualPrice());

		hrAssetDefinitionImpl.resetOriginalValues();

		return hrAssetDefinitionImpl;
	}

	public int compareTo(HRAssetDefinition hrAssetDefinition) {
		long primaryKey = hrAssetDefinition.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		HRAssetDefinition hrAssetDefinition = null;

		try {
			hrAssetDefinition = (HRAssetDefinition)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hrAssetDefinition.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{hrAssetDefinitionId=");
		sb.append(getHrAssetDefinitionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", hrAssetProductId=");
		sb.append(getHrAssetProductId());
		sb.append(", hrAssetTypeId=");
		sb.append(getHrAssetTypeId());
		sb.append(", hrAssetVendorId=");
		sb.append(getHrAssetVendorId());
		sb.append(", definitionNumber=");
		sb.append(getDefinitionNumber());
		sb.append(", orderId=");
		sb.append(getOrderId());
		sb.append(", orderDate=");
		sb.append(getOrderDate());
		sb.append(", quantity=");
		sb.append(getQuantity());
		sb.append(", individualPrice=");
		sb.append(getIndividualPrice());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.liferay.hr.model.HRAssetDefinition");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>hrAssetDefinitionId</column-name><column-value><![CDATA[");
		sb.append(getHrAssetDefinitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hrAssetProductId</column-name><column-value><![CDATA[");
		sb.append(getHrAssetProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hrAssetTypeId</column-name><column-value><![CDATA[");
		sb.append(getHrAssetTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hrAssetVendorId</column-name><column-value><![CDATA[");
		sb.append(getHrAssetVendorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>definitionNumber</column-name><column-value><![CDATA[");
		sb.append(getDefinitionNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderId</column-name><column-value><![CDATA[");
		sb.append(getOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderDate</column-name><column-value><![CDATA[");
		sb.append(getOrderDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>individualPrice</column-name><column-value><![CDATA[");
		sb.append(getIndividualPrice());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = HRAssetDefinition.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			HRAssetDefinition.class
		};
	private long _hrAssetDefinitionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _hrAssetProductId;
	private long _hrAssetTypeId;
	private long _hrAssetVendorId;
	private String _definitionNumber;
	private Date _orderId;
	private Date _orderDate;
	private int _quantity;
	private double _individualPrice;
	private transient ExpandoBridge _expandoBridge;
}