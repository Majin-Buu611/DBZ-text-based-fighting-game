package me.jonah.rpg;

import java.util.ArrayList;
import java.util.List;
import me.jonah.rpg.characters.*;
import me.jonah.rpg.characters.enemies.*;

public class Main {
  public static void main(String[] args) {
    Player player = new Player("Player 1", 100, 100, 20, 10, 1, 0, 20);
    List<Enemy> enemies = new ArrayList<>();
    enemies.add(new Zombie("Zombie 1", 50, 50, 15, 5, 1));
    enemies.add(new Zombie("Zombie 2", 60, 60, 18, 6, 2));
    enemies.add(new Zombie("Zombie 3", 70, 70, 21, 7, 3));
    enemies.add(new Zombie("Zombie 4", 80, 80, 24, 8, 4));

    Enemy enemy = chooseEnemy(player, enemies);
    while (player.isAlive() && enemy.isAlive()) {
      player.attack(enemy);
      if (enemy.isAlive()) {
        enemy.attack(player);
      }
      if (!player.isAlive()) {
        System.out.println("You have been defeated.");
        break;
      }
      if (!enemy.isAlive()) {
        System.out.println("You have defeated " + enemy.getName() + " and gained " + enemy.getExpOnDeath() + " exp.");
        player.gainExp(enemy.getExpOnDeath());
        enemy = chooseEnemy(player, enemies);
      }
    }
  }

  public static Enemy chooseEnemy(Player player, List<Enemy> enemies) {
    List<Enemy> availableEnemies = new ArrayList<>();
    for (Enemy e : enemies) {
      if (e.getMinLevel() <= player.getLevel()) {
        availableEnemies.add(e);
      }
    }
    int randomIndex = (int) (Math.random() * availableEnemies.size());
    return availableEnemies.get(randomIndex);
  }
}
