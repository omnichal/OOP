public class Bag {
    private String  color;
    private double weight;
    private static int Totalballs;
    private static double Totalweight;

    Bag(){
        this.color="White";
        this.weight=24.8;
        Totalballs++;
        Totalweight+=this.weight;
    }
    Bag(String color){
        this.color=color;
        this.weight=48.9;
        Totalballs++;
        Totalweight+=this.weight;
    }
    Bag(double weight){
        this.color="Maroon";
        this.weight=weight;
        Totalballs++;
        Totalweight+=this.weight;
    }
    Bag(String color, double weight){
        this.color=color;
        this.weight=weight;
        Totalballs++;
        Totalweight+=this.weight;
    }

    public static int getTotalballs() {
        return Totalballs;
    }

    public static double getTotalweight() {
        return Totalweight;
    }

    public void RemoveWeight(){
        Totalweight-=this.weight;
        Totalballs--;
    }

    public void display(){
        System.out.println("\t\t\t\t"+color+"\t\t\t\t\t"+weight);
    }


}
