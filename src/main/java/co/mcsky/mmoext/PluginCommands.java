package co.mcsky.mmoext;

import cc.mewcraft.spatula.message.Translations;
import me.lucko.helper.Commands;
import org.bukkit.command.ConsoleCommandSender;

import java.util.Locale;

public class PluginCommands {

    private final RPGBridgePlugin plugin;
    private final Translations translations;

    public PluginCommands(
            final RPGBridgePlugin plugin,
            final Translations translations
    ) {
        this.plugin = plugin;
        this.translations = translations;
    }

    public void register() {
        Commands.create()
                .assertConsole()
                .handler(context -> {
                    context.arg(0).assertPresent();
                    String parse = context.arg(0).parseOrFail(String.class).toLowerCase(Locale.ROOT);
                    ConsoleCommandSender sender = context.sender();
                    if (parse.equals("reload")) {
                        plugin.reloadSettings();
                        translations.of("msg_reloaded_config").replace("plugin", plugin.getPluginMeta().getName()).send(sender);
                    }
                })
                .registerAndBind(plugin, "mmoext");
    }

}
