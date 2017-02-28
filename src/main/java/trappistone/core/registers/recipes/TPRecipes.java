package trappistone.core.registers.recipes;

import trappistone.core.registers.items.TPItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class TPRecipes {

	public static void initialize()
    {
		GameRegistry.addRecipe(new ItemStack(TPItems.itemAlienGel), new Object[]{"SSS", "GCG", "DDD", 'S', Blocks.sand, 'G', Blocks.gravel, 'C', Blocks.cactus, 'D', Blocks.dirt});
    }
}
