package HelloWorld;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class NewGame {
	
	private String name;
	private int health = 100;
	private int coins = 100;
	private ArrayList<String> inventory = new ArrayList<String>();
	private ArrayList<String> woodenPlanks = new ArrayList<String>();
	private Scanner sc = new Scanner(System.in);
	char option;
	private int count;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// print home menu
	public void showHome() {
		System.out.println("--------------------------------------------------");
		System.out.println("What do you plan to do?");
		System.out.println("--------------------------------------------------");
		System.out.println("A: Go to shop");
		System.out.println("B: Proceed to game");
		System.out.println("--------------------------------------------------");
		option = sc.next().charAt(0);
		homeOptions(option);
	}
	
	// user input for home menu
	private void homeOptions(char options) {
		if (options == 'A' || options == 'a') {
			shop();
		} else if (options == 'B' || options == 'b') {
			if(inventory.isEmpty()) {
				warningNoWeapons();
			} else {
				showMenu();
			}
		}
	}
	
	// warning if user did not purchase weapons
	private void warningNoWeapons() {
		System.out.println("--------------------------------------------------");
		System.out.println("Warning: You are proceeding without weapons.");
		System.out.println("--------------------------------------------------");
		System.out.println("A: Continue");
		System.out.println("B: Go to shop");
		option = sc.next().charAt(0);
		if (option == 'B' || option == 'b') {
			shop();
		} else {
			showMenu();
		}	
	}
	
	// shop menu
	private void shop() {
		System.out.println("--------------------------------------------------");
		System.out.println("Your current health level: " + showHealth());
		System.out.println("--------------------------------------------------");
		System.out.println("What do you want to buy?");
		System.out.println("--------------------------------------------------");
		System.out.println("A: Sword");
		System.out.println("B: Shield");
		System.out.println("C: Pistol");
		System.out.println("D: Healing potion");
		System.out.println("E: 1 Wooden plank");
		System.out.println("F: Exit");
		System.out.println("--------------------------------------------------");
		option = sc.next().charAt(0);
		shopOptions(option);
	}
	
	// user input for shop
	private void shopOptions(char options) {
		if (options == 'A' || options == 'a') {
			System.out.println("You have successfully purchased a sword");
			inventory.add("Sword");
			pay(20);
			//System.out.println("Coins remaining: " + showCoins());
			shop();
		} else if (options == 'B' || options == 'b'){
			System.out.println("You are now equipped with a shield");
			inventory.add("Shield");
			pay(30);
			//System.out.println("Coins remaining: " + showCoins());
			addHealth();
			System.out.println("Your new health: " + showHealth());
			shop();
		} else if (options == 'C' || options == 'c') {
			System.out.println("You have successfully purchased a pistol");
			inventory.add("Pistol");
			pay(25);
			//System.out.println("Coins remaining: " + showCoins());
			shop();
		} else if (options == 'D' || options == 'd') {
			inventory.add("Healing potion");
			System.out.println("You have succesfully purchased healing potion");
			pay(30);
			//System.out.println("Coins remaining: " + showCoins());
			shop();
		} else if (options == 'E' || options == 'e') {
			woodenPlanks.add("Wooden plank");
			System.out.println("You have successfully purchased a wooden plank");
			pay(5);
			//System.out.println("Coins remaining: " + showCoins());
			shop();
		} else if (options == 'F' || options == 'f') {
			if ( inventory.isEmpty()) {
				warningNoWeapons();
			} else {
				showHome();
			}
			
		}
		
	}
	
	private void pay(int cost) {
		coins -= cost;
	}
	
	private int showCoins() {
		return coins;
	}
	
	private void noCoins() {
		if (coins > 0) {
			System.out.println("Coins remaining: " + showCoins());
		} else {
			//cannot buy anymore
		}
	}
	
	private void addHealth() {
		health += 10;
	}
	
	private int showHealth() {
		return health;
	}
	
	// print game menu
	private void showMenu() {
		System.out.println("--------------------------------------------------");
		System.out.println("What do you plan to do?");
		System.out.println("--------------------------------------------------");
		System.out.println("A: Go North");
		System.out.println("B: Go East");
		System.out.println("C: Go South");
		System.out.println("D: Go West");
		System.out.println("--------------------------------------------------");
		option = sc.next().charAt(0);
		menuOptions(option);
	}
	
	// user input for game menu
	private void menuOptions(char options) {
		if (options == 'A' || options == 'a') {
			swamp();
		} else if (options == 'B' || options == 'b'){
			dungeons();
		} else if (options == 'C' || options == 'c') {
			hills();
		} else if (options == 'D' || options == 'd') {
			forest();
		}
	}
	
	// north direction to swamp
	private void swamp() {
		System.out.println("--------------------------------------------------");
		System.out.println("BEWARE: You are entering Gator Swamp");
		System.out.println("--------------------------------------------------");
		System.out.println("A: Yes");
		System.out.println("B: Go back");
		System.out.println("--------------------------------------------------");
		option = sc.next().charAt(0);
		if (option == 'A' || option == 'a') {
			crossSwamp();
		} else if (option == 'B' || option == 'b') {
			showMenu();
		}
	}
	private void crossSwamp() {
		System.out.println("--------------------------------------------------");
		System.out.println("How will you get to the other side of the swamp?");
		System.out.println("--------------------------------------------------");
		System.out.println("A: Build a raft (requires 4 planks of wood)");
		System.out.println("B: Swim");
		System.out.println("C: Open inventory");
		System.out.println("--------------------------------------------------");
		option = sc.next().charAt(0);
		if (option == 'A' || option == 'a') {
			count = Collections.frequency(woodenPlanks, "Wooden plank");
			if (count > 4) {
					buildRaft();
					System.out.println("--------------------------------------------------");
					System.out.println("Use raft?");
					System.out.println("--------------------------------------------------");
					System.out.println("A: Yes");
					System.out.println("B: Go home");
					System.out.println("--------------------------------------------------");
					option = sc.next().charAt(0);
					if (option == 'A' || option == 'a') {
						dojo();
					} else if (option == 'B' || option == 'b') {
						showMenu();
					}
			} else {
					System.out.println("You do not not have enough wooden planks to build a raft");
			}
		} else if (option == 'B' || option == 'b') {
			swim();
		} else if (option == 'C' || option == 'c') {
			displayInventory();
		}
	} 
	
	private void buildRaft() {
		System.out.println("You have successfully built a raft");
		woodenPlanks.remove(0);
		woodenPlanks.remove(1);
		woodenPlanks.remove(2);
		woodenPlanks.remove(3);
		count = Collections.frequency(woodenPlanks, "Wooden plank");
		System.out.println("You have " + count + " wooden planks remaining");
	}
	
	private void dojo() {
		System.out.println("--------------------------------------------------");
		System.out.println("You have discovered the secret Dojo");
		System.out.println("--------------------------------------------------");
	}
	
	private void swim() {
		// how to terminate program and repeat
	}
	// east direction to dungeon
	private void dungeons() {
		System.out.println("--------------------------------------------------");
		System.out.println("Continue straight towards the Deadly Dungeon");
		System.out.println("--------------------------------------------------");
		System.out.println("A: Yes");
		System.out.println("B: Go back");
		System.out.println("--------------------------------------------------");
		option = sc.next().charAt(0);
		if (option == 'A' || option == 'a') {
			knights();
		} else if (option == 'B' || option == 'b') {
			showMenu();
		}
	}
	
	// south direction to hills
	private void hills() {
		System.out.println("--------------------------------------------------");
		System.out.println("Continue South to the hills");
	}
	
	// west direction to forest
	private void forest() {
		System.out.println("--------------------------------------------------");
		System.out.println("Continue West to the Forest of Trolls");
		
	}
	
	
	// user input to fight knights or return
	private void knights() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("You have to defeat the Knights in order to enter the Deadly Dungeon");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("A: Yes");
		System.out.println("B: Go back");
		System.out.println("----------------------------------------------------------------------");
		char option = sc.next().charAt(0);
		if (option == 'A' || option == 'a') {
			fightKnights();
		} else if (option == 'B' || option == 'b') {
			dungeons();
		}
	}
		
	// display inventory items
	private void displayInventory() {
		// check if inventory is empty
		if (!inventory.isEmpty()) {
			for (int i = 0; i<inventory.size(); i++) {
				System.out.println(inventory.get(i));
			}
		} displayPlanks();
	}
	
	private void displayPlanks() {
	// check for wooden planks
		if (!woodenPlanks.isEmpty()) {
			count = Collections.frequency(woodenPlanks, "Wooden plank");
			if (count > 1) {
				System.out.println(count + " Wooden planks");
			} else {
				System.out.println(count + " Wooden plank");
			} 
		} else {
			System.out.println("");
		}
	}
	
	// time delay to enemy's attack
	private void timeToAttack() {
		
	}
	// user decides to fight knights
	private void fightKnights() {
		System.out.println("--------------------------------------------------");
		System.out.println("A: Open inventory");
		System.out.println("B: Go back");
		System.out.println("--------------------------------------------------");
		option = sc.next().charAt(0);
		System.out.println("--------------------------------------------------");
		// display inventory
		if (option == 'A' || option == 'a') {
			displayInventory();
				System.out.println("--------------------------------------------------");
		}
		timeToAttack();
		}
	}

public class NewClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		NewGame player = new NewGame();
		player.setName(name);
		System.out.println("Hello " + player.getName() + ", welcome to Knights and Ninjas!");
		
		player.showHome();
	}
}

