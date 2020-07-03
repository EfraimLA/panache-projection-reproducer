package io.efraim.models;

import io.quarkus.runtime.annotations.RegisterForReflection;


@RegisterForReflection
public class TicketUser {

    public final Long id;
    // Entity Relation
    public final User user;

    public TicketUser(Long id, User user) {
        this.id = id;
        this.user = user;
    }

    @Override
    public String toString() {
        return "TicketUser{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
