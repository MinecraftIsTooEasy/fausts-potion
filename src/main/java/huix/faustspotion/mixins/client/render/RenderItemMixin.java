package huix.faustspotion.mixins.client.render;


import com.llamalad7.mixinextras.sugar.Local;
import huix.faustspotion.game_objects.item.CombinedTool;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin( RenderItem.class )
public class RenderItemMixin {

    @Unique
    private static final int toolIcons = 3;

    @Redirect(method = "renderDroppedItem", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/ItemRenderer;renderItemIn2D(Lnet/minecraft/Tessellator;FFFFIIF)V", ordinal = 0))
    private void injectCombinedToolRender(Tessellator tessellator, float par1, float par2, float par3, float par4, int par5, int par6, float par7,
                                          @Local(argsOnly = true)EntityItem par1EntityItem) {
        if (par1EntityItem.getEntityItem().getItem() instanceof CombinedTool tool) {
            int iconParts = toolIcons;
            Icon[] tempParts = new Icon[iconParts];

            for (int i = iconParts; i-- > 0; ) {
                    tempParts[i] = tool.getIcon(i);
            }

            int count = 0;
            Icon[] parts = new Icon[iconParts];
            for (int i = 0; i < iconParts; ++i) {
                Icon part = tempParts[i];
                if (part == null | part == CombinedTool.emptyIcon)
                    ++count;
                else
                    parts[i - count] = part;
            }
            iconParts -= count;


            if (iconParts <= 0) {
                iconParts = 1;
            }

            float[] xMax = new float[iconParts];
            float[] yMin = new float[iconParts];
            float[] xMin = new float[iconParts];
            float[] yMax = new float[iconParts];

            int[] width = new int[iconParts];
            int[] height = new int[iconParts];

            for (int i = 0; i < iconParts; ++i) {
                Icon icon = parts[i];
                xMin[i] = icon.getMinU();
                xMax[i] = icon.getMaxU();
                yMin[i] = icon.getMinV();
                yMax[i] = icon.getMaxV();
                width[i] = icon.getIconWidth();
                height[i] = icon.getIconHeight();
            }

            for (int i = 0; i < iconParts; ++i) {
                ItemRenderer.renderItemIn2D(tessellator, xMax[i], yMin[i], xMin[i], yMax[i], width[i], height[i], par7);
            }
        } else {
            ItemRenderer.renderItemIn2D(tessellator, par1, par2, par3, par4, par5, par6, par7);
        }
    }

    @Redirect(method = "renderItemIntoGUI", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/RenderItem;renderIcon(IILnet/minecraft/Icon;II)V", ordinal = 1))
    private void injectCombinedToolRender(RenderItem instance, int par1, int par2, Icon par3Icon, int par4, int par5,
                                          @Local(argsOnly = true)ItemStack itemStack) {
        if (itemStack.getItem() instanceof CombinedTool tool) {
            int iconParts = toolIcons;
            Icon[] tempParts = new Icon[iconParts];

            for (int i = iconParts; i-- > 0; ) {
                tempParts[i] = tool.getIcon(i);
            }

            int count = 0;
            Icon[] parts = new Icon[iconParts];
            for (int i = 0; i < iconParts; ++i) {
                Icon part = tempParts[i];
                if (part == null | part == CombinedTool.emptyIcon)
                    ++count;
                else
                    parts[i - count] = part;
            }
            iconParts -= count;

            if (iconParts <= 0) {
                iconParts = 1;
            }

            Icon[] icons = new Icon[iconParts];
            System.arraycopy(parts, 0, icons, 0, iconParts);

            for (int i = 0; i < iconParts; ++i) {
                this.renderIcon(par1, par2, icons[i], 16, 16);
            }

        } else {
            this.renderIcon(par1, par2, par3Icon, 16, 16);
        }
    }

    @Shadow
    public void renderIcon(int par1, int par2, Icon par3Icon, int par4, int par5)   {

    }


}
