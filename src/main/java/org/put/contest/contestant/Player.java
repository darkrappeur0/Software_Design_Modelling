package org.put.contest.contestant;

public class Player extends Contestant{
    private int awardNumber;
    private String nationality;
    private float height;
    private float weight;
    

    public Player(String name, String nationality, float height, float weight) {
        this.name = name;
        this.awardNumber = 0;
        this.nationality = nationality
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAwardNumber() {
        return awardNumber;
    }

    public String getNationality() {
        return  nationality;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public void giveAward() {
        this.awardNumber++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", award number=" + awardNumber +
                ", nationality=" + nationality +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}