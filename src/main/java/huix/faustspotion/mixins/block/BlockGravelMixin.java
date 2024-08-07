package huix.faustspotion.mixins.block;

import huix.faustpotion.game_objects.material.FPMaterialsKt;
import net.minecraft.BlockConstants;
import net.minecraft.BlockFalling;
import net.minecraft.BlockGravel;
import net.minecraft.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin( BlockGravel.class )
public class BlockGravelMixin extends BlockFalling {

    public BlockGravelMixin(int par1, Material material, BlockConstants constants) {
        super(par1, material, constants);
    }

    @ModifyArg(method = "<init>", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/BlockFalling;<init>(ILnet/minecraft/Material;Lnet/minecraft/BlockConstants;)V")
            , index = 1)
    private static Material changeItsMaterial(Material material) {
        return FPMaterialsKt.Companion.getGravel();
    }
}
