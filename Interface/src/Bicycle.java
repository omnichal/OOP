public class Bicycle implements Vehicle {

    private int speed, gear;
    private static final int MAXSPEED = 60, MAXGEAR = 12;

    public Bicycle() {
        this.speed = 0;
        this.gear = 1;
    }

    public void changeGear(boolean increase) {
        if (increase) {
            if (gear == MAXGEAR) {
                System.out.println("Can't increase gear, max value for gear reached");
            }
            else {
                gear++;
                System.out.println("Bicycle Gear increased");
                System.out.println("Current Gear: " + gear);
            }
        }
        else {
            if (gear == 1) {
                System.out.println("Can't decrease gear, min value for gear reached");
            }
            else {
                gear--;
                System.out.println("Bicycle Gear decreased");
                System.out.println("Current Gear: " + gear);
            }
        }
    }

    public void applyBarkes() {
        if (speed == 0) {
            System.out.println("Can't decrease speed, bicycle is already stopped");
        }
        else {
            speed -= 5;
            System.out.println("Bicycle speed decreased");
            System.out.println("Current Speed: " + speed);
        }
    }

    public void speedUp() {
        if (speed == MAXSPEED) {
            System.out.println("Can't increase speed, bicycle is already at max speed");
        }
        else {
            speed += 5;
            System.out.println("Bicycle speed increased");
            System.out.println("Current Speed: " + speed);
        }
    }
}
