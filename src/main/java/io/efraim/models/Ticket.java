package io.efraim.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
public class Ticket extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String title;

    public String description;

    @ManyToOne(fetch = FetchType.LAZY)
    public User issuer;

    @ManyToOne(fetch = FetchType.LAZY)
    public User admin;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", issuer=" + issuer +
                ", admin=" + admin +
                '}';
    }
}
