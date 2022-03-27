package repositories;

import DataBase.Database;
import entities.Decor;
import entities.Product;

import java.util.List;

public class DecorRepository {

    Database database;

    public DecorRepository(Database database){
        this.database = database;
    }

    public Decor createDecor(String name, double price, Decor.Material material){
        return new Decor(name, price, material);
    }

    public void addDecor(Decor decor){
        database.getDecorations().add(decor);
    }

    public void removeDecor(int id){

        boolean exist = false;
        int i = 0;

        while(!exist && i<database.getDecorations().size()){

            if(id == database.getDecorations().get(i).getId()){
                exist = true;
                database.getDecorations().remove(i);
            }
            i++;
        }

    }

    public int getDecorStockQuantity(){
        return database.getDecorations().size();
    }

    public List<Product> getDecorFromDatabase(){
        return database.getDecorations();
    }

    public double getDecorPrice(int i){
        return database.getDecorations().get(i).getPrice();
    }
}
