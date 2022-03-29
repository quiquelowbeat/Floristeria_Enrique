package vista;

import entities.*;

import java.util.HashMap;
import java.util.List;


public class View {

    public static void showStock(List<Product> trees, List<Product> flowers, List<Product> decorations) {
        System.out.println("TREES:");
        trees.forEach(x -> {
            Tree tree = (Tree) x;
            System.out.println("Id: " + tree.getId() +
                    " Name: " + tree.getName() +
                    " Height: " + tree.getHeight() +
                    " Price: " + tree.getPrice() + "€");
        });
        System.out.println("FLOWERS:");
        flowers.forEach(x -> {
            Flower flower = (Flower) x;
            System.out.println("Id: " + flower.getId() +
                    " Name: " + flower.getName() +
                    " Color: " + flower.getcolor() +
                    " Price: " + flower.getPrice() + "€");
        });
        System.out.println("DECORATIONS:");
        decorations.forEach(x -> {
            Decor decor = (Decor) x;
            System.out.println("Id: " + decor.getId() +
                    " Name: " + decor.getName() +
                    " Material: " + decor.getMaterial() +
                    " Price: " + decor.getPrice() + "€");
        });
    }

    public static void showTotalValueFlorist(double totalValue) {

        System.out.println(totalValue);

    }

    public static void showStockByProduct(HashMap<String, Integer> stockProducts) {
        System.out.println("TOTAL STOCK:");
        System.out.println("TREES STOCK: " + stockProducts.get("Trees"));
        System.out.println("FLOWERS STOCK: " + stockProducts.get("Flowers"));
        System.out.println("DECOR STOCK: " + stockProducts.get("Decorations"));
    }

    public static void showInfoTicket(Ticket ticket) {

        System.out.println("Ticket number: " + ticket.getNumTicket() +
                "\nDate: " + ticket.getDate());

        for (Product product : ticket.getProducts()) {

            if (product instanceof Tree) {

                Tree tree = (Tree) product;
                System.out.println(tree.showInfo());

            } else if (product instanceof Flower) {

                Flower flower = (Flower) product;
                System.out.println(flower.showInfo());

            } else if (product instanceof Decor) {

                Decor decor = (Decor) product;
                System.out.println(decor.showInfo());
            }
        }

        System.out.println("TICKET TOTAL: " + ((double) Math.round(ticket.getTotal() * 100d) / 100d) + "€");
    }

    public static void showOldTickets(List<Ticket> oldTickets) {

        oldTickets.forEach(x -> showInfoTicket(x));

    }

    public static void showRemoveMessageConfirmation(boolean exist) { // Revisar
        if (exist) {
            System.out.println("Producto borrado con éxito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }


    public static void showTotalSales(double totalSales) {

        System.out.println("TOTAL SALES: " + ((double) Math.round(totalSales * 100d) / 100d) + "€");

    }

    public static void chooseOption () {
        System.out.println("SELECT OPTION 0 - 8:");
        System.out.println("1-ADD TREE." +
                "\n2-ADD FLOWER." +
                "\n3-ADD DECOR." +
                "\n4-SHOW STOCK." +
                "\n5-REMOVE TREE." +
                "\n6-REMOVE FLOWER." +
                "\n7-REMOVE DECOR." +
                "\n8-SHOW STOCK QUANTITY" +
                "\n9-TOTAL VALUE" +
                "\n10-CREATE TICKET" +
                "\n11-SHOW OLD TICKETS" +
                "\n0-EXIT.");
    }

    public static void productAdded ( boolean result){
        if (result) {
            System.out.println("Producto añadido con éxito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void ticketAdded ( boolean result){
        if (result) {
            System.out.println("Ticket añadido con éxito.");
        } else {
            System.out.println("Ticket no añadido.");
        }
    }

    public static void showMessage (String message){
        System.out.println(message);
    }

    public static void closedSoftware () {
        System.out.println("Successfully closed software");
    }

    public static void formatError () {
        System.out.println("Error de formato");
    }

    public static void invalidInformation () {
        System.out.println("Introducción no válida");
    }

    public static void introductionErrorString () {
        System.out.println("Error en la introducción de la string.");

    }

}


