package repositories;

import DataBase.Database;
import entities.Product;
import entities.Tree;

import java.util.List;

public class TreeRepository {

    private Database database;

    public TreeRepository(Database database) {
        this.database = database;
    }

    public Tree createTree(String name, double price, double height){
        return new Tree(name, price, height);
    }

    public void addTree (Tree tree ){

        database.getTrees().add(tree);

    }

    public void removeTree (int id){

        boolean exist = false;
        int i = 0;

        while (!exist && i< database.getTrees().size()) {

            if (id == database.getTrees().get(i).getId()) {

                exist = true;
                database.getTrees().remove(i);

            }
            i++;
        }
    }

    public int getTreeStockQuantity(){
        return database.getTrees().size();
    }

    public List<Product> getTreesFromDatabase(){
        return database.getTrees();
    }

    public double getTreePrice(int i){

        return database.getTrees().get(i).getPrice();

    }

}
