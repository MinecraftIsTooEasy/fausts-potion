package huix.faustspotion.mixins.entity.player;


import huix.faustspotion.game_objects.block.BlockPos;
import huix.faustspotion.game_objects.inventory.container.ReforgeContainer;
import huix.faustspotion.game_objects.tileentity.ReforgeTileEntity;
import huix.faustspotion.injected_interfaces.IIPlayer;
import net.minecraft.*;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin( ServerPlayer.class )
public class ServerPlayerMixin extends EntityPlayer {

    @Shadow
    public NetServerHandler playerNetServerHandler;
    @Shadow
    private int currentWindowId;

    public ServerPlayerMixin(World par1World, String par2Str) {
        super(par1World, par2Str);
    }

    @Unique
    @Override
    public void displayReforgeGui(ReforgeTileEntity tileEntity) {
        this.incrementWindowID();
//        System.out.println("ServerPlayer" + tileEntity);
//        System.out.println(new BlockPos(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord));

        this.playerNetServerHandler.sendPacketToPlayer((new Packet100OpenWindow(this.currentWindowId,
                20, tileEntity.getCustomInvName(), tileEntity.getSizeInventory(), tileEntity.hasCustomName())).setCoords(tileEntity));
        this.openContainer = new ReforgeContainer(this, tileEntity);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.addCraftingToCrafters(ReflectHelper.dyCast(ServerPlayer.class, this));
    }


    @Shadow
    private void incrementWindowID(){
    }

    @Shadow
    public INetworkManager getNetManager() {
        return null;
    }

    @Shadow
    public void sendChatToPlayer(ChatMessageComponent chatMessageComponent) {
    }

    @Shadow
    public boolean canCommandSenderUseCommand(int i, String string) {
        return false;
    }

    @Shadow
    public ChunkCoordinates getPlayerCoordinates() {
        return null;
    }
}
