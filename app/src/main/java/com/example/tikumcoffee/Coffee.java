package com.example.tikumcoffee;

public class Coffee {
    private String coffeeId;
    private String coffeeName;
    private String coffeeDescription;
    private Integer coffeePrice;
    private Integer coffeeImage;

    public Coffee(String coffeeId, String coffeeName, String coffeeDescription, Integer coffeePrice, Integer coffeeImage) {
        this.coffeeId = coffeeId;
        this.coffeeName = coffeeName;
        this.coffeeDescription = coffeeDescription;
        this.coffeePrice = coffeePrice;
        this.coffeeImage = coffeeImage;
    }

    public String getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(String coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getCoffeeDescription() {
        return coffeeDescription;
    }

    public void setCoffeeDescription(String coffeeDescription) {
        this.coffeeDescription = coffeeDescription;
    }

    public Integer getCoffeePrice() {
        return coffeePrice;
    }

    public void setCoffeePrice(Integer coffeePrice) {
        this.coffeePrice = coffeePrice;
    }

    public Integer getCoffeeImage() {
        return coffeeImage;
    }

    public void setCoffeeImage(Integer coffeeImage) {
        this.coffeeImage = coffeeImage;
    }
}
