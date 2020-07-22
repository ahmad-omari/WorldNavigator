package GameObjects;

public class Light {
    private boolean lightON;

    public Light(){
        lightON=false;
    }

    public boolean isLightON() {
        return lightON;
    }

    public void setLightON(boolean lightON) {
        this.lightON = lightON;
    }

    public void switchLight() {
        if (isLightON())
            lightON=false;
        else
            lightON=true;
    }

    @Override
    public String toString() {
        return "Light";
    }
}
