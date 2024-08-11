package huix.faustspotion.injected_interfaces;

import net.minecraft.Block;
import net.minecraft.CreativeTabs;
import net.minecraft.Item;
import net.minecraft.ItemBlock;

public interface IIItemRegistryEvent {

    default Item registerWithoutResource(String namespace, String unlocalized_name, Item item, CreativeTabs tab) {
        return item;
    }

    default void registerItemBlockWithoutResource(String namespace, String unlocalized_name, Block block) {

    }

    default void registerItemBlockWithCraftingDifficulty(String namespace, String resourceLocation, Block block, float lowest_crafting_difficulty_to_produce) {

    }


}
