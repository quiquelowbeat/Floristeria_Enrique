package services;

import entities.Florist;
import entities.Product;
import repositories.TicketRepository;
import repositories.TreeRepository;

import java.util.List;

public class FloristService {

    private TreeRepository treeRepository;
    private TicketRepository ticketRepository;



    public FloristService(TreeRepository treeRepository, TicketRepository ticketRepository) {
        this.treeRepository = treeRepository;
        this.ticketRepository = ticketRepository;
    }

    public FloristService(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    public void createStockFlorist(Florist florist){

        florist.getProducts().put("Tree", treeRepository.getTreeStockQuantity()); // Falta añadir las entidades que faltan

    }

    public double getTotalValue(){
        double result = 0;
        for(int i = 0; i<treeRepository.getTreeStockQuantity(); i++){

            result += treeRepository.getTreePrice(i);

        }

        return result;

    }

    public List<Product> getTrees() {

        return treeRepository.getTreesFromDatabase();
    }


}
