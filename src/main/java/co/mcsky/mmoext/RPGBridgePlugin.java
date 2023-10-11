package co.mcsky.mmoext;

import cc.mewcraft.spatula.message.Translations;
import co.mcsky.mmoext.listener.SummonListener;
import me.lucko.helper.plugin.ExtendedJavaPlugin;

public class RPGBridgePlugin extends ExtendedJavaPlugin {

    private static RPGBridgePlugin INSTANCE;

    private PluginSettings settings;
    private PluginCommands commands;
    private Translations translations;

    public static PluginSettings settings() {
        return INSTANCE.settings;
    }

    public void reloadSettings() {
        settings.loadDefaultConfig();
        settings.loadSummonItems();
        translations = new Translations(this);
    }

    @Override protected void enable() {
        INSTANCE = this;

        if (isPluginPresent("MythicMobs") && isPluginPresent("ItemsAdder")) {
            registerListener(new SummonListener(this, settings, translations));
        } else {
            getSLF4JLogger().error("MythicMobs / ItemsAdder are not present in this server. This plugin will effectively not work!");
            return;
        }

        commands = new PluginCommands(this, translations);
        commands.register();

        settings = new PluginSettings(this, getSLF4JLogger());
        translations = new Translations(this, "lang");
    }

}
