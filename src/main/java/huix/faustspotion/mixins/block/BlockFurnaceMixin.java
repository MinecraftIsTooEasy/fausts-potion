package huix.faustspotion.mixins.block;


import net.minecraft.BlockFurnace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin( BlockFurnace.class )
public class BlockFurnaceMixin {

    @Inject(method = "getCraftingDifficultyAsComponent", at = @At(value = "HEAD"), cancellable = true)
    private void injectCraftingDifficultyAsComponent(int metadata, CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(5.0F);
    }

}
