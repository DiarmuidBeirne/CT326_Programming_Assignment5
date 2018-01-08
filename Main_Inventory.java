
package Assignment5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
Assignment5
Author: 15331436 | Diarmuid Beirne

18 Oct 2017
*/
public class Main_Inventory {
    public static void main(String... args)
    {
       
        ArrayList<Inventory> itemList = new ArrayList<Inventory>();
        itemList.add(new Inventory("1000", "Apple", 30, 2.50, 1.25));
        itemList.add(new Inventory("1001", "Orange", 40, 2.00, 1.00));
        itemList.add(new Inventory("2001", "Milk", 10, 2.39, 1.50));
        itemList.add(new Inventory("2002", "Orange Juice", 20, 1.99, 1.25));
        itemList.add(new Inventory("3001", "Blue Cheese", 10, 2.25, 1.50));
        itemList.add(new Inventory("3002", "Chedder", 20, 2.79, 1.60));
        itemList.add(new Inventory("4001", "Chocolate", 40, 2.99, 1.70));
        itemList.add(new Inventory("4002", "Candy", 30, 0.99, 0.50));
        itemList.add(new Inventory("5001", "Beef", 10, 5.00, 3.00));
        itemList.add(new Inventory("5002", "Chicken", 10, 4.00, 2.00));

        for(Inventory item : itemList)
        {
            System.out.println(item.toString());
        }
        try //Not sure if this should be in this class ?
        {
            FileOutputStream out = new FileOutputStream(Inventory.getFileName());
            ObjectOutputStream stream = new ObjectOutputStream(out);
            stream.writeObject(itemList);
            stream.flush();
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
