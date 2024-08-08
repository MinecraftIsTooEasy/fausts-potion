package huix.faustpotion.game_objects.item

import huix.faustpotion.game_objects.material.FPMaterialsKt
import huix.faustspotion.injected_interfaces.IIItemRegistryEvent
import net.minecraft.*
import net.xiaoyu233.fml.api.item.NuggetItem
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent
import net.xiaoyu233.fml.reload.utils.IdUtil

class FPItemsKt {
    companion object {
        val gold_pan_empty = GoldPanItemKt(Material.clay, null)
        val gold_pan_sand = GoldPanItemKt(Material.clay, Material.sand)
        val gold_pan_gravel = GoldPanItemKt(Material.clay, FPMaterialsKt.gravel)
        val gold_pan_clay = GoldPanItemKt(Material.clay, Material.clay)
        val gold_pan_dirt = GoldPanItemKt(Material.clay, Material.dirt)

        val bake_clay = FPClayItemKt().setXPReward(2).setCraftingDifficultyAsComponent(4.0F)
        val clay_brick = FPClayItemKt().setXPReward(0).setCraftingDifficultyAsComponent(1.0F)

        val zinc_ingot = ItemIngot(IdUtil.getNextItemID(), FPMaterialsKt.zinc).setXPReward(10)
        val zinc_nugget = NuggetItem(IdUtil.getNextItemID(), FPMaterialsKt.zinc).setXPReward(10)
        val aluminum_ingot = ItemIngot(IdUtil.getNextItemID(), FPMaterialsKt.aluminum).setXPReward(10)
        val aluminum_nugget = NuggetItem(IdUtil.getNextItemID(), FPMaterialsKt.aluminum).setXPReward(10)

        val tin_ingot = ItemIngot(IdUtil.getNextItemID(), FPMaterialsKt.tin).setXPReward(10)
        val tin_nugget = NuggetItem(IdUtil.getNextItemID(), FPMaterialsKt.tin)
        val nickel_ingot = ItemIngot(IdUtil.getNextItemID(), FPMaterialsKt.nickel).setXPReward(10)
        val nickel_nugget = NuggetItem(IdUtil.getNextItemID(), FPMaterialsKt.nickel)
        val lead_ingot = ItemIngot(IdUtil.getNextItemID(), FPMaterialsKt.lead).setXPReward(10)
        val lead_nugget = NuggetItem(IdUtil.getNextItemID(), FPMaterialsKt.lead)
        val platinum_ingot = ItemIngot(IdUtil.getNextItemID(), FPMaterialsKt.platinum).setXPReward(10)
        val platinum_nugget = NuggetItem(IdUtil.getNextItemID(), FPMaterialsKt.platinum)
        val uranium_ingot = ItemIngot(IdUtil.getNextItemID(), FPMaterialsKt.uranium).setXPReward(50)
        val uranium_nugget = NuggetItem(IdUtil.getNextItemID(), FPMaterialsKt.uranium)





        fun registerItemsForFP(registry: ItemRegistryEvent) {
            registry.register( "Faust's potion", "zinc_ingot", zinc_ingot)
            registry.register( "Faust's potion", "zinc_nugget", zinc_nugget)
            registry.register( "Faust's potion", "aluminum_ingot", aluminum_ingot)
            registry.register( "Faust's potion", "aluminum_nugget", aluminum_nugget)
            registry.register( "Faust's potion", "tin_ingot", tin_ingot)
            registry.register( "Faust's potion", "tin_nugget", tin_nugget)
            registry.register( "Faust's potion", "nickel_ingot", nickel_ingot)
            registry.register( "Faust's potion", "nickel_nugget", nickel_nugget)
            registry.register( "Faust's potion", "lead_ingot", lead_ingot)
            registry.register( "Faust's potion", "lead_nugget", lead_nugget)
            registry.register( "Faust's potion", "platinum_ingot", platinum_ingot)
            registry.register( "Faust's potion", "platinum_nugget", platinum_nugget)
            registry.register( "Faust's potion", "uranium_nugget", uranium_nugget)
            registry.register( "Faust's potion", "uranium_ingot", uranium_ingot)

            (registry as IIItemRegistryEvent).registerWithoutResource(
                "Faust's potion", "gold_pan_empty", gold_pan_empty, CreativeTabs.tabMaterials)
            (registry as IIItemRegistryEvent).registerWithoutResource(
                "Faust's potion", "gold_pan_sand", gold_pan_sand, CreativeTabs.tabMaterials)
            (registry as IIItemRegistryEvent).registerWithoutResource(
                "Faust's potion", "gold_pan_gravel", gold_pan_gravel, CreativeTabs.tabMaterials)
            (registry as IIItemRegistryEvent).registerWithoutResource(
                "Faust's potion", "gold_pan_clay", gold_pan_clay, CreativeTabs.tabMaterials)
            (registry as IIItemRegistryEvent).registerWithoutResource(
                "Faust's potion", "gold_pan_dirt", gold_pan_dirt, CreativeTabs.tabMaterials)

            registry.register( "Faust's potion", "bake_clay", bake_clay, CreativeTabs.tabMaterials)
            registry.register( "Faust's potion", "clay_brick", clay_brick, CreativeTabs.tabMaterials)

        }
    }
}