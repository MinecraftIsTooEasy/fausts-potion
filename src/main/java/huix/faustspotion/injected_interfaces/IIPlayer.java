package huix.faustspotion.injected_interfaces;

import huix.faustspotion.game_objects.tileentity.ReforgeTileEntity;

public interface IIPlayer {

    default void displayReforgeGui(int x, int y, int z, ReforgeTileEntity tileEntity){}

}
