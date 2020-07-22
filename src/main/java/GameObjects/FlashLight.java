package GameObjects;

public class FlashLight extends Item {
    Light light;
    public FlashLight() {
        super("FlashLight");
        light = new Light();
        MapConfiguration configuration = new MapConfiguration();
        setItemValue(configuration.getFlashlightGoldValue());
    }

    public boolean isLightON() {
        return light.isLightON();
    }

    public void switchLight(){
        if (isLightON())
            light.setLightON(false);
        else
            light.setLightON(true);
    }

    @Override
    public String toString() {
        return "Flashlight";
    }
}
