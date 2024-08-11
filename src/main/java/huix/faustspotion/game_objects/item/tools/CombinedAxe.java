package huix.faustspotion.game_objects.item.tools;

import huix.faustspotion.game_objects.item.CombinedTool;
import net.minecraft.Block;
import net.minecraft.IconRegister;
import net.minecraft.ItemStack;
import net.minecraft.Material;
import org.spongepowered.asm.mixin.Overwrite;

public class CombinedAxe extends CombinedTool {

    private final String headAxeIcon;
    private final String handleAxeIcon;

    public CombinedAxe(Material material, String head_icon, String handle_icon) {
        super(material);
        this.headAxeIcon = head_icon;
        this.handleAxeIcon = handle_icon;
        this.addMaterialsEffectiveAgainst(new Material[]{Material.cactus, Material.clay, Material.glass, Material.hardened_clay, Material.ice, Material.pumpkin, Material.wood});
        this.addBlocksEffectiveAgainst(new Block[]{Block.ladder, Block.reed, Block.sandStone});
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.headIcon = iconRegister.registerIcon("tools/axe/" + this.headAxeIcon + "_axe_head");
        this.handleIcon = iconRegister.registerIcon("tools/axe/handle/" + this.handleAxeIcon);
    }


    @Override
    public float getBaseHarvestEfficiency(Block block) {
        return block == Block.sandStone ? super.getBaseHarvestEfficiency(block) * 0.5F : super.getBaseHarvestEfficiency(block);
    }

    @Override
    public float getBaseDamageVsEntity() {
        return 3.0F;
    }

    @Override
    public float getBaseDecayRateForBreakingBlock(Block block) {
        return block == Block.sandStone ? 1.875F : 1.0F;
    }

    @Override
    public float getBaseDecayRateForAttackingEntity(ItemStack itemStack) {
        return 1.0F;
    }

    @Override
    public String getToolType() {
        return "axe";
    }

    @Override
    public int getNumComponentsForDurability() {
        return 3;
    }
}
