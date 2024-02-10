package view;

import java.util.List;
import java.util.Scanner;

import controller.RoastInventoryHelper;
import model.RoastInventory;

/**
 * @author nicci - npuente CIS175 - Spring 2024 Feb 2, 2024
 */

public class Main {
	static Scanner in = new Scanner(System.in);
	static RoastInventoryHelper bih = new RoastInventoryHelper();

	private static void addNewRoast() {

		System.out.print("Enter the name of the roast: ");
		String roastName = in.nextLine();
		System.out.print("Enter the roast type: ");
		String roastType = in.nextLine();

		RoastInventory toAdd = new RoastInventory(roastName, roastType);
		bih.addRoast(toAdd);

	}

	private static void deleteRoast() {
		System.out.println("Enter the name of the roast you would like to delete: ");
		String roastName = in.nextLine();
		System.out.println("Enter the roast type you would like to delete: ");
		String roastType = in.nextLine();

		RoastInventory toDelete = new RoastInventory(roastName, roastType);
		bih.deleteRoast(toDelete);
	}

	private static void editRoast() {
		System.out.println(
				"Would you like to search by roast name or roast type? Press '1' for roast name or '2' for roast type: ");
		int searchBy = in.nextInt();
		in.nextLine();

		List<RoastInventory> foundItem;
		if (searchBy == 1) {
			System.out.println(("Enter the name of the roast: "));
			String roastName = in.nextLine();
			foundItem = bih.searchRoastName(roastName);
		} else {
			System.out.println("Enter the name of the roast type: ");
			String roastType = in.nextLine();
			foundItem = bih.searchRoastType(roastType);
		}

		if (!foundItem.isEmpty()) {
			System.out.println("Results found.");
			for (RoastInventory l : foundItem) {
				System.out.println(l.getRoastId() + " : " + l.toString());
			}
			System.out.println("Enter the Roast ID to edit: ");
			int idEdit = in.nextInt();
			RoastInventory toEdit = bih.SearchRoastId(idEdit);
			System.out.println(toEdit.getRoastName() + "from " + toEdit.getRoastType() + " was retrieved");
			System.out.println("To edit the roast press '1' or, to edit the roast type, press '2': ");
			int update = in.nextInt();
			in.nextLine();
			if (update == 1) {
				System.out.print("New roast: ");
				String newRoast = in.nextLine();
				toEdit.setRoastName(newRoast);
			} else if (update == 2) {
				System.out.print("New roast type: ");
				String newSupplier = in.nextLine();
				toEdit.setRoastType(newSupplier);
			}
			bih.updateRoast(toEdit);
		} else {
			System.out.println("---- No results found ----");
		}

	}

	public static void runMenu() {
		boolean runAgain = true;
		System.out.println("Roast Inventory");
		while (runAgain) {
			System.out.println(" What would you like to do? Enter the corresponding number:");
			System.out.println("* 1 -- Add an item");
			System.out.println("* 2 -- Edit an item");
			System.out.println("* 3 -- Delete an item");
			System.out.println("* 4 -- View the list");
			System.out.println("* 5 -- End Program");
			System.out.print("* Your selection: ");
			int selection = in.nextInt();
			in.nextLine();
			if (selection == 1) {
				addNewRoast();
			} else if (selection == 2) {
				editRoast();
			} else if (selection == 3) {
				deleteRoast();
			} else if (selection == 4) {
				viewList();
			} else {
				bih.cleanUp();
				System.out.println("End program");
				runAgain = false;
			}
		}
	}

	private static void viewList() {
		List<RoastInventory> allItems = bih.showAllRoasts();

		for (RoastInventory singleItem : allItems) {
			System.out.println(singleItem.returnRoastDetails());
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();
	}

}
