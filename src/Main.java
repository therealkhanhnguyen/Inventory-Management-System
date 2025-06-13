import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n====== INVENTORY MENU ======");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity or Price");
            System.out.println("4. View All Items");
            System.out.println("5. Search Item by Name");
            System.out.println("6. Exit");
            System.out.print("Enter option: ");
            int option = -1;

            try{
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid option");
            }

        System.out.println("====== INVENTORY MENU ======");
            switch (option) {
                case 1:
                    //name should be a string, not a number.
                    String name;
                    while(true){
                        System.out.println("What is the name of the item?");
                        name = scanner.nextLine().toLowerCase();
                        if(name.matches(".*\\d.*")){
                            System.out.println("Item name should not contain numbers. Try again.");
                        } else {
                            break;
                        }
                    }
                    // price should be a positive number.
                    double price;
                    while(true){
                        try {
                            System.out.println("What is the price of the item?");
                            price = Double.parseDouble(scanner.nextLine());
                            if(price < 0){

                                System.out.println("Price should be greater than 0. Try again.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid price. Please enter a number.");
                        }
                    }
                    // quantity should be a positive number.
                    int quantity;
                    while(true){
                        try {
                            System.out.println("What is the quantity of the item?");
                            quantity = Integer.parseInt(scanner.nextLine());
                            if(quantity < 0){
                                System.out.println("Quantity should be greater than 0. Try again.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid quantity. Please enter a whole number.");
                        }
                    }
                    // add item to list
                    Item item = new Item(name, price, quantity);
                    items.add(item);
                    System.out.println("Item added successfully");
                    item.printDetail();
                    break;
                case 2:
                    String nameRemove;
                    while(true){
                        System.out.println("What is the name of the item?");
                        nameRemove = scanner.nextLine().toLowerCase();
                        if(nameRemove.matches(".*\\d.*")){
                            System.out.println("Item name should not contain numbers. Try again.");
                        } else {
                            break;
                        }
                    }

                    // loop through the list to find item

                    boolean removed = false;
                    for (int i = 0; i < items.size(); i++) {
                        if(items.get(i).getName().equalsIgnoreCase(nameRemove)){
                            items.remove(i);
                            removed = true;
                            System.out.println("Remove Item Selected");
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Item not found. Try again.");
                    }
                    break;
                case 3:
//                     String itemName;
//                    while(true){
//                        System.out.println("What's the item name?");
//                        itemName = scanner.nextLine();
//
//                        try{
//                            if(itemName.matches(".*\\d.*")){
//                                System.out.println("Item name should not contain numbers. Try again.");
//                            } else {
//                                break;
//                            }
//                        } catch (Exception e) {
//                            System.out.println("Invalid item name. Try again.");
//                            break;
//                        }
//                    }
//                        //loop through the list to find item
//                        for (int i = 0; i < items.size(); i++) {
//                            if(items.get(i).getName().equalsIgnoreCase(itemName)){
//                                System.out.println(itemName + " found in the list. What would you like to update?");
//                                System.out.println("1. Update Quantity");
//                                System.out.println("2. Update Price");
//
//
//                                int subChoice;
//                                while(true){
//                                    subChoice = Integer.parseInt(scanner.nextLine());
//                                    try {
//
//                                        switch(subChoice){
//                                            case 1:
//                                                System.out.println("Curren quantity: " + items.get(i).getQuantity());
//                                                System.out.println("What will be the new quantity?");
//                                                int newQuantity = Integer.parseInt(scanner.nextLine());
//                                                items.get(i).setQuantity(newQuantity);
//                                                System.out.println("Update quantity successfully, new quantity: " + newQuantity);
//                                                break;
//                                            case 2:
//                                                System.out.println("Current price: " + items.get(i).getPrice());
//                                                System.out.println("What will be the new price?");
//                                                double newPrice = Double.parseDouble(scanner.nextLine());
//                                                items.get(i).setPrice(newPrice);
//                                                System.out.println("Update price successfully, new price: " + newPrice);
//                                                break;
//                                        }
//                                    } catch (NumberFormatException e) {
//                                        System.out.println("Invalid choice. Try again.");
//                                    }
//                                    break;
//                                }
//                            } else {
//                                System.out.println(itemName + " not found. Try again.");
//                                break;
//                            }
//                        }
//
//                    break;
                    String itemName;
                    while(true){
                        System.out.println("What is the name of the item?");
                        itemName = scanner.nextLine();

                        if(itemName.matches(".*\\d.*")){
                            System.out.println("Item name should not contain numbers. Try again.");
                        } else {
                            break;
                        }
                    }

                    Item foundItem = null;
                    for (Item invItem: items) {
                        if(invItem.getName().equalsIgnoreCase(itemName)){
                            foundItem = invItem;
                            break;
                        }
                    }
                    if(foundItem != null){
                        System.out.println("Item found.");
                    }

                    System.out.println(itemName + " found. What would you like to update?");
                    System.out.println("1. Update Quantity");
                    System.out.println("2. Update Price");

                    int subChoice = -1;
                    try{
                        subChoice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid option");
                        break;
                    }

                    switch (subChoice){
                        case 1:
                            System.out.println("Current quantity: " + foundItem.getQuantity());
                            System.out.print("Enter new quantity: ");
                            int newQty = Integer.parseInt(scanner.nextLine());
                            foundItem.setQuantity(newQty);
                            System.out.println("Quantity updated successfully");
                            break;
                        case 2:
                            System.out.println("Current price: " + foundItem.getPrice());
                            System.out.print("Enter new price: ");
                            double newPrice = Double.parseDouble(scanner.nextLine());
                            foundItem.setPrice(newPrice);
                            System.out.println("Price updated successfully");
                            break;
                        default:
                            System.out.println("Invalid option. Try again.");
                    }
                    break;

                case 4:
                    if (items.isEmpty()){
                        System.out.println("Items list is empty. Try again.");
                    } else {
                        System.out.println("📦 Inventory List:");
                        for (Item currentItem : items) {
                            System.out.println("-".repeat(30));
                            currentItem.printDetail();
                        }
                    }

                   break;
                case 5:
                    String nameSearch;

                    while(true) {
                        System.out.println("Enter the item name to search:");
                        nameSearch = scanner.nextLine();
                        if (nameSearch.matches(".*\\d.*")) {
                            System.out.println("Item name should not contain numbers. Try again.");
                        } else {
                            break;
                        }
                    }

                     Item searchItem = null;
                     for (Item currentItem : items) {
                         if(currentItem.getName().equalsIgnoreCase(nameSearch)){
                             searchItem = currentItem;
                             break;
                         }
                     }

                     if(searchItem != null){
                         System.out.println("Item found.");
                         System.out.println("-".repeat(30));
                         searchItem.printDetail();
                     } else {
                         System.out.println("Item not found in the inventory list.");
                     }
                     break;

                case 6:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        scanner.close();
    }
}
