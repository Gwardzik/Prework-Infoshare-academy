public class U2 extends Rocket {

    int rocketWeightNoCargo = 18000;
    int maxRocketWeight = 29000;
    double cargoLimit = maxRocketWeight - rocketWeightNoCargo;
    double launchSuccess = 0.04;
    double landSuccess = 0.08;
    U2() {
        maxWeightWithCargo = maxRocketWeight;
        currentRocketWeight = rocketWeightNoCargo;
    }

    @Override
    public boolean launch() {
        double randomNumber = Math.random() ;
        return  randomNumber > launchSuccess * ((currentRocketWeight - rocketWeightNoCargo) / cargoLimit);
    }

    @Override
    public boolean land() {
        double randomNumber = Math.random() ;
        return  randomNumber > landSuccess * ((currentRocketWeight - rocketWeightNoCargo) / cargoLimit);    }
}

