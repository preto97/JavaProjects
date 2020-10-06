package com.company;

public class Main {

    public static void main(String[] args) {

        // I created the ham object of Hamburgar class and I gave it a name, a meat type, a price and a bread type
        // This is the base hamburger
        Hamburger ham = new Hamburger("Big Tasty", "chicken", 25.0, "dry");
        // To this hamburger you can add up to 4 addition items
        // Each addition has a specific price
        ham.addHamburgerAddition1("Salad", 0.3);
        ham.addHamburgerAddition2("Tomato", 0.2);
        ham.addHamburgerAddition3("Carot", 0.5);
        ham.addHamburgerAddition4("Garlic", 0.1);
        // Next line print the price of the Big Tasty hamburger with all additions.
        System.out.println("Total is: " + ham.itemizeHamburger());

        System.out.println();

        // The next hamburger, HelathyBurger inherit all datas and methods from base Hamburger
        // This burger is different because it has 2 more addition items (6 addition items in total)
        // healthy object of HealthyHamburger class comes by default with name: "Healthy burger" and "Brown rye" bread type
        HealthyBurger healthy = new HealthyBurger("Cheese", 35.0);
        // I added to it 4 addition items (5, 1, 4, 6)
        healthy.addHamburgerAddition5("Parsley", 0.22);
        healthy.addHamburgerAddition1("Tomato", 0.3);
        healthy.addHamburgerAddition4("Dill", 0.1);
        healthy.addHamburgerAddition6("Rice", 0.18);
        // Next line print the price of the Healthy Hamburger with all additions.
        System.out.println("Total is: " + healthy.itemizeHamburger());

        System.out.println();

        // The third hamburger, Deluxe Hamburger inherit all datas and methods from base Hamburger
        // But it cames by default with name: "Deluxe Hamburger" and "Normal" bread type +
        // + two more adition items: chips (Chio) and drinks (CocaCola) and NONE of any extra additions
        DeluxeHamburger deluxe = new DeluxeHamburger("Beef", 40);
        deluxe.addHamburgerAddition2("ketchup", 55); // This addition is not allowed

        // Next line print the price of the Deluxe Hamburger with all 2 additions (chips and drinks)
        System.out.println("Total is: " + deluxe.itemizeHamburger());

        deluxe.addHamburgerAddition3("Beef2", 5); // This addition is not allowed
        // Next line print the price of the Deluxe Hamburger with all 2 additions (chips and drinks)
        System.out.println("Total is: " + deluxe.itemizeHamburger());
    }
}
