import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        U1 ship = new U1();

        Simulation simulation = new Simulation();
        try {
             simulation.loadItems();

        } catch (FileNotFoundException notFoundException) {
            System.out.println("FileNotFound exeptiona has been ussed");
        }
    }
}