package io.efraim.models;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class TicketDesc {

    public final Long id;
    public final String title;
    public final String description;

    public TicketDesc(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "TicketDesc{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
