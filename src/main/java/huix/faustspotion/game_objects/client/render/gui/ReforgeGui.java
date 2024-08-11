package huix.faustspotion.game_objects.client.render.gui;

import huix.faustspotion.game_objects.inventory.container.ReforgeContainer;
import huix.faustspotion.game_objects.tileentity.ReforgeTileEntity;
import net.minecraft.*;
import org.lwjgl.opengl.GL11;
import huix.faustpotion.game_objects.material.MaterialHelperKt;

public class ReforgeGui extends GuiContainer {

    private static final ResourceLocation REFORGE_TEXTURE = new ResourceLocation("textures/gui/reforge.png");
    private final RenderItem itemRender = new RenderItem();

    private final ReforgeTileEntity reforgeTile;

    public ReforgeGui(EntityPlayer player, ReforgeTileEntity reforgeTile) {
        super(new ReforgeContainer(player, reforgeTile));

        this.reforgeTile = reforgeTile;
//        if (!player.getWorld().isRemote) {
//
//        } else {
//            this.reforgeTile = null;
//        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(REFORGE_TEXTURE);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        //Args: x, y, u, v, width, height
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);


        int progress = this.reforgeTile.getBuildProgressScaled(24);
        this.drawTexturedModalRect(x + 68, y + 24, 176, 0, progress + 1, 16);

        progress = this.reforgeTile.getTemperatureProgressScaled(64);
        this.drawTexturedModalRect(x + 112, y + 56, 176, 18, progress + 1, 12);

        this.fontRenderer.drawString("当前温度: " + this.reforgeTile.temperature, x + 112, y + 70, 4210752);


        for (int k = 0; k <= 2; ++k) {
            if (this.inventorySlots.getInventory().get(k) != null) {
                ItemStack itemStack = (ItemStack) this.inventorySlots.getInventory().get(k);
                Item item = itemStack.getItem();
                if (item instanceof ItemIngot || (itemStack.isBlock() && itemStack.getItemAsBlock().getBlock() instanceof BlockOreStorage)) {

                    int count;
                    if (itemStack.isBlock()) {
                        count = itemStack.stackSize * 81;
                    } else if (item instanceof ItemNugget) {
                        count = itemStack.stackSize;
                    } else {
                        count = itemStack.stackSize * 9;
                    }

                    if (MaterialHelperKt.Companion.getNuggetByMaterial(itemStack.getMaterialForRepairs()).getMaterialForRepairs()
                            != Material.stone) {
                        this.itemRender.renderItemIntoGUI(this.mc.fontRenderer, this.mc.getTextureManager(),
                                new ItemStack(MaterialHelperKt.Companion.getNuggetByMaterial(itemStack.getMaterialForRepairs())),
                                x + 26, y + 8 + k * 20);
                        //string, x, y, color, dropShadow
                        this.fontRenderer.drawString(" *" + count, x + 36, y + 11 + k * 20, 4210752);
                    }
                }
            }
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String text = this.reforgeTile.hasCustomName() ? this.reforgeTile.getCustomNameOrUnlocalized()
                        : I18n.getString(this.reforgeTile.getCustomNameOrUnlocalized());
        this.fontRenderer.drawString(text, this.xSize / 2 - fontRenderer.getStringWidth(text) / 2 + 55, 6, 4210752);
        this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }
}
