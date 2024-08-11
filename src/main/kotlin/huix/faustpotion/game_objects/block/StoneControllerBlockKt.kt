package huix.faustpotion.game_objects.block

import huix.faustspotion.game_objects.block.ControllerBlock
import net.minecraft.Block
import net.minecraft.IconRegister
import net.minecraft.Material

class StoneControllerBlockKt(id:Int, isActive: Boolean) : ControllerBlock(id, Material.stone, isActive) {

    override fun registerIcons(iconRegister: IconRegister) {
        this.blockIcon = iconRegister.registerIcon("controller/stone/side");
        this.iconFront = iconRegister.registerIcon(if (this.isActive) "controller/stone/front_on" else "controller/stone/front_off");
    }

    override fun getMaxTemperature(): Int {
        return 801;
    }

    override fun getIdleBlockID(): Int {
        return BlocksKt.stone_controller_block_idle.blockID
    }

    override fun getActiveBlockID(): Int {
        return BlocksKt.stone_controller_block.blockID
    }

    override fun getBrickBlock(): Block {
        return BlocksKt.stone_brick
    }

    override fun getCoreBlock(): Block {
        return BlocksKt.stone_controller_core
    }

}