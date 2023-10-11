package co.mcsky.mmoext.object;

public class SummonItem {
    private final String mobId;
    private final String itemId;
    private final SummonCondition condition;
    private final SummonEffect effect;
    private int delaySpawn;
    private int mobLevel;

    public SummonItem(String itemId, String mobId) {
        this.itemId = itemId;
        this.mobId = mobId;

        this.effect = new SummonEffect();
        this.condition = new SummonCondition();

        this.mobLevel = 1;
        this.delaySpawn = 20;
    }

    public String getMobId() {
        return mobId;
    }

    public String getItemId() {
        return itemId;
    }

    public SummonCondition getCondition() {
        return condition;
    }

    public SummonEffect getEffect() {
        return effect;
    }

    public int getDelaySpawn() {
        return delaySpawn;
    }

    public void setDelaySpawn(int delaySpawn) {
        this.delaySpawn = delaySpawn;
    }

    public int getMobLevel() {
        return mobLevel;
    }

    public void setMobLevel(int mobLevel) {
        this.mobLevel = mobLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SummonItem that = (SummonItem) o;

        return itemId.equals(that.itemId);
    }

    @Override
    public int hashCode() {
        return itemId.hashCode();
    }
}
