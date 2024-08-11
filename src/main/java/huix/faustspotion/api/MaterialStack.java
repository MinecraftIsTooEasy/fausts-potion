package huix.faustspotion.api;

import net.minecraft.Material;

public class MaterialStack {
    public final Material material;
    public final int amount;

    public MaterialStack( final Material material, final int amount ) {
        this.material = material;
        this.amount = amount;
    }

}
