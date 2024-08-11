package huix.faustpotion.game_objects.recipe

import huix.faustpotion.game_objects.block.BlocksKt
import huix.faustpotion.game_objects.item.ItemsKt
import net.minecraft.FurnaceRecipes
import net.minecraft.Item
import net.minecraft.ItemStack

class FurnaceRecipesKt {

    companion object {
        fun registerRecipes() {
            registerFPFRecipes(Item.clay.itemID, ItemStack(ItemsKt.bake_clay))
            registerFPFRecipes(ItemsKt.clay_brick.itemID, ItemStack(Item.brick))

            registerFPFRecipes(BlocksKt.tin_ore.blockID, ItemStack(ItemsKt.tin_ingot))
            registerFPFRecipes(BlocksKt.nickel_ore.blockID, ItemStack(ItemsKt.nickel_ingot))
            registerFPFRecipes(BlocksKt.lead_ore.blockID, ItemStack(ItemsKt.lead_ingot))
            registerFPFRecipes(BlocksKt.platinum_ore.blockID, ItemStack(ItemsKt.platinum_ingot))
            registerFPFRecipes(BlocksKt.uranium_ore.blockID, ItemStack(ItemsKt.uranium_ingot))
        }


        private fun registerFPFRecipes(input_id: Int, output_itemstack: ItemStack) {
            FurnaceRecipes.smelting().addSmelting(input_id, output_itemstack)
        }
    }
}