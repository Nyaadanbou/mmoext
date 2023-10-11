package co.mcsky.mmoext;

import co.mcsky.mmoext.config.SummonItemLoader;
import co.mcsky.mmoext.object.SummonItem;
import org.bukkit.plugin.Plugin;
import org.slf4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class PluginSettings {

    private final Plugin plugin;
    private final Logger logger;

    private final Map<String, SummonItem> summonItemMap;
    private final Set<String> summonMobIds;

    public PluginSettings(final Plugin plugin, final Logger logger) {
        this.plugin = plugin;
        this.logger = logger;
        this.summonItemMap = new HashMap<>();
        this.summonMobIds = new HashSet<>();
        this.loadDefaultConfig();
    }

    public void loadDefaultConfig() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
    }

    public void loadSummonItems() {
        // Put map
        summonItemMap.clear();
        Set<SummonItem> itemSet = new SummonItemLoader(plugin, logger).readAll();
        itemSet.forEach(i -> summonItemMap.put(i.getItemId(), i));

        // Put set
        summonMobIds.clear();
        summonItemMap.forEach((k, v) -> summonMobIds.add(v.getMobId()));
    }

    public boolean getDebug() {
        return plugin.getConfig().getBoolean("debug");
    }

    public Set<String> getSummonMobIds() {
        return summonMobIds;
    }

    public Collection<SummonItem> getSummonItems() {
        return summonItemMap.values();
    }

    public Optional<SummonItem> getSummonItem(String itemId) {
        return Optional.ofNullable(summonItemMap.get(itemId));
    }

    public String getDamageFormat() {
        return plugin.getConfig().getString("damage.format");
    }

}
