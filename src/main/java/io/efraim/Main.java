package io.efraim;

import io.efraim.models.Ticket;
import io.efraim.models.TicketDesc;
import io.efraim.models.TicketUser;
import io.efraim.models.User;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@QuarkusMain
public class Main {

    public static void main(final String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        private static final Logger LOGGER = Logger.getLogger(App.class);

        @Inject
        EntityManager em;

        @Override
        @Transactional
        public int run(final String... args) throws Exception {
            final User user = new User();
            user.name = "test";

            User.persist(user);

            LOGGER.info("Persisted User: " + user);

            final Ticket ticket = new Ticket();
            ticket.title = "Test 1";
            ticket.description = "Used to test application";
            ticket.issuer = user;
            ticket.admin = user;

            final Ticket ticket1 = new Ticket();
            ticket1.title = "Test 2";
            ticket1.description = "Testing twice";
            ticket1.issuer = user;

            final Ticket ticket2 = new Ticket();
            ticket2.title = "Test 3";
            ticket2.description = "Testing three";
            ticket2.admin = user;

            Ticket.persist(ticket);
            Ticket.persist(ticket1);
            Ticket.persist(ticket2);

            LOGGER.info("Persisted Ticket: " + ticket);
            LOGGER.info("Persisted Ticket 1: " + ticket1);
            LOGGER.info("Persisted Ticket 2: " + ticket2);

            final List<TicketDesc> ticketDescs = Ticket.findAll().project(TicketDesc.class).list();

            ticketDescs.forEach(t -> LOGGER.info("Projected TicketDesc: " + t));

            // Throws NPE
//            final List<TicketUser> ticketUsers = em.createQuery("select t from Ticket t", TicketUser.class).getResultList();

            // Doesn't throw exception but fails when fetching null relations
            final List<TicketUser> ticketUsers = em.createQuery("select new io.efraim.models.TicketUser(t.id, t.issuer, t.admin) from Ticket t", TicketUser.class).getResultList();
            ticketUsers.forEach(t -> LOGGER.info("Projected TicketUser: " + t));

            Quarkus.waitForExit();
            return 0;
        }
    }
}
