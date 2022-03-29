import database.Database;
<<<<<<< HEAD
import entities.Florist;
import entities.Ticket;
=======
import entities.*;
import tools.Keyboard;
>>>>>>> main
import repositories.DecorRepository;
import repositories.FlowerRepository;
import repositories.TicketRepository;
import repositories.TreeRepository;
import services.FloristService;
import services.TicketService;
import tools.Keyboard;
import vista.View;

import java.io.IOException;
import java.time.LocalDate;


public class App {

    public static void main(String[] args) throws IOException {


        Florist florist = new Florist("Margarita", "C/ Peru 254", "698574526");

        Database database = new Database();

        TreeRepository treeRepository = new TreeRepository(database);
        FlowerRepository flowerRepository = new FlowerRepository(database);
        DecorRepository decorRepository = new DecorRepository(database);
        TicketRepository ticketRepository = new TicketRepository(database);

        FloristService floristService = new FloristService(treeRepository,flowerRepository,decorRepository,ticketRepository);
        TicketService ticketService = new TicketService(ticketRepository,treeRepository, flowerRepository, decorRepository);

        //------------- Menu ------------------

        String choice;
        do{
            View.options();
            choice = Keyboard.readString("");
            if (!isBetween0And12(choice)){
                View.options();
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
                        break;

                    case "12":
                        View.showTotalSales(ticketService.getTotalSales());
                        break;
                }

                System.out.println("--------------------------------------------");

            }
        }while (!choice.equals("0"));

<<<<<<< HEAD
        database.writeDataToFiles();
        database.readDataFromFiles();
=======
        //database.writeDataToFiles();
        //database.readDataFromFiles();
>>>>>>> main

    }

    static boolean isBetween0And12(String choice){
        return (choice.equals("0")) || (choice.equals("1")) || (choice.equals("2")) || (choice.equals("3")) || (choice.equals("4")) ||
                (choice.equals("5")) || (choice.equals("6")) || (choice.equals("7")) || (choice.equals("8")) || (choice.equals("9")) ||
                (choice.equals("10")) || (choice.equals("11")) || (choice.equals("12"));
    }

}
