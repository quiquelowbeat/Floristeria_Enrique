import entities.Florist;
import entities.Ticket;
import entities.Tree;
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

        TicketRepository ticketRepository = new TicketRepository(database);

        FloristService floristService = new FloristService(treeRepository,ticketRepository);

        Tree tree = new Tree("Manzano", 25.45, 2.4);
        Tree tree2 = new Tree("Pino", 21.45, 2.1);
        Tree tree3 = new Tree("Olivo", 20, 2);
        Tree tree4 = new Tree("Roble", 25, 2);
        Tree tree5 = new Tree("Peral", 20, 2);
        Tree tree6 = new Tree("Castaño", 25, 2);

        treeRepository.addTree(tree);

        treeRepository.addTree(tree2);

        treeRepository.addTree(tree3);

        treeRepository.addTree(tree4);

        treeRepository.addTree(tree5);

        treeRepository.addTree(tree6);

        Ticket ticket = new Ticket();
        Ticket ticket2 = new Ticket(LocalDate.of(2019,11,4));
        Ticket ticket3 = new Ticket(LocalDate.of(2018,11,4));

        TicketService ticketService = new TicketService(ticketRepository);

        ticketService.addProduct(ticket, tree);
        ticketService.addProduct(ticket, tree2);
        ticketService.total(ticket);
        ticketRepository.addTicket(ticket);

        view.showInfoTicket(ticket);

        ticketService.addProduct(ticket2, tree3);
        ticketService.addProduct(ticket2, tree4);
        ticketService.total(ticket2);

        ticketRepository.addTicket(ticket2);

        ticketService.addProduct(ticket3, tree5);
        ticketService.addProduct(ticket3, tree6);
        ticketService.total(ticket3);

        ticketRepository.addTicket(ticket3);

        view.showOldTickets(ticketRepository.getOldSales(LocalDate.of(2020,1,1)));

        floristService.createStockFlorist(florist);

        view.showStock(floristService.getTrees());

        view.showStockByProduct(florist.getProducts());

        view.showTotalValueFlorist(floristService.getTotalValue());

        treeRepository.removeTree(2);

        view.showStock(floristService.getTrees());

        view.showTotalValueFlorist(floristService.getTotalValue());



    }

}
