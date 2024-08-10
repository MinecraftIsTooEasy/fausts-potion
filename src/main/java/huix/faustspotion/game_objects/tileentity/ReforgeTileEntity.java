package huix.faustspotion.game_objects.tileentity;

import huix.faustspotion.api.MaterialStack;
import huix.faustspotion.api.ReforgeingRecipe;
import huix.faustspotion.api.ReforgeingRecipeManager;
import huix.faustspotion.game_objects.block.ControllerBlock;
import net.minecraft.*;

import java.util.Arrays;

public class ReforgeTileEntity extends TileEntity implements IInventory {

    private ItemStack[] reforgeContents = new ItemStack[7];

    public int forgeBuildTime;
    public int flueBurnTime;
    public int temperature = 0;
    public int currentFlueBurnTime;

    public int temperature_change_tick = 40;

    @Override
    public void updateEntity() {
        if (this.getControllerBlock().isActive) {
            if (!this.worldObj.isRemote && this.flueBurnTime != 1 && (this.isFlooded() || this.isSmotheredBySolidBlock())) {
                if (this.flueBurnTime > 0) {
                    if (this.isFlooded()) {
                        this.worldObj.blockFX(EnumBlockFX.smoke_and_steam, this.xCoord, this.yCoord, this.zCoord);
                    }
                }

                this.flueBurnTime = 0;
                this.forgeBuildTime = 0;
            } else {
                //temperature change
                if (this.flueBurnTime > 0) {
                    if (--this.temperature_change_tick == 0) {
                        if (this.temperature <= this.getControllerBlock().getMaxTemperature()) {
                            ++this.temperature;
//                        System.out.println(this.temperature);
                        }

                        this.temperature_change_tick = 30;
                    }

                    --this.flueBurnTime;
                } else {
                    if (this.temperature > 1 && --this.temperature_change_tick == 0) {
                        --this.temperature;
                        this.temperature_change_tick = 60;
                    }
                }

                if (!this.worldObj.isRemote) {
                    if (this.flueBurnTime == 0 || this.flueBurnTime <= 10) {
                        if (this.isItemValid(this.getItemHeatLevel(this.reforgeContents[3]))) {
                            this.currentFlueBurnTime = this.flueBurnTime = this.getItemBurnTime(this.reforgeContents[3]);

                            if (this.reforgeContents[3] != null) {
                                --this.reforgeContents[3].stackSize;

                                if (this.reforgeContents[3].stackSize == 0) {
                                    Item item = this.reforgeContents[3].getItem().getContainerItem();
                                    this.reforgeContents[3] = item != null ? new ItemStack(item) : null;
                                }
                            }
                        } else {
                            this.currentFlueBurnTime = this.flueBurnTime = this.getItemBurnTime(this.reforgeContents[4]);

                            if (this.reforgeContents[4] != null) {
                                --this.reforgeContents[4].stackSize;

                                if (this.reforgeContents[4].stackSize == 0) {
                                    Item item = this.reforgeContents[4].getItem().getContainerItem();
                                    this.reforgeContents[4] = item != null ? new ItemStack(item) : null;
                                }
                            }
//                        if (this.reforgeContents[4] == null) {
//                            this.reforgeContents[4] = this.reforgeContents[3];
//                        } else {
//                            this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.xCoord, this.yCoord, this.zCoord, this.reforgeContents[4]));
//                        }
//                        this.reforgeContents[3] = null;
                        }
                    }
                }

                if (this.isBurning()) {
                    this.reforgeing();
                } else {
                    this.forgeBuildTime = 0;

                }
            }
        }
    }

//    private int getAllNuggetsFromItem(int index) {
//        int count = 0;
//        if (this.reforgeContents[index] != null) {
//            ItemStack itemStack = this.reforgeContents[index];
//            Item item = itemStack.getItem();
//            if (item instanceof ItemIngot || (itemStack.isBlock() && itemStack.getItemAsBlock().getBlock() instanceof BlockOreStorage)) {
//                if (itemStack.isBlock()) {
//                    count = itemStack.stackSize * 81;
//                } else if (item instanceof ItemIngot) {
//                    count = itemStack.stackSize * 9;
//                } else {
//                    count = itemStack.stackSize;
//                }
//            }
//        }
//        return count;
//    }

