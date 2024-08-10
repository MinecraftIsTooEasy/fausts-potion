//package huix.faustpotion.game_objects.client.render.gui
//
//import huix.faustpotion.game_objects.material.MaterialHelperKt
//import huix.faustspotion.game_objects.inventory.container.ReforgeContainer
//import huix.faustspotion.game_objects.tileentity.ReforgeTileEntity
//import net.minecraft.*
//import org.lwjgl.opengl.GL11
//
//class ReforgeGuiKt(player: EntityPlayer, private val reforgeTile: ReforgeTileEntity) : GuiContainer(ReforgeContainer(player, reforgeTile)) {
//
//    private val itemRender = RenderItem()
//
//    private val REFORGE_TEXTURE = ResourceLocation("textures/gui/reforge.png")
//
////    override fun drawScreen(mouse_x: Int, mouse_y: Int, par3: Float) {
////        super.drawScreen(mouse_x, mouse_y, par3)
////
////
////        val x = (this.width - this.xSize) / 2
////        val y = (this.height - this.ySize) / 2
////        //left, top, width, height, pointX, pointY
////        if (this.isPointInRegion(90, 48, 5, 12, x + 112, y + 56)) {
////            println("11111111111")
////            this.drawCreativeTabHoveringText(Translator.get("reforgeing.temperature") + ": "
////                    + this.reforgeTile.temperature, x + 112, y + 56)
////        }
////
////    }
//
//
//    override fun drawGuiContainerForegroundLayer(par1: Int, par2: Int) {
//        val text = if (this.reforgeTile.hasCustomName()) this.reforgeTile.customNameOrUnlocalized
//                    else I18n.getString(this.reforgeTile.customNameOrUnlocalized)
//        this.fontRenderer.drawString(text, this.xSize / 2 - fontRenderer.getStringWidth(text) / 2 + 55, 6, 4210752)
//        this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96 + 2, 4210752)
//    }
//
//    override fun drawGuiContainerBackgroundLayer(f: Float, i: Int, j: Int) {
//        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f)
//        this.drawDefaultBackground()
//        this.mc.textureManager.bindTexture(REFORGE_TEXTURE)
//        val x = (this.width - this.xSize) / 2
//        val y = (this.height - this.ySize) / 2
//        //Args: x, y, u, v, width, height
//        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize)
//
//
//        var progress: Int = this.reforgeTile.getBuildProgressScaled(24)
//        this.drawTexturedModalRect(x + 68, y + 24, 176, 0, progress + 1, 16)
//
//        progress = this.reforgeTile.getTemperatureProgressScaled(64)
//        this.drawTexturedModalRect(x + 112, y + 56, 176, 18, progress + 1, 12)
//
//        this.fontRenderer.drawString("当前温度: " + this.reforgeTile.temperature, x + 112, y + 70, 4210752)
//
//        for(i in 0..2 ) {
//            if (this.inventorySlots.inventory[i] != null) {
//                val itemStack = ((this.inventorySlots.inventory[i]) as ItemStack)
//                val item = itemStack.item
//                if (item is ItemIngot || (itemStack.isBlock && itemStack.itemAsBlock.block is BlockOreStorage)) {
//
//                    val count = if (itemStack.isBlock) {
//                        itemStack.stackSize * 81
//                    } else if (item is ItemNugget) {
//                        itemStack.stackSize
//                    } else {
//                        itemStack.stackSize * 9
//                    }
//
//                    this.itemRender.renderItemIntoGUI(this.mc.fontRenderer, this.mc.textureManager,
//                        ItemStack(MaterialHelperKt.getNuggetByMaterial(itemStack.materialForRepairs)), x + 26, y + 8 + i * 20)
//                    //string, x, y, color, dropShadow
//                    this.fontRenderer.drawString(" *$count", x + 36, y + 11 + i * 20, 4210752)
//                }
//            }
//        }
//    }
//}