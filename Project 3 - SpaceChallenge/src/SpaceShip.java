public interface SpaceShip {
    // if launch successful -TRUE, if rocket crash -FALSE
    boolean launch();

    // if land successful -TRUE, if rocket crash -FALSE
    boolean land();

    // returns True when passed Item object can be launch
    boolean canCarry(Item item);

    // updates current weight of rocket after Item object is passed
    void carry(Item item);


}
