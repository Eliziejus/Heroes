package com.heroes.heroeszp202;


import java.io.Serializable;


public class Hero implements Serializable {
    private String id;
    private String name;
    private Object powerstats;
    private String intelligence;
    private String strength;
    private String speed;
    private String durability;
    private String power;



    public Hero(String id, String name, Object powerstats, String intelligence, String strength, String speed, String durability) {
        this.id = id;
        this.name = name;
        this.powerstats = powerstats;
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.durability = durability;
        this.power = power;
    }

    public Hero(String name, String intelligence, String power, String speed) {
        this.name = name;
        this.intelligence = intelligence;
        this.power = power;
        this.speed = speed;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPowerstats() {
        return powerstats;
    }

    public void setPowerstats(Object powerstats) {
        this.powerstats = powerstats;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "hero='" + name + '\'' +
                ", intelligence='" + intelligence + '\'' +
                ", Id='" + id + '\'' +
                ", power=" + power +
                ", speed=" + speed +
                '}';
    }
}



