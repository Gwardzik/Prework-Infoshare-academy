public class Rocket implements SpaceShip {

    int currentRocketWeight;
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
    //takes an Item object and updates the current weight of the rocket
    @Override
    public void carry(Item item) {
        currentRocketWeight = currentRocketWeight + item.weight;
    }


}
