package com.company;

// This is DeluxeBurger class which is inherited from Hamburger class
// This means that DeluxeBurger have all data and methods from parent class Hamburger
public class DeluxeHamburger extends Hamburger {

    // This class/hamburger comes with 2 addiotion items by default
    // and each of them have a specific price
    private String addChips;
    private double priceChips = 3.5;

    private String addDrink;
    private double priceDrink = 5;

    // This is the  HealthyBurger constructor
    public DeluxeHamburger(String meat, double price) {
        // This is called in Hamburger class
        super("Deluxe Hamburger", meat, price, "Normal");
        // We added the chips and drink for this hamburger
        this.addChips = "Chio";
        this.addDrink = "CocaCola";
    }

    // The next functions gives the name and the price for each addition item
    public void addChips(String name, double price) {
        this.addChips = name;
        this.priceChips = price;
    }

    public void addDrink(String name, double price) {
        this.addDrink = name;
        this.priceDrink = price;
    }

    // We override itemizeHamburger() method to add into it the new addition items (chio and drink)
    @Override
    public double itemizeHamburger() {
        double deluxeBurgerPrice = super.itemizeHamburger();
        if (this.addChips != null) {
            deluxeBurgerPrice += this.priceChips;
            System.out.println("Added " + this.addChips + " for an extra " + this.priceChips);
        }
        if (this.addDrink != null) {
            deluxeBurgerPrice += this.priceDrink;
            System.out.println("Added " + this.addDrink + " for an extra " + this.priceDrink);
        }
        return deluxeBurgerPrice;
    }

    // We override all addHamburgerAddition(1, 2, 3, 4) methods to not allow any of them to execute
    // Insted, we display a specific message
    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("You cannot add some extra addoons.");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("You cannot add some extra addoons.");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("You cannot add some extra addoons.");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("You cannot add some extra addoons.");
    }
}
