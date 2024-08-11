package huix.faustspotion.api;

import huix.faustpotion.game_objects.material.MaterialsKt;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.minecraft.Material;

import java.util.ArrayList;
import java.util.List;

public class ReforgeingRecipeManager {

    public static final ReforgeingRecipeManager instance = new ReforgeingRecipeManager();

    public List<ReforgeingRecipe> reforgeingRecipes = new ArrayList<>();

    private ReforgeingRecipeManager() {
        this.addReforgeingRecipe(new MaterialStack(MaterialsKt.Companion.getBronze(), 4), 800,
                new MaterialStack(Material.copper, 3), new MaterialStack(MaterialsKt.Companion.getTin(), 1));
        this.addReforgeingRecipe(new MaterialStack(MaterialsKt.Companion.getSteel(), 3), 1000,
                new MaterialStack(Material.coal, 1), new MaterialStack(Material.iron, 3));
    }

    public void addReforgeingRecipe(MaterialStack recipe_output, int min_temperature, Object ... objects) {
        ArrayList<MaterialStack> list = new ArrayList<>();
        for (Object o : objects) {
            if (o instanceof MaterialStack materialStack) {
                list.add(materialStack);
            }
        }

        this.reforgeingRecipes.add(new ReforgeingRecipe(list, recipe_output, min_temperature));
    }

}
