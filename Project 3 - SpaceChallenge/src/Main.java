import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Simulation simulation = new Simulation();

        File phase1File = new File("/home/patryk/Desktop/Projekty/prework dla infoshare/Project 3 - SpaceChallenge/src/cargo files/Phase-1.txt");
        File phase2File = new File("/home/patryk/Desktop/Projekty/prework dla infoshare/Project 3 - SpaceChallenge/src/cargo files/Phase-2.txt");
        int costU1Phase1;
        int costU1Phase2;
        int costU2Phase1;
        int costU2Phase2;

        int totalCostU1P1 = 0;
        int totalCostU1P2 = 0;
        int totalCostU2P1 = 0;
        int totalCostU2P2 = 0;

        int u1AverageCost;
        int u2AverageCost;

        int numberOfRandSimulations = 1000;

        ArrayList<Item> phase1ItemList;
        ArrayList<Item> phase2ItemList;

        for (int i = 0; i < numberOfRandSimulations; i++) {
            {
            }
            try {
                //Loading Items for phase one and two

                phase1ItemList = simulation.loadItems(phase1File);
                phase1ItemList = simulation.bubbleSort(phase1ItemList);

                phase2ItemList = simulation.loadItems(phase2File);
                phase2ItemList = simulation.bubbleSort(phase2ItemList);

                //Printing Item List
                if (i == 0) {
                    System.out.println("           Stage 1 Items - sorted\n");
                    simulation.printItemList(phase1ItemList);
                    System.out.println("           Stage 2 Items - sorted\n");
                    simulation.printItemList(phase2ItemList);
                }
                //phase 1 rocket load U1
                ArrayList<Rocket> phase1U1Rocket;
                phase1U1Rocket = simulation.loadU1(phase1ItemList);
                //phase 2 rocket load U2
                ArrayList<Rocket> phase2U1Rocket;
                phase2U1Rocket = simulation.loadU1(phase2ItemList);

                if (i == 0) {
                    System.out.println("           Stage 1 Rocket U1\n");
                    simulation.printRocketList(phase1U1Rocket);
                    System.out.println("           Stage 2 Rocket U1\n");
                    simulation.printRocketList(phase2U1Rocket);
                }

                phase1ItemList = simulation.loadItems(phase1File);
                phase1ItemList = simulation.bubbleSort(phase1ItemList);

                phase2ItemList = simulation.loadItems(phase2File);
                phase2ItemList = simulation.bubbleSort(phase2ItemList);


                //loading U2 rocket for phase one
                ArrayList<Rocket> phase1U2Rocket;
                phase1U2Rocket = simulation.loadU2(phase1ItemList);

                // loading U2 Rocket for phase two
                ArrayList<Rocket> phase2U2Rocket;
                phase2U2Rocket = simulation.loadU2(phase2ItemList);


                costU1Phase1 = simulation.runSimulation(phase1U1Rocket);
                costU1Phase2 = simulation.runSimulation((phase2U1Rocket));


                costU2Phase1 = simulation.runSimulation(phase1U2Rocket);
                costU2Phase2 = simulation.runSimulation(phase2U2Rocket);

                totalCostU1P1 += costU1Phase1;
                totalCostU1P2 += costU1Phase2;
                totalCostU2P1 += costU2Phase1;
                totalCostU2P2 += costU2Phase2;
            } catch (FileNotFoundException notFoundException) {
                System.out.println("FileNotFound exception has been used");
            }

        }
        System.out.println("\n");

        u1AverageCost = (totalCostU1P1 + totalCostU1P2) / numberOfRandSimulations;
        u2AverageCost = (totalCostU2P1 + totalCostU2P2) / numberOfRandSimulations;

        System.out.println("Cost summary in millions:");
        System.out.println("Number of simulations:" + numberOfRandSimulations);
        System.out.println("Average U1 Rocket P1 " + totalCostU1P1 / numberOfRandSimulations);
        System.out.println("Average U1 Rocket P2 " + totalCostU1P2 / numberOfRandSimulations);
        System.out.println("Average U2 Rocket P1 " + totalCostU2P1 / numberOfRandSimulations);
        System.out.println("Average U2 Rocket P2 " + totalCostU2P2 / numberOfRandSimulations);
        System.out.println();
        System.out.println("Average cost for U1 " + u1AverageCost);
        System.out.println("Average cost for U2 " + u2AverageCost);
        if (u1AverageCost < u2AverageCost)
            System.out.println("\n More cost efficient rocket is U1 rocket");
        else
            System.out.println("\n More cost efficient rocket is U2 rocket");

    }


}