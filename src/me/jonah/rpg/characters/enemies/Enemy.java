package me.jonah.rpg.characters.enemies;

import me.jonah.rpg.characters.Character;

public abstract class Enemy extends Character {
protected int minLevel;
protected int expGivenOnDeath;
public Enemy(String name, int health, int maxHealth, int attack, int defense, int expOnDeath, int expGivenOnDeath) {
super (name, health, maxHealth, attack, defense);
this.minLevel = minLevel;
this.expOnDeath = expOnDeath;
}

public int getMinLevel() {
return minLevel;
}

public void setMinLevel(int minLevel) {
this.minLevel = minLevel;
}

public int getExpOnDeath() {
return expOnDeath;
}

public void setExpOnDeath(int expOnDeath) {
this.expOnDeath = expOnDeath;
}
}
