package com.example.demo.config;

import com.google.common.collect.Sets;

public enum ApplicationUserPermission {

    ADMIN_READ("Admin:read"),
    ADMIN_DELETE("Admin:delete"),
    //ASSISTANCE("Admin:read","Admin:delete","Admin:add"),
    USER_ADD("User_add"),
    ;

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

