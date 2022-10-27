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
        if (maxWeightWithCargo > currentRocketWeight + item.weight)
            return true;
        else
            return false;
    }

    @Override
    public void carry(Item item) {
        currentRocketWeight = currentRocketWeight + item.weight;
    }


}
