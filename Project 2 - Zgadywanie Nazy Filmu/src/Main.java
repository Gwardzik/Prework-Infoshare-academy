import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws java.io.FileNotFoundException {

        Game gra = new Game();
        int numberOfFilms;
        String filmToGuess;
        char usserGuess;
        int numberOfValidTrys = 10;

        // finding how many films there are in a file
        numberOfFilms = gra.howManyRowsInTheFile();

        // randomy selects film
        filmToGuess = gra.selectingFilmToGuess(numberOfFilms);

        // sets gameboard for specyfic film
        gra.gameBoardCreat(filmToGuess);
        
        System.out.print("You are guessing:");
        gra.printBoard();

        System.out.println("\n" + filmToGuess);

        while (numberOfValidTrys > 0) {
            usserGuess = gra.userInputStringInToChar();
            if (gra.wasItAllredyGuessed(usserGuess)) {
                System.out.println("Juz podałeś taka liczbe, podaj nową");
                continue;
            }
            if(!gra.isCharInString(usserGuess, filmToGuess)){
                numberOfValidTrys--;
            }



            gra.printBoard();
            System.out.println("\nPozostało " + numberOfValidTrys + "prób");
        }
    }
}