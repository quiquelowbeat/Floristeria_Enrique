package repositories;

import entities.Florist;
import entities.Tree;

public class TreeRepository {

    private Florist florist;

    public TreeRepository(Florist florist) {
        this.florist = florist;
    }

    public void addTree (String name, double price, double height ){

        florist.getWarehouse().getTrees().add(new Tree(name, price, height));

    }

    public void removeTree (int id){

        boolean exist = false;
        int i = 0;

        while (!exist && i< florist.getWarehouse().getTrees().size()) {

            if (id == florist.getWarehouse().getTrees().get(i).getId()) {

                exist = true;
                florist.getWarehouse().getTrees().remove(florist.getWarehouse().getTrees().get(i));

            }
            i++;
        }
    }

    public void stock(){
        System.out.println("TREES:");
        florist.getWarehouse().getTrees().forEach(x -> {

            Tree tree = (Tree) x;
            System.out.println("Id: " + tree.getId() +
                    " Name: " + tree.getName() +
                    " Height: " + tree.getHeight() +
                    " Price: " + tree.getPrice());
        } );
    }

    public void stockQuantity(){

        System.out.println("TREES: " + florist.getWarehouse().getTrees().size());

    }

    public double totalPriceTree(int i){

        return florist.getWarehouse().getTrees().get(i).getPrice();

    }

}
