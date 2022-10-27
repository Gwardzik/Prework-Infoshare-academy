public class U1 extends Rocket {
    int rocketWeightNoCargo = 10000;
    int maxRocketWeight = 18000;
    int cargoLimit = maxRocketWeight - rocketWeightNoCargo;


    public int launch(int howMany) {
        double losowaLiczba = Math.random() * 100;
        System.out.println((int)losowaLiczba);
        //(0.05*(currentRocketWeight-rocketWeightNoCargo)/cargoLimit);
        System.out.println(losowaLiczba);
        if((int)losowaLiczba == 0)
            howMany++;
        return howMany;
    }

    @Override
    public boolean land() {
        return false;
    }
}
