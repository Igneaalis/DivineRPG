package divinerpg.entities.projectile;

import divinerpg.enums.*;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class EntityTwilightDemonShot extends EntityColoredBullet {


    public EntityTwilightDemonShot(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityTwilightDemonShot(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world, BulletType bulletType) {
        super(type, entity, world, bulletType);
    }

    @Override
    public float getGravity() {
        return 0;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide && this.tickCount > 20) {
            this.kill();
        }
    }

    @Override
    public void onHitEntity(EntityHitResult result) {
        if (tickCount != 1 || tickCount != 0) {
            if (result.getEntity() != null && result.getEntity() instanceof Player) {
                ((Player) result.getEntity()).addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0));
                ((Player) result.getEntity()).hurt(DamageSource.mobAttack((LivingEntity) this.getOwner()), 5);
            }
        }
    }
}