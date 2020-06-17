package com.online.dao;



import com.online.model.Food;
import com.online.model.Food.MealType;

import java.util.*;
import java.util.stream.Collectors;

public class FoodDAO {
    public static Map<Integer, Food> fooddb = new HashMap<>();

    private static Integer nextId = 1;

    public static Integer getNextId() {
        return nextId++;
    }

    static {
        Food food1 = new Food("egg","scrambled egg", MealType.BREAKFAST, 41);
        Food food2 = new Food("meat","rosted", MealType.LUNCH,44);
        Food food3 = new Food("pizza","vegitable pizza", MealType.DINNER,43);
        Food food4 = new Food("cake","blackforest", MealType.DESSERT,47);
        Food food5 = new Food("soda","coca", MealType.DRINK,49);

        fooddb.put( food1.getFoodId(), food1);
        fooddb.put(food2.getFoodId(), food2);
        fooddb.put(food3.getFoodId(), food3);
        fooddb.put(food4.getFoodId(), food4);
        fooddb.put(food5.getFoodId(), food5);
    }

    public void addFood(Food food) {fooddb.put(food.getFoodId(),food);}
    public void deleteFood(int foodId){
        fooddb.remove(foodId);
    }

    public void updateFood(Food food){
        fooddb.put(food.getFoodId(), food);
    }

    public List<Food> getAllFood(){
        return new ArrayList<>(fooddb.values());
    }
    public Optional<Food> getFoodByName(String name){
        return fooddb.values().stream()
                .filter(f -> f.getName().toLowerCase().equals(name.toLowerCase()))
                .findAny();
    }
    public int genId() { return fooddb.size()+1; }

    public Optional<Food> findById(Integer id) {
        return Optional.ofNullable(fooddb.get(id));
    }
    public boolean remove(Food food) {
        return fooddb.remove(food.getFoodId()) == null;
    }

    public Collection<Food> getFoodByType(String mealType) {
        if (mealType.equals("ALL")) return getAllFood();
        return getAllFood().stream().filter(f -> f.getMealType().toString().equals(mealType)).collect(Collectors.toList());
    }
}

