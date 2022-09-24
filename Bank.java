import java.util.ArrayList;
import java.util.Scanner;
class Bank{
    private Scanner s = new Scanner(System.in);
    private ArrayList<Double> Balance = new ArrayList<>();
    private ArrayList<String> Name =  new ArrayList<>();
    public final static void clearScreen()
{
    try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } catch (Exception ex) {}
}

    private void showMenu() {
        
        System.out.println("BANK ADMIN MENU");
        System.out.println("Please Enter option : ");
        System.out.println("(1): Add Customer to Bank");
		System.out.println("(2): Change Customer Name");
		System.out.println("(3): Check Account Balance");
		System.out.println("(4): Modify Account Balance");
		System.out.println("(5): Summary of All Accounts");
		System.out.println("(-1): Quit");
        int choice = Integer.parseInt(s.nextLine());
        this.choose(choice);
    }
    private void addCustomer(){
        clearScreen();
        System.out.println("Enter New customer details : ");
        System.out.print("Name : ");
        Name.add(s.nextLine());
        System.out.println();
        System.out.print("Enter Account Balance : ");
        Balance.add(Double.parseDouble(s.nextLine()));
        System.out.println("Your Customer ID is "+ Name.size()+1+"\n\n");
    }
    private void changeName(){
        clearScreen();
        System.out.println("Enter the Customer ID : ");
        int index = Integer.parseInt(s.nextLine());
        if(index-1>Name.size()){
            System.out.println("Invalid Customer ID");
            showMenu();
        }
        else{
            System.out.print("Enter the new Name : ");
            Name.add(index-1, s.nextLine());
            System.out.println("Successfully Changed Name");
        }
    }
    private void checkBalance(){
        clearScreen();
        System.out.println("Enter tht Customer ID : ");
        int index = Integer.parseInt(s.nextLine());
        if(index-1>Name.size()){
            System.out.println("Invalid Customer ID");
            showMenu();
        }
        else{
            System.out.println("Balance for the Customer ID "+index+" is "+Balance.get(index-1));
            showMenu();
        }
    }
    private void modifyBanalce(){
        clearScreen();
        System.out.println("Enter tht Customer ID : ");
        int index = Integer.parseInt(s.nextLine());
        if(index-1>Name.size()){
            System.out.println("Invalid Customer ID");
            showMenu();
        }
        else{
            System.out.print("Enter the new amount : ");
            Balance.add(index-1, Double.parseDouble(s.nextLine()));
        }
    }
    private void summarizeAccounts(){
        clearScreen();
        System.out.println("Summarizing all the accounts");
        for(int i = 0;i<Name.size();i++){
            System.out.println("Balance of "+Name.get(i)+"with Customer ID "+i+1+" is "+Balance.get(i));
        }
    }
    private void choose(int choice){
        if(choice == 1){
            addCustomer();
            showMenu();
        }
        else if(choice == 2){
            changeName();
            showMenu();
        }
        else if(choice ==  3){
            checkBalance();
            showMenu();
        }
        else if(choice == 4){
            modifyBanalce();
            showMenu();
        }
        else if(choice == 5){
            summarizeAccounts();
            showMenu();
        }
        else if(choice == -1){
            System.exit(0);
        }
        else{
            System.out.println("Invalid choice !!!");
            this.showMenu();
        }
    }
    public static void main(String[] args) {
            Bank bank = new Bank(); 
            bank.showMenu();

    }
}