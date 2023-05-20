package reg.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {

    ADMIN("Administrator"),
    MANAGER("Manager"),
    USER("User");

    private final String value;

    Roles(String value) {
        this.value = value;
    }

    @Override
    public String getAuthority() {
        return name();
    }

    @Override
    public String toString() {
        return value;
    }
}
