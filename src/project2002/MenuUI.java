package project2002;

import java.util.Scanner;

import project2002.Restaurant.UIType;

public class MenuUI extends UI{
	public enum ItemType { MAIN, DRINK, DESSERT, SIDE, PROMO }	
	private MenuManager menuManager;

	public MenuUI(Scanner scanner){
		super(scanner);
		this.type=UIType.MENU;
	}
	public void printOptions() {
		int choice=0;
		do {
			System.out.printf("-------------Menu Options------------\n"
					+ "Please select one of this 8 options: \n"
					+ "1.	Print Menu\n"
					+ "2.	Add Menu Item\n"
					+ "3.	Remove Menu Item\n"
					+ "4.	Update Menu Item\n"
					+ "5.	Add Promo Set\n"
					+ "6.	Remove Promo Set\n"
					+ "7.	Update Promo Set\n"
					+ "8.	Quit\n"
					+ "Please enter your choice: ");
			choice=this.getInt();
			switch(choice) {
			case 1:
				menuManager.printMenu();
				break;
			case 2:
				String name=this.getString();
				int price= this.getInt();
				String description=this.getString();
				ItemType i=this.getItemType();
				if(menuManager.addMenuItem(name,price,description,i)==1) {
					System.out.println("Item is successfully added.");
				}
				else {
					System.out.println("Item could not be added/ duplicate item exist...");
				}
				break;
			case 3:
				int x=menuManager.removeMenuItem();
				if(x ==0) {
					System.out.println("Item does not exist in the menu");
				}
				else System.out.println("Item successfully removed");
				break;
			case 4:
				menuManager.updateMenuItem();
				break;
			case 5:
				System.out.println(menuManager.addPromoSet());
				break;
			case 6:
				System.out.println(menuManager.removePromoSet());
				break;
			case 7:
				System.out.println(menuManager.updatePromoSet());
				break;
			case 8:
				break;
			default:
				System.out.println("");
			}
			} while(choice!=8);
		
	}
	public ItemType getItemType() {
		System.out.println("Please enter menu item type: ");
		String type=this.getString();
		for (ItemType i : ItemType.values())  {
			if(type.toUpperCase()==i.toString()) return i;  
		} 
		return null;
	}
	
	public int getItemID() {
		int itemID;
		System.out.printf("Please enter the item ID: \n");
		itemID=scan.nextInt();
		return itemID;
	}

	@Override
	protected void assignUIManager(Manager m) {
		menuManager=(MenuManager) m;
	}
	
	public void updateItem(String name,int ID) {
		System.out.println("You have selected " + name + ".");
		System.out.println("Select:\n1. Update Name\n2. Update Price\n3. Update Description\nInsert -1 when done.");
		int choice = scan.nextInt();
		while(choice != -1) {
			switch(choice) {
			case 1:
				System.out.println("New Name?");
				String newname = scan.next();
				menuManager.updateName(ID,newname);
				System.out.println("Name updated.");
				break;
			case 2:
				System.out.println("New Price?");
				double price = scan.nextDouble();
				menuManager.updatePrice(ID,price);
				System.out.println("Price updated.");
				break;
			case 3: 
				System.out.println("New Description?");
				String description = scan.next();
				menuManager.updateDescription(ID,description);
				System.out.println("Description updated.");
				break;
			default:
				System.out.println("Please select again.");
				break;
			}
			choice = scan.nextInt();
		}
		System.out.println("Update Complete.");
		}
}
