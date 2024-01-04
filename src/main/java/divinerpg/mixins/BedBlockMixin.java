package divinerpg.mixins;

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

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(BedBlock.class)
public abstract class BedBlockMixin extends HorizontalDirectionalBlock {
    private BedBlockMixin(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Inject(method = "use", at=@At("HEAD"), cancellable = true)
    public void useMixin(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit, CallbackInfoReturnable<InteractionResult> cir) {
        if (level.isClientSide) {
            cir.setReturnValue(InteractionResult.CONSUME);
        } else {
            if (blockState.getValue(BedBlock.PART) != BedPart.HEAD) {
                pos = pos.relative((Direction)blockState.getValue(FACING));
                blockState = level.getBlockState(pos);
                if (!blockState.is((BedBlock)(Object)this)) {
                    cir.setReturnValue(InteractionResult.CONSUME);
                }
            }
            if ((Boolean)blockState.getValue(BedBlock.OCCUPIED)) {
                if (!this.kickVillagerOutOfBed(level, pos)) {
                    player.displayClientMessage(Component.translatable("block.minecraft.bed.occupied"), true);
                }
                cir.setReturnValue(InteractionResult.SUCCESS);
            } else {
                player.startSleepInBed(pos).ifLeft((reason) -> {
                    if (reason.getMessage() != null) {
                        player.displayClientMessage(reason.getMessage(), true);
                    }
                });
                cir.setReturnValue(InteractionResult.SUCCESS);
            }
        }
    }

    @Overwrite
    public static boolean canSetSpawn(Level p_49489_) { return true; }

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