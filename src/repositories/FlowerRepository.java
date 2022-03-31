package repositories;

import database.Database;
import entities.Flower;
import entities.Product;

import java.util.List;

public class FlowerRepository {

    private Database database;

    public FlowerRepository(Database database) {
        this.database = database;
    }

    public Flower createFlower(String name, double price, String color){
        return new Flower(name, price, color);
    }

    public boolean addFlower(Flower flower){
        return database.getFlowers().add(flower);
    }

    public boolean removeFlower(String name){

        boolean exist = false;
        int i = 0;

        while(!exist && i<database.getFlowers().size()){

            if(name.equalsIgnoreCase(database.getFlowers().get(i).getName())){
                exist = true;
                database.getFlowers().remove(i);
            }
            i++;
        }
        return exist;
    }

    public Product findOne (String name){
        Product product = null;
        boolean exist = false;
        int i = 0;

        while (!exist && i< database.getFlowers().size()) {

            if (name.equalsIgnoreCase(database.getFlowers().get(i).getName())) {

                exist = true;
                product = database.getFlowers().get(i);

            }
            i++;
        }
        return product;
    }

    public int getFlowerStockQuantity(){
        return database.getFlowers().size();
    }

    public List<Product> getFlowersFromDatabase(){
        return database.getFlowers();
    }

    public double getFlowerPrice(int i){
        return database.getFlowers().get(i).getPrice();
    }

}
