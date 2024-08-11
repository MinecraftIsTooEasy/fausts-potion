package huix.faustspotion.mixins.item;


import com.llamalad7.mixinextras.sugar.Local;
import huix.faustspotion.injected_interfaces.IIItemStack;
import net.minecraft.EntityLivingBase;
import net.minecraft.ItemStack;
import net.minecraft.NBTTagCompound;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin( ItemStack.class )
public class ItemStackMixin implements IIItemStack {
    @Shadow
    public int stackSize;

//    @Inject(method = "writeToNBT", at = @At(value = "INVOKE", target = "Lnet/minecraft/NBTTagCompound;setInteger(Ljava/lang/String;I)V", ordinal = 1))
//    private void injectCombinedNBT(NBTTagCompound par1NBTTagCompound, CallbackInfoReturnable<NBTTagCompound> cir
//            , @Local(ordinal = 0, argsOnly = true) NBTTagCompound effective_stackTagCompound) {
//
//        effective_stackTagCompound.setCompoundTag("InfiTool", new NBTTagCompound());
//        effective_stackTagCompound.getCompoundTag("InfiTool").setInteger("RenderHead", 2);
//        effective_stackTagCompound.getCompoundTag("InfiTool").setInteger("RenderHandle", 0);
//        effective_stackTagCompound.getCompoundTag("InfiTool").setInteger("RenderAccessory", 10);
//    }

}
