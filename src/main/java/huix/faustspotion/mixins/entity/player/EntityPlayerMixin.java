package huix.faustspotion.mixins.entity.player;

import huix.faustspotion.game_objects.tileentity.ReforgeTileEntity;
import huix.faustspotion.injected_interfaces.IIPlayer;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin( EntityPlayer.class )
public class EntityPlayerMixin implements IIPlayer {

    @Unique
    @Override
    public void displayReforgeGui(ReforgeTileEntity tileEntity) {

    }

    //    @Overwrite
//    public final boolean setHeldItemInUse() {
//        ItemStack item_stack = this.getHeldItemStack();
//        if (item_stack == null) {
//            Minecraft.setErrorMessage("setHeldItemInUse: no item held");
//        } else if (item_stack.getItemInUseAction(this) == null) {
//            Minecraft.setErrorMessage("setHeldItemInUse: item has no inUseAction");
//        } else if (item_stack != this.itemInUse) {
//            this.itemInUse = item_stack;
//            this.itemInUseCount = item_stack.getMaxItemUseDuration();
//            if (this.onServer() && this.itemInUse.getItemInUseAction(this) == EnumItemInUseAction.EAT) {
//                this.setEating(true);
//                this.getWorldServer().getEntityTracker().sendPacketToAllAssociatedPlayers(this, new Packet18Animation(this, 5));
//            }
//
//            if (this.onServer()) {
//                this.sendPacketToAssociatedPlayers((new Packet85SimpleSignal(EnumSignal.item_in_use)).setInteger(this.itemInUseCount).setEntityID(this), false);
//            }
//
//            return true;
//        }
//
//        return false;
//    }

}
