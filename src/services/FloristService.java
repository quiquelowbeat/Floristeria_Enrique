package services;

import entities.Florist;
import repositories.TreeRepository;

public class FloristService {

    private TreeRepository treeRepository;
    private Florist florist;

    public FloristService(TreeRepository treeRepository, Florist florist) {
        this.treeRepository = treeRepository;
        this.florist = florist;
    }

    public FloristService(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    public void TotalValue(){
        double result = 0;
        for(int i = 0; i<florist.getWarehouse().getTrees().size(); i++){

            result += treeRepository.totalPriceTree(i);

        }

        System.out.println(result);

    }

}