    private boolean isBurning() {
        return this.flueBurnTime > 0;
    }

    private void reforgeing() {
        for (ReforgeingRecipe recipe : ReforgeingRecipeManager.instance.reforgeingRecipes) {
            if (recipe.recipe_material.size() == 2) {
                for (int i = 0; i <= 2; ++i) {
                    for (int j = 0; j <= 2; ++j) {
                        for (MaterialStack materialStack : recipe.recipe_material) {
                            if (materialStack != null) {
                                if (this.reforgeContents[i] != null && this.reforgeContents[j] != null) {
                                    ItemStack itemStack = this.reforgeContents[i];
                                    ItemStack itemStack1 = this.reforgeContents[j];

                                    ItemStack typeValid = this.isTypeValid(new int[]{i, j}, itemStack, itemStack1);

//                                    System.out.println(typeValid);
                                    if (typeValid == null) {
                                        return;
                                    }

                                    int count_0 = itemStack.stackSize;
                                    int count_1 = itemStack1.stackSize;

                                    int amount = recipe.recipe_material.get(0).amount;
                                    int amount1 = recipe.recipe_material.get(1).amount;

                                    if (count_0 >= amount && count_1 >= amount1) {
                                        if (itemStack.getMaterialForRepairs() == recipe.recipe_material.get(0).material &&
                                                itemStack1.getMaterialForRepairs() == recipe.recipe_material.get(1).material) {

                                            ++this.forgeBuildTime;

                                            if (this.forgeBuildTime == 6000) {
                                                this.forgeBuildTime = 0;

                                                ItemStack output = recipe.getRecipeOutput(this, typeValid);

                                                if (this.reforgeContents[5] == null) {
                                                    this.reforgeContents[5] = output.copy();
                                                } else {
                                                    this.reforgeContents[6] = output.copy();
                                                }

                                                output = null;

                                                int resultSize_0 = itemStack.stackSize - recipe.recipe_material.get(0).amount;
                                                if (resultSize_0 > 0) {
                                                    this.reforgeContents[i].setStackSize(resultSize_0);
                                                } else {
                                                    this.reforgeContents[i] = null;
                                                }

                                                int resultSize_1 = itemStack1.stackSize - recipe.recipe_material.get(1).amount;
                                                if (resultSize_1 > 0) {
                                                    this.reforgeContents[j].setStackSize(resultSize_1);
                                                } else {
                                                    this.reforgeContents[j] = null;
                                                }


                                                this.onInventoryChanged();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (recipe.recipe_material.size() == 3) {
                for (int i = 0; i <= 2; ++i) {
                    for (int j = 0; j <= 2; ++j) {
                        for (int k = 0; k <= 2; k++) {
                            for (MaterialStack materialStack : recipe.recipe_material) {
                                if (materialStack != null) {
                                    if (this.reforgeContents[i] != null && this.reforgeContents[j] != null && this.reforgeContents[k] != null) {
                                        ItemStack itemStack = this.reforgeContents[i];
                                        ItemStack itemStack1 = this.reforgeContents[j];
                                        ItemStack itemStack2 = this.reforgeContents[k];

                                        ItemStack typeValid = this.isTypeValid(new int[]{i, j, k}, itemStack, itemStack1, itemStack2);

                                        if (typeValid == null) {
                                            return;
                                        }

                                        int count_0 = itemStack.stackSize;
                                        int count_1 = itemStack1.stackSize;
                                        int count_2 = itemStack2.stackSize;

                                        int amount = recipe.recipe_material.get(0).amount;
                                        int amount1 = recipe.recipe_material.get(1).amount;
                                        int amount2 = recipe.recipe_material.get(2).amount;
                                        if (count_0 >= amount && count_1 >= amount1 && count_2 >= amount2) {
                                            if (itemStack.getMaterialForRepairs() == recipe.recipe_material.get(0).material &&
                                                    itemStack1.getMaterialForRepairs() == recipe.recipe_material.get(1).material &&
                                                    itemStack2.getMaterialForRepairs() == recipe.recipe_material.get(2).material) {


                                                ++this.forgeBuildTime;
                                                if (this.forgeBuildTime == 6000) {
                                                    this.forgeBuildTime = 0;

                                                    ItemStack output = recipe.getRecipeOutput(this, typeValid);

                                                    if (this.reforgeContents[5] == null) {
                                                        this.reforgeContents[5] = output.copy();
                                                    } else {
                                                        this.reforgeContents[6] = output.copy();
                                                    }

                                                    output = null;

                                                    int resultSize_0 = itemStack.stackSize - recipe.recipe_material.get(0).amount;
                                                    if (resultSize_0 > 0) {
                                                        this.reforgeContents[i].setStackSize(resultSize_0);
                                                    } else {
                                                        this.reforgeContents[i] = null;
                                                    }

                                                    int resultSize_1 = itemStack1.stackSize - recipe.recipe_material.get(1).amount;
                                                    if (resultSize_1 > 0) {
                                                        this.reforgeContents[j].setStackSize(resultSize_1);
                                                    } else {
                                                        this.reforgeContents[j] = null;
                                                    }

                                                    int resultSize_2 = itemStack2.stackSize - recipe.recipe_material.get(2).amount;
                                                    if (resultSize_2 > 0) {
                                                        this.reforgeContents[k].setStackSize(resultSize_2);
                                                    } else {
                                                        this.reforgeContents[k] = null;
                                                    }

                                                    this.onInventoryChanged();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private ItemStack isTypeValid(int[] value, ItemStack... itemStacks) {
        if (itemStacks.length == 2 && value.length == 2) {
            if (value[0] >= 2) {
                value[0] = 1;
            }

            if (value[1] >= 2) {
                value[1] = 1;
            }

            if (itemStacks[value[0]] != null && itemStacks[value[1]] != null) {
                if (itemStacks[value[0]].isBlock() && itemStacks[value[1]].isBlock()) {
                    return itemStacks[value[0]];
                } else {
                    Item item_0 = itemStacks[value[0]].getItem();
                    Item item_1 = itemStacks[value[1]].getItem();
                    if (item_0 instanceof ItemNugget && item_1 instanceof ItemNugget) {
                        return new ItemStack(item_0);
                    } else if (item_0 instanceof ItemIngot && item_1 instanceof ItemIngot) {
                        return new ItemStack(item_0);
                    }
                }
            }
        } else if (itemStacks.length == 3 && value.length == 3) {
            if (itemStacks[value[0]] != null && itemStacks[value[1]] != null && itemStacks[value[2]] != null) {
                if (itemStacks[value[0]].isBlock() && itemStacks[value[1]].isBlock() && itemStacks[value[2]].isBlock()) {
                    return itemStacks[value[0]];
                } else {
                    Item item_0 = itemStacks[value[0]].getItem();
                    Item item_1 = itemStacks[value[1]].getItem();
                    Item item_2 = itemStacks[value[2]].getItem();
                    if (item_0 instanceof ItemNugget && item_1 instanceof ItemNugget && item_2 instanceof ItemNugget) {
                        return new ItemStack(item_0);
                    } else if (item_0 instanceof ItemIngot && item_1 instanceof ItemIngot && item_2 instanceof ItemIngot) {
                        return new ItemStack(item_0);
                    }
                }
            }
        }
        return null;
    }


//    private void costItems(ReforgeingRecipe recipe) {
//
//
//    }


    private boolean isItemValid(int heat_level) {
        if (this.temperature <= 300 && heat_level == 1) {
            return true;
        } else if (300 < this.temperature && this.temperature <= 1200 && heat_level == 2) {
            return true;
        } else if (1200 < this.temperature && this.temperature <= 1500  && heat_level == 3) {
            return true;
        } else
            return 1500 < this.temperature && this.temperature <= 3000 && heat_level == 4;
    }

    public int getItemBurnTime(ItemStack par0ItemStack) {
        return par0ItemStack == null ? 0 : par0ItemStack.getItem().getBurnTime(par0ItemStack);
    }

    public boolean isFlooded() {
        return this.getControllerBlock() != null &&
                this.worldObj.getNeighborBlockMaterial(this.xCoord, this.yCoord, this.zCoord, this.getControllerBlock()
                        .getDirectionFacing(this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord))) == Material.water;
    }

    public boolean isSmotheredBySolidBlock() {
        if (this.getControllerBlock() == null) {
            return false;
        } else {
            EnumFace facing = this.getControllerBlock().getDirectionFacing(this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord)).getFace();
            int[] neighbor_coords = World.getNeighboringBlockCoords(this.xCoord, this.yCoord, this.zCoord, facing);
            return this.worldObj.isBlockFaceFlatAndSolid(neighbor_coords[0], neighbor_coords[1], neighbor_coords[2], facing.getOpposite());
        }
    }


    public ControllerBlock getControllerBlock() {
        return (ControllerBlock)this.getBlockType();
    }

    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("ForgeTime", (short) this.forgeBuildTime);
        par1NBTTagCompound.setShort("FlueBurnTime", (short) this.flueBurnTime);
        par1NBTTagCompound.setShort("CurrentForgeTime", (short) this.currentFlueBurnTime);

        NBTTagList var2 = new NBTTagList();
        for (int i = 0; i < this.reforgeContents.length; ++i) {
            if (this.reforgeContents[i] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte) i);
                this.reforgeContents[i].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        par1NBTTagCompound.setTag("Items", var2);
        par1NBTTagCompound.setInteger("Temperature", this.temperature);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList items = par1NBTTagCompound.getTagList("Items");
        this.reforgeContents = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < items.tagCount(); ++i) {
            NBTTagCompound var4 = (NBTTagCompound)items.tagAt(i);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.reforgeContents.length) {
                this.reforgeContents[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.forgeBuildTime = par1NBTTagCompound.getShort("ForgeTime");
        this.flueBurnTime = par1NBTTagCompound.getShort("FlueBurnTime");
        this.currentFlueBurnTime = par1NBTTagCompound.getShort("CurrentForgeTime");
        this.temperature = par1NBTTagCompound.getInteger("Temperature");
    }

    public int getItemHeatLevel(ItemStack item_stack) {
        return item_stack == null ? 0 : item_stack.getItem().getHeatLevel(item_stack);
    }

    public int getBuildProgressScaled(int scaled) {
        return this.forgeBuildTime * scaled / 6000;
    }

    public int getTemperatureProgressScaled(int scaled) {
        return this.temperature * scaled / 5000;
    }

    @Override
    public String getUnlocalizedInvName() {
        return this.getBlockType().getUnlocalizedName() + ".reforge";
    }

    @Override
    public int getSizeInventory() {
        return this.reforgeContents.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.reforgeContents[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (this.reforgeContents[i] != null) {
            ItemStack var3;

            if (this.reforgeContents[i].stackSize <= j) {
                var3 = this.reforgeContents[i];
                this.reforgeContents[i] = null;
            } else {
                var3 = this.reforgeContents[i].splitStack(j);

                if (this.reforgeContents[i].stackSize == 0) {
                    this.reforgeContents[i] = null;
                }

            }
            this.onInventoryChanged();
            return var3;
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if (this.reforgeContents[i] != null) {
            ItemStack var2 = this.reforgeContents[i];
            this.reforgeContents[i] = null;
            return var2;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {
        this.reforgeContents[i] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }

        this.onInventoryChanged();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return  entityPlayer.getWorld().getBlock(this.xCoord, this.yCoord, this.zCoord) instanceof ControllerBlock
                && entityPlayer.getWorld().getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) instanceof ReforgeTileEntity
                && entityPlayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openChest() {}

    @Override
    public void closeChest() {}

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return true;
    }

    @Override
    public void destroyInventory() {
        Arrays.fill(this.reforgeContents, null);
    }
}
