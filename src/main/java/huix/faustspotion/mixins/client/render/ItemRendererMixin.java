package huix.faustspotion.mixins.client.render;


import huix.faustspotion.game_objects.item.CombinedTool;
import net.minecraft.*;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin( ItemRenderer.class )
public class ItemRendererMixin {
    @Shadow
    private Minecraft mc;

    @Unique
    private static final int toolIcons = 3;

    @Inject(method = "renderItem", at = @At(value = "HEAD"), cancellable = true)
    private void injectCombinedToolRender(EntityLivingBase ent, ItemStack itemStack, int par3, CallbackInfo ci) {
        if (itemStack.getItem() instanceof CombinedTool tool) {
            int iconParts = toolIcons;
            Icon[] tempParts = new Icon[iconParts];
            label:{
                if (ent instanceof EntityPlayer player) {
                    ItemStack itemInUse = player.getItemInUse();
                    if (itemInUse != null) {
                        for (int i = iconParts; i-- > 0; )
                            tempParts[i] = tool.getIcon(i);
                        break label;
                    }
                }
                for (int i = iconParts; i-- > 0; ) {
                    tempParts[i] = tool.getIcon(i);
                }
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
                // TODO: assign default sprite
                // parts = new Icon[]{ defaultSprite };
            }

            Tessellator tess = Tessellator.instance;
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

            GL11.glPushMatrix();

            TextureManager var4 = this.mc.getTextureManager();
            var4.bindTexture(var4.getResourceLocation(itemStack.getItemSpriteNumber()));

            GL11.glEnable(32826);
            float var11 = 0.0F;
            float var12 = 0.3F;
            GL11.glTranslatef(-var11, -var12, 0.0F);
            float var13 = 1.5F;
            GL11.glScalef(var13, var13, var13);
            GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);

            for (int i = 0; i < iconParts; ++i) {
                ItemRenderer.renderItemIn2D(tess, xMax[i], yMin[i], xMin[i], yMax[i], width[i], height[i], 0.0625F);
            }

            GL11.glDisable(32826);
            GL11.glPopMatrix();
        }
    }
}

