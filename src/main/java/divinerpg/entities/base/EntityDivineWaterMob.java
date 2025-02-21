package divinerpg.entities.base;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.ai.navigation.*;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class EntityDivineWaterMob extends WaterAnimal {


    public EntityDivineWaterMob(EntityType<? extends EntityDivineWaterMob> type, Level worldIn) {
        super(type, worldIn);
    }

    public boolean checkSpawnObstruction(LevelReader worldIn) {
        return worldIn.containsAnyLiquid(this.getBoundingBox()) && worldIn.noCollision(this);
    }

    public static AttributeSupplier.Builder attributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, (double)1.2F).add(Attributes.ATTACK_DAMAGE, 3.0D);
    }

    @Override
    protected void registerGoals() {
        addBasicAI();
        if(isAggressive()) {
            addAttackingAI();
        }
    }

    public boolean isAggressive() {
        return false;
    }
    protected void addBasicAI() {
        this.goalSelector.addGoal(1, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 10));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 32.0F));
        this.goalSelector.addGoal(8, new FollowBoatGoal(this));
        this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, Guardian.class, 8.0F, 1.0D, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, Guardian.class)).setAlertOthers());

    }
    protected void addAttackingAI() {
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_28332_, DifficultyInstance p_28333_, MobSpawnType p_28334_, @Nullable SpawnGroupData p_28335_, @Nullable CompoundTag p_28336_) {
        this.setAirSupply(this.getMaxAirSupply());
        this.setXRot(0.0F);
        return super.finalizeSpawn(p_28332_, p_28333_, p_28334_, p_28335_, p_28336_);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    protected void handleAirSupply(int p_28326_) {
    }

    protected PathNavigation createNavigation(Level p_28362_) {
        return new WaterBoundPathNavigation(this, p_28362_);
    }

    public int getMaxHeadXRot() {
        return 1;
    }

    public int getMaxHeadYRot() {
        return 1;
    }

    public void tick() {
        super.tick();
        if (this.onGround) {
            this.setDeltaMovement(this.getDeltaMovement().add((double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.2F), 0.5D, (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.2F)));
            this.setYRot(this.random.nextFloat() * 360.0F);
            this.onGround = false;
            this.hasImpulse = true;
        }

    }

    protected boolean closeToNextPos() {
        BlockPos blockpos = this.getNavigation().getTargetPos();
        return blockpos != null ? blockpos.closerToCenterThan(this.position(), 12.0D) : false;
    }

    public void travel(Vec3 p_28383_) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), p_28383_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(p_28383_);
        }

    }


}