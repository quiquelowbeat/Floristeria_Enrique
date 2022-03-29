package services;

import entities.Product;
import entities.Ticket;
import entities.Tree;
import repositories.DecorRepository;
import repositories.FlowerRepository;
import repositories.TicketRepository;
import repositories.TreeRepository;

import java.util.List;


public class TicketService {

    private TicketRepository ticketRepository;
    private TreeRepository treeRepository;
    private FlowerRepository flowerRepository;
    private DecorRepository decorRepository;

    public TicketService ( TicketRepository ticketRepository, TreeRepository treeRepository,
                           FlowerRepository flowerRepository, DecorRepository decorRepository) {
        this.ticketRepository = ticketRepository;
        this.treeRepository = treeRepository;
        this.flowerRepository = flowerRepository;
        this.decorRepository = decorRepository;
    }

    public boolean addProduct(Ticket ticket, int id) {

        boolean result = false;
        Product tree = treeRepository.findOne(id);
        Product flower = flowerRepository.findOne(id);
        Product decor = decorRepository.findOne(id);
        if(tree != null ){
            ticket.getProducts().add(tree);
            treeRepository.removeTree(id);
            result = true;
        }else if(flower != null){
            ticket.getProducts().add(flower);
            flowerRepository.removeFlower(id);
            result = true;
        }else if(decor != null){
            ticket.getProducts().add(decor);
            decorRepository.removeDecor(id);
            result = true;
        }
        return result;
    }

    public void total(Ticket ticket) {

        double totalPriceTicket = 0;

        for (Product product : ticket.getProducts()) {

            totalPriceTicket += product.getPrice();
        }

        ticket.setTotal(totalPriceTicket);
    }

    public double getTotalSales(){
        double totalSales = 0;
        for(Double totalPrice : ticketRepository.getTotalPricesFromDatabase()){
            totalSales += totalPrice;
        }
        return totalSales;

    }




}
