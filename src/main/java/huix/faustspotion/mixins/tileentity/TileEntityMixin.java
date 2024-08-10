package huix.faustspotion.mixins.tileentity;

import huix.faustspotion.game_objects.tileentity.ReforgeTileEntity;
import net.minecraft.NBTTagCompound;
import net.minecraft.TileEntity;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(TileEntity.class)
public class TileEntityMixin {

   @Shadow
   private static void addMapping(Class par0Class, String par1Str) {}

   @Inject(method = "<clinit>()V", at = @At("RETURN"))
   private static void registerForgingTable(CallbackInfo callbackInfo) {
      addMapping(ReforgeTileEntity.class, "Reforge");
   }

//   @Shadow
//   private static Map nameToClassMap;
//
//   @Overwrite
//   public static TileEntity createAndLoadEntity(NBTTagCompound par0NBTTagCompound) {
//      TileEntity var1 = null;
//
//      try {
//         Class var2 = (Class)nameToClassMap.get(par0NBTTagCompound.getString("id"));
//         if (var2 != null) {
//            var1 = (TileEntity)var2.newInstance();
//            if (var2.getName().equals(ReforgeTileEntity.class.getName())) {
//               System.out.println("111111111111111111");
//            }
//         }
//      } catch (Exception var3) {
//         var3.printStackTrace();
//      }
//
//      if (var1 != null) {
//         var1.readFromNBT(par0NBTTagCompound);
//      } else {
//         MinecraftServer.getServer().getLogAgent().logWarning("Skipping TileEntity with id " + par0NBTTagCompound.getString("id"));
//      }
//
//      return var1;
//   }

}
