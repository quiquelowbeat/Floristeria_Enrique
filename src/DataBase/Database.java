package DataBase;

import entities.Product;
import entities.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Product> trees;
    private List<Ticket> tickets;

    public Database() {

        trees = new ArrayList<>();
        tickets = new ArrayList<>();

    }

    public List<Product> getTrees() {
        return trees;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTrees(List<Product> trees) {
        this.trees = trees;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }



}
