package huix.faustspotion.game_objects.inventory.container;

import huix.faustspotion.game_objects.block.ControllerBlock;
import huix.faustspotion.game_objects.inventory.slot.FuelSlot;
import huix.faustspotion.game_objects.tileentity.ReforgeTileEntity;
import net.minecraft.*;

public class ReforgeContainer extends Container {

    private final ReforgeTileEntity reforgeTile;

    private int lastCurrentFlueBurnTime;
    private int lastFlueBurnTime;
    private int lastForgeBuildTime;
    private int lastTemperature;
    public final int temperature;

//    private final int blockX,blockY,blockZ;

    public ReforgeContainer(EntityPlayer player, ReforgeTileEntity reforgeTile) {
        super(player);

//        this.blockX = x;
//        this.blockY = y;
//        this.blockZ = z;


        this.reforgeTile = reforgeTile;
        this.temperature = reforgeTile == null ? 0 : reforgeTile.temperature;

//        if (!player.getWorld().isRemote) {
//
//            this.temperature = this.reforgeTile.temperature;
//        } else {
//            this.reforgeTile = null;
//            this.temperature = 0;
//        }


        this.addSlotToContainer(new Slot(reforgeTile, 0, 8, 8));
        this.addSlotToContainer(new Slot(reforgeTile, 1, 8, 28));
        this.addSlotToContainer(new Slot(reforgeTile, 2, 8, 48));

        this.addSlotToContainer(new FuelSlot(reforgeTile, 3, 62, 48, reforgeTile));
        this.addSlotToContainer(new FuelSlot(reforgeTile, 4, 82, 48, reforgeTile));
        this.addSlotToContainer(new Slot(reforgeTile, 5, 116, 27) {
            public boolean isItemValid(ItemStack par1ItemStack) {
                return false;
            }
        });
        this.addSlotToContainer(new Slot(reforgeTile, 6, 148, 27) {
            public boolean isItemValid(ItemStack par1ItemStack) {
                return false;
            }
        });


        int i;
        for (int j = 0; j < 3; ++j) {
            for (i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(player.inventory, i + j * 9 + 9, 8 + i * 18, 84 + j * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public void addCraftingToCrafters(ICrafting par1ICrafting) {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.reforgeTile.currentFlueBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.reforgeTile.flueBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.reforgeTile.forgeBuildTime);
        par1ICrafting.sendProgressBarUpdate(this, 3, this.reforgeTile.temperature);
    }

    @Override
    public void updateProgressBar(int par1, int par2) {
        if (par1 == 0)
            this.reforgeTile.currentFlueBurnTime = par2;


        if (par1 == 1)
            this.reforgeTile.flueBurnTime = par2;


        if (par1 == 2)
            this.reforgeTile.forgeBuildTime = par2;

        if (par1 == 3)
            this.reforgeTile.temperature = par2;
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (Object crafter : this.crafters) {
            ICrafting iCrafting = (ICrafting) crafter;

            if (this.lastCurrentFlueBurnTime != this.reforgeTile.currentFlueBurnTime) {
                iCrafting.sendProgressBarUpdate(this, 0, this.reforgeTile.currentFlueBurnTime);
            }

            if (this.lastFlueBurnTime != this.reforgeTile.flueBurnTime) {
                iCrafting.sendProgressBarUpdate(this, 1, this.reforgeTile.flueBurnTime);
            }

            if (this.lastForgeBuildTime != this.reforgeTile.forgeBuildTime) {
                iCrafting.sendProgressBarUpdate(this, 2, this.reforgeTile.forgeBuildTime);
            }

            if (this.lastTemperature != this.reforgeTile.temperature) {
                iCrafting.sendProgressBarUpdate(this, 3, this.reforgeTile.temperature);
            }
        }

        this.lastCurrentFlueBurnTime = this.reforgeTile.currentFlueBurnTime;
        this.lastFlueBurnTime = this.reforgeTile.flueBurnTime;
        this.lastForgeBuildTime = this.reforgeTile.forgeBuildTime;
        this.lastTemperature = this.reforgeTile.temperature;
    }




    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int index) {
        ItemStack o = null;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack slotStack = slot.getStack();
            o = slotStack.copy();

            if (index < this.inventorySlots.size()){
                if (!this.mergeItemStack(slotStack, this.inventorySlots.size(), this.inventorySlots.size(), false)){
                    return null;
                }
            } else if (!this.mergeItemStack(slotStack, 0, this.inventorySlots.size(), false)) {
                return null;
            }

            if (slotStack.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }

            if (slotStack.stackSize == o.stackSize) {
                return null;
            }

        }

        return o;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.reforgeTile.isUseableByPlayer(entityPlayer);
//                this.world.getBlock(this.blockX, this.blockY, this.blockZ) instanceof ControllerBlock
//                && this.world.getBlockTileEntity(this.blockX, this.blockY, this.blockZ) instanceof ReforgeTileEntity
//                && player.getDistanceSq((double) this.blockX + 0.5D, (double) this.blockY + 0.5D, (double) this.blockZ + 0.5D) <= 64.0D;
    }

}
