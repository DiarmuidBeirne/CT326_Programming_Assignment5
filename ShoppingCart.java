
package Assignment5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Assignment5
Author: 15331436 | Diarmuid Beirne

18 Oct 2017
*/

public class ShoppingCart {
    private String customerName;
    private String date;
    private ArrayList<Item> itemList;
    private ArrayList<Inventory> inventoryItems;


    public ShoppingCart(String customerName, String date)
    {


        this.itemList = new ArrayList<Item>();
        try
        {
            FileInputStream inputStream = new FileInputStream(Inventory.getFileName());
            ObjectInputStream stream = new ObjectInputStream(inputStream);
            inventoryItems = (ArrayList<Inventory>) stream.readObject();
        }
        catch(IOException | ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
        this.customerName = customerName;
        this.date = date;

    }


    public Inventory searchInventory(String itemName)
    {
        Inventory i = new Inventory(itemName);
        Collections.sort(inventoryItems, new InventoryComparator());
        int index = Collections.binarySearch(inventoryItems, i,
                new InventoryComparator());
        if(index < 0)
        {
            return null;

        }
        return inventoryItems.get(index);
    }


    public void addItem(String itemName, int quantity)
    {
        Inventory itemRequired = searchInventory(itemName);
        if(itemRequired == null)
        {
            System.out.println("Item " + itemName + " not found.");
            return;
        }
        if(quantity > itemRequired.getQuantity())
        {
            System.out.println("Can only purchase " + itemRequired.getQuantity() 
                    + " of " + itemName + ".");
            itemList.add(new Item(itemName, itemRequired.getPrice(), quantity));
            itemRequired.setQuantity(0);
        }
        else if(itemRequired.getQuantity() == 0)
        {
            System.out.println("None of " + itemName + " is available.");
        }
        else
        {

            itemList.add(new Item(itemName, itemRequired.getPrice(), quantity));
            itemRequired.setQuantity(itemRequired.getQuantity() - quantity);
            System.out.println(itemName + " added to cart");
        }
    }



    public void removeItem(String itemName, int quantity)
    {
        Inventory itemRequired = searchInventory(itemName);

        if(itemRequired == null)
        {
             System.out.println("Item " + itemName + " not found");
            return;
        }
        Item itemToRemove = null;
        for(Item item : itemList)
        {
            if(item.getName().equalsIgnoreCase(itemName))
            {
                    itemToRemove = item;
                    break;
            }
        }
        if(itemToRemove == null)
        {
                return;
        }

        if(quantity > itemToRemove.getQuantity())
        {
            System.out.println("Can only remove " + itemToRemove.getQuantity()
                    + "of " + itemName);
            itemList.remove(itemToRemove);
            itemRequired.setQuantity(quantity);

        }
        else
        {

            itemList.remove(itemToRemove);
            itemToRemove.setQuantity(itemToRemove.getQuantity() - quantity);
            if (itemToRemove.getQuantity() == 0)
            {
                return;
            }

            itemList.add(itemToRemove);
            itemRequired.setQuantity(quantity);
            System.out.println(quantity + " removed from " + itemName);
        }
    }



    public void printCart()
    {
        System.out.println(date + " Name: " + customerName);
        for(int i = 0; i < itemList.size(); i++)
        {

            System.out.println(itemList.get(i).toString());
        }
    }


    public ArrayList<Item> getCartItems()
    {
        return itemList;
    }

}

class InventoryComparator implements Comparator<Inventory> //Not sure if i needed Comparator
{
    @Override
    public int compare(Inventory a, Inventory b)
    {

        int returnValue = a.getItemName().compareToIgnoreCase(b.getItemName());

        return returnValue;
    }
}

