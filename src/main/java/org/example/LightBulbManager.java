package org.example;

public class LightBulbManager {
    private int ia;
    private int ib;
    private int fa;
    private int fb;

    public LightBulbManager() {}
    public LightBulbManager(int ia, int ib, int fa, int fb) {
        if (isInputInvalid(ia)) throw new IllegalArgumentException("Input must be either 0 or 1");
        if (isInputInvalid(ib)) throw new IllegalArgumentException("Input must be either 0 or 1");
        if (isInputInvalid(fa)) throw new IllegalArgumentException("Input must be either 0 or 1");
        if (isInputInvalid(fb)) throw new IllegalArgumentException("Input must be either 0 or 1");

        this.ia = ia;
        this.ib = ib;
        this.fa = fa;
        this.fb = fb;
    }

    boolean isInputInvalid(int input) {
        return input == 0 || input == 1;
    }
}
