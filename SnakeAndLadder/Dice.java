
public class Dice {
    private int noOfDice;

    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }

    public int getNoOfDice() {
        return noOfDice;
    }

    public void setNoOfDice(int noOfDice) {
        this.noOfDice = noOfDice;
    }

    public int rollDice() {
        int max = 6 * noOfDice;
        int min = noOfDice;
        return (int) Math.floor((Math.random() * (max - min + 1) + min));
    }
}
