package trappistone.core.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;

import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;

import cpw.mods.fml.common.FMLLog;
import micdoodle8.mods.galacticraft.core.Constants;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class TPBiomeConfig {
	public static boolean loaded;
	private static Configuration config;
	
	public static void initalize(File file) {
		TPBiomeConfig.config = new Configuration(file);
		TPBiomeConfig.syncConfig(true);
	}
	
	public static int biomeIDSpace;
	
	private static void syncConfig(boolean load) {
		List<String> propOrder = new ArrayList<String>();
		try {
			Property prop = null;
			if(!config.isChild) {
				if(load) {
					config.load();
				}
			}
			
			biomeIDSpace = getIntegerConfigNode(config, prop, propOrder, Constants.CONFIG_CATEGORY_DIMENSIONS, "biomeIDSpace", "Biome ID for Space.", 100);
			
			config.setCategoryPropertyOrder(CATEGORY_GENERAL, propOrder);

            if (config.hasChanged())
            {
                config.save();
            }
		}catch (final Exception ex) {
			FMLLog.log(Level.ERROR, ex, "Trappist-1 has a problem loading it's config, this can have negative repercussions.");
		}
	}
	
	public static int getIntegerConfigNode(Configuration conf, Property prop, List<String> propOrder, String category, String key, String discription, int defaultInt) {
		int out;
		prop = conf.get(category, key, defaultInt);
		prop.comment = discription;
		prop.setLanguageKey("gc.configgui.dimensionIDMars").setRequiresMcRestart(true);
		out = prop.getInt();
		propOrder.add(prop.getName());
		return out;
	}
}
