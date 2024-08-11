package huix.faustspotion.mixins.client.render;

import net.minecraft.RenderBlocks;
import org.spongepowered.asm.mixin.Mixin;

@Mixin( RenderBlocks.class )
public class RenderBlocksMixin {

//    @Inject(method = "renderBlockAsItem", at = @At(value = "HEAD"))
//    private void fixControllerIcon1(Block par1Block, int par2, float par3, CallbackInfo ci){
//        System.out.println("111111111111111111111111");
//        System.out.println(par1Block.getUnlocalizedName());
//    }


//    @ModifyConstant(method = "renderBlockAsItem", constant = @Constant(intValue = 3, ordinal = 0))
//    private int fixControllerIcon(int constant, @Local(ordinal = 0, argsOnly = true) Block block) {
//        if (block == BlocksKt.Companion.getNetherrack_controller_block_idle()) {
//            System.out.println("111111111111111");
//        }
//        if (block == Block.dispenser || block == Block.dropper || block instanceof BlockFurnace) {
//            return 3;
//        }
//        return 0;
//    }
}
