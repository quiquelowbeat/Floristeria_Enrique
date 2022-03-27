import entities.*;
import repositories.DecorRepository;
import repositories.FlowerRepository;
import repositories.TicketRepository;
import repositories.TreeRepository;
import services.FloristService;
import services.TicketService;
import vista.View;

import java.time.LocalDate;


public class App {

    public static void main(String[] args) {

        Florist florist = new Florist("Margarita", "C/ Peru 254", "698574526");

        View view = new View();

        DataBase.Database database = new DataBase.Database();

        TreeRepository treeRepository = new TreeRepository(database);
        FlowerRepository flowerRepository = new FlowerRepository(database);
        DecorRepository decorRepository = new DecorRepository(database);
        TicketRepository ticketRepository = new TicketRepository(database);

        FloristService floristService = new FloristService(treeRepository,flowerRepository,decorRepository,ticketRepository);

        Tree tree = new Tree("Manzano", 25.45, 2.4);
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

        TicketService ticketService = new TicketService(ticketRepository);

        ticketService.addProduct(ticket, tree);
        ticketService.addProduct(ticket, tree2);
        ticketService.addProduct(ticket, flower3);
        ticketService.addProduct(ticket, decor3);
        ticketService.total(ticket);
        ticketRepository.addTicket(ticket);

        view.showInfoTicket(ticket);

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

        view.showOldTickets(ticketRepository.getOldSales(LocalDate.of(2020,1,1)));

        floristService.createStockFlorist(florist);

        view.showStock(floristService.getTrees(), floristService.getFlowers(), floristService.getDecorations());

        view.showStockByProduct(florist.getProducts());

        view.showTotalValueFlorist(floristService.getTotalValue());

        treeRepository.removeTree(2); // Test View.showRemoveMessageConfirmation();
        treeRepository.removeTree(9);
        flowerRepository.removeFlower(7);
        decorRepository.removeDecor(13);

        view.showStock(floristService.getTrees(), floristService.getFlowers(), floristService.getDecorations());

        view.showTotalValueFlorist(floristService.getTotalValue());

        treeRepository.updateTreePrice(3, 35);

        // floristService.createStockFlorist(florist);
        view.showStock(floristService.getTrees(), floristService.getFlowers(), floristService.getDecorations());
        view.showStockByProduct(florist.getProducts());

    }

}
