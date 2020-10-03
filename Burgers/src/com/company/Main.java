package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Hamburger ham = new Hamburger("Big Tasty", "chicken", 25.0, "dry");
        ham.addHamburgerAddition1("Salad", 0.3);
        ham.addHamburgerAddition3("Carots", 0.5);
        System.out.println("Total is: " + ham.itemizeHamburger());

        System.out.println();

        HealthyBurger healthy = new HealthyBurger("vita", 35.0);
        //healthy.itemizeHamburger();
        healthy.addHamburgerAddition5("Patrunjel", 0.22);
        healthy.addHamburgerAddition1("Rosii", 0.3);
        healthy.addHamburgerAddition4("Marar", 0.1);
        healthy.addHamburgerAddition6("Orez", 0.18);
        System.out.println("Total is: " + healthy.itemizeHamburger());



        System.out.println();

        DeluxeHamburger deluxe = new DeluxeHamburger("Oaie", 40);
        deluxe.addHamburgerAddition2("ketchup", 55);

        System.out.println("Total is: " + deluxe.itemizeHamburger());

        deluxe.addHamburgerAddition3("cheese", 5);
        System.out.println("Total is: " + deluxe.itemizeHamburger());


    }
}
