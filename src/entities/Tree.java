package entities;

public class Tree extends Product {

    private double height;

    public Tree(String name, double price, double height){
        super(name, price);
        this.height = height;
    }

    @Override
    public String showInfo() {
        return "Nombre árbol: " + super.getName() + "\nAltura: " + this.height + "\nPrecio: " + super.getPrice() + "€\n";
    }
}
