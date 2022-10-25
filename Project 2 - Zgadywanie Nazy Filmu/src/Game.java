import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

    // FILDS ----------------------------------------------------------------------------------
    File file = new File("Lista filmow");
    char[] gameboard;
    char[] charsThatHaveBeenGuess = new char[100];
    Scanner scannerForInput = new Scanner(System.in);

    // FILDS ----------------------------------------------------------------------------------

    /* howManyRowsInTheFile
        1. checks and returns how many rows in the film file
     */
    public int howManyRowsInTheFile() throws FileNotFoundException {
        Scanner scannerForFiles = new Scanner(file);
        int numberOfRows = 0;
        while (scannerForFiles.hasNextLine()) {
            scannerForFiles.nextLine();
            numberOfRows += 1;
        }

        return numberOfRows;
    }

    public String selectingRandomlyFilmToGuess(int numberOfFilms) throws FileNotFoundException {
        int random = (int) (Math.random() * (numberOfFilms - 1)) + 1;
        Scanner scanner = new Scanner(file);
        String chosenFilm = null;
        for (int i = 0; i < random; i++) {
            chosenFilm = scanner.nextLine();

        }
        return chosenFilm;
    }

    public int howManySpaces(String filmToGuess) {
        int start = 0;
        int count = 0;
        boolean find = true;
        while (find) {
            start = filmToGuess.indexOf(' ', start) + 1;
            if (start == 0) {
                find = false;
                continue;
            }
            count++;
        }
        return count;
    }

    /* gameBoardCreat
        1. creates Char table as big as film String given.
        2. fills char table with underscore- '_' as blank bord
     */
    public void gameBoardCreat(@NotNull String filmName) {
        gameboard = new char[filmName.length()];
        for (int i = 0; i < filmName.length(); i++) {
            gameboard[i] = '_';
        }
    }

    /*  printsBoard
        1. prints current board
     */
    public void printBoard() {
        for (int i = 0; i < gameboard.length; i++) {
            System.out.print(gameboard[i]);
        }
    }

    /* isCHarInString
         1. checking is char in string and updating it if it is
     */
    public boolean isCharInString(char guess, String filmToGuess) {
        int start = 0;
        int updateString = 1;
        boolean isIt = false;

        while (updateString >= 0) {
            updateString = filmToGuess.indexOf(guess, start);
            if (updateString < 0)
                break;
            else {
                gameboard[updateString] = guess;
                start = updateString + 1;
                isIt = true;
            }
        }
        return isIt;
    }

    /* ussrInputChat
        1. get input guess from usser as a String
        2. turns string to char
        3. returns lower case char as usser guess
     */
    public char userInputStringInToChar() {
        char guess;
        String usserString;

        usserString = (scannerForInput.nextLine()).toLowerCase();
        guess = usserString.charAt(0);
        return guess;
    }

    public boolean wasItAllredyGuessed(char guess) {
        boolean isIt = false;

        for (int i = 0; i < charsThatHaveBeenGuess.length; i++) {
            if (charsThatHaveBeenGuess[i] == guess) {
                isIt = true;
                break;
            }
        }
        //if char was not in array add guess in to array
        if (!isIt) {
            for (int i = 0; i < charsThatHaveBeenGuess.length; i++) {
                if (charsThatHaveBeenGuess[i] == Character.MIN_VALUE) {
                    charsThatHaveBeenGuess[i] = guess;
                    // System.out.println(charsThatHaveBeenGuess[i] + "ja");
                    break;
                }
            }
        }
        return isIt;
    }

    public void printUsedGuesses(String filmToGuess) {
        for (int i = 0; i < charsThatHaveBeenGuess.length; i++) {
            if ((charsThatHaveBeenGuess[i] != Character.MIN_VALUE) && (-1 == filmToGuess.indexOf(charsThatHaveBeenGuess[i]))) {
                System.out.print(charsThatHaveBeenGuess[i]);
            }

        }
    }

    public boolean winCondition(int numberOfSpaces) {
        int count = 0;
        boolean winOrLouse = false;
        for (char c : gameboard) {
            if (c == '_') {
                count++;
            }
        }
        if (count == numberOfSpaces) {
            winOrLouse = true;
        }
        return winOrLouse;
    }
}


