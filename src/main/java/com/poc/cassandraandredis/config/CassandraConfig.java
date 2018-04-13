package com.poc.cassandraandredis.config;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${cassandra.contactpoints}")
    private String contactPoints;
    @Value("${cassandra.port}")
    private int port;
    @Value("${cassandra.keyspace}")
    private String keySpace;
    @Value("${cassandra.basepackages}")
    private String basePackages;

    @Override
    protected String getKeyspaceName() {
        return keySpace;
    }

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }
    
    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
      final CreateKeyspaceSpecification specification =
          CreateKeyspaceSpecification.createKeyspace(keySpace)
              .ifNotExists()
              .with(KeyspaceOption.DURABLE_WRITES, true)
              .withSimpleReplication();
      return Collections.singletonList(specification);
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] { basePackages };
    }

}