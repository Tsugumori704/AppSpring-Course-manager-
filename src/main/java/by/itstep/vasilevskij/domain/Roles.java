package by.itstep.vasilevskij.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    USER, ADMIN, TEACHER;

    @Override
    public String getAuthority() {
        return name();
    }
}