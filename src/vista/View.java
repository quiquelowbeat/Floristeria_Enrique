package vista;

import entities.Product;
import entities.Ticket;
import entities.Tree;

import java.util.HashMap;
import java.util.List;

public class View {

    public void showStock(List<Product> trees) { //Falta añadir los otros productos
        System.out.println("TREES:");
        trees.forEach(x -> {
            Tree tree = (Tree) x;
            System.out.println("Id: " + tree.getId() +
                    " Name: " + tree.getName() +
                    " Height: " + tree.getHeight() +
                    " Price: " + tree.getPrice() + "€");
        });
    }

    public void showTotalValueFlorist(double totalValue){

        System.out.println(totalValue);

    }

    public void showStockByProduct(HashMap<String, Integer> stockProducts){ // Falta añadir los demás productos
        System.out.println("TOTAL STOCK:");
        System.out.println("TREES STOCK: " + stockProducts.get("Tree"));
    }

    public void showInfoTicket (Ticket ticket){

        System.out.println("Ticket number: " + ticket.getNumTicket() +
                "\nDate: " + ticket.getDate());

        for (Product product: ticket.getProducts()){

            if (product instanceof Tree){

                Tree tree = (Tree) product;

                System.out.println(tree.showInfo());

            }
        }

        System.out.println("Total:" + ticket.getTotal());

    }

    public void showOldTickets(List<Ticket> oldTickets){

        oldTickets.forEach(x -> showInfoTicket(x));

    }

}
