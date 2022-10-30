
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


        while (!newItem.isEmpty()) {

            U1 newRocket = new U1();
            System.out.println(1);
            int originalItemSize = newItem.size();
            int numberOfDeletions = 0;
            int i =0;
            while (newItem.size() == newItem.lastIndexOf(newItem)) {
                    i = 0;
                if (newRocket.canCarry(newItem.get(i))) {
                    newRocket.carry(newItem.get(i));
                    newItem.remove(i);
                    numberOfDeletions++;
                    i++;
                }


            }

            rocketList.add(newRocket);
        }
        return rocketList;
    }

}
