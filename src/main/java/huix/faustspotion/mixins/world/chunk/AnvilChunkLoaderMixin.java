package huix.faustspotion.mixins.world.chunk;

import com.llamalad7.mixinextras.sugar.Local;
import huix.faustpotion.game_objects.block.BlocksKt;
import net.minecraft.AnvilChunkLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin( AnvilChunkLoader.class )
public class AnvilChunkLoaderMixin {

    @Inject(method = "getInvalidSectionBlockConversionIdsOrMetadata", at = @At("RETURN"))
    private static void registerForgingTable(CallbackInfoReturnable<int[][]> cir, @Local(ordinal = 0)int[][] array) {
        array[BlocksKt.Companion.getNetherrack_controller_block().blockID] = air();
        array[BlocksKt.Companion.getNetherrack_controller_block_idle().blockID] = air();
        array[BlocksKt.Companion.getObsidian_controller_block_idle().blockID] = air();
        array[BlocksKt.Companion.getObsidian_controller_block().blockID] = air();
    }

    @Shadow
    private static int[] air() {
        return null;
    }
}
