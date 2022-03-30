import database.Database;
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

    public static void main(String[] args) {


        Florist florist = new Florist("Margarita", "C/ Peru 254", "698574526");

        Database database = new Database();
        Database.configDatabase(database);

        TreeRepository treeRepository = new TreeRepository(database);
        FlowerRepository flowerRepository = new FlowerRepository(database);
        DecorRepository decorRepository = new DecorRepository(database);
        TicketRepository ticketRepository = new TicketRepository(database);

        FloristService floristService = new FloristService(treeRepository,flowerRepository,decorRepository,ticketRepository);
        TicketService ticketService = new TicketService(ticketRepository,treeRepository, flowerRepository, decorRepository);

        //------------- Menu ------------------

        int choice;
        do{
            View.options();
            choice = Keyboard.readInt("");
            if (!isBetween0And12(choice)){
                View.options();
                choice = Keyboard.readInt("");
            }else{
                switch (choice){

                    case 0:
                        database.writeDataToFiles();
                        View.closedSoftware();
                        break;
                    case 1:
                        View.treeAdded(treeRepository.addTree(treeRepository.createTree(Keyboard.readString("ENTER NAME"),
                                                                                            Keyboard.readDouble("ENTER PRICE"),
                                                                                            Keyboard.readDouble("ENTER HEIGHT"))));
                        break;
                    case 2:
                        View.flowerAdded(flowerRepository.addFlower(flowerRepository.createFlower(Keyboard.readString("ENTER NAME"),
                                                                                                    Keyboard.readDouble("ENTER PRICE"),
                                                                                                    Keyboard.readString("ENTER COLOR"))));
                        break;
                    case 3:
                        Decor decor = decorRepository.createDecor(Keyboard.readString("ENTER NAME"),Keyboard.readDouble("ENTER PRICE"));
                        boolean select;
                        do{
                            select = decor.setTypeOfMaterial(Keyboard.readInt("""
                                                                        MATERIAL:\s
                                                                        1-WOOD
                                                                        2-PLASTIC"""));
                            if(!select){View.showMessage("SELECT 1 OR 2");}
                        }while (!select);
                        View.decorAdded(decorRepository.addDecor(decor));
                        break;
                    case 4:
                        View.showStock(floristService.getTrees(), floristService.getFlowers(), floristService.getDecorations());
                        break;

                    case 5:
                        View.showRemoveMessageConfirmation(treeRepository.removeTree(Keyboard.readInt("ENTER ID")));
                        break;

                    case 6:
                        View.showRemoveMessageConfirmation(flowerRepository.removeFlower(Keyboard.readInt("ENTER ID")));
                        break;

                    case 7:
                        View.showRemoveMessageConfirmation(decorRepository.removeDecor(Keyboard.readInt("ENTER ID")));
                        break;

                    case 8:
                        floristService.createStockFlorist(florist);
                        View.showStockByProduct(florist.getProducts());
                        break;

                    case 9:
                        View.showTotalValueFlorist(floristService.getTotalValue());
                        break;

                    case 10:
                        String x;
                        Ticket ticket = ticketRepository.createTicket();
                        do {
                            View.productAdded(ticketService.addProduct(ticket, Keyboard.readInt("ENTER ID")));
                            x = Keyboard.readString("1-ADD PRODUCT" + "\n0-EXIT");
                        }while (!x.equalsIgnoreCase("0"));
                        ticketService.total(ticket);
                        View.ticketAdded(ticketRepository.addTicket(ticket));
                        break;

                    case 11:
                        View.showOldTickets(ticketRepository.getOldSales(LocalDate.of(Keyboard.readInt("Year YYYY"),
                                                                                        Keyboard.readInt("MONTH MM"),
                                                                                        Keyboard.readInt("DAY DD"))));
                        break;

                    case 12:
                        View.showTotalSales(ticketService.getTotalSales());
                        break;
                }

                System.out.println("--------------------------------------------");

            }
        }while (choice!=0);

    }

    static boolean isBetween0And12(int choice){
        return (choice >= 0) && (choice <=12);
    }

}
