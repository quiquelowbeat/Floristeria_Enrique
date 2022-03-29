package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable {

    static int numTicketGen = 1;
    private int numTicket;
    private LocalDate date;
    private List<Product> products;
    private double total;

    public Ticket() {
        numTicket = numTicketGen++;
        date = LocalDate.now();
        products = new ArrayList<>();
        total = 0;
    }

    public Ticket(LocalDate date) {
        numTicket = numTicketGen++;
        this.date = date;
        products = new ArrayList<>();
        total = 0;
    }

    public int getNumTicket() {
        return numTicket;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }



}
