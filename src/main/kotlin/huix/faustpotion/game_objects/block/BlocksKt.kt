package huix.faustpotion.game_objects.block

import huix.faustpotion.game_objects.material.MaterialsKt
import huix.faustspotion.game_objects.block.CookingPotBlock
import huix.faustspotion.injected_interfaces.IIItemRegistryEvent
import net.minecraft.*
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent
import net.xiaoyu233.fml.reload.utils.IdUtil

class BlocksKt {

    companion object {
        val obsidian_brick = BrickBlockKt(8.0F)
        val netherrack_brick = BrickBlockKt(10.0F)
        val stone_brick = BrickBlockKt(10.0F)

        val obsidian_controller_block = ObsidianControllerBlockKt(180,true)
        val netherrack_controller_block = NetherrackControllerBlockKt(181, true)
        val obsidian_controller_block_idle = ObsidianControllerBlockKt(182, false).setCreativeTab(CreativeTabs.tabDecorations)
        val netherrack_controller_block_idle = NetherrackControllerBlockKt(183, false).setCreativeTab(CreativeTabs.tabDecorations)

        val stone_controller_block = StoneControllerBlockKt(184, true)
        val stone_controller_block_idle = StoneControllerBlockKt(185, false).setCreativeTab(CreativeTabs.tabDecorations)


        val obsidian_controller_core = BrickBlockKt(8.0F)
        val netherrack_controller_core = BrickBlockKt(10.0F)
        val stone_controller_core = BrickBlockKt(10.0F)

        //活泼金属
        //Zn
        val zinc_ore = BlockOre(IdUtil.getNextBlockID(), MaterialsKt.zinc, 1)
        val zinc_block = BlockOreStorage(IdUtil.getNextBlockID(), MaterialsKt.zinc)
        //Al
        //铝土
        val bauxite_ore = BlockOre(IdUtil.getNextBlockID(), MaterialsKt.aluminum, 1)
        val aluminum_block = BlockOreStorage(IdUtil.getNextBlockID(), MaterialsKt.aluminum)

        //ore
        //锡矿
        val tin_ore = BlockOre(IdUtil.getNextBlockID(), MaterialsKt.tin, 1)
        val tin_block = BlockOreStorage(IdUtil.getNextBlockID(), MaterialsKt.tin)
        //镍矿
        val nickel_ore = BlockOre(IdUtil.getNextBlockID(), MaterialsKt.nickel, 1)
        val nickel_block = BlockOreStorage(IdUtil.getNextBlockID(), MaterialsKt.nickel)
        //铅矿
        val lead_ore = BlockOre(IdUtil.getNextBlockID(), MaterialsKt.lead, 1)
        val lead_block = BlockOreStorage(IdUtil.getNextBlockID(), MaterialsKt.lead)
        //铂矿
        val platinum_ore = BlockOre(IdUtil.getNextBlockID(), MaterialsKt.platinum, 1)
        val platinum_block = BlockOreStorage(IdUtil.getNextBlockID(), MaterialsKt.platinum)
        //铀矿
        val uranium_ore = BlockOre(IdUtil.getNextBlockID(), MaterialsKt.uranium, 3)
        val uranium_block = BlockOreStorage(IdUtil.getNextBlockID(), MaterialsKt.uranium)

        val cooking_pot = CookingPotBlock()




        fun registerBlocksForFP(registry: ItemRegistryEvent){
            (registry as IIItemRegistryEvent).registerItemBlockWithoutResource("Faust's potion", "cooking_pot", cooking_pot)

            registry.registerItemBlock("Faust's potion", "zinc_ore", zinc_ore)
            registry.registerItemBlock("Faust's potion", "zinc_block", zinc_block)
            registry.registerItemBlock("Faust's potion", "bauxite_ore", bauxite_ore)
            registry.registerItemBlock("Faust's potion", "aluminum_block", aluminum_block)
            registry.registerItemBlock("Faust's potion", "tin_ore", tin_ore)
            registry.registerItemBlock("Faust's potion", "tin_block", tin_block)
            registry.registerItemBlock("Faust's potion", "nickel_ore", nickel_ore)
            registry.registerItemBlock("Faust's potion", "nickel_block", nickel_block)
            registry.registerItemBlock("Faust's potion", "lead_ore", lead_ore)
            registry.registerItemBlock("Faust's potion", "lead_block", lead_block)
            registry.registerItemBlock("Faust's potion", "platinum_ore", platinum_ore)
            registry.registerItemBlock("Faust's potion", "platinum_block", platinum_block)
            registry.registerItemBlock("Faust's potion", "uranium_ore", uranium_ore)
            registry.registerItemBlock("Faust's potion", "uranium_block", uranium_block)

            (registry as IIItemRegistryEvent).registerItemBlockWithCraftingDifficulty("Faust's potion", "obsidian_brick", obsidian_brick, 5.0F)
            (registry as IIItemRegistryEvent).registerItemBlockWithCraftingDifficulty("Faust's potion", "netherrack_brick", netherrack_brick, 5.0F)
            (registry as IIItemRegistryEvent).registerItemBlockWithCraftingDifficulty("Faust's potion", "stone_brick", stone_brick, 5.0F)
            registry.registerItemBlock("Faust's potion", "obsidian_controller_block", obsidian_controller_block)
            registry.registerItemBlock("Faust's potion", "netherrack_controller_block", netherrack_controller_block)
            registry.registerItemBlock("Faust's potion", "stone_controller_block", stone_controller_block)
            (registry as IIItemRegistryEvent).registerItemBlockWithCraftingDifficulty("Faust's potion", "obsidian_controller_block_idle", obsidian_controller_block_idle, 10.0F)
            (registry as IIItemRegistryEvent).registerItemBlockWithCraftingDifficulty("Faust's potion", "netherrack_controller_block_idle", netherrack_controller_block_idle, 10.0F)
            (registry as IIItemRegistryEvent).registerItemBlockWithCraftingDifficulty("Faust's potion", "stone_controller_block_idle", stone_controller_block_idle, 10.0F)
            (registry as IIItemRegistryEvent).registerItemBlockWithCraftingDifficulty("Faust's potion", "obsidian_controller_core", obsidian_controller_core, 10.0F)
            (registry as IIItemRegistryEvent).registerItemBlockWithCraftingDifficulty("Faust's potion", "netherrack_controller_core", netherrack_controller_core, 10.0F)
            (registry as IIItemRegistryEvent).registerItemBlockWithCraftingDifficulty("Faust's potion", "stone_controller_core", stone_controller_core, 10.0F)
        }
    }
}