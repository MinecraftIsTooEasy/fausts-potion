//package huix.faustspotion.mixins.fml;
//
//
//import huix.faustspotion.enum_extend.EnumItemInUseActionExtend;
//import net.xiaoyu233.fml.util.EnumExtends;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin( EnumExtends.class )
//public class EnumExtendsMixin {
//
//    @Inject(method = "buildEnumExtending", at = @At("RETURN"))
//    private static void injectEnumExtends(CallbackInfo ci) {
//        EnumItemInUseActionExtend.ITEM_IN_USE_ACTION.build();
//    }
//}
