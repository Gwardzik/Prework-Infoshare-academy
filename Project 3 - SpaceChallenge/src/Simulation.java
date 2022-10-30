
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Simulation {

    File phase1File = new File("/home/patryk/Desktop/Projekty/prework dla infoshare/Project 3 - SpaceChallenge/src/cargo files/Phase-1.txt");
    String tempString;

    ArrayList<Item> loadItems() throws FileNotFoundException {

        ArrayList<Item> itemArrayList = new ArrayList<>();

        Scanner scanner = new Scanner(phase1File);

        while (scanner.hasNextLine()) {
            Item newItem = new Item();
            tempString = scanner.nextLine();
            // making first substring from whole line-name of object
            newItem.name = tempString.substring(0, tempString.indexOf("="));
            //making second substring-weight of the oject, converting String to int thx to Integer.parseInt
            newItem.weight = Integer.parseInt(tempString.substring(tempString.indexOf("=") + 1));
            //adding object to ArrayList
            itemArrayList.add(newItem);
        }
        // sorting algoritm in the future to be added at this spot.aa
        return itemArrayList;
    }

    ArrayList<U1> loadU1(ArrayList<Item> newItem) {

        ArrayList<U1> rocketList = new ArrayList<>();


        U1 newRocket = new U1();
        ArrayList<Integer> toBeDeleted = new ArrayList<>();

        while (!newItem.isEmpty()) {
            for (int i = 0; i < newItem.size(); i++) {
                //adding weight to the rocket by checking what items will fit
                if (newRocket.canCarry(newItem.get(i))) {
                    newRocket.carry(newItem.get(i));
                    toBeDeleted.add(i);
                }
            }
            System.out.println(toBeDeleted);
            //removing items from list that has been already added to newRocket so it does not repeat in next one
            for (int i = 0; i < toBeDeleted.size(); i++) {
                newItem.remove((int) toBeDeleted.get((int) toBeDeleted.size() - 1) - i);
            }
            System.out.println(newItem.size());

            rocketList.add(newRocket);
        }
        return rocketList;
    }

}
