
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
public class Main_ShoppingCart {


    private static ArrayList<Inventory> inventory;


    public static void main(String[] args)
    {
        //create shoping carts
        ShoppingCart cart1 = new ShoppingCart("Leo", "18/10/2017");
        ShoppingCart cart2 = new ShoppingCart("Paul", "19/10/2017");

        //print inventory before adding items
        try
        {
            FileInputStream inputStream = new FileInputStream(Inventory.getFileName());
            ObjectInputStream stream = new ObjectInputStream(inputStream);
            inventory = (ArrayList<Inventory>) stream.readObject();
        }
        catch(IOException | ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
        }

        for(Inventory i : inventory)

        {
                System.out.println(i.toString());

        }

        cart1.addItem("Apple", 2);
        cart1.addItem("Orange", 5);
        cart1.addItem("Milk", 2);
        cart1.addItem("Blue Cheese", 4);
        cart1.addItem("Candy", 25);
        cart1.removeItem("Candy", 5);


        cart2.addItem("Apple", 2);
        cart2.addItem("Orange", 5);
        cart2.addItem("Milk", 2);
        cart2.addItem("Blue Cheese", 4);
        cart2.addItem("Chedder", 3);
        cart2.addItem("Beef", 6);
        cart2.addItem("Candy", 20);
        cart2.addItem("Chocolate", 10);
        cart2.addItem("Chicken", 2);
        cart2.removeItem("Chocolate", 5);
        cart2.removeItem("Blue Cheese", 1);

        cart1.printCart();
        cart2.printCart();


        //print inventory before adding items COULD NOT GET THIS TO WORK
       /* try
        {
            FileInputStream inputStream2 = new FileInputStream(Inventory.getFileName());
            ObjectInputStream stream2 = new ObjectInputStream(inputStream2);
            inventory = (ArrayList<Inventory>) stream2.readObject();
        }
        catch(IOException | ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
        }

        for(Inventory i : inventory)

        {
            System.out.println(i.toString());
*/
        }

    
}



