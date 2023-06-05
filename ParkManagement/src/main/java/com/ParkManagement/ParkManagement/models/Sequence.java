package com.ParkManagement.ParkManagement.models;

public class Sequence {
    int nextVal;

    public Sequence() {
    }

    public Sequence(int nextVal) {
        this.nextVal = nextVal;
    }

    public int getNextVal() {
        return nextVal;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "nextVal=" + nextVal +
                '}';
    }

    public void setNextVal(int nextVal) {
        this.nextVal = nextVal;
    }
}
