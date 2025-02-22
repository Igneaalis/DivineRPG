package divinerpg.entities.projectile;


import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class EntityWreckExplosiveShot extends DivineThrowable {


    public EntityWreckExplosiveShot(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityWreckExplosiveShot(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntityWreckExplosiveShot(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

    @Override
    protected void onHit(HitResult par1MovingObjectPosition) {
        if(tickCount != 1 || tickCount != 0) {
            if (!this.level.isClientSide) {
                this.kill();
                this.level.explode(this, this.xo, this.yo, this.zo, 3, false, Explosion.BlockInteraction.NONE);
            }
        }
    }

    @Override
    protected float getGravity()
    {
        return 0.0007F;
    }
}