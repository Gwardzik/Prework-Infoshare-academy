
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
        }
        return itemArrayList;
    }

    ArrayList<Item> bubbleSort(ArrayList<Item> itemListToSort) {
        ArrayList<Item> temp = new ArrayList<>();
        temp.add(itemListToSort.get(1));
        boolean end = false;

        while (!end) {
            end = true;
            for (int i = 0; i < itemListToSort.size() - 1; i++) {
                if (itemListToSort.get(i).weight < itemListToSort.get(i + 1).weight) {
                    temp.set(0, (itemListToSort.get(i + 1)));
                    itemListToSort.set(i + 1, itemListToSort.get(i));
                    itemListToSort.set(i, temp.get(0));
                    end = false;
                }
            }
        }


        return itemListToSort;
    }

    ArrayList<Item> quickShort(ArrayList<Item> itemListToSort, int smallIndex, int bigIndex) {
        printItemList(itemListToSort);
        //first step- chousing a pivot
        int pivot = itemListToSort.get(bigIndex).weight;
        // second moving left and right of the pivot

        int leftIndex = smallIndex;
        int rightIndex = bigIndex - 1;
        Item tempItem;

        while (leftIndex < rightIndex) {
            while (itemListToSort.get(leftIndex).weight <= pivot && leftIndex < rightIndex) {
                leftIndex++;
            }
            while (itemListToSort.get(rightIndex).weight > pivot && rightIndex > leftIndex) {
                rightIndex--;
            }
            tempItem = itemListToSort.get(bigIndex);
            itemListToSort.set(bigIndex, itemListToSort.get(leftIndex));
            itemListToSort.set(leftIndex, tempItem);

            tempItem = itemListToSort.get(leftIndex);
            itemListToSort.set(leftIndex, itemListToSort.get(rightIndex));
            itemListToSort.set(rightIndex, tempItem);
        }
        System.out.println("\n");
        printItemList(itemListToSort);

        return itemListToSort;
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
                }
            }

            //removing items from list that has been already added to newRocket so it does not repeat in next one
            while (!toBeDeleted.isEmpty()) {
                newItem.remove((int) toBeDeleted.get(toBeDeleted.size() - 1));
                toBeDeleted.remove(toBeDeleted.size() - 1);
            }
            rocketList.add(newRocket);
        }

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
            while (!toBeDeleted.isEmpty()) {
                newItem2.remove((int) toBeDeleted.get(toBeDeleted.size() - 1));
                toBeDeleted.remove(toBeDeleted.size() - 1);
            }
            //clearing list from items that has been already deleted
            rocketList2.add(newRocket);
        }

        return rocketList2;
    }

    int runSimulation(ArrayList<Rocket> rocketList) {
        int currentCost = 0;

        Rocket currentRocket = new Rocket();

        for (int i = 0; i < rocketList.size(); i++) {
            currentRocket = rocketList.get(i);

            boolean succeedLaunchAndLanding = false;

            while (!succeedLaunchAndLanding) {
                while (!currentRocket.launch()) {
                    currentCost += currentRocket.rocketPrice;
                }

                if (currentRocket.land()) {
                    currentCost += currentRocket.rocketPrice;
                    succeedLaunchAndLanding = true;
                } else {
                    currentCost += currentRocket.rocketPrice;
                }
            }
        }
        return currentCost;
    }

    void printItemList(ArrayList<Item> item) {


        for (Item value : item) {
            System.out.println(value.name + "  " + value.weight);
        }
    }

    void printRocketList(ArrayList<Rocket> rocket) {
        for (Rocket value : rocket) {
            System.out.println("U1 Rocket  " + value.currentRocketWeight);
        }
    }

    void swap(ArrayList<Item> itemListToSort, int leftIndex, int rightIndex){
        Item tempItem;
//        tempItem = itemListToSort.get(bigIndex);
//        itemListToSort.set(bigIndex, itemListToSort.get(leftIndex));
  //      itemListToSort.set(leftIndex, tempItem);
    }
}
