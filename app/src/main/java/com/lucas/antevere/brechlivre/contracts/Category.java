package com.lucas.antevere.brechlivre.contracts;

public class Category {
    private int id;
    private String name;
    private String color;
    private String iconName;

    public Category(int id, String name, String color, String iconName){
        this.setId(id);
        this.setName(name);
        this.setColor(color);
        this.setIconName(iconName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
}
