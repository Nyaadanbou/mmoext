package co.mcsky.mmoext.hook;

import com.palmergames.bukkit.towny.TownyAPI;
import org.bukkit.Location;

public class TownyUtils {
    /**
     * Checks if the location is in wilderness
     *
     * @param location Location
     * @return Is the location in wilderness?
     */
    public static boolean isInWilderness(Location location) {
        return TownyAPI.getInstance().isWilderness(location);
    }
}
