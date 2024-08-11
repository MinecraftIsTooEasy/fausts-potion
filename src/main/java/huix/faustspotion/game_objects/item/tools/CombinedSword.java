package huix.faustspotion.game_objects.item.tools;

import huix.faustspotion.game_objects.item.CombinedTool;
import net.minecraft.*;

public class CombinedSword extends CombinedTool {

    private final String headSwordIcon;
    private final String handleSwordIcon;

    public Icon accessoryIcon;

    public CombinedSword(Material material, String head_icon, String handle_icon) {
        super(material);
        this.headSwordIcon = head_icon;
        this.handleSwordIcon = handle_icon;
        this.addMaterialsEffectiveAgainst(new Material[]{Material.materialCarpet, Material.cloth, Material.tree_leaves, Material.plants, Material.pumpkin, Material.vine, Material.web});
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.headIcon = iconRegister.registerIcon("tools/sword/" + this.headSwordIcon + "_sword_blade");
        this.accessoryIcon = iconRegister.registerIcon("tools/sword/" + this.headSwordIcon + "_sword_accessory");
        this.handleIcon = iconRegister.registerIcon("tools/sword/handle/" + this.handleSwordIcon);
    }

    @Override
    public Icon getIcon (int renderPass) {
        if (renderPass < getPartAmount()) {
            if (renderPass == 0)
                return this.handleIcon;
            else if (renderPass == 1) // Head
                return this.headIcon;
            else if (renderPass == 2) // Accessory
                return this.accessoryIcon;
        }
        return emptyIcon;
    }



    @Override
    public float getBaseHarvestEfficiency(Block block) {
        return 2.0F;
    }

    @Override
    public float getBaseDamageVsEntity() {
        return 4.0F;
    }

    @Override
    public int getNumComponentsForDurability() {
        return 2;
    }

    @Override
    public float getBaseDecayRateForBreakingBlock(Block block) {
        return 2.0F;
    }

    @Override
    public float getBaseDecayRateForAttackingEntity(ItemStack item_stack) {
        return 0.5F;
    }

    @Override
    public String getToolType() {
        return "sword";
    }

}
