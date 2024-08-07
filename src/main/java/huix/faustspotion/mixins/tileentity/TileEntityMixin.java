package huix.faustspotion.mixins.tileentity;

import huix.faustspotion.game_objects.tileentity.ReforgeTileEntity;
import net.minecraft.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TileEntity.class)
public class TileEntityMixin {

   @Shadow
   private static void addMapping(Class par0Class, String par1Str) {}

   @Inject(method = "<clinit>()V", at = @At("RETURN"))
   private static void registerForgingTable(CallbackInfo callbackInfo) {
      addMapping(ReforgeTileEntity.class, "Reforge");
   }
}
