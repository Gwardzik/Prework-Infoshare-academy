
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    ArrayList<Item> loadItems(File fileToLoad) throws FileNotFoundException {
        String tempString;
        ArrayList<Item> itemArrayList = new ArrayList<>();

        Scanner scanner = new Scanner(fileToLoad);

        while (scanner.hasNextLine()) {
            Item newItem = new Item();
            tempString = scanner.nextLine();
            // making first substring from whole line-name of object
            newItem.name = tempString.substring(0, tempString.indexOf("="));
            //making second substring-weight of the oject, converting String to int thx to Integer.parseInt
            newItem.weight = Integer.parseInt(tempString.substring(tempString.indexOf("=") + 1));
            //adding object to ArrayList
            itemArrayList.add(newItem);
            System.out.println("New item has been added :" + newItem.name + "      " + newItem.weight);
        }
        // sorting algoritm in the future to be added at this spot.aa
        return itemArrayList;
    }

    ArrayList<Rocket> loadU1(ArrayList<Item> newItem) {

        ArrayList<Rocket> rocketList = new ArrayList<>();
        ArrayList<Integer> toBeDeleted = new ArrayList<>();

        while (!newItem.isEmpty()) {
            //creating new rocket
            Rocket newRocket = new U1();

            //adding weight to the rocket by checking what items will fit
            for (int i = 0; i < newItem.size(); i++) {
                if (newRocket.canCarry(newItem.get(i))) {
                    newRocket.carry(newItem.get(i));
                    toBeDeleted.add(i);
                    //System.out.println("Rocket " + i + "has been added");
                }
            }
            System.out.println("New U1 Rocket has been created " + newRocket.currentRocketWeight);

            //removing items from list that has been already added to newRocket so it does not repeat in next one
            for (int i = 0; i < toBeDeleted.size(); i++) {
                newItem.remove((int) toBeDeleted.get((int) toBeDeleted.size() - 1) - i);
            }
            //clearing list from items that has been already deleted
            toBeDeleted.clear();
            rocketList.add(newRocket);
        }
        System.out.println("----------------------");

        return rocketList;
    }

    ArrayList<Rocket> loadU2(ArrayList<Item> newItem2) {

        ArrayList<Rocket> rocketList2 = new ArrayList<>();
        ArrayList<Integer> toBeDeleted = new ArrayList<>();
        while (!newItem2.isEmpty()) {
            //creating new rocket
            Rocket newRocket = new U2();

            //adding weight to the rocket by checking what items will fit
            for (int i = 0; i < newItem2.size(); i++) {
                if (newRocket.canCarry(newItem2.get(i))) {
                    newRocket.carry(newItem2.get(i));
                    toBeDeleted.add(i);
                }
            }
            //removing items from list that has been already added to newRocket so it does not repeat in next one
            for (int i = 0; i < toBeDeleted.size(); i++) {
                newItem2.remove((int) toBeDeleted.get((int) toBeDeleted.size() - 1) - i);
            }
            //clearing list from items that has been already deleted
            toBeDeleted.clear();
            rocketList2.add(newRocket);
        }
        return rocketList2;
    }

    int runSimulation(ArrayList<Rocket> rocketList) {
        int currentCost = 0;
        System.out.println("Simulation has starte\n" +
                "--------------------------------------------------------------");
        //System.out.println(rocketList.get(0));

        Rocket currentRocket = new Rocket();
        for (int i = 0; i < rocketList.size(); i++) {
            currentRocket = rocketList.get(i);
            System.out.println("Prepering for lounch seguens 3..2..1..0 blast off");
            while (!currentRocket.launch()) {
                currentCost += currentRocket.rocketPrice;
                System.out.println("booom launching,try againm (");
            }
            System.out.println("launching sucess !!!!");
            System.out.println("Prepering for landing aprouch 3..2..1..0 blast off");
            while (!currentRocket.land()) {
                currentCost += currentRocket.rocketPrice;
                System.out.println("booom landing, im sorry, try again ;(");
            }
            System.out.println("landing sucess !!!!");

            currentCost += currentRocket.rocketPrice;
            System.out.println(currentCost);
            System.out.println("Current cost" + currentCost + "\n " + "---------------------");
        }
        System.out.println("Simulation has ended" +
                "--------------------------------------------------------------");

        return currentCost;
    }
}
