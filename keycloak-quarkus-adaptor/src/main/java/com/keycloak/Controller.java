package com.keycloak;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("app_quarkus")
public class Controller {

    @GET
    @Path("read")
    public String read() {
        return "this role can read";
    }

    @GET
    @Path("write")
    public String write() {
        return "this role can write";
    }

    @GET
    @Path("modify")
    public String modify() {
        return "this role can modify";
    }

}
