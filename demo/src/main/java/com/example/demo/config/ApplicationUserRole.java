package com.example.demo.config;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.demo.config.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_DELETE)),
    USER(Sets.newHashSet()),
    ASSISTANCE(Sets.newHashSet(ADMIN_READ,ADMIN_DELETE,USER_ADD))
    ;

    private final Set<ApplicationUserPermission> permission;

    ApplicationUserRole(Set<ApplicationUserPermission> permission) {
        this.permission = permission;
    }
}
