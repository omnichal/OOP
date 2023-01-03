public class Main {
    public static void main(String[] args) throws Exception {

        Inventory inventory = new Inventory();
        if(inventory.file.isFile()){
            inventory.readFile();
        }
        inventory.runApp();
        inventory.writeFile();
    }
}
