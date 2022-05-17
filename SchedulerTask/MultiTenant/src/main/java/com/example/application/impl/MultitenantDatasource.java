package com.example.application.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.application.config.TenantConfig;

@Component
public class MultitenantDatasource extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7034131858204409482L;

	private static final String DEFAULT_TENANT_ID = "tenant";

	@Autowired
	private DataSource defaultDS;

	@Autowired
	private ApplicationContext context;

	private Map<String, DataSource> map = new HashMap<>();

	boolean init = false;

	@PostConstruct
	public void load() {
		map.put(DEFAULT_TENANT_ID, defaultDS);
	}

	@Override
	protected DataSource selectAnyDataSource() {
		return map.get(DEFAULT_TENANT_ID);
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) throws BeansException {
		if (!init) {
			init = true;
			TenantConfig tenantconfig = context.getBean(TenantConfig.class);
			map.putAll(tenantconfig.getAll());
		}
		return map.get(tenantIdentifier) != null ? map.get(tenantIdentifier) : map.get(DEFAULT_TENANT_ID);
	}
}
