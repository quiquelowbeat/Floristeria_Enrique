package entities;

public class Decor extends Product {

    public enum Material {WOOD, PLASTIC};
    private String typeOfMaterial;

    public Decor(String name, double price, Material material){
        super(name, price);
        this.typeOfMaterial = material.toString().toLowerCase();
    }

    public String getMaterial() {
        return this.typeOfMaterial;
    }

    @Override
    public String showInfo() {
        return "ID: " + super.id + "\nNombre árbol: " + super.name + "\nMaterial: " + this.typeOfMaterial + "\nPrecio: " + super.price + "€";
    }
}
