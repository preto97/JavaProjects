package com.company;

// This is base Hamburger class with fields: name, meat, price, breadType +
// + all addition items names and prices
public class Hamburger {

    private String name;
    private String meat;
    private double price;
    private String breadType;

    private String addition1Name;
    private double addition1Price;

    private String addition2Name;
    private double addition2Price;

    private String addition3Name;
    private double addition3Price;

    private String addition4Name;
    private double addition4Price;

    // This is the base Hamburger constructor
    public Hamburger(String name, String meat, double price, String breadType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadType = breadType;
    }

    // The next functions gives the name and the price for each addition item
    public void addHamburgerAddition1 (String name, double price){
        this.addition1Name = name;
        this.addition1Price = price;
    }

    public void addHamburgerAddition2 (String name, double price){
        this.addition2Name = name;
        this.addition2Price = price;
    }

    public void addHamburgerAddition3 (String name, double price){
        this.addition3Name = name;
        this.addition3Price = price;
    }

    public void addHamburgerAddition4 (String name, double price){
        this.addition4Name = name;
        this.addition4Price = price;
    }

    // This function return the price of the base Hamburger + each addiotion made in main.java file
    public double itemizeHamburger(){
        // Set the base Hmburger price
        double hamburgerPrize = this.price;
        // The next line print the contains of the base Hamburger and the price
        System.out.println(this.name + " hamburger on a " + this.breadType +" roll with " + this.meat + " price is " + hamburgerPrize + " $");

        // The next code lines checks if it is any addition items and if exists
        // increment the Hamburger price by addition price and display a message
        if (this.addition1Name != null) {
            hamburgerPrize += this.addition1Price;
            System.out.println("Added " + this.addition1Name + " for an extra "+ this.addition1Price);
        }
        if (this.addition2Name != null) {
            hamburgerPrize += this.addition2Price;
            System.out.println("Added " + this.addition2Name + " for an extra "+ this.addition2Price);
        }
        if (this.addition3Name != null) {
            hamburgerPrize += this.addition3Price;
            System.out.println("Added " + this.addition3Name + " for an extra "+ this.addition3Price);
        }
        if (this.addition4Name != null) {
            hamburgerPrize += this.addition4Price;
            System.out.println("Added " + this.addition4Name + " for an extra "+ this.addition4Price);
        }
        return hamburgerPrize;
    }

    // We used getters and setters to get/set the Hamburger price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
