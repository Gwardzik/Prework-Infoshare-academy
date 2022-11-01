public class U1 extends Rocket {
    int rocketWeightNoCargo = 10000;
    int maxRocketWeight = 18000;
    double cargoLimit = maxRocketWeight - rocketWeightNoCargo;
    double launchSuccess = 0.05;
    double landSuccess = 0.01;
    int priceOfSingelRocket = 100;

    U1() {
        maxWeightWithCargo = maxRocketWeight;
        currentRocketWeight = rocketWeightNoCargo;
        rocketPrice = priceOfSingelRocket;
    }

    @Override
    public boolean launch() {
        double randomNumber = Math.random();
        return randomNumber > launchSuccess * ((currentRocketWeight - rocketWeightNoCargo) / cargoLimit);
    }

    @Override
    public boolean land() {
        double randomNumber = Math.random();
        return randomNumber > landSuccess * ((currentRocketWeight - rocketWeightNoCargo) / cargoLimit);
    }
}
