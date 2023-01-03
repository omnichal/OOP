public class Car implements Vehicle {

    private int speed, gear;
    private static final int MAXSPEED = 150, MAXGEAR = 8;

    public Car() {
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
                System.out.println("Car Gear increased");
                System.out.println("Current Gear: " + gear);
            }
        }
        else {
            if (gear == 1) {
                System.out.println("Can't decrease gear, min value for gear reached");
            }
            else {
                gear--;
                System.out.println("Car Gear decreased");
                System.out.println("Current Gear: " + gear);
            }
        }
    }

    public void applyBarkes() {
        if (speed == 0) {
            System.out.println("Can't decrease speed, car is already stopped");
        }
        else {
            speed -= 5;
            System.out.println("Car speed decreased");
            System.out.println("Current Speed: " + speed);
        }
    }

    public void speedUp() {
        if (speed == MAXSPEED) {
            System.out.println("Can't increase speed, car is already at max speed");
        }
        else {
            speed += 5;
            System.out.println("Car speed increased");
            System.out.println("Current Speed: " + speed);
        }
    }
}