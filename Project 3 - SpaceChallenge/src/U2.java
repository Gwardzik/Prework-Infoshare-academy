public class U2 extends Rocket {

    long rocketCost = 120000000;
    int rocketWeight = 18000;
    int maxWeightWithCargo = 29000;

    @Override
    public boolean launch() {
        return false;
    }

    @Override
    public boolean land() {
        return false;
    }
}

