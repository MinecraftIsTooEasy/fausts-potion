package huix.faustspotion.game_objects.block;

import net.minecraft.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class CookingPotBlock extends Block {

    private Icon[] icon;

    public CookingPotBlock() {
        super(IdUtil.getNextBlockID(), Material.iron, new BlockConstants());
        this.setCreativeTab(CreativeTabs.tabDecorations);

        this.setBounds();
    }


    private void setBounds() {
        float var1 = 0.375F;
        //前 下 厚度 高度 宽度
        this.setBlockBounds(0.5F - var1, 0.0D, 0.5F - var1, 0.5F + var1, 0.6250D, 0.5F + var1, true);
    }

    @Override
    public boolean canBeReplacedBy(int metadata, Block other_block, int other_block_metadata) {
        return false;
    }

    @Override
    public void setBlockBoundsForItemRender(int item_damage) {
        this.setBounds();
    }

    @Override
    public boolean isStandardFormCube(boolean[] is_standard_form_cube, int metadata) {
        return false;
    }


    @Override
    public Icon getIcon(int side, int meta) {
        if (side < 2) {
            return this.icon[side];
        }
        return this.icon[2];
    }


    @Override
    public void registerIcons(IconRegister register) {
        this.icon = new Icon[3];
        this.icon[0] = register.registerIcon("cooking_pot_bottom");
        this.icon[1] = register.registerIcon("cooking_pot_top");
        this.icon[2] = register.registerIcon("cooking_pot_side");
    }


}
