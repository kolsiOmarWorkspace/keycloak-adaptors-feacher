package com.keycloak;


import io.quarkus.security.Authenticated;
import io.vertx.core.http.HttpServerRequest;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.IOException;


@Provider
public class CustomFilter implements ContainerRequestFilter {

    private static final Logger LOG = Logger.getLogger(CustomFilter.class);

    @Context
    UriInfo info;

    @Context
    HttpServerRequest request;

    @Inject
    SecurityContext securityContext;


    @Override
    @Authenticated
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        final String method = containerRequestContext.getMethod();
        final String path = info.getPath();
        final String address = request.remoteAddress().toString();
        System.out.println(securityContext);
        LOG.infof("Request %s %s from IP %s", method, path, address);
    }
}
