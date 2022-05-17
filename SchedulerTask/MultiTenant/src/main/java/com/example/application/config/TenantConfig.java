package com.example.application.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import com.example.application.repository.DataRepo;

@Component
public class TenantConfig {

	private HashMap<String, DataSource> dataSources = new HashMap<>();

	@Autowired
	private DataRepo datarepo;

	public DataSource getDataSource(String name) {
		if (dataSources.get(name) != null) {
			return dataSources.get(name);
		}
		DataSource dataSource = createDataSource(name);
		if (dataSource != null) {
			dataSources.put(name, dataSource);
		}
		return dataSource;
	}

	@PostConstruct
	public Map<String, DataSource> getAll() {
		List<Data> configList = datarepo.findAll();
		Map<String, DataSource> result = new HashMap<>();
		for (Data config : configList) {
			DataSource dataSource = getDataSource(config.getName());
			result.put(config.getName(), dataSource);
		}
		return result;
	}

	private DataSource createDataSource(String name) {
		Data config = datarepo.findByName(name);
		if (config != null) {
			DataSourceBuilder<?> factory = DataSourceBuilder.create().driverClassName(config.getDriverclassname())
					.username(config.getUsername()).password(config.getPassword()).url(config.getUrl());
			DataSource ds = factory.build();
			return ds;
		}
		return null;
	}
}
