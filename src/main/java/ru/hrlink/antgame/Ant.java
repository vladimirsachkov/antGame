package ru.hrlink.antgame;

import static ru.hrlink.antgame.Way.LEFT;
import static ru.hrlink.antgame.Way.RIGHT;

public class Ant {
    //This is the way where the ant goes
    private String way;
    //This is a position
    private int position;
    //This is the color of the ant.
    private String colorPrefix;
    private String colorSuffix;
    private String mark;

    public Ant(String way, int position, String colorPrefix, String colorSuffix) {
        this.position = position;
        this.colorPrefix = colorPrefix;
        this.colorSuffix = colorSuffix;
        setWay(way);
    }

    public void move() {
        if (way.equals(LEFT)) position = position - 1;
        if (way.equals(RIGHT)) position = position + 1;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
        if (way.equals(RIGHT)) setMark(">");
        if (way.equals(LEFT)) setMark("<");
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    public String getColorPrefix() {
        return colorPrefix;
    }

    public void setColorPrefix(String colorPrefix) {
        this.colorPrefix = colorPrefix;
    }

    public String getColorSuffix() {
        return colorSuffix;
    }

    public void setColorSuffix(String colorSuffix) {
        this.colorSuffix = colorSuffix;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = colorPrefix + mark + colorSuffix;
    }
}
