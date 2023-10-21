package com.kbtool.configuration;

import com.mongodb.client.MongoClients;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
public class MongoMorphiaConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoMorphiaConfiguration.class);

    @Autowired
    private Environment env;

    @Bean
    @Scope("singleton")
    public Datastore morphiaDatastore() {
        String database = env.getProperty("application.datasource.database");
        LOGGER.info("Morphia Datastore is loading. Database: " + database);
        final Datastore datastore = Morphia.createDatastore(MongoClients.create(buildDatasourceUri()), database);
        datastore.getMapper().mapPackage("com.kbtool.entity");
        datastore.ensureIndexes();

        return datastore;
    }

    private String buildDatasourceUri() {
        String uri = env.getProperty("application.datasource.uri");
        String user = env.getProperty("application.datasource.user");
        String pwd = env.getProperty("application.datasource.pwd");

        return String.format(uri, user, pwd);
    }
}
