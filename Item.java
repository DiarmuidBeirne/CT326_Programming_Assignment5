/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment5;

import java.io.Serializable;

/*
Assignment5
Author: 15331436 | Diarmuid Beirne

18 Oct 2017
*/
public class Item implements Serializable{
    private String itemName;
    private double price;
    private int quantity;


    public Item(String itemName, double price, int quantity)
    {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }


    public String getName()
    {
        return itemName;
    }
    public double getPrice()
    {
        return price;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int newQuantity)
    {
        quantity = newQuantity;
    }


    @Override
    public String toString()
    {
        return quantity + "\t" + itemName + "\t€" + price*quantity;
    }
}
