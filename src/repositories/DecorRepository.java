package repositories;

import database.Database;
import entities.Decor;
import entities.Product;

import java.util.List;

public class DecorRepository {

    Database database;

    public DecorRepository(Database database){
        this.database = database;
    }

    public Decor createDecor(String name, double price){
        return new Decor(name, price);
    }

    public boolean addDecor(Decor decor){
        return database.getDecorations().add(decor);
    }

    public boolean removeDecor(String name){

        boolean exist = false;
        int i = 0;

        while(!exist && i<database.getDecorations().size()){

            if(name.equalsIgnoreCase(database.getDecorations().get(i).getName())){
                exist = true;
                database.getDecorations().remove(i);
            }
            i++;
        }
        return exist;
    }

    public Product findOne (String name){
        Product product = null;
        boolean exist = false;
        int i = 0;

        while (!exist && i< database.getDecorations().size()) {

            if (name.equalsIgnoreCase(database.getDecorations().get(i).getName())) {

                exist = true;
                product = database.getDecorations().get(i);

            }
            i++;
        }
        return product;
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
