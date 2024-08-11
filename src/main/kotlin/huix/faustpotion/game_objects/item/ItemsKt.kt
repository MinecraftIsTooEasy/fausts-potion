package huix.faustpotion.game_objects.item

import huix.faustpotion.game_objects.item.parts.AxeheadItem
import huix.faustpotion.game_objects.item.parts.PickaxeheadItem
import huix.faustpotion.game_objects.item.parts.ShovelheadItem
import huix.faustpotion.game_objects.item.parts.SwordbladeItem
import huix.faustpotion.game_objects.material.MaterialsKt
import huix.faustspotion.game_objects.item.AlloyIngotItem
import huix.faustspotion.game_objects.item.tools.CombinedAxe
import huix.faustspotion.game_objects.item.tools.CombinedPickaxe
import huix.faustspotion.game_objects.item.tools.CombinedShovel
import huix.faustspotion.game_objects.item.tools.CombinedSword
import huix.faustspotion.injected_interfaces.IIItemRegistryEvent
import net.minecraft.*
import net.xiaoyu233.fml.api.item.NuggetItem
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent
import net.xiaoyu233.fml.reload.utils.IdUtil

class ItemsKt {
    companion object {
        val gold_pan_empty = GoldPanItemKt(Material.clay, null)
        val gold_pan_sand = GoldPanItemKt(Material.clay, Material.sand)
        val gold_pan_gravel = GoldPanItemKt(Material.clay, MaterialsKt.gravel)
        val gold_pan_clay = GoldPanItemKt(Material.clay, Material.clay)
        val gold_pan_dirt = GoldPanItemKt(Material.clay, Material.dirt)

        val bake_clay = ClayItemKt().setXPReward(2).setCraftingDifficultyAsComponent(4.0F)
        val clay_brick = ClayItemKt().setXPReward(0).setCraftingDifficultyAsComponent(1.0F)

        val zinc_ingot = ItemIngot(IdUtil.getNextItemID(), MaterialsKt.zinc).setXPReward(10)
        val zinc_nugget = NuggetItem(IdUtil.getNextItemID(), MaterialsKt.zinc)
        val aluminum_ingot = ItemIngot(IdUtil.getNextItemID(), MaterialsKt.aluminum).setXPReward(10)
        val aluminum_nugget = NuggetItem(IdUtil.getNextItemID(), MaterialsKt.aluminum)

        val tin_ingot = ItemIngot(IdUtil.getNextItemID(), MaterialsKt.tin).setXPReward(10)
        val tin_nugget = NuggetItem(IdUtil.getNextItemID(), MaterialsKt.tin)
        val nickel_ingot = ItemIngot(IdUtil.getNextItemID(), MaterialsKt.nickel).setXPReward(10)
        val nickel_nugget = NuggetItem(IdUtil.getNextItemID(), MaterialsKt.nickel)
        val lead_ingot = ItemIngot(IdUtil.getNextItemID(), MaterialsKt.lead).setXPReward(10)
        val lead_nugget = NuggetItem(IdUtil.getNextItemID(), MaterialsKt.lead)
        val platinum_ingot = ItemIngot(IdUtil.getNextItemID(), MaterialsKt.platinum).setXPReward(10)
        val platinum_nugget = NuggetItem(IdUtil.getNextItemID(), MaterialsKt.platinum)
        val uranium_ingot = ItemIngot(IdUtil.getNextItemID(), MaterialsKt.uranium).setXPReward(50)
        val uranium_nugget = NuggetItem(IdUtil.getNextItemID(), MaterialsKt.uranium)

        val scrap = Item(IdUtil.getNextItemID(), Material.clay, "").setCreativeTab(CreativeTabs.tabFood)


        val bronze_ingot = AlloyIngotItem(MaterialsKt.bronze)
        val pig_iron_ingot = AlloyIngotItem(MaterialsKt.pig_iron)
        val steel_ingot = AlloyIngotItem(MaterialsKt.steel)

        val bronze_sword = CombinedSword(MaterialsKt.bronze, "bronze", "wood")
        val bronze_sword_blade = SwordbladeItem(MaterialsKt.bronze)
        val bronze_pickaxe = CombinedPickaxe(MaterialsKt.bronze, "bronze", "wood")
        val bronze_pickaxe_head = PickaxeheadItem(MaterialsKt.bronze)
        val bronze_axe = CombinedAxe(MaterialsKt.bronze, "bronze", "wood")
        val bronze_axe_head = AxeheadItem(MaterialsKt.bronze)
        val bronze_shovel = CombinedShovel(MaterialsKt.bronze, "bronze", "wood")
        val bronze_shovel_head = ShovelheadItem(MaterialsKt.bronze)

        val steel_sword = CombinedSword(MaterialsKt.steel, "steel", "wood")
        val steel_sword_blade = SwordbladeItem(MaterialsKt.steel)
        val steel_pickaxe = CombinedPickaxe(MaterialsKt.steel, "steel", "wood")
        val steel_pickaxe_head = PickaxeheadItem(MaterialsKt.steel)
        val steel_axe = CombinedAxe(MaterialsKt.steel, "steel", "wood")
        val steel_axe_head = AxeheadItem(MaterialsKt.steel)
        val steel_shovel = CombinedShovel(MaterialsKt.steel, "steel", "wood")
        val steel_shovel_head = ShovelheadItem(MaterialsKt.steel)



        val coal_ingot = ItemIngot(IdUtil.getNextItemID(), Material.coal)



        fun registerItemsForFP(registry: ItemRegistryEvent) {
            registry.register( "Faust's potion", "coal_brick", coal_ingot)

            registry.register( "Faust's potion", "bronze_sword", bronze_sword)
            registry.register( "Faust's potion", "bronze_sword_blade", bronze_sword_blade)
            registry.register( "Faust's potion", "bronze_pickaxe", bronze_pickaxe)
            registry.register( "Faust's potion", "bronze_pickaxe_head", bronze_pickaxe_head)
            registry.register( "Faust's potion", "bronze_axe", bronze_axe)
            registry.register( "Faust's potion", "bronze_axe_head", bronze_axe_head)
            registry.register( "Faust's potion", "bronze_shovel", bronze_shovel)
            registry.register( "Faust's potion", "bronze_shovel_head", bronze_shovel_head)

            registry.register( "Faust's potion", "steel_sword", steel_sword)
            registry.register( "Faust's potion", "steel_sword_blade", steel_sword_blade)
            registry.register( "Faust's potion", "steel_pickaxe", steel_pickaxe)
            registry.register( "Faust's potion", "steel_pickaxe_head", steel_pickaxe_head)
            registry.register( "Faust's potion", "steel_axe", steel_axe)
            registry.register( "Faust's potion", "steel_axe_head", steel_axe_head)
            registry.register( "Faust's potion", "steel_shovel", steel_shovel)
            registry.register( "Faust's potion", "steel_shovel_head", steel_shovel_head)

            registry.register( "Faust's potion", "bronze_ingot", bronze_ingot)
            registry.register( "Faust's potion", "pig_iron_ingot", pig_iron_ingot)
            registry.register( "Faust's potion", "steel_ingot", steel_ingot)


            registry.register( "Faust's potion", "scrap", scrap)
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