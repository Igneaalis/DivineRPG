package divinerpg.mixin;

import com.mojang.authlib.GameProfile;
import divinerpg.DivineRPG;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.ProfilePublicKey;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player {
    public ServerPlayerMixin(Level level, BlockPos blockPos, float f, GameProfile gameProfile, @Nullable ProfilePublicKey ppk) {
        super(level, blockPos, f, gameProfile, ppk);
    }

    @Inject(method = "startSleepInBed", at = @At(value = "RETURN", ordinal = 1))
    private void startSleepInBedMixin(CallbackInfo ci, BlockPos pos) {
        DivineRPG.LOGGER.info("startSleepInBedMixin!");
        this.setRespawnPosition(this.level.dimension(), pos, this.getYRot(), false, true);
    }
    @Shadow
    public abstract void setRespawnPosition(ResourceKey<Level> level, @javax.annotation.Nullable BlockPos pos, float f, boolean respawnForced, boolean setSpawnForced);
}
