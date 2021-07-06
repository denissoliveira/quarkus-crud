package br.com.qrksCrud.model;

import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.testcontainers.containers.MariaDBContainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class DataBaseLifeCycle implements QuarkusTestResourceLifecycleManager {
	
	@SuppressWarnings("deprecation")
	@Rule
    public MariaDBContainer mariaDB = new MariaDBContainer();

	@Override
	public Map<String, String> start() {
		mariaDB.start();
		Map<String, String> propriedades = new HashMap<String, String>();
		propriedades.put("quarkus.datasource.jdbc.url", mariaDB.getJdbcUrl());
		propriedades.put("quarkus.datasource.username", mariaDB.getUsername());
		propriedades.put("quarkus.datasource.password", mariaDB.getPassword());
		return propriedades;
	}

	@Override
	public void stop() {
		if(mariaDB != null) {
			mariaDB.stop();
		}
	}

}
