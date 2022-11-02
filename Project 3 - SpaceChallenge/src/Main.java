import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Simulation simulation = new Simulation();

        File phase1File = new File("/home/patryk/Desktop/Projekty/prework dla infoshare/Project 3 - SpaceChallenge/src/cargo files/Phase-1.txt");
        File phase2File = new File("/home/patryk/Desktop/Projekty/prework dla infoshare/Project 3 - SpaceChallenge/src/cargo files/Phase-2.txt");
        int costU1Phase1 = 0;
        int costU1Phase2 = 0;
        int costU2Phase1 = 0;
        int costU2Phase2 = 0;
        try {
            //Loading Items for phase one and two
            ArrayList<Item> phase1ItemList;
            phase1ItemList = simulation.loadItems(phase1File);
            ArrayList<Item> phase2ItemList;
            phase2ItemList = simulation.loadItems(phase2File);

            //loading U1 rocket for phase one
            ArrayList<Rocket> phase1U1Rocket;
            phase1U1Rocket = simulation.loadU1(phase1ItemList);
            // loading U1 Rocket for phase two
            ArrayList<Rocket> phase2U1Rocket;
            phase2U1Rocket = simulation.loadU1(phase2ItemList);

            //loading U2 rocket for phase one
            ArrayList<Rocket> phase1U2Rocket;
            phase1U2Rocket = simulation.loadU2(phase1ItemList);
            // loading U2 Rocket for phase two
            ArrayList<Rocket> phase2U2Rocket;
            phase2U2Rocket = simulation.loadU2(phase2ItemList);


            // cost simulation for U1 phase 1 and two

           costU1Phase1 = simulation.runSimulation(phase1U1Rocket);
           costU1Phase2 = simulation.runSimulation((phase2U1Rocket));

            System.out.println(costU1Phase1 + "   " + costU1Phase2);

            // cost simulation for U2 Phase and two with integrated loading
            costU2Phase1 = simulation.runSimulation(phase1U2Rocket);
            costU2Phase2 = simulation.runSimulation(phase2U2Rocket);
            System.out.println(costU2Phase1 + "   " + costU2Phase2);

        } catch (FileNotFoundException notFoundException) {
            System.out.println("FileNotFound exeptiona has been ussed");
        }

    }
}