package huix.faustspotion.mixins.inventory.slot;


import net.minecraft.EntityLivingBase;
import net.minecraft.ItemStack;
import net.minecraft.NBTTagCompound;
import net.minecraft.SlotCrafting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin( SlotCrafting.class)
public class SlotCraftingMixin {

//    @Inject(method = "onCrafting(Lnet/minecraft/ItemStack;)V", at = @At(value = "HEAD"))
//    private void injectCombinedToolRender(ItemStack par1ItemStack, CallbackInfo ci) {
//        int head = -1, handle = -1, accessory = -1;
//
//        head = par1ItemStack.getMaterialForRepairs(),get(headStack);
//        if (head == -1)
//            validMaterials = false;
//
//        handle = getMaterialID(handleStack);
//        if (handle == -1)
//            validMaterials = false;
//
//        NBTTagCompound compound = new NBTTagCompound();
//
//        compound.setCompoundTag("InfiTool", new NBTTagCompound());
//        compound.getCompoundTag("InfiTool").setInteger("Head", head);
//        compound.getCompoundTag("InfiTool").setInteger("RenderHead", head);
//
//        compound.getCompoundTag("InfiTool").setInteger("Handle", handle);
//        compound.getCompoundTag("InfiTool").setInteger("RenderHandle", handle);
//    }

}
