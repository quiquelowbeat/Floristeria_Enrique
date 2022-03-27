package repositories;

import DataBase.Database;
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

    public void addFlower(Flower flower){
        database.getFlowers().add(flower);
    }

    public void removeFlower(int id){

        boolean exist = false;
        int i = 0;

        while(!exist && i<database.getFlowers().size()){

            if(id == database.getFlowers().get(i).getId()){
                exist = true;
                database.getFlowers().remove(i);
            }
            i++;
        }

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
