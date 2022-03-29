package entities;

public class Flower extends Product {

    private String color;

    public Flower(String name, double price, String color){
        super(name, price);
        this.color = color;
    }

    public String getcolor() {
        return this.color;
    }

    @Override
    public String showInfo() {
        return "ID: " + super.id + "\nNombre flor: " + super.name + "\nColor: " + this.color + "\nPrecio: " + super.price + "€";
    }
}
