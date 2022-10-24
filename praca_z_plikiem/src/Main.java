import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

       File file = new File("Two Cities");

       Scanner scanner = new Scanner(file);

        int iloscWyrazow = 0;

       while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            iloscWyrazow +=line.split(" ").length;
       }
        System.out.println(iloscWyrazow);
    }
}