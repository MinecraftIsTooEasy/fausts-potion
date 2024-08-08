package huix.faustpotion.game_objects.recipe

import huix.faustpotion.game_objects.block.FPBlocksKt
import huix.faustpotion.game_objects.item.FPItemsKt
import net.minecraft.FurnaceRecipes
import net.minecraft.Item
import net.minecraft.ItemStack

class FPFurnaceRecipesKt {

    companion object {
        fun registerRecipes() {
            registerFPFRecipes(Item.clay.itemID, ItemStack(FPItemsKt.bake_clay))
            registerFPFRecipes(FPItemsKt.clay_brick.itemID, ItemStack(Item.brick))

            registerFPFRecipes(FPBlocksKt.tin_ore.blockID, ItemStack(FPItemsKt.tin_ingot))
            registerFPFRecipes(FPBlocksKt.nickel_ore.blockID, ItemStack(FPItemsKt.nickel_ingot))
            registerFPFRecipes(FPBlocksKt.lead_ore.blockID, ItemStack(FPItemsKt.lead_ingot))
            registerFPFRecipes(FPBlocksKt.platinum_ore.blockID, ItemStack(FPItemsKt.platinum_ingot))
            registerFPFRecipes(FPBlocksKt.uranium_ore.blockID, ItemStack(FPItemsKt.uranium_ingot))
        }


        private fun registerFPFRecipes(input_id: Int, output_itemstack: ItemStack) {
            FurnaceRecipes.smelting().addSmelting(input_id, output_itemstack)
        }
    }
}