package divinerpg.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;

import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(BedBlock.class)
public class BedMixin extends HorizontalDirectionalBlock {
    private BedMixin(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Overwrite
    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.CONSUME;
        } else {
            if (blockState.getValue(BedBlock.PART) != BedPart.HEAD) {
                pos = pos.relative((Direction)blockState.getValue(FACING));
                blockState = level.getBlockState(pos);
                if (!blockState.is(this)) {
                    return InteractionResult.CONSUME;
                }
            }
            if ((Boolean)blockState.getValue(BedBlock.OCCUPIED)) {
                if (!this.kickVillagerOutOfBed(level, pos)) {
                    player.displayClientMessage(Component.translatable("block.minecraft.bed.occupied"), true);
                }
                return InteractionResult.SUCCESS;
            } else {
                player.startSleepInBed(pos).ifLeft((reason) -> {
                    if (reason.getMessage() != null) {
                        player.displayClientMessage(reason.getMessage(), true);
                    }
                });
                return InteractionResult.SUCCESS;
            }
        }
    }

    @Unique
    private boolean kickVillagerOutOfBed(Level level, BlockPos pos) {
        List<Villager> list = level.getEntitiesOfClass(Villager.class, new AABB(pos), LivingEntity::isSleeping);
        if (list.isEmpty()) {
            return false;
        } else {
            ((Villager)list.get(0)).stopSleeping();
            return true;
        }
    }
}