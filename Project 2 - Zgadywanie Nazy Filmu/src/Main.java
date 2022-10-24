import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws java.io.FileNotFoundException {

        Game gra = new Game();
        int numberOfFilms;
        String filmToGuess;
        char usserGuess;
        int numberOfValidTrys = 0;
        int numberOfSpacesInTitle;

        // finding how many films there are in a file
        numberOfFilms = gra.howManyRowsInTheFile();

        // randomy selects film
        filmToGuess = gra.selectingRandomlyFilmToGuess(numberOfFilms);
        System.out.println(filmToGuess);
        //fiding out how many space character in film name string
        numberOfSpacesInTitle = gra.howManySpaces(filmToGuess);
        System.out.println(numberOfSpacesInTitle);

        // sets gameboard for specyfic film
        gra.gameBoardCreat(filmToGuess);
        //do usuniecia
        System.out.println("\n" + filmToGuess);

        while (numberOfValidTrys < 10) {
            System.out.print("You are guessing: ");
            gra.printBoard();
            System.out.print("\n" + "You have guessed" + "(" + numberOfValidTrys + ")" + " wrong letters:");
            gra.printUsedGuesses(filmToGuess);
            System.out.print("\nGuess a letter:");
            usserGuess = gra.userInputStringInToChar();
            if (gra.wasItAllredyGuessed(usserGuess)) {
                continue;
            }
            if (!gra.isCharInString(usserGuess, filmToGuess)) {
                numberOfValidTrys++;
            }
        }
    }
}