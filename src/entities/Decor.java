package entities;

public class Decor extends Product {

    private enum Material {WOOD, PLASTIC}
    private String typeOfMaterial;

    public Decor(String name, double price, String type){
        super(name, price);
        if(type.equalsIgnoreCase("wood")){
            this.typeOfMaterial = "madera";
        } else if(type.equalsIgnoreCase("plastic")) {
            this.typeOfMaterial = "plástico";
        } else{

        }
    }

    public String getMaterial() {
        return this.typeOfMaterial;
    }

    @Override
    public String showInfo() {
        return "ID: " + super.id + "\nNombre árbol: " + super.name + "\nMaterial: " + this.typeOfMaterial + "\nPrecio: " + super.price + "€";
    }
}
