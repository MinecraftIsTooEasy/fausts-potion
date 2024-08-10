package huix.faustspotion.api;

import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.minecraft.Material;

import java.util.ArrayList;
import java.util.List;

public class ReforgeingRecipeManager {

    public static final ReforgeingRecipeManager instance = new ReforgeingRecipeManager();

    public List<ReforgeingRecipe> reforgeingRecipes = new ArrayList<>();

    private ReforgeingRecipeManager() {
        this.addReforgeingRecipe(new MaterialStack(Material.adamantium, 3), 2000,
                new MaterialStack(Material.copper, 2), new MaterialStack(Material.silver, 1));
        this.addReforgeingRecipe(new MaterialStack(Material.mithril, 3), 0,
                new MaterialStack(Material.copper, 2), new MaterialStack(Material.ancient_metal, 1),
                new MaterialStack(Material.adamantium, 1));
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
