package es5;

class Counter {
    private int value;
    public Counter() {
        value = 0;
    }
    public synchronized int getNextStart() {
        int start = value + 1;
        value += 10;
        return start;
    }
}