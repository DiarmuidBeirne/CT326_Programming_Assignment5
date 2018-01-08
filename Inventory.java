
package Assignment5;

import java.io.Serializable;

/*
Assignment5
Author: 15331436 | Diarmuid Beirne

18 Oct 2017
*/
public class Inventory implements Serializable {
    private String sku;
    private double cost;
    private Item item;
    private String itemName;
    private static String fileName = "inventories.txt";

    public Inventory(String sku, String itemName, 
            int quantity, double price, double cost)
    {
        this.itemName = itemName;
        this.sku = sku;
        this.cost = cost;
        item = new Item(itemName, price, quantity);
    }

    public Inventory(String Name)//Was unsure about this but only way i could get it to work
    {
        this.itemName = Name;
    }

    public String getItemName()
    {
        return itemName;
    }

    public int getQuantity()
    {
        return item.getQuantity();
    }

    public void setQuantity(int newQuantity)
    {
        item.setQuantity(newQuantity);
    }

    public double getPrice()
    {
        return item.getPrice();
    }

    public static String getFileName() {
        return fileName;
    }
    @Override
    public String toString()
    {
        
        return sku + "\t" + item.getName() + "\t"+ item.getQuantity()
                + "\t" + item.getPrice();
    }


}
