package entities;

public class Decor extends Product {

    public enum Material {WOOD, PLASTIC}
    private String typeOfMaterial;

    public Decor(String name, double price, Material material){
        super(name, price);
        if(material.equals(Material.WOOD)){
            this.typeOfMaterial = "madera";
        } else {
            this.typeOfMaterial = "plástico";
        }
    }

    public String getMaterial() {
        return this.typeOfMaterial;
    }

    @Override
    public String showInfo() {
        return "ID: " + super.id + "\nNombre decoración: " + super.name + "\nMaterial: " + this.typeOfMaterial + "\nPrecio: " + super.price + "€";
    }
}
