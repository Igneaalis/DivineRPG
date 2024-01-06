package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.*;
import net.minecraft.world.level.Level;

public class EntityLiopleurodon extends EntityDivineWaterMob {

    public EntityLiopleurodon(EntityType<? extends EntityLiopleurodon> type, Level worldIn) {
        super(type, worldIn);
        //Entity, maxTurnX, maxTurnY, inWaterSpeedModifier, outsideWaterSpeedModifier
        this.moveControl = new SmoothSwimmingMoveControl(this, 1, 1, 0.3F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.7F;
    }

    @Override
    public boolean isAggressive() {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.LIOPLEURODON.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LIOPLEURODON_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.LIOPLEURODON_HURT.get();
    }

}