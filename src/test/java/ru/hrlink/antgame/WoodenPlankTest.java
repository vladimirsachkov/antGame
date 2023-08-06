package ru.hrlink.antgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WoodenPlankTest {

    @Test
    void woodenPlankRunWith4Size1Left3RightTest() {
        WoodenPlank woodenPlank = new WoodenPlank(4,1,3);
        int n = woodenPlank.runGame();
        assertEquals(2, n);
    }

    @Test
    void woodenPlankRunWith4Size4Left1RightTest() {
        WoodenPlank woodenPlank = new WoodenPlank(4,4,1);
        int n = woodenPlank.runGame();
        assertEquals(3, n);
    }

    @Test
    void woodenPlankRunWith4Size4Left3RightTest() {
        WoodenPlank woodenPlank = new WoodenPlank(4,4,3);
        int n = woodenPlank.runGame();
        assertEquals(1, n);
    }
}