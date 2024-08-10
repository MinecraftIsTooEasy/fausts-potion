package huix.faustspotion.mixins.entity.player;

//import huix.faustpotion.game_objects.client.render.gui.ReforgeGuiKt;
import huix.faustspotion.game_objects.client.render.gui.ReforgeGui;
import huix.faustspotion.game_objects.tileentity.ReforgeTileEntity;
import huix.faustspotion.injected_interfaces.IIPlayer;
import net.minecraft.*;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin( ClientPlayer.class )
public abstract class ClientPlayerMixin extends AbstractClientPlayer {

    @Shadow
    protected Minecraft mc;

    public ClientPlayerMixin(World par1World, String par2Str) {
        super(par1World, par2Str);
    }


    @Unique
    @Override
    public void displayReforgeGui(ReforgeTileEntity tileEntity) {
        this.mc.displayGuiScreen(new ReforgeGui(ReflectHelper.dyCast(this), tileEntity));
    }

//    public void displayGUIFurnace(TileEntityFurnace par1TileEntityFurnace) {
//        System.out.println("clientplayer par1TileEntityFurnace : " + par1TileEntityFurnace);
//        this.mc.displayGuiScreen(new GuiFurnace(this, par1TileEntityFurnace));
//    }



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
