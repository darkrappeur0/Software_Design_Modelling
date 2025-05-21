package org.put.common.contestant;

public class Player extends Contestant {
    private int awardNumber;
    private float height;
    private float weight;

    public Player(String name, String sportType, String nationality, float height, float weight) {
        super(name, sportType, nationality);
        this.awardNumber = 0;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return super.getName();
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

    public void giveAward() {
        this.awardNumber++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + getName() + '\'' +
                ", award number=" + awardNumber +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}