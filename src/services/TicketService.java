package services;

import entities.Florist;
import entities.Product;
import entities.Ticket;
import entities.Tree;


public class TicketService {

    private Ticket ticket;

    public TicketService(Ticket ticket) {
        this.ticket = ticket;
    }

    public void addTree(int id, Florist florist) {

        boolean exist = false;
        int i = 0;

        while (!exist && i < florist.getWarehouse().getTrees().size()) {

            if (id == florist.getWarehouse().getTrees().get(i).getId()) {

                exist = true;

                ticket.getProducts().add(florist.getWarehouse().getTrees().get(i));

            }
            i++;
        }
    }

    public void total() {

        double totalPriceTicket = 0;

        for (Product product : ticket.getProducts()) {

            totalPriceTicket += product.getPrice();
        }

        ticket.setTotal(totalPriceTicket);
    }

    public void showInfoTicket (){

        System.out.println("Ticket number: " + ticket.getNumTicket() +
                            "\n Date: " + ticket.getDate());

        for (Product product: ticket.getProducts()){

            if (product instanceof Tree){

                Tree tree = (Tree) product;

                System.out.println("Id: " + tree.getId() +
                                    " Name: " + tree.getName() +
                                    " Height: " + tree.getHeight() +
                                    " Price: " + tree.getPrice());

            }
        }

        System.out.println("Total:" + ticket.getTotal());

    }

}
