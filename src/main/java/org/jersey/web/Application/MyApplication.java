package org.jersey.web.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.jersey.web.resource.MyResource;

/**
 * Created by nandaye on 2016/3/12 11:55.
 */
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(MyResource.class);
        register(RequestContextFilter.class);
    }
}
