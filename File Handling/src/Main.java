public class Main {
    public static void main(String[] args){
        Database db=new Database();
        try {
            db.menu();
        }catch (Exception e){
            System.out.println("An Error Occurred!\nKindly Enter data");
            db.menu();
        }
    }
}