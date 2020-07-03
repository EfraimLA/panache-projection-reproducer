package io.efraim;

import io.efraim.models.Ticket;
import io.efraim.models.TicketDesc;
import io.efraim.models.TicketUser;
import io.efraim.models.User;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.jboss.logging.Logger;

import javax.transaction.Transactional;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        private static final Logger LOGGER = Logger.getLogger(App.class);

        @Override
        @Transactional
        public int run(String... args) throws Exception {
            User user = new User();
            user.name = "test";

            User.persist(user);

            LOGGER.info("Persisted User: " + user);

            Ticket ticket = new Ticket();
            ticket.title = "Test 1";
            ticket.description = "Used to test application";
            ticket.user = user;

            Ticket.persist(ticket);

            LOGGER.info("Persisted Ticket: " + ticket);

            TicketDesc ticketDesc = Ticket.find("id", ticket.id).project(TicketDesc.class).firstResult();

            LOGGER.info("Projected TicketDesc: " + ticketDesc);

            // This will throw exception
            TicketUser ticketUser = Ticket.find("id", ticket.id).project(TicketUser.class).firstResult();

            LOGGER.info("Projected TicketUser: " + ticketUser);

            Quarkus.waitForExit();
            return 0;
        }
    }
}
