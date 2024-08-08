package huix.faustspotion.injected_interfaces;

import net.minecraft.Block;
import net.minecraft.CreativeTabs;
import net.minecraft.Item;

public interface IIItemRegistryEvent {

    default Item registerWithoutResource(String namespace, String unlocalized_name, Item item, CreativeTabs tab) {
        return item;
    }

    default void registerItemBlockWithoutResource(String namespace, String unlocalized_name, Block block) {

    }
}
