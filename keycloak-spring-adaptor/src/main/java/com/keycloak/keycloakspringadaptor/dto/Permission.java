package com.keycloak.keycloakspringadaptor.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Permission {
    private String role;
    private List<String> permission;
}
