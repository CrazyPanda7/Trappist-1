package trappistone.core.registers.items;

import trappistone.Core;
import micdoodle8.mods.galacticraft.core.Constants;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.common.registry.GameRegistry;

public class TPItems {
	
	public static Item itemAlienGel;

	public static void initialize()
    {
		itemAlienGel = new ItemFood(12, 1.0F, true).setTextureName(Core.ASSET_PREFIX + ":" + "alienGel");		
		
		registerItems();
    	oreDictRegistration();
    }
	
	private static void registerItems()
    {
		registerItem(itemAlienGel);
    }
	
	// -------------------------------------------------------------------------------------
	public static void registerItem(Item item)
    {
		GameRegistry.registerItem(item, item.getUnlocalizedName());
    }
	
	public static void oreDictRegistration()
    {
		// OreDictionary.registerOre("ingotLead", new ItemStack(GSItems.Ingots, 1, 3));
    }
	// -------------------------------------------------------------------------------------
	
}
