import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {


        Simulation simulation = new Simulation();
        try {

            simulation.runSimulation(simulation.loadU1(simulation.loadItems()));


        } catch (FileNotFoundException notFoundException) {
            System.out.println("FileNotFound exeptiona has been ussed");
        }



    }
}