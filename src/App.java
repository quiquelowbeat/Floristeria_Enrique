import entities.*;
import tools.Keyboard;
import repositories.DecorRepository;
import repositories.FlowerRepository;
import repositories.TicketRepository;
import repositories.TreeRepository;
import services.FloristService;
import services.TicketService;
import vista.View;

import java.io.IOException;
import java.time.LocalDate;


public class App {

    public static void main(String[] args) throws IOException {


        Florist florist = new Florist("Margarita", "C/ Peru 254", "698574526");

        DataBase.Database database = new DataBase.Database();

        TreeRepository treeRepository = new TreeRepository(database);
        FlowerRepository flowerRepository = new FlowerRepository(database);
        DecorRepository decorRepository = new DecorRepository(database);
        TicketRepository ticketRepository = new TicketRepository(database);

        FloristService floristService = new FloristService(treeRepository,flowerRepository,decorRepository,ticketRepository);
        TicketService ticketService = new TicketService(ticketRepository,treeRepository, flowerRepository, decorRepository);

        //------------- Menu ------------------

        String choice;
        do{
            View.chooseOption();
            choice = Keyboard.readString("");
            if (!isBetween0And11(choice)){
                //System.out.println("Select option between 0 y 7.");
                View.chooseOption();
                choice = Keyboard.readString("");
            }else{
                switch (choice){

                    case "0":
                        View.closedSoftware();
                        break;
                    case "1":

                        treeRepository.addTree(treeRepository.createTree(Keyboard.readString("ENTER NAME."),
                                                                            Keyboard.readDouble("ENTER PRICE"),
                                                                            Keyboard.readDouble("ENTER HEIGHT")));
                        break;
                    case "2":
                        flowerRepository.addFlower(flowerRepository.createFlower(Keyboard.readString("ENTER NAME."),
                                                                                    Keyboard.readDouble("ENTER PRICE"),
                                                                                    Keyboard.readString("ENTER COLOR.")));
                        break;
                    case "3":
                        /*decorRepository.addDecor(decorRepository.createDecor(Keyboard.inputStringMessage("ENTER NAME."),
                                                                                Keyboard.inputDoubleMessage("ENTER PRICE"),
                                                                                Keyboard.inputStringMessage("ENTER COLOR.")));*/ // Mirar los enum
                        break;
                    case "4":
                        View.showStock(floristService.getTrees(), floristService.getFlowers(), floristService.getDecorations());

                        break;

                    case "5":
                        View.showRemoveMessageConfirmation(treeRepository.removeTree(Keyboard.readInt("ENTER ID")));
                        break;

                    case "6":
                        View.showRemoveMessageConfirmation(flowerRepository.removeFlower(Keyboard.readInt("ENTER ID")));
                        break;

                    case "7":
                        View.showRemoveMessageConfirmation(decorRepository.removeDecor(Keyboard.readInt("ENTER ID")));
                        break;

                    case "8":
                        floristService.createStockFlorist(florist);
                        View.showStockByProduct(florist.getProducts());
                        break;

                    case "9":
                        View.showTotalValueFlorist(floristService.getTotalValue());
                        break;

                    case "10":
                        String x;
                        Ticket ticket = ticketRepository.createTicket();
                        do {
                            View.productAdded(ticketService.addProduct(ticket, Keyboard.readInt("ENTER ID")));
                            x = Keyboard.readString("1-ADD PRODUCT" + "\n0-EXIT");
                        }while (!x.equalsIgnoreCase("0"));
                        ticketService.total(ticket);
                        View.ticketAdded(ticketRepository.addTicket(ticket));
                        break;

                    case "11":

                        View.showOldTickets(ticketRepository.getOldSales(LocalDate.of(Keyboard.readInt("Year YYYY"),
                                                                                        Keyboard.readInt("MONTH 00"),
                                                                                        Keyboard.readInt("DAY 00"))));

                }

                System.out.println("--------------------------------------------");

            }
        }while (!choice.equals("0"));

        /*Tree tree = new Tree("Manzano", 25.45, 2.4);
        Tree tree2 = new Tree("Pino", 21.45, 2.1);
        Tree tree3 = new Tree("Olivo", 20, 2);
        Tree tree4 = new Tree("Roble", 25, 2);
        Tree tree5 = new Tree("Peral", 20, 2);
        Tree tree6 = new Tree("Castaño", 25, 2);

        Flower flower = new Flower("Margarita", 3.5, "blanco");
        Flower flower2 = new Flower("Rosal", 34.98, "rojo");
        Flower flower3 = new Flower("Diente de león", 18.25, "naranja");
        Flower flower4 = new Flower("Orquídea", 88.7, "blanco");
        Flower flower5 = new Flower("Flor de loto", 94.98, "azul");
        Flower flower6 = new Flower("Jazmín", 24.65, "blanco");

        Decor decor = new Decor("Maceta rústica", 34, Decor.Material.WOOD);
        Decor decor2 = new Decor("Maceta moderna", 21, Decor.Material.PLASTIC);
        Decor decor3 = new Decor("Maceta tallada a mano", 44, Decor.Material.WOOD);

        treeRepository.addTree(tree);
        treeRepository.addTree(tree2);
        treeRepository.addTree(tree3);
        treeRepository.addTree(tree4);
        treeRepository.addTree(tree5);
        treeRepository.addTree(tree6);

        flowerRepository.addFlower(flower);
        flowerRepository.addFlower(flower2);
        flowerRepository.addFlower(flower3);
        flowerRepository.addFlower(flower4);
        flowerRepository.addFlower(flower5);

        decorRepository.addDecor(decor);
        decorRepository.addDecor(decor2);
        decorRepository.addDecor(decor3);

        Ticket ticket = new Ticket();
        Ticket ticket2 = new Ticket(LocalDate.of(2019,11,4));
        Ticket ticket3 = new Ticket(LocalDate.of(2018,11,4));



        ticketService.addProduct(ticket, tree);
        ticketService.addProduct(ticket, tree2);
        ticketService.addProduct(ticket, flower3);
        ticketService.addProduct(ticket, decor3);
        ticketService.total(ticket);
        ticketRepository.addTicket(ticket);

        View.showInfoTicket(ticket);

        ticketService.addProduct(ticket2, tree3);
        ticketService.addProduct(ticket2, tree4);
        ticketService.addProduct(ticket2, flower);
        ticketService.addProduct(ticket2, flower5);
        ticketService.addProduct(ticket2, flower6);
        ticketService.addProduct(ticket, decor);
        ticketService.addProduct(ticket, decor2);
        ticketService.addProduct(ticket, decor3);
        ticketService.total(ticket2);

        ticketRepository.addTicket(ticket2);

        ticketService.addProduct(ticket3, tree5);
        ticketService.addProduct(ticket3, tree6);
        ticketService.addProduct(ticket3, flower3);
        ticketService.addProduct(ticket, decor3);
        ticketService.total(ticket3);

        ticketRepository.addTicket(ticket3);

        View.showOldTickets(ticketRepository.getOldSales(LocalDate.of(2020,1,1)));

        floristService.createStockFlorist(florist);

        View.showStock(floristService.getTrees(), floristService.getFlowers(), floristService.getDecorations());

        View.showStockByProduct(florist.getProducts());

        View.showTotalValueFlorist(floristService.getTotalValue());

        treeRepository.removeTree(2);
        treeRepository.removeTree(9);
        flowerRepository.removeFlower(7);
        decorRepository.removeDecor(13);
        View.showRemoveMessageConfirmation(treeRepository.removeTree(13));
        floristService.createStockFlorist(florist);

        View.showStock(floristService.getTrees(), floristService.getFlowers(), floristService.getDecorations());

        View.showTotalValueFlorist(floristService.getTotalValue());

        // treeRepository.updateTreePrice(3, 35);

        // floristService.createStockFlorist(florist);
        View.showStock(floristService.getTrees(), floristService.getFlowers(), floristService.getDecorations());
        View.showStockByProduct(florist.getProducts());

        View.showTotalSales(ticketService.getTotalSales());

        */
        database.writeDataToFiles();
        database.readDataFromFiles();

        //treeRepository.updateTreePrice(3, 35);

        // floristService.createStockFlorist(florist);
        //view.showStock(floristService.getTrees(), floristService.getFlowers(), floristService.getDecorations());
        //view.showStockByProduct(florist.getProducts());

    }

    static boolean isBetween0And11(String choice){
        return (choice.equals("0")) || (choice.equals("1")) || (choice.equals("2")) || (choice.equals("3")) || (choice.equals("4")) ||
                (choice.equals("5")) || (choice.equals("6")) || (choice.equals("7")) || (choice.equals("8")) || (choice.equals("9")) ||
                (choice.equals("10")) || (choice.equals("11"));
    }

}
