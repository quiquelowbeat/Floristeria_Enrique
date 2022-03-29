package entities;

public class Decor extends Product {

    enum Material {WOOD, PLASTIC}
    private String typeOfMaterial;

    public Decor(String name, double price){
        super(name, price);
        typeOfMaterial = "";
    }

    public boolean setTypeOfMaterial(int type) {
        boolean select = false;
        if(type == 1) {
            typeOfMaterial = "WOOD";
            select = true;
        }else if(type == 2){
            typeOfMaterial = "PLASTIC";
            select = true;
        }
        return select;
    }

    public String getMaterial() {
        return this.typeOfMaterial;
    }

    @Override
    public String showInfo() {
        return "ID: " + super.id + "\nNombre decoración: " + super.name + "\nMaterial: " + this.typeOfMaterial + "\nPrecio: " + super.price + "€";
    }
}
