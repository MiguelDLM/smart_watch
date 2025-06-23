package com.alibaba.fastjson.support.jaxrs;

import javax.annotation.Priority;
import javax.ws.rs.core.FeatureContext;
import org.glassfish.jersey.internal.spi.AutoDiscoverable;

@Priority(1999)
public class FastJsonAutoDiscoverable implements AutoDiscoverable {
    public static final String FASTJSON_AUTO_DISCOVERABLE = "fastjson.auto.discoverable";
    public static volatile boolean autoDiscover = true;

    static {
        try {
            autoDiscover = Boolean.parseBoolean(System.getProperty(FASTJSON_AUTO_DISCOVERABLE, String.valueOf(autoDiscover)));
        } catch (Throwable unused) {
        }
    }

    public void configure(FeatureContext featureContext) {
        if (!featureContext.getConfiguration().isRegistered(FastJsonFeature.class) && autoDiscover) {
            featureContext.register(FastJsonFeature.class);
        }
    }
}
