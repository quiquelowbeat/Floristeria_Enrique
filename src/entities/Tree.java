package entities;

public class Tree extends Product {

    private double height;

    public Tree(String name, double price, double height){
        super(name, price);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    public String showInfo() {
        return "ID: " + super.id + "\nNombre árbol: " + super.name + "\nAltura: " + this.height + "\nPrecio: " + super.price + "€";
    }
}
