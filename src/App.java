import entities.Florist;
import repositories.TreeRepository;
import services.FloristService;


public class App {

    public static void main(String[] args) {

        Florist florist = new Florist("Margarita", "C/ Peru 254", "698574526");

        TreeRepository floristRepository = new TreeRepository(florist);

        FloristService floristService = new FloristService(floristRepository, florist);

        floristRepository.addTree("Manzano", 25.45, 2.4);

        floristRepository.addTree("Pino", 21.45, 2.1);

        floristRepository.addTree("Olivo", 20, 2);

        floristRepository.stock();

        floristService.TotalValue();

        floristRepository.removeTree(2);

        floristRepository.stock();

        floristRepository.stockQuantity();

        floristService.TotalValue();



    }

}
