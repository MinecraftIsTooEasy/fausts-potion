package huix.faustpotion.game_objects.recipe

import huix.faustpotion.game_objects.block.BlocksKt
import huix.faustpotion.game_objects.item.ItemsKt
import huix.faustpotion.game_objects.material.MaterialHelperKt
import net.minecraft.Block
import net.minecraft.Item
import net.minecraft.ItemStack
import net.xiaoyu233.fml.reload.event.RecipeRegistryEvent

class CraftTableRecipesKt {
    companion object {
        fun registerRecipes(register: RecipeRegistryEvent) {
            register.registerShapedRecipe(ItemStack(BlocksKt.stone_brick, 6), false,
                "ZZZ",
                "XYX",
                "ZZZ",
                'X', ItemsKt.bake_clay,
                'Y', Block.brick,
                'Z', Block.stoneBrick)
            register.registerShapedRecipe(ItemStack(BlocksKt.obsidian_brick, 6), false,
                "ZZZ",
                "XYX",
                "ZZZ",
                'X', ItemsKt.bake_clay,
                'Y', Block.brick,
                'Z', Block.obsidian)
            register.registerShapedRecipe(ItemStack(BlocksKt.netherrack_brick, 6), false,
                "ZZZ",
                "XYX",
                "ZZZ",
                'X', ItemsKt.bake_clay,
                'Y', Block.brick,
                'Z', Block.netherrack)

            register.registerShapedRecipe(ItemStack(BlocksKt.netherrack_controller_block_idle), false,
                "XYX",
                'X', BlocksKt.netherrack_brick,
                'Y', Block.furnaceNetherrackIdle)
            register.registerShapedRecipe(ItemStack(BlocksKt.obsidian_controller_block_idle), false,
                "XYX",
                'X', BlocksKt.obsidian_brick,
                'Y', Block.furnaceObsidianIdle)
            register.registerShapedRecipe(ItemStack(BlocksKt.stone_controller_block_idle), false,
                "XYX",
                'X', BlocksKt.stone_brick,
                'Y', Block.furnaceIdle)

            register.registerShapedRecipe(ItemStack(BlocksKt.netherrack_controller_core), false,
                "XYX",
                'X', BlocksKt.netherrack_brick,
                'Y', Block.hopperBlock)
            register.registerShapedRecipe(ItemStack(BlocksKt.obsidian_controller_core), false,
                "XYX",
                'X', BlocksKt.obsidian_brick,
                'Y', Block.hopperBlock)
            register.registerShapedRecipe(ItemStack(BlocksKt.stone_controller_core), false,
                "XYX",
                'X', BlocksKt.stone_brick,
                'Y', Block.hopperBlock)

            register.registerShapedRecipe(ItemStack(ItemsKt.coal_ingot, 8), true,
                "ZZZ",
                "ZXZ",
                "ZZZ",
                'X', ItemsKt.bake_clay,
                'Z', ItemStack(Item.coal, 1, 0))

            this.registerCombinedRecipe(register, ItemsKt.bronze_sword_blade, ItemsKt.bronze_sword)
            this.registerCombinedRecipe(register, ItemsKt.steel_sword_blade, ItemsKt.steel_sword)
            this.registerCombinedRecipe(register, ItemsKt.bronze_pickaxe_head, ItemsKt.bronze_pickaxe)
            this.registerCombinedRecipe(register, ItemsKt.steel_pickaxe_head, ItemsKt.steel_pickaxe)
            this.registerCombinedRecipe(register, ItemsKt.bronze_axe_head, ItemsKt.bronze_axe)
            this.registerCombinedRecipe(register, ItemsKt.steel_axe_head, ItemsKt.steel_axe)
            this.registerCombinedRecipe(register, ItemsKt.bronze_shovel_head, ItemsKt.bronze_shovel)
            this.registerCombinedRecipe(register, ItemsKt.steel_shovel_head, ItemsKt.steel_shovel)


            val sword_blades = arrayOf(ItemsKt.bronze_sword_blade, ItemsKt.steel_sword_blade)
            val pickaxe_heads = arrayOf(ItemsKt.bronze_pickaxe_head, ItemsKt.steel_pickaxe_head)
            val axe_heads = arrayOf(ItemsKt.bronze_axe_head, ItemsKt.steel_axe_head)
            val shovel_heads = arrayOf(ItemsKt.bronze_shovel_head, ItemsKt.steel_shovel_head)

            for (sword in sword_blades) {
                register.registerShapedRecipe(ItemStack(sword), false,
                    "#",
                    "#",
                    '#', MaterialHelperKt.getIngotByMaterial(sword.materialForRepairs))
            }
            for (pickaxe in pickaxe_heads) {
                register.registerShapedRecipe(ItemStack(pickaxe), false,
                    "###",
                    '#', MaterialHelperKt.getIngotByMaterial(pickaxe.materialForRepairs))
            }
            for (axe in axe_heads) {
                register.registerShapedRecipe(ItemStack(axe), false,
                    "##",
                    " #",
                    '#', MaterialHelperKt.getIngotByMaterial(axe.materialForRepairs))
            }
            for (shovel in shovel_heads) {
                register.registerShapedRecipe(ItemStack(shovel), false,
                    "#",
                    '#', MaterialHelperKt.getIngotByMaterial(shovel.materialForRepairs))
            }

            register.registerShapedRecipe(ItemStack(ItemsKt.gold_pan_empty, 3),
                true,
                "# #",
                " # ",
                '#', ItemsKt.bake_clay)

            register.registerShapedRecipe(ItemStack(ItemsKt.clay_brick, 3),
                true,
                "###",
                '#', Item.clay)

            val ingots = arrayOf(ItemsKt.zinc_ingot, ItemsKt.aluminum_ingot, ItemsKt.tin_ingot, ItemsKt.nickel_ingot,
                ItemsKt.lead_ingot, ItemsKt.platinum_ingot, ItemsKt.uranium_ingot)
            val nuggets = arrayOf(ItemsKt.zinc_nugget, ItemsKt.aluminum_nugget, ItemsKt.tin_nugget, ItemsKt.nickel_nugget,
                ItemsKt.lead_nugget, ItemsKt.platinum_nugget, ItemsKt.uranium_nugget)
            val ore_blocks = arrayOf(BlocksKt.zinc_block, BlocksKt.aluminum_block, BlocksKt.tin_block, BlocksKt.nickel_block,
                BlocksKt.lead_block, BlocksKt.platinum_block, BlocksKt.uranium_block)


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
        private fun registerCombinedRecipe(register: RecipeRegistryEvent, input: Item, output: Item) {
            register.registerShapedRecipe(ItemStack(output),
                true,
                "X",
                "Y",
                'X', input, 'Y', Item.stick)
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