package huix.faustpotion.game_objects.block

import huix.faustspotion.game_objects.block.ControllerBlock
import net.minecraft.Block
import net.minecraft.IconRegister
import net.minecraft.Material

class NetherrackControllerBlockKt(id:Int, isActive: Boolean) : ControllerBlock(id, Material.netherrack, isActive) {

    override fun registerIcons(iconRegister: IconRegister) {
        this.blockIcon = iconRegister.registerIcon("controller/netherrack/side");
        this.iconFront = iconRegister.registerIcon(if (this.isActive) "controller/netherrack/front_on" else "controller/netherrack/front_off");
    }

    override fun getMaxTemperature(): Int {
        return 3000;
    }

    override fun getIdleBlockID(): Int {
        return BlocksKt.netherrack_controller_block_idle.blockID
    }

    override fun getActiveBlockID(): Int {
        return BlocksKt.netherrack_controller_block.blockID
    }

    override fun getBrickBlock(): Block {
        return BlocksKt.netherrack_brick
    }

    override fun getCoreBlock(): Block {
        return BlocksKt.netherrack_controller_core
    }

}