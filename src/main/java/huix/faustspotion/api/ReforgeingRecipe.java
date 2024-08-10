package huix.faustspotion.api;

import huix.faustpotion.game_objects.item.FPItemsKt;
import huix.faustpotion.game_objects.material.MaterialHelperKt;
import huix.faustspotion.game_objects.tileentity.ReforgeTileEntity;
import net.minecraft.Item;
import net.minecraft.ItemIngot;
import net.minecraft.ItemNugget;
import net.minecraft.ItemStack;

import java.util.List;

public class ReforgeingRecipe {

    private final MaterialStack recipeOutput;
    private final int minTemperature;
    public List<MaterialStack> recipe_material;

    public ReforgeingRecipe(List<MaterialStack> recipe_material, MaterialStack recipe_output, int min_temperature) {
        this.recipe_material = recipe_material;
        this.recipeOutput = recipe_output;
        this.minTemperature = min_temperature;
    }


    public ItemStack getRecipeOutput(ReforgeTileEntity reforgeTile, ItemStack stack) {
        if (reforgeTile.temperature >= this.minTemperature) {
            if (stack.isBlock()) {
                return new ItemStack(MaterialHelperKt.Companion.getBlockByMaterial(this.recipeOutput.material), this.recipeOutput.amount);
            } else if (stack.getItem() instanceof ItemNugget) {
                return new ItemStack(MaterialHelperKt.Companion.getNuggetByMaterial(this.recipeOutput.material), this.recipeOutput.amount);
            } else if (stack.getItem() instanceof ItemIngot) {
                return new ItemStack(MaterialHelperKt.Companion.getIngotByMaterial(this.recipeOutput.material), this.recipeOutput.amount);
            }
        }
        return new ItemStack(FPItemsKt.Companion.getScrap());
    }

}
