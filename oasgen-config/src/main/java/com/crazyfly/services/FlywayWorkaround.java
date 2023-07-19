package com.crazyfly.services;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.flywaydb.core.Flyway;

@ApplicationScoped
public class FlywayWorkaround {

    @ConfigProperty(name = "quarkus.datasource.reactive.url")
    String datasourceUrl;

    @ConfigProperty(name = "quarkus.datasource.username")
    String datasourceUsername;

    @ConfigProperty(name = "quarkus.datasource.password")
    String datasourcePassword;

    public void runFlywayMigration(@Observes StartupEvent event) {
        Flyway flyway = Flyway.configure().dataSource("jdbc:" + datasourceUrl.substring(datasourceUrl.indexOf("postgresql://")), datasourceUsername, datasourcePassword).load();
        flyway.baseline();
        flyway.migrate();
    }
}
