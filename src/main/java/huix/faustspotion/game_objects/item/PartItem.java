package huix.faustspotion.game_objects.item;

import net.minecraft.Item;
import net.minecraft.Material;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class PartItem extends Item {


    public PartItem(Material material) {
        super(IdUtil.getNextItemID(), material, "");
        this.setMaxStackSize(1);
        this.setLowestCraftingDifficultyToProduce(0);
    }
}
