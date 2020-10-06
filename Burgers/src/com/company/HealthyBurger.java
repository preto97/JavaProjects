package com.company;

// This is HealthyBurger class which is inherited from Hamburger class
// This means that HealthyBurger have all data and methods from parent class Hamburger
public class HealthyBurger extends Hamburger {

    // We added 2 extra addition items
    private String addition5Name;
    private double addition5Price;

    private String addition6Name;
    private double addition6Price;

    // This is the  HealthyBurger constructor
    public HealthyBurger(String meat, double price) {
        // This is called in Hamburger class
        super("Healthy burger", meat, price, "Brown rye");
    }

    // The next functions gives the name and the price for each new addition item (5 and 6)
    public void addHamburgerAddition5(String name, double price) {
        this.addition5Name = name;
        this.addition5Price = price;
    }

    public void addHamburgerAddition6(String name, double price) {
        this.addition6Name = name;
        this.addition6Price = price;
    }

    // We override itemizeHamburger() method to add into it the new addition items
    @Override
    public double itemizeHamburger() {
        double hamburgerPrize = super.itemizeHamburger();
        if (this.addition5Name != null) {
            hamburgerPrize += this.addition5Price;
            System.out.println("Added " + this.addition5Name + " for an extra " + this.addition5Price);
        }

        if (this.addition6Name != null) {
            hamburgerPrize += this.addition6Price;
            System.out.println("Added " + this.addition6Name + " for an extra " + this.addition6Price);
        }
        return hamburgerPrize;
    }
}
