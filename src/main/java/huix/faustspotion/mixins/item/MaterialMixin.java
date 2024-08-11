package huix.faustspotion.mixins.item;

import huix.faustpotion.game_objects.material.MaterialsKt;
import net.minecraft.Material;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin( Material.class )
public class MaterialMixin {

//    @Inject(method = "getDamageVsEntity", at = @At(value = "RETURN"))
//    private void injectCombinedNBT(CallbackInfoReturnable<Float> cir) {
//
//
//    }

}
