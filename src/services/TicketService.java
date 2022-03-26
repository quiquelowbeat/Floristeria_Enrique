package services;

import entities.Product;
import entities.Ticket;
import entities.Tree;
import repositories.TicketRepository;


public class TicketService {

    private TicketRepository ticketRepository;

    public TicketService ( TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void addProduct(Ticket ticket, Product product) {

        ticket.getProducts().add(product);

    }

    public void total(Ticket ticket) {

        double totalPriceTicket = 0;

        for (Product product : ticket.getProducts()) {

            totalPriceTicket += product.getPrice();
        }

        ticket.setTotal(totalPriceTicket);
    }




}
