package com.keycloak.keycloakspringadaptor.config;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keycloak.keycloakspringadaptor.dto.Permission;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PermissionRoleBased {

    private List<Permission> permissionList;


    public List<String> getPermissionsByRoles(Set<String> roles) {

        return   permissionList.stream().distinct()
                .filter(x -> roles.contains(x.getRole())).flatMap( x-> x.getPermission().stream()).collect(Collectors.toList());

    }


    @PostConstruct
    public void read() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Permission>> typeReference = new TypeReference<List<Permission>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
        try {
            List<Permission> permissions = mapper.readValue(inputStream, typeReference);
            permissionList = permissions;
        } catch (IOException e) {

        }
    }
}
