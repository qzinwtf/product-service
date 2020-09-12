package ru.nkuzin.task.integration;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

/**
 * PostgresInitializer.
 *
 * @author Nikita_Mikaev
 */
public class PostgresInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public static final PostgreSQLContainer dbContainer = (PostgreSQLContainer) new PostgreSQLContainer()
            .withDatabaseName("products")
            .withReuse(true);

    static {
        dbContainer.start();
    }


    @Override
    public void initialize(final ConfigurableApplicationContext configurableApplicationContext) {
        TestPropertyValues.of(
                "spring.datasource.url=" + dbContainer.getJdbcUrl(),
                "spring.datasource.username=" + dbContainer.getUsername(),
                "spring.datasource.password=" + dbContainer.getPassword()
        ).applyTo(configurableApplicationContext.getEnvironment());
    }
}
