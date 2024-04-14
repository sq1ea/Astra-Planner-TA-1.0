package com.astra.security.util;


import java.security.Principal;

public class CustomPrincipal implements Principal {
    private Long id;
    private String name;

    public CustomPrincipal(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public CustomPrincipal () {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
