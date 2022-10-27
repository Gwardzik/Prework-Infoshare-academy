public class Rocket implements SpaceShip {

    int currentRocketWeight = 18000;
    int maxWeightWithCargo;


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return (maxWeightWithCargo > currentRocketWeight + item.weight);

    }

    @Override
    public void carry(Item item) {
        currentRocketWeight = currentRocketWeight + item.weight;
    }


}
