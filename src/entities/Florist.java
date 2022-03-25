package entities;

import DataBase.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class Florist {

    static int idGenerator = 1;
    private int idFlorist;
    private String name;
    private String address;
    private String phoneNum;
    private Warehouse warehouse;
    /*private List<Product> trees;
    private List<Ticket> tickets;*/

    public Florist (String name, String address, String phoneNum) {
        idFlorist = idGenerator++;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        warehouse = new Warehouse();
        /*trees = new ArrayList<>();
        tickets = new ArrayList<>();*/
    }

    public int getIdFlorist() {
        return idFlorist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    /*public List<Product> getTrees() {
        return trees;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }*/
}
