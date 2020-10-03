package com.company;

public class DeluxeHamburger extends Hamburger {

    private String addChips;
    private double priceChips = 3.5;

    private String addDrink;
    private double priceDrink = 5;

    public DeluxeHamburger(String meat, double price) {
        super("Deluxe Hamburger", meat, price, "Normal");
        this.addChips = "Chio";
        this.addDrink = "CocaCola";
    }

    public void addChips(String name, double price){
        this.addChips = name;
        this.priceChips = price;
    }

    public void addDrink(String name, double price){
        this.addDrink = name;
        this.priceDrink = price;
    }

    @Override
    public double itemizeHamburger() {
        double deluxeBurgerPrice = super.itemizeHamburger();
        if (this.addChips != null){
            deluxeBurgerPrice += this.priceChips;
            System.out.println("Added " + this.addChips + " for an extra "+ this.priceChips);
        }
        if (this.addDrink != null){
            deluxeBurgerPrice += this.priceDrink;
            System.out.println("Added " + this.addDrink + " for an extra "+ this.priceDrink);
        }

        return deluxeBurgerPrice;
    }

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
