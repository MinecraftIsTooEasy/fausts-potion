package huix.faustspotion.game_objects.item.tools;

import huix.faustspotion.game_objects.item.CombinedTool;
import net.minecraft.Block;
import net.minecraft.IconRegister;
import net.minecraft.ItemStack;
import net.minecraft.Material;

public class CombinedShovel extends CombinedTool {

    private final String headShovelIcon;
    private final String handleShovelIcon;

    public CombinedShovel(Material material, String head_icon, String handle_icon) {
        super(material);
        this.addMaterialsEffectiveAgainst(new Material[]{Material.cake, Material.clay, Material.craftedSnow, Material.grass, Material.dirt, Material.sand, Material.snow});
        this.addBlocksEffectiveAgainst(new Block[]{Block.carrot, Block.onions, Block.potato, Block.thinGlass});
        if (material.isMetal()) {
            this.addBlocksEffectiveAgainst(new Block[]{Block.glass});
        }

        this.headShovelIcon = head_icon;
        this.handleShovelIcon = handle_icon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.headIcon = iconRegister.registerIcon("tools/shovel/" + this.headShovelIcon + "_shovel_head");
        this.handleIcon = iconRegister.registerIcon("tools/shovel/handle/" + this.handleShovelIcon);
    }



    @Override
    public float getBaseDamageVsEntity() {
        return 1.0F;
    }

    @Override
    public float getBaseDecayRateForBreakingBlock(Block block) {
        return 0.5F;
    }

    @Override
    public float getBaseDecayRateForAttackingEntity(ItemStack itemStack) {
        return 1.0F;
    }

    @Override
    public String getToolType() {
        return "shovel";
    }

    @Override
    public int getNumComponentsForDurability() {
        return 1;
    }
}
