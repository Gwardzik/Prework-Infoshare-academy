public class U1 extends Rocket {
    int rocketWeightNoCargo = 10000;
    int maxRocketWeight = 18000;
    int cargoLimit = maxRocketWeight - rocketWeightNoCargo;

    @Override
    public boolean launch() {
        Math.random();
        M(0.05*(currentRocketWeight-rocketWeightNoCargo)/cargoLimit)
        return false;
    }

    @Override
    public boolean land() {
        return false;
    }
}
