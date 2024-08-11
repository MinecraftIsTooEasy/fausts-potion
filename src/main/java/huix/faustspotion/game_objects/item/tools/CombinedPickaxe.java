package huix.faustspotion.game_objects.item.tools;

import huix.faustspotion.game_objects.item.CombinedTool;
import net.minecraft.*;

public class CombinedPickaxe extends CombinedTool {

    private final String headPickaxeIcon;
    private final String handlePickaxeIcon;

    public CombinedPickaxe(Material material, String head_icon, String handle_icon) {
        super(material);
        this.headPickaxeIcon = head_icon;
        this.handlePickaxeIcon = handle_icon;
        this.addMaterialsEffectiveAgainst(new Material[]{Material.adamantium, Material.ancient_metal, Material.circuits, Material.clay, Material.coal, Material.copper, Material.coral, Material.diamond, Material.emerald, Material.glass, Material.gold, Material.hardened_clay, Material.ice, Material.iron, Material.mithril, Material.netherrack, Material.obsidian, Material.quartz, Material.redstone, Material.stone, Material.rusted_iron, Material.silver});
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.headIcon = iconRegister.registerIcon("tools/pickaxe/" + this.headPickaxeIcon + "_pickaxe_head");
        this.handleIcon = iconRegister.registerIcon("tools/pickaxe/handle/" + this.handlePickaxeIcon);
    }



    @Override
    public float getBaseDamageVsEntity() {
        return 2.0F;
    }

    @Override
    public float getBaseDecayRateForBreakingBlock(Block block) {
        return 1.0F;
    }

    @Override
    public float getBaseDecayRateForAttackingEntity(ItemStack itemStack) {
        return 1.0F;
    }

    @Override
    public String getToolType() {
        return "pickaxe";
    }

    @Override
    public int getNumComponentsForDurability() {
        return 3;
    }
}
