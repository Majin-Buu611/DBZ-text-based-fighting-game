package me.jonah.rpg.characters.enemies;

import me.jonah.rpg.characters.Character;

public abstract class Enemy extends Character {
protected int expGivenOnDeath;
public Enemy(String name, int health, int maxHealth, int attack, int defense, int expGivenOnDeath) {
super (name, health, maxHealth, attack, defense);
this.expGivenOnDeath = expGivenOnDeath;
}

public int getExpGivenOnDeath() {
return expGivenOnDeath;
}
}
