package huix.faustspotion.mixins.fml;

import huix.faustspotion.injected_interfaces.IIItemRegistryEvent;
import net.minecraft.Block;
import net.minecraft.CreativeTabs;
import net.minecraft.Item;
import net.minecraft.ItemBlock;
import net.xiaoyu233.fml.api.block.IBlock;
import net.xiaoyu233.fml.api.item.IItem;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin( ItemRegistryEvent.class )
public class ItemRegistryEventMixin implements IIItemRegistryEvent {

    @Unique
    @Override
    public Item registerWithoutResource(String namespace, String unlocalized_name, Item item, CreativeTabs tab) {
        item.setUnlocalizedName(unlocalized_name);
        ((IItem) item).setNamespace(namespace);
        item.setCreativeTab(tab);
        return item;
    }

    @Unique
    @Override
    public void registerItemBlockWithoutResource(String namespace, String unlocalized_name, Block block) {
        block.setUnlocalizedName(unlocalized_name);
        if (!((IBlock) block).hasNamespaceSet()) {
            ((IBlock) block).setNamespace(namespace);
        }

        Item item = (new ItemBlock(block)).setUnlocalizedName(unlocalized_name);
        ((IItem) item).setNamespace(namespace);
        item.setMaxStackSize(block.getItemStackLimit());
    }
}
