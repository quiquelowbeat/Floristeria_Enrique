package entities;

import java.util.Objects;

public abstract class Product {

    static int nextId = 1;

    protected int id;
    protected String name;
    protected double price;

    public Product(String name, double price){

        this.id = nextId;
        nextId++;
        this.name = name;
        this.price = price;

    }

    public int getId(){

        return this.id;

    }

    public String getName(){

        return this.name;

    }

    public double getPrice(){

        return this.price;

    }

    public void setPrice(double price) {
        this.price = price;
    }

    abstract String showInfo();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
