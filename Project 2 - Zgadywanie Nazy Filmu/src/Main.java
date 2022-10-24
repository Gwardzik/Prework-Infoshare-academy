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
        String[] test = new String[2];

        System.out.println(filmToGuess);
        System.out.println("Witaj w mojej grze. Zosta wybrany losowo film, który musisz zgadnąć");
        System.out.println("To film do zgadnięcia:");
        System.out.println("\n Prosze podaj pierwszą litere do zgdnięcia, masz 10 prób");

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
            System.out.println("Pozostało " + numberOfValidTrys + "prób");
        }
    }
}