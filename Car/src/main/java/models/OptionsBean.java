package models;

import java.io.Serializable;

public class OptionsBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean conditioner;
    private Boolean leather;
    private Boolean alloyWheels;
    private Boolean fogLights;
    private Boolean signaling;

    public void init() {
        conditioner = false;
        leather = false;
        alloyWheels = false;        
        fogLights = false;
        signaling = false;
    }

    public Boolean getConditioner() {
        return conditioner;
    }

    public void setConditioner(Boolean conditioner) {
        this.conditioner = conditioner;
    }

    public Boolean getLeather() {
        return leather;
    }

    public void setLeather(Boolean leather) {
        this.leather = leather;
    }

    public Boolean getAlloyWheels() {
        return alloyWheels;
    }

    public void setAlloyWheels(Boolean alloyWheels) {
        this.alloyWheels = alloyWheels;
    }

    public Boolean getFogLights() {
        return fogLights;
    }

    public void setFogLights(Boolean fogLights) {
        this.fogLights = fogLights;
    }

    public Boolean getSignaling() {
        return signaling;
    }

    public void setSignaling(Boolean signaling) {
        this.signaling = signaling;
    }
}

