package io.efraim.models;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class TicketUser {

    public Long id;
    public User issuer;
    public User admin;

    public TicketUser(final Long id, final User issuer, final User admin) {
        this.id = id;
        this.issuer = issuer;
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "TicketUser{" +
                "id=" + id +
                ", issuer=" + issuer +
                ", admin=" + admin +
                '}';
    }
}
