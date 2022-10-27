public class Main {

    public static void main(String[] args) {

        U1 ship = new U1();
        int isFalse = 0;
        int isTrue = 0;
        for (int i = 0; i < 1000000000; i++) {

            if (ship.launch()) {
                isTrue++;
            } else {
                isFalse++;

            }
        }
        System.out.println(isTrue);
        System.out.println(isFalse);
    }
}