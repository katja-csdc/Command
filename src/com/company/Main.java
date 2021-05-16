package com.company;

class ChefCook {
    public void startCooking() {
        System.out.println("Meisterkoch fängt an Ihr Gericht vorbereiten!\n");
    }

    public void stopCooking() {
        System.out.println("Meisterkoch stoppt kochen!\n");
    }
}

class Cook {
    public void startCooking() {
        System.out.println("Hilfskoch fängt an Ihr Gericht vorbereiten!\n");
    }

    public void stopCooking() {
        System.out.println("Hilfskoch stoppt kochen!\n");
    }
}

class Order {
    private Command start, stop;

    public Order(Command startCooking, Command stopCooking) {
        start = startCooking;
        stop = stopCooking;
    }

    void startCooking(){
        start.execute();
    }

    void stopCooking(){
        stop.execute();
    }
}

class ChefCooksOrder implements Command{
    private ChefCook myChef;

    public ChefCooksOrder(ChefCook cc) {
        myChef = cc;
    }

    public void execute(){
        myChef.startCooking();
    }
}

class ChefStopsCookingOrder implements Command{
    private ChefCook myChef;

    public ChefStopsCookingOrder(ChefCook cc) {
        myChef = cc;
    }

    public void execute(){
        myChef.stopCooking();
    }
}

class RegularCookMakesOrder implements Command{
    private Cook myCook;

    public RegularCookMakesOrder(Cook c) {
        myCook = c;
    }

    public void execute(){
        myCook.startCooking();
    }
}

class RegularCookStopsMakingOrder implements Command{
    private Cook myCook;

    public RegularCookStopsMakingOrder(Cook c){
        myCook = c;
    }

    public void execute(){
        myCook.stopCooking();
    }
}

public class Main {
    public static void main(String[] args) {
        ChefCook chef = new ChefCook();
        ChefCooksOrder chefCooksOrderCommand = new ChefCooksOrder(chef);
        ChefStopsCookingOrder chefStopsCookingOrderCommand = new ChefStopsCookingOrder(chef);

        Order newOrderForChef = new Order(chefCooksOrderCommand, chefStopsCookingOrderCommand);

        newOrderForChef.startCooking();
        newOrderForChef.stopCooking();



        Cook regularCook = new Cook();
        RegularCookMakesOrder regularCookMakesOrderCommand = new RegularCookMakesOrder(regularCook);
        RegularCookStopsMakingOrder regularCookStopsMakingOrderCommand = new RegularCookStopsMakingOrder(regularCook);

        Order newOrderForCook = new Order(regularCookMakesOrderCommand, regularCookStopsMakingOrderCommand);

        newOrderForCook.startCooking();
        newOrderForCook.stopCooking();
    }
}
