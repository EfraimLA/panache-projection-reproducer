package io.efraim.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    @OneToMany(mappedBy = "issuer")
    public List<Ticket> issuedTickets = new ArrayList<>();

    @OneToMany(mappedBy = "admin")
    public List<Ticket> adminTickets = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", issuedTickets=" + issuedTickets +
                ", adminTickets=" + adminTickets +
                '}';
    }
}
