package org.put.common.contestant;

public class TeamPlayer{
    private String name;
    private int awardNumber;
    private float height;
    private float weight;
    private String position;
    

    public TeamPlayer(String name, float height, float weight, String position) {
        this.name = name;
        this.awardNumber = 0;
        this.height = height;
        this.weight = weight;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAwardNumber() {
        return awardNumber;
    }

    public float getHeight() {
        return height;
    }
    
    public float getWeight() {
        return weight;
    }

    public String getPosition() {
        return position;
    }

    public void giveAward() {
        this.awardNumber++;
    }

    @Override
    public String toString() {
        return "TeamPlayer{" +
                "name='" + name + '\'' +
                ", award number=" + awardNumber +
                ", height=" + height +
                ", weight=" + weight +
                ", position='" + position +
                '}';
    }
}