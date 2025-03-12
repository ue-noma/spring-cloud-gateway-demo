package com.gatewaysample.gateway;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakRealmRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

	@Override
	public Collection<GrantedAuthority> convert(Jwt jwt) {
			Map<String, Object> realmAccess = jwt.getClaim("realm_access");
			if (realmAccess == null || !realmAccess.containsKey("roles")) {
					return Collections.emptyList();
			}

			Collection<String> roles = (Collection<String>) realmAccess.get("roles");

			return roles.stream()
							.map(role -> "ROLE_" + role.toUpperCase())  // Spring Security 標準の ROLE_ プレフィックスを付与
							.map(SimpleGrantedAuthority::new)
							.collect(Collectors.toList());
	}
}
