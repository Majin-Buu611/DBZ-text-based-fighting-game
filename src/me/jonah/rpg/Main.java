package me.jonah.rpg;

import java.util.ArrayList;
import java.util.List;
import me.jonah.rpg.characters.*;
import me.jonah.rpg.characters.enemies.*;

public class Main {
  public static void main(String[] args) {
    Player player = new Player("Player 1", 100, 100, 20, 20, 1, 0, 20);
    List<Enemy> enemies = new ArrayList<>();
    enemies.add(new Zombie("Zombie 1", 50, 50, 20, 10, 1, 20));
    enemies.add(new Zombie("Zombie 2", 60, 60, 40, 40, 3, 100));
    enemies.add(new Zombie("Zombie 3", 70, 70, 100, 50, 7, 200));
    enemies.add(new Zombie("Zombie 4", 100, 100, 200, 100, 15, 1000));

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
