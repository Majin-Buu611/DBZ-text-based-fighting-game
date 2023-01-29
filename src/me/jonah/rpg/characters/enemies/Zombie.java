package me.jonah.rpg.characters.enemies;

import me.jonah.rpg.characters.Enemy;

public class Zombie extends Enemy {
public Zombie(String name, int health, int maxHealth, int attack, int defense, int minLevel, int expOnDeath) {
super (name, health, maxHealth, attack, defense, minLevel, expGivenOnDeath);
}
}
