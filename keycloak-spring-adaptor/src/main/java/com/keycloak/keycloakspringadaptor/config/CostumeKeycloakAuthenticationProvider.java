package com.keycloak.keycloakspringadaptor.config;

import org.keycloak.adapters.springsecurity.account.KeycloakRole;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CostumeKeycloakAuthenticationProvider extends KeycloakAuthenticationProvider {

    @Autowired
    PermissionRoleBased permissionRoleBased;

    private GrantedAuthoritiesMapper grantedAuthoritiesMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken)authentication;
        List<GrantedAuthority> grantedAuthorities = new ArrayList();
//        Iterator var4 = token.getAccount().getRoles().iterator();
        Iterator var4 =  permissionRoleBased.getPermissionsByRoles(token.getAccount().getRoles()).iterator();

        while(var4.hasNext()) {
            String role = (String)var4.next();
            System.out.println("from the costume role: " + role);
            grantedAuthorities.add(new KeycloakRole(role));

        }

        return new KeycloakAuthenticationToken(token.getAccount(), token.isInteractive(), this.mapAuthorities(grantedAuthorities));
    }

    private Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
        return this.grantedAuthoritiesMapper != null ? this.grantedAuthoritiesMapper.mapAuthorities(authorities) : authorities;
    }
}
