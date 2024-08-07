package huix.faustspotion.mixins.client.render;


import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;

@Mixin( ItemRenderer.class )
public class ItemRendererMixin {

//    @Inject(method = "renderItemInFirstPerson", at = @At(value = "INVOKE", target = "Lnet/minecraft/ItemStack;getItemInUseAction(Lnet/minecraft/EntityPlayer;)Lnet/minecraft/EnumItemInUseAction;"
//             , ordinal = 0 , shift = At.Shift.AFTER))
//    private void injectGoldPanAnn(float par1, CallbackInfo ci, @Local(ordinal = 1) EntityClientPlayerMP player,
//                                  @Local(ordinal = 0) ItemStack itemToRender) {
//        float v0;
//        float v1;
//        float v2;
//        if (itemToRender.getItem() instanceof GoldPanItemKt) {
//            v0 = itemToRender.getMaxItemUseDuration() - ((float)player.getItemInUseCount() - par1 + 1.0F);
//            v2 = v0 / (float)20;
//            v2 = (v2 * v2 + v2 * 2.0F) / 3.0F;
//
//            if (v2 > 1.0F)
//            {
//                v2 = 1.0F;
//            }
//
//            if (v2 > 0.1F)
//            {
//                GL11.glTranslatef(0.0F, MathHelper.sin((v0 - 0.1F) * 1.3F) * 0.01F * (v2 - 0.1F), 0.0F);
//            }
//
//            GL11.glTranslatef(0.0F, 0.0F, v2 * 0.2F);
//            GL11.glRotatef(-335.0F, 0.0F, 0.0F, 1.0F);
//            GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
//            GL11.glTranslatef(0.0F, 0.5F, 0.0F);
//            v1 = 1.0F + v2 * 0.2F;
//            GL11.glScalef(1.0F, 1.0F, v1);
//            GL11.glTranslatef(0.0F, -0.5F, 0.0F);
//            GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
//            GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
//        }
//    }
}
