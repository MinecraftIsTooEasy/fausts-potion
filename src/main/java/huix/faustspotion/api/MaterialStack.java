package huix.faustspotion.api;

import net.minecraft.Item;
import net.minecraft.Material;
import huix.faustpotion.game_objects.item.FPItemsKt;
import huix.faustpotion.game_objects.material.FPMaterialsKt;

public class MaterialStack {
    public final Material material;
    public final int amount;

    public MaterialStack( final Material material, final int amount ) {
        this.material = material;
        this.amount = amount;
    }

}
