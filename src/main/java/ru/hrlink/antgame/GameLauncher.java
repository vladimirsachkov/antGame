package ru.hrlink.antgame;

public class GameLauncher {
    public static void main(String[] args) {
        WoodenPlank woodenPlank = new WoodenPlank(3,  3, 1);
        int n = woodenPlank.runGame();
        System.out.println("Number of rounds: " + n);
    }
}
