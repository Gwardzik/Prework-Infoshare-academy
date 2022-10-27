public class Main {

    public static void main(String[] args) {
        int howMany= 0;
        U1 ship = new U1();
        for(int i =0 ; i < 10000; i ++){
            ship.launch(howMany);
        }
    }
}