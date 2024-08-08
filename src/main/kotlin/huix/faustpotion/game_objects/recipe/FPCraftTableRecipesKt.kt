package huix.faustpotion.game_objects.recipe

import huix.faustpotion.game_objects.block.FPBlocksKt
import huix.faustpotion.game_objects.item.FPItemsKt
import net.minecraft.Block
import net.minecraft.Item
import net.minecraft.ItemStack
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent

class FPCraftTableRecipesKt {
    companion object {
        fun registerRecipes(register: RecipeRegistryEvent) {
            register.registerShapedRecipe(
                ItemStack(FPItemsKt.gold_pan_empty, 3),
                true,
                "# #",
                " # ",
                '#', FPItemsKt.bake_clay
            )

            register.registerShapedRecipe(
                ItemStack(FPItemsKt.clay_brick, 3),
                true,
                "###",
                '#', Item.clay
            )

            val ingots = arrayOf(FPItemsKt.zinc_ingot, FPItemsKt.aluminum_ingot, FPItemsKt.tin_ingot, FPItemsKt.nickel_ingot,
                FPItemsKt.lead_ingot, FPItemsKt.platinum_ingot, FPItemsKt.uranium_ingot)
            val nuggets = arrayOf(FPItemsKt.zinc_nugget, FPItemsKt.aluminum_nugget, FPItemsKt.tin_nugget, FPItemsKt.nickel_nugget,
                FPItemsKt.lead_nugget, FPItemsKt.platinum_nugget, FPItemsKt.uranium_nugget)
            val ore_blocks = arrayOf(FPBlocksKt.zinc_block, FPBlocksKt.aluminum_block, FPBlocksKt.tin_block, FPBlocksKt.nickel_block,
                FPBlocksKt.lead_block, FPBlocksKt.platinum_block, FPBlocksKt.uranium_block)


            for(ingot in ingots) {
                for (nugget in nuggets) {
                    if (ingot.materialForDurability === nugget.materialForDurability) {
                        this.registerShapelessNineToOne(register, ItemStack(nugget), ItemStack(ingot))
                        this.registerShapelessOneToNine(register, ItemStack(ingot), nugget)
                    }
                }

                for (ore_block in ore_blocks) {
                    if (ingot.materialForDurability === ore_block.blockMaterial) {
                        this.registerShapelessNineToOne(register, ItemStack(ingot), ItemStack(ore_block))
                        this.registerShapelessOneToNine(register, ItemStack(ore_block), ingot)
                    }
                }
            }


        }

        private fun registerShapelessNineToOne(register: RecipeRegistryEvent, input: ItemStack, output: ItemStack) {
            register.registerShapelessRecipe(output,
                true,
                input, input, input,
                input, input, input,
                input, input, input)
        }

        private fun registerShapelessOneToNine(register: RecipeRegistryEvent, input: ItemStack, output: Item) {
            register.registerShapelessRecipe(
                ItemStack(output, 9),
                true,
                input);
        }

        private fun registerShapelessOneToNine(register: RecipeRegistryEvent, input: ItemStack, output: Block) {
            register.registerShapelessRecipe(
                ItemStack(output, 9),
                true,
                input);
        }


    }
}