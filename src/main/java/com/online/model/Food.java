package com.online.model;


import com.online.dao.FoodDAO;

public class Food {
    public enum MealType {
        BREAKFAST, LUNCH, DINNER,DRINK,DESSERT
    }

    private Integer foodId;
    private String name, description;
    private MealType mealType;
    private int price;

    public Food() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Food(String name, String description, MealType mealType, int price) {
        this.name = name;
        this.description = description;
        this.mealType = mealType;
        this.price = price;
        this.foodId = FoodDAO.getNextId();
    }

    public Food(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", mealType=" + mealType +
                ", price=" + price +
                '}';
    }

}
