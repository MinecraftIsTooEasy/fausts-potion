package huix.faustpotion.game_objects.material

import huix.faustpotion.game_objects.block.BlocksKt
import huix.faustpotion.game_objects.item.ItemsKt
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
                MaterialsKt.uranium -> ItemsKt.uranium_nugget
                MaterialsKt.platinum -> ItemsKt.platinum_nugget
                MaterialsKt.lead -> ItemsKt.lead_nugget
                MaterialsKt.nickel -> ItemsKt.nickel_nugget
                MaterialsKt.tin -> ItemsKt.tin_nugget
                MaterialsKt.aluminum -> ItemsKt.aluminum_nugget
                MaterialsKt.zinc -> ItemsKt.zinc_nugget
                else -> ItemStack(1).item
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
                MaterialsKt.uranium -> ItemsKt.uranium_ingot
                MaterialsKt.platinum -> ItemsKt.platinum_ingot
                MaterialsKt.lead -> ItemsKt.lead_ingot
                MaterialsKt.nickel -> ItemsKt.nickel_ingot
                MaterialsKt.tin -> ItemsKt.tin_ingot
                MaterialsKt.aluminum -> ItemsKt.aluminum_ingot
                MaterialsKt.zinc -> ItemsKt.zinc_ingot

                Material.coal -> ItemsKt.coal_ingot
                MaterialsKt.bronze -> ItemsKt.bronze_ingot
                MaterialsKt.steel -> ItemsKt.steel_ingot
                else -> ItemStack(1).item
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
                MaterialsKt.uranium -> BlocksKt.uranium_block
                MaterialsKt.platinum -> BlocksKt.platinum_block
                MaterialsKt.lead -> BlocksKt.lead_block
                MaterialsKt.nickel -> BlocksKt.nickel_block
                MaterialsKt.tin -> BlocksKt.tin_block
                MaterialsKt.aluminum -> BlocksKt.aluminum_block
                MaterialsKt.zinc -> BlocksKt.zinc_block
                else -> ItemStack(1).itemAsBlock.block
            }
        }
    }

}