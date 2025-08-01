package com.ctw.workstation.config;

import io.quarkus.logging.Log;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Map;

public class CommodoreTestConfig implements QuarkusTestResourceLifecycleManager {

    @Override
    public Map<String, String> start() {
        Log.info("Starting CommodoreTestConfig");
        return Map.of();
    }

    @Override
    public void stop() {
        Log.info("Stopping CommodoreTestConfig");

    }

    @Override
    public void init(Map<String, String> initArgs) {
        Log.info("Initiating CommodoreTestConfig");
        QuarkusTestResourceLifecycleManager.super.init(initArgs);
    }
}
