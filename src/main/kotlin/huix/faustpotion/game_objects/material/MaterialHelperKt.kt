package huix.faustpotion.game_objects.material

import huix.faustpotion.game_objects.block.FPBlocksKt
import huix.faustpotion.game_objects.item.FPItemsKt
import net.minecraft.Block
import net.minecraft.Item
import net.minecraft.ItemStack
import net.minecraft.Material

class MaterialHelperKt {

    companion object {
        fun getNuggetByMaterial(material: Material): Item {
            return when(material) {
                Material.copper -> Item.copperNugget
                Material.silver -> Item.silverNugget
                Material.iron -> Item.ironNugget
                Material.ancient_metal -> Item.ancientMetalNugget
                Material.gold -> Item.goldNugget
                Material.mithril -> Item.mithrilNugget
                Material.adamantium -> Item.adamantiumNugget
                FPMaterialsKt.uranium -> FPItemsKt.uranium_nugget
                FPMaterialsKt.platinum -> FPItemsKt.platinum_nugget
                FPMaterialsKt.lead -> FPItemsKt.lead_nugget
                FPMaterialsKt.nickel -> FPItemsKt.nickel_nugget
                FPMaterialsKt.tin -> FPItemsKt.tin_nugget
                FPMaterialsKt.aluminum -> FPItemsKt.aluminum_nugget
                FPMaterialsKt.zinc -> FPItemsKt.zinc_nugget
                else -> ItemStack(0).item
            }
        }

        fun getIngotByMaterial(material: Material): Item {
            return when(material) {
                Material.copper -> Item.ingotCopper
                Material.silver -> Item.ingotSilver
                Material.iron -> Item.ingotIron
                Material.ancient_metal -> Item.ingotAncientMetal
                Material.gold -> Item.ingotGold
                Material.mithril -> Item.ingotMithril
                Material.adamantium -> Item.ingotAdamantium
                FPMaterialsKt.uranium -> FPItemsKt.uranium_ingot
                FPMaterialsKt.platinum -> FPItemsKt.platinum_ingot
                FPMaterialsKt.lead -> FPItemsKt.lead_ingot
                FPMaterialsKt.nickel -> FPItemsKt.nickel_ingot
                FPMaterialsKt.tin -> FPItemsKt.tin_ingot
                FPMaterialsKt.aluminum -> FPItemsKt.aluminum_ingot
                FPMaterialsKt.zinc -> FPItemsKt.zinc_ingot
                else -> ItemStack(0).item
            }
        }

        fun getBlockByMaterial(material: Material): Block {
            return when(material) {
                Material.copper -> Block.blockCopper
                Material.silver -> Block.blockSilver
                Material.iron -> Block.blockIron
                Material.ancient_metal -> Block.blockAncientMetal
                Material.gold -> Block.blockGold
                Material.mithril -> Block.blockMithril
                Material.adamantium -> Block.blockAdamantium
                FPMaterialsKt.uranium -> FPBlocksKt.uranium_block
                FPMaterialsKt.platinum -> FPBlocksKt.platinum_block
                FPMaterialsKt.lead -> FPBlocksKt.lead_block
                FPMaterialsKt.nickel -> FPBlocksKt.nickel_block
                FPMaterialsKt.tin -> FPBlocksKt.tin_block
                FPMaterialsKt.aluminum -> FPBlocksKt.aluminum_block
                FPMaterialsKt.zinc -> FPBlocksKt.zinc_block
                else -> ItemStack(0).itemAsBlock.block
            }
        }
    }

}