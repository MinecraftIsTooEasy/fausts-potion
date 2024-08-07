package huix.faustspotion.game_objects.block;

import net.minecraft.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public abstract class ControllerBlock extends BlockDirectionalWithTileEntity {

    protected final boolean isActive;
    protected Icon iconFront;


    protected ControllerBlock(Material material, boolean isActive) {
        super(IdUtil.getNextBlockID(), material, new BlockConstants());
        this.setMaxStackSize(1);
        this.setHardness(8.0F);
        this.setResistance(0.875F);
        this.setStepSound(Block.soundStoneFootstep);
        this.isActive = isActive;
    }

    @Override
    public boolean canBeCarried() {
        return !this.isActive;
    }

    @Override
    public boolean isValidMetadata(int metadata) {
        return metadata > 1 && metadata < 6;
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        if (!this.getTrueBlockSide(world, x, y, z, this.getBrickBlockID())) {
            return;
        }

        EnumFace frontFace = this.getFrontFace(world.getBlockMetadata(x, y, z));
        if (frontFace== EnumFace.EAST || frontFace== EnumFace.WEST) {
            int middle_block_x;
            int last_block_x;
            if (frontFace == EnumFace.EAST) {
                middle_block_x = x - 1;
                last_block_x = x - 2;
            } else {
                middle_block_x = x + 1;
                last_block_x = x + 2;
            }

            if (this.getTrueBlockForWE(world, middle_block_x, y - 1, z, this.getBrickBlockID()) &&
                    this.getTrueBlockForWE(world, middle_block_x, y + 1, z, this.getBrickBlockID()) &&
                    world.getBlock(middle_block_x, y, z) == this.getBrickBlockID() &&
                    this.getTrueBlockSide(world, middle_block_x, y, z, this.getBrickBlockID()) &&
                    world.getBlock(last_block_x , y, z) == this.getBrickBlockID() &&
                    this.getTrueBlockSide(world, last_block_x, y, z, this.getBrickBlockID())
            ) {
                world.setBlock(x, y, z, this.getActiveBlockID(), world.getBlockMetadata(x, y, z), 3);
            }
            return;
        }


        if (frontFace== EnumFace.NORTH || frontFace== EnumFace.SOUTH) {
            int middle_block_z;
            int last_block_z ;
            if (frontFace == EnumFace.SOUTH) {
                middle_block_z = z - 1;
                last_block_z = z - 2;
            } else {
                middle_block_z = z + 1;
                last_block_z = z + 2;
            }

            if (this.getTrueBlockForNS(world, x, y - 1, middle_block_z, this.getBrickBlockID()) &&
                    this.getTrueBlockForNS(world, x, y + 1, middle_block_z, this.getBrickBlockID()) &&
                    world.getBlock(x, y, middle_block_z) == this.getBrickBlockID() &&
                    this.getTrueBlockSide(world, x, y, middle_block_z, this.getBrickBlockID()) &&
                    world.getBlock(x , y, last_block_z) == this.getBrickBlockID() &&
                    this.getTrueBlockSide(world, x, y, last_block_z, this.getBrickBlockID())
            ) {
                world.setBlock(x, y, z, this.getActiveBlockID(), world.getBlockMetadata(x, y, z), 3);
            }
        }
    }

    protected boolean getTrueBlockSide(World world, int x, int y, int z, Block choose_block) {
        return (world.getBlock(x, y, z - 1) == choose_block && world.getBlock(x, y, z + 1) == choose_block)
                || (world.getBlock(x - 1, y, z) == choose_block && world.getBlock(x + 1, y, z) == choose_block);
    }

    protected boolean getTrueBlockForNS(World world, int x, int y, int z, Block choose_block) {
        int i;
        int j;

        for (i = 0; i < 2; ++i) {
            for (j = 0; j < 2; ++j) {
                if (world.getBlock(x - i, y, z + j) != choose_block) {
                    return false;
                }
                if (i != 0 || j != 0){
                    if (world.getBlock(x + i, y, z - j) != choose_block) {
                        return false;
                    }
                }
                if (i != 0 && j != 0){
                    if (world.getBlock(x + i, y, z + j) != choose_block) {
                        return false;
                    }
                    if (world.getBlock(x - i, y, z - j) != choose_block) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    protected boolean getTrueBlockForWE(World world, int x, int y, int z, Block choose_block) {
        int i;
        int j;

        for (i = 0; i < 2; ++i) {
            for (j = 0; j < 2; ++j) {
                if (world.getBlock(x - i, y, z + j) != choose_block) {
                    return false;
                }
                if (i != 0 || j != 0){
                    if (world.getBlock(x + i, y, z - j) != choose_block) {
                        return false;
                    }
                }
                if (i != 0 && j != 0){
                    if (world.getBlock(x + i, y, z + j) != choose_block) {
                        return false;
                    }
                    if (world.getBlock(x - i, y, z - j) != choose_block) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public abstract int getIdleBlockID();

    public abstract int getActiveBlockID();

    public abstract Block getBrickBlockID();

    @Override
    public int idPicked(World par1World, int par2, int par3, int par4) {
        return this.getIdleBlockID();
    }

    @Override
    public Icon getIcon(int par1, int par2) {
        return par1 != par2 ? this.blockIcon : this.iconFront;
    }

    public abstract void registerIcons(IconRegister iconRegister);

    @Override
    public TileEntity createNewTileEntity(World world) {
        return null;
    }

    @Override
    public EnumDirection getDirectionFacing(int metadata) {
        return this.getDirectionFacingStandard6(metadata);
    }

    @Override
    public String getNameDisambiguationForReferenceFile(int metadata) {
        return this.isActive ? "" : "idle";
    }

    @Override
    public int getMetadataForDirectionFacing(int metadata, EnumDirection direction) {
        return direction.isNorth() ? 2 : (direction.isSouth() ? 3 : (direction.isWest() ? 4 : (direction.isEast() ? 5 : -1)));
    }

}
