public class U1 extends Rocket {
    int rocketWeightNoCargo = 10000;
    int maxRocketWeight = 18000;
    int cargoLimit = maxRocketWeight - rocketWeightNoCargo;
    int launchSucces = 5;
    int accurecyCoeficiant = 1000;


    @Override
    public boolean launch() {
        double losowaLiczba = (Math.random() * 100*accurecyCoeficiant)+1;

        System.out.println((int)losowaLiczba);

        (launchSucces*accurecyCoeficiant)*((currentRocketWeight-rocketWeightNoCargo)/cargoLimit);

        return true;
    }

    @Override
    public boolean land() {
        return false;
    }
}
