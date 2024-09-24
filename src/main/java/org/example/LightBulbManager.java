package org.example;

public class LightBulbManager {
    private int ia;
    private int ib;
    private int fa;
    private int fb;

    private int numberOfclicks;

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




    public void setLightBulbA(int value) {
        this.ia = value;
    }
    public void setLightBulbB(int value) {
        this.ib = value;
    }

    public void setLightBulbAFinalConfig(int value) {
        this.fa = value;
    }
    public void setLightBulbConfigBFinalConfig(int value) {
        this.fb = value;
    }

    public void increaseOneClick() {
        this.numberOfclicks++;
    }

    public int getLightBulbA() {
        return this.ia;
    }

    public int getLightBulbB() {
        return this.ib;
    }

    boolean isInputInvalid(int input) {
        return input != 0 && input != 1;
    }

    public void clickFirstSwitch() {
        if (this.ia == 0) {
            this.ia++;
            return;
        }
        this.ia--;
    }


    public void clickSecondSwitch() {
        if (this.ia == 0) {
            this.ia++;
        }
        else this.ia--;
        if (this.ib == 0) {
            this.ib++;
            return;
        }
        this.ib--;
    }

    public boolean isLampACorrect() {
        return this.ia == this.fa;
    }

    public boolean isLampBCorrect() {
        return this.ib == this.fb;
    }

    public void SolveLightBulbProblem() {
        if(!isLampBCorrect()) this.clickSecondSwitch();
        if(!isLampACorrect()) this.clickFirstSwitch();
    }
}
