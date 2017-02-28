package trappistone;

import micdoodle8.mods.galacticraft.core.util.CreativeTabGC;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Level;

import trappistone.TrappistSystem.TrappistOnePlanets;
import trappistone.core.proxy.CommonProxy;
import trappistone.core.registers.blocks.TPBlocks;
import trappistone.core.registers.items.TPItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.relauncher.FMLRelaunchLog;

@Mod(modid = Core.MODID, version = Core.VERSION, dependencies = "required-after:GalacticraftCore; required-after:GalacticraftMars;", name = Core.NAME)
public class Core

{

	public static final int major_version = 0;
	public static final int minor_version = 0;
	public static final int build_version = 1;

	public static final String MODID = "TrappistSystem";
	public static final String VERSION = "0.0.1";
	public static final String NAME = "TrappistSystem";
	public static final String ASSET_PREFIX = "trappistone";

	public static boolean debug = false;
	// ---------------------------------------------

	@Instance("Core")
	public static Core instance;

	@SidedProxy(clientSide = "trappistone.core.proxy.ClientProxy", serverSide = "trappistone.core.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		TPBlocks.initialize();
		TPItems.initialize();
		proxy.preload();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.load();
		this.registerEntities();
		// TODO Register Planets: -------------------------------

		TrappistOnePlanets.init();

		TPCreativeTabs.TPBlocksTab = new CreativeTabGC(CreativeTabs.getNextID(), "TPBlocks", Item.getItemFromBlock(Blocks.grass), 0);
		TPCreativeTabs.TPItemsTab = new CreativeTabGC(CreativeTabs.getNextID(), "TPItems", TPItems.itemAlienGel, 0);
		TPCreativeTabs.TPArmorTab = new CreativeTabGC(CreativeTabs.getNextID(), "TPArmor", Items.diamond_helmet, 0);

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		proxy.postload();
	}

	@EventHandler
	public void serverInit(FMLServerStartedEvent event) {
		ThreadVersionCheck.startCheck();
	}

	private void registerEntities() {
		this.registerCreatures();
		this.registerNonMobEntities();
		this.registerTileEntities();
		this.registerRecipesWorkBench();
	}

	public void registerCreatures() {
	}

	private void registerNonMobEntities() {
	}

	private void registerTileEntities() {
	}

	private void registerRecipesWorkBench() {
	}

	public static void info(String message) {
		FMLRelaunchLog.log("TrappistSystem", Level.INFO, message);
	}

	public static void severe(String message) {
		FMLRelaunchLog.log("TrappistSystem", Level.ERROR, message);
	}

}
