package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import divinerpg.tiles.bosses.*;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class BlockModAltar extends BaseEntityBlock {

    public BlockModAltar() {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(6000000F, 6000000F).noOcclusion());
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        return Shapes.create(new AABB(0.0D, 0.0D, 0.0D, 1.0D, 0.9D, 1.0D));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dramix_altar")) ? new TileEntityDramixAltar(p_153215_, p_153216_) : new TileEntityParasectaAltar(p_153215_, p_153216_);
    }
}
