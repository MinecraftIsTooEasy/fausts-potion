package huix.faustspotion.game_objects.inventory.slot;

import huix.faustspotion.game_objects.tileentity.ReforgeTileEntity;
import net.minecraft.IInventory;
import net.minecraft.ItemStack;
import net.minecraft.Slot;

public class FuelSlot extends Slot {

    private final ReforgeTileEntity reforgeTile;

    public FuelSlot(IInventory inventory, int slot_index, int display_x, int display_y, ReforgeTileEntity reforgeTile) {
        super(inventory, slot_index, display_x, display_y);
        this.reforgeTile = reforgeTile;

    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        int temperature = this.reforgeTile.temperature;
        int heat_level = this.reforgeTile.getItemHeatLevel(itemStack);
        if (temperature <= 300 && heat_level == 1) {
            return super.isItemValid(itemStack);
        } else if (300 < temperature && temperature <= 1200 && heat_level == 2) {
            return super.isItemValid(itemStack);
        } else if (1200 < temperature && temperature <= 1500  && heat_level == 3) {
            return super.isItemValid(itemStack);
        } else if (1500 < temperature && temperature <= 3000 && heat_level == 4) {
            return super.isItemValid(itemStack);
        }

        return false;
    }
}
