package database;

import entities.*;
import vista.View;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Product> trees;
    private List<Product> flowers;
    private List<Product> decorations;
    private List<Ticket> tickets;
    private static File currentDirectory = configDirectory();
    private static final Path[] pathNames = {Path.of(currentDirectory + File.separator + "trees_db.txt"),
            Path.of(currentDirectory + File.separator + "flowers_db.txt"),
            Path.of(currentDirectory + File.separator + "decor_db.txt"),
            Path.of(currentDirectory + File.separator + "tickets_db.txt")};

    public Database() {

        trees = new ArrayList<>();
        flowers = new ArrayList<>();
        decorations = new ArrayList<>();
        tickets = new ArrayList<>();

    }

    public List<Product> getTrees() { return trees; }
    public List<Product> getFlowers(){ return flowers; }
    public List<Product> getDecorations(){ return decorations; }
    public List<Ticket> getTickets() { return tickets;}


    public void setTrees(List<Product> trees) { this.trees = trees; }
    public void setFlowers(List<Product> flowers) { this.flowers = flowers; }
    public void setDecorations(List<Product> decorations) { this.decorations = decorations; }
    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }

    // Métodos de escritura y lectura de archivos.

    public void writeDataToFiles() {
        ObjectOutputStream writeFile = null;
        // System.out.println(Database.configDirectory());
        try {
            writeFile = new ObjectOutputStream(new FileOutputStream(String.valueOf(pathNames[0])));
            writeFile.writeObject(this.trees);
            writeFile = new ObjectOutputStream(new FileOutputStream(String.valueOf(pathNames[1])));
            writeFile.writeObject(this.flowers);
            writeFile = new ObjectOutputStream(new FileOutputStream(String.valueOf(pathNames[2])));
            writeFile.writeObject(this.decorations);
            writeFile = new ObjectOutputStream(new FileOutputStream(String.valueOf(pathNames[3])));
            writeFile.writeObject(this.tickets);
            writeFile.close();
        } catch (IOException e) {
            View.fileNotFound();
            e.printStackTrace();
        }

    }

    public void readDataFromFiles() {
        ObjectInputStream readFile = null;
        // System.out.println(Database.configDirectory());
        try {
            readFile = new ObjectInputStream(new FileInputStream(String.valueOf(pathNames[0])));
            trees = ((ArrayList<Product>) readFile.readObject()); // Hacemos cast porque readFile devuelve un Object.
            readFile = new ObjectInputStream(new FileInputStream(String.valueOf(pathNames[1])));
            flowers = (ArrayList<Product>) readFile.readObject();
            readFile = new ObjectInputStream(new FileInputStream(String.valueOf(pathNames[2])));
            decorations = (ArrayList<Product>) readFile.readObject();
            readFile = new ObjectInputStream(new FileInputStream(String.valueOf(pathNames[3])));
            tickets = (ArrayList<Ticket>) readFile.readObject();
            readFile.close();
        } catch (ClassNotFoundException | IOException e) {
            View.fileNotFound();
            e.printStackTrace();
        }

    }

    public static void configDatabase(Database database) {
        File file;
        try {
            if(!Files.exists(pathNames[0]) && !Files.exists(pathNames[1])
                    && !Files.exists(pathNames[2]) && !Files.exists(pathNames[3])) {
                for (int i = 0; i < pathNames.length; i++) {
                    file = new File(String.valueOf(pathNames[i]));
                    if(!file.exists()) {
                        file.createNewFile();
                    }
                }
                database.writeDataToFiles();
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        database.readDataFromFiles();

    }

    public static File configDirectory(){

        String osName = System.getProperty("os.name").toLowerCase();

        if(osName.contains("mac") || osName.contains("nix") || osName.contains("nux") || osName.contains("aix")){
            currentDirectory = new File(System.getProperty("user.dir") + File.separator + "database");
        } else {
            currentDirectory = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "database");
        }

        return currentDirectory;

    }

}
