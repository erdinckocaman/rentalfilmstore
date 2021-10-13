package com.tamplan.sample.store.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Listing the configuration parameters of service
 */
@ConfigurationProperties(prefix = "app.config")
@Configuration
public class RentalStoreCoreAppConfiguration {

    private String env;

    public void setEnv(String env) {
        this.env = env;
    }

    public String getEnv() {
        return env;
    }


}
