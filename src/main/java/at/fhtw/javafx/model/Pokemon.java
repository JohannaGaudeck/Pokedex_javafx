package at.fhtw.javafx.model;

public class Pokemon {

    private String name;
    private int level;

    private  int hp;
    private  int exp;

    public Pokemon(String name, int level, int hp , int exp) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return name + ", lv: " + level +", hp: "+hp + ", exp: "+exp;
    }
}
