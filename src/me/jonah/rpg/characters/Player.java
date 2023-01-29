package me.jonah.rpg.characters;

public class Player extends Character {
private int level;
private int exp;
private int expToNextLevel;
public Player(String name, int health, int maxHealth, int attack, int defense, int level, int exp, int expToNextLevel) {
super (name, health, maxHealth, attack, defense);
this.level = level;
this.exp = exp;
this.expToNextLevel = expToNextLevel;
}

//getters and setters for exp and level things
public int getLevel() {
return level;
}

public void setLevel(int level) {
this.level = level;
}

public int getExp() {
return exp;
}

public void setExp(int exp) {
this.exp = exp;
}

public int getExpToNextLevel() {
return expToNextLevel;
}

public void setExpToNextLevel(int expToNextLevel) {
this.expToNextLevel = expToNextLevel;
}

// method for gaining experience
public void gainExp(int amount) {
exp += amount;

if (exp >= expToNextLevel) {
System.out.println("You have increased your level. You will need " + (20 * Math.pow(level+ 1, 2)));
levelup();
}
}

// method for leveling up
public void levelup() {
level++;
exp = 0;
expToNextLevel = (int) 20 * (Math.pow(level, 2));
maxHealth += level * 10;
health += maxHealth / 2;
attack+= level* 10;
defense += level * 10;
}

// method for increasing multiple levels at once
public void increaseLevel(int amount) {
for (int i = 0; i < amount; i++) {
levelup();
}
System.out.println("You will need " + expToNextLevel + " exp to reach the next level.");
}
}
