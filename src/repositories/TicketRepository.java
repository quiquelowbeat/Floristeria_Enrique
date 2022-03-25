package repositories;

import entities.Florist;
import entities.Ticket;

public class TicketRepository {

    private Florist florist;

    public TicketRepository(Florist florist) {
        this.florist = florist;
    }

    public void addTicket(){
        florist.getWarehouse().getTickets().add(new Ticket());
    }
}
