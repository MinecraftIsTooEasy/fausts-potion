package huix.faustspotion.game_objects.item;

import net.minecraft.IconRegister;
import net.minecraft.ItemIngot;
import net.minecraft.Material;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class AlloyIngotItem extends ItemIngot {

    public AlloyIngotItem(Material material) {
        super(IdUtil.getNextItemID(), material);
        this.setLowestCraftingDifficultyToProduce(material.min_harvest_level);
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("alloy/" + this.getIconString());

    }
}
