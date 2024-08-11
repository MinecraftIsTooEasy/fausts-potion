package huix.faustpotion.event

import com.google.common.eventbus.Subscribe
import huix.faustpotion.game_objects.block.BlocksKt
import huix.faustpotion.game_objects.item.ItemsKt
import huix.faustpotion.game_objects.recipe.CraftTableRecipesKt
import huix.faustpotion.game_objects.recipe.FurnaceRecipesKt

import net.xiaoyu233.fml.reload.event.ItemRegistryEvent
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent

class FaustPotionEvents {

    @Subscribe
    fun onRecipeRegister(event: RecipeRegistryEvent) {
        FurnaceRecipesKt.registerRecipes()
        CraftTableRecipesKt.registerRecipes(event)
    }

    @Subscribe
    fun onItemRegister(event: ItemRegistryEvent) {
        ItemsKt.registerItemsForFP(event)
        BlocksKt.registerBlocksForFP(event)
    }


}