package huix.faustspotion.mixins.item;


import huix.faustspotion.injected_interfaces.IIItemStack;
import net.minecraft.ItemStack;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin( ItemStack.class )
public class ItemStackMixin implements IIItemStack {
    @Shadow
    public int stackSize;

}
