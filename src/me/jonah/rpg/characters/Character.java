package me.jonah.rpg.characters;

public abstract class Character {
protected String name;
protected int health;
protected int maxHealth;
protected int attack;
protected int defense;

public Character(String name, int health, int maxHealth, int attack, int defense) {
  this.name = name;
  this.health = health;
  this.maxHealth = maxHealth;
  this.attack = attack;
  this.defense = defense;
}

// gets and sets properties
public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

public int getHealth() {
  return health;
}

public void setHealth(int health) {
  this.health = health;
}

public int getMaxHealth() {
  return maxHealth;
}

public void setMaxHealth(int maxHealth) {
  this.maxHealth = maxHealth;
}

public int getAttack() {
  return attack;
}

public void setAttack(int attack) {
  this.attack = attack;
}

public int getDefense() {
  return defense;
}

public void setDefense(int defense) {
  this.defense = defense;
}

// general methods for attacking, taking damage, etc
public int attack(Character target) {
  int damage = this.attack - target.defense;
  target.takeDamage(damage);
  return damage;
}

public void takeDamage(int damage) {
  health = Math.max(health - damage, 1);
}

public void heal(int amount) {
  health = Math.min(health + amount, maxHealth);
}

public boolean isAlive() {
  return health > 0;
}
}
