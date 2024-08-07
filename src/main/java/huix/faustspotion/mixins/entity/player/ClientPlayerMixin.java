package huix.faustspotion.mixins.entity.player;

import huix.faustpotion.game_objects.client.render.gui.ReforgeGui;
import huix.faustspotion.game_objects.tileentity.ReforgeTileEntity;
import huix.faustspotion.injected_interfaces.IIPlayer;
import net.minecraft.ClientPlayer;
import net.minecraft.Minecraft;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin( ClientPlayer.class )
public class ClientPlayerMixin implements IIPlayer {

    @Shadow
    protected Minecraft mc;


    @Unique
    @Override
    public void displayReforgeGui(int x, int y, int z, ReforgeTileEntity tileEntity) {
        this.mc.displayGuiScreen(new ReforgeGui(ReflectHelper.dyCast(this), tileEntity));
    }
}
