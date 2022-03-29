package repositories;

import DataBase.Database;
import entities.Product;
import entities.Tree;
import vista.View;

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

    public boolean removeTree (int id){

        boolean exist = false;
        int i = 0;

        while (!exist && i< database.getTrees().size()) {

            if (id == database.getTrees().get(i).getId()) {

                exist = true;
                database.getTrees().remove(i);

            }
            i++;
        }
       return exist;
    }

    public Product findOne (int id){
        Product product = null;
        boolean exist = false;
        int i = 0;

        while (!exist && i< database.getTrees().size()) {

            if (id == database.getTrees().get(i).getId()) {

                exist = true;
                product = database.getTrees().get(i);

            }
            i++;
        }
        return product;
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

    // Testing update (CRUD)
    /*public void updateTreePrice(int id, double price){
        boolean exist = false;
        int i = 0;

        while(!exist && i<database.getTrees().size()){
            if (id == database.getTrees().get(i).getId()){
                exist = true;
                database.getTrees().get(i).setPrice(price);
            }
            i++;
        }

    }*/
}
