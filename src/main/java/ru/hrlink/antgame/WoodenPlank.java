package ru.hrlink.antgame;

import java.util.Map;

import static ru.hrlink.antgame.Way.LEFT;
import static ru.hrlink.antgame.Way.RIGHT;

public class WoodenPlank {
    //1234 - size of the Wooden Plank.
    private int length;
    //>--
    //123 - Wooden Plank
    private Ant antRight;
    //--<
    //123 - Wooden Plank
    private Ant antLeft;
    private String[][] matrix;
    private int round = 0;
    private final Map<String, String> colors = Map.of(
            "GREEN", "\u001B[32m",
            "BLUE", "\u001B[34m",
            "RED", "\u001B[31m",
            "WHITE", "\u001B[37m"
    );

    public WoodenPlank(int length, int positionAntLeft, int positionAntRight) {
        if (gameValidator(length, positionAntLeft, positionAntRight)) {
            this.length = length + 1;
            antLeft = new Ant(LEFT, positionAntLeft, colors.get("GREEN"), colors.get("WHITE"));
            antRight = new Ant(RIGHT, positionAntRight, colors.get("RED"), colors.get("WHITE"));
            matrix = new String[2][this.length];
            matrixInitializer(this.length);
            showMatrix();
            System.out.println("WoodenPlank created.");
            System.out.println("--------------------------------------");
            setupAntsPositionOnWoodenPlank();
            showMatrix();
            System.out.println("Ant added on the WoodenPlank");
            System.out.println("--------------------------------------");
        } else {
            System.out.println("Error. You should use this constraints:\n" +
                    "1 <= n <= 10^4\n" +
                    "0 <= left <= n\n" +
                    "0 <= right <= n\n" +
                    "left != right");
        }
    }

    private void matrixInitializer(int length) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < length; j++) {
                if (i == 0) {
                    matrix[i][j] = colors.get("WHITE") + "-";
                }
                if (i == 1) {
                    matrix[i][j] = colors.get("BLUE") + String.valueOf(j);
                }
            }
        }
    }

    public int runGame() {
        if (round == 0) {
            if ((antRight.getPosition() + 1) == antLeft.getPosition()) {
                antLeft.setWay(RIGHT);
                antLeft.move();
                runMatrix();
            } else {
                antLeft.move();
                runMatrix();
            }
        }
        while (-1 < antLeft.getPosition() && antLeft.getPosition() < length &&
                -1 < antRight.getPosition() && antRight.getPosition() < length) {
            if ((antRight.getPosition() + 1) == antLeft.getPosition() ||
                (antRight.getPosition() + 2) == antLeft.getPosition()) {
                antLeft.setWay(RIGHT);
                antRight.setWay(LEFT);
                antLeft.move();
                antRight.move();
                runMatrix();
            } else {
                antLeft.move();
                antRight.move();
                runMatrix();
            }
        }
        return round;
    }

    private void runMatrix() {
        matrixInitializer(length);
        setupAntsPositionOnWoodenPlank();
        showMatrix();
        round = round + 1;
        System.out.println("Round - " + round + " finished");
        System.out.println("--------------------------------------");
    }

    private void setupAntsPositionOnWoodenPlank() {
        if (0 <= antRight.getPosition() && antRight.getPosition() <= length - 1)
            matrix[0][antRight.getPosition()] = antRight.getMark();
        if (0 <= antLeft.getPosition() && antLeft.getPosition() <= length - 1)
            matrix[0][antLeft.getPosition()] = antLeft.getMark();
    }

    public void showMatrix() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j]);
                if (j == length - 1) System.out.println();
            }
        }
    }

    private boolean gameValidator(int length, int positionAntLeft, int positionAntRight) {
        if ((1 <= length && length <= Math.pow(10, 4)) &&
                (0 <= positionAntLeft && positionAntLeft <= length) &&
                (0 <= positionAntRight && positionAntRight <= length) &&
                (positionAntLeft != positionAntRight)) {
            return true;
        }
        return false;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Ant getAntRight() {
        return antRight;
    }

    public void setAntRight(Ant antRight) {
        this.antRight = antRight;
    }

    public Ant getAntLeft() {
        return antLeft;
    }

    public void setAntLeft(Ant antLeft) {
        this.antLeft = antLeft;
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

    public Map<String, String> getColors() {
        return colors;
    }
}
