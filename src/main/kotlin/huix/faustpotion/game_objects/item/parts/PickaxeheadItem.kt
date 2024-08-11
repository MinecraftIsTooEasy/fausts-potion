package huix.faustpotion.game_objects.item.parts

import huix.faustspotion.game_objects.item.PartItem
import net.minecraft.IconRegister
import net.minecraft.Item
import net.minecraft.Material
import net.xiaoyu233.fml.reload.utils.IdUtil

class PickaxeheadItem(private val material: Material) : PartItem(material) {

    override fun registerIcons(iconRegister: IconRegister) {
        this.itemIcon = iconRegister.registerIcon("tools/pickaxe/" + material + "_pickaxe_head");
    }

}