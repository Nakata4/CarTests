package entities;

public class Engine {
    private int id;
    private int volume;
    private Integer hp;
    private Integer nm;
    private EngineType engineType;

    public Engine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getNm() {
        return nm;
    }

    public void setNm(Integer nm) {
        this.nm = nm;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", volume=" + volume +
                ", hp=" + hp +
                ", nm=" + nm +
                ", engineType=" + engineType +
                '}';
    }
}
