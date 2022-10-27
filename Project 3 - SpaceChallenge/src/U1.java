public class U1 extends Rocket {
    int rocketWeightNoCargo = 10000;
    int maxRocketWeight = 18000;
    int cargoLimit = maxRocketWeight - rocketWeightNoCargo;
    int launchSuccess = 5;
    int accurecyCoeficiant = 1000000;


    @Override
    public boolean launch() {
        double randomNumber = (Math.random() * 100 * accurecyCoeficiant) + 1;

       // System.out.println((int) randomNumber);
       // System.out.println((launchSuccess * accurecyCoeficiant) * ((currentRocketWeight - rocketWeightNoCargo) / cargoLimit));
        return (int) randomNumber > (launchSuccess * accurecyCoeficiant) * ((currentRocketWeight - rocketWeightNoCargo) / cargoLimit);
    }

    @Override
    public boolean land() {
        return false;
    }
}
