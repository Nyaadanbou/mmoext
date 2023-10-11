package co.mcsky.mmoext.object;

import co.mcsky.mmoext.config.ExplosionEffectConfig;
import co.mcsky.mmoext.config.PotionEffectConfig;
import co.mcsky.mmoext.config.SoundEffectConfig;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SummonEffect {

    private ExplosionEffectConfig explosion;
    private final Set<SoundEffectConfig> sounds;
    private final Set<PotionEffectConfig> potions;

    public SummonEffect() {
        this.explosion = null;
        this.sounds = new HashSet<>();
        this.potions = new HashSet<>();
    }

    public Optional<ExplosionEffectConfig> getExplosion() {
        return Optional.ofNullable(explosion);
    }

    public void setExplosion(ExplosionEffectConfig explosion) {
        this.explosion = explosion;
    }

    public Set<SoundEffectConfig> getSounds() {
        return sounds;
    }

    public void addSound(SoundEffectConfig sound) {
        sounds.add(sound);
    }

    public Set<PotionEffectConfig> getPotions() {
        return potions;
    }

    public void addPotion(PotionEffectConfig effect) {
        potions.add(effect);
    }

}
