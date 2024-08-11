package huix.faustspotion.game_objects.item;

import huix.faustpotion.game_objects.material.MaterialsKt;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class CombinedTool extends ItemTool {

    private final Material material;

    protected CombinedTool(Material material) {
        super(IdUtil.getNextItemID(), material);
        this.material = material;
        this.setLowestCraftingDifficultyToProduce(1.0F);
    }

//    public HashMap<Integer, Icon> headIcons = new HashMap<>();
//    public HashMap<Integer, Icon> handleIcons = new HashMap<>();
//    public HashMap<Integer, Icon> accessoryIcons = new HashMap<>();
//
//    public HashMap<Integer, String> headStrings = new HashMap<>();
//    public HashMap<Integer, String> handleStrings = new HashMap<>();
//    public HashMap<Integer, String> accessoryStrings = new HashMap<>();


    public Icon headIcon;
    public Icon handleIcon;

    public static Icon emptyIcon;

    //Override me please!
    public int getPartAmount () {
        return 3;
    }


    @Override
    public void registerIcons (IconRegister iconRegister) {
        emptyIcon = iconRegister.registerIcon("blankface");
    }

    public Icon getIcon (int renderPass) {
        if (renderPass < getPartAmount()) {
            if (renderPass == 0)
                return handleIcon;
            else if (renderPass == 1) // Head
                return headIcon;
        }
        return emptyIcon;
    }

    @Override
    public float getMaterialHarvestEfficiency() {
        if (this.material == MaterialsKt.Companion.getBronze()) {
            return 1.8F;
        } else if (this.material == MaterialsKt.Companion.getSteel()) {
            return 2.5F;
        } else {
            Minecraft.setErrorMessage("getMaterialHarvestEfficiency: tool material not handled");
            return 0.0F;
        }
    }
}
