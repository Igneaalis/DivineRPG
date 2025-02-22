package divinerpg.entities.projectile;

import net.minecraft.world.phys.HitResult;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class EntityZoragonBomb extends DivineThrowable {

    public EntityZoragonBomb(EntityType<? extends ThrowableProjectile> type, Level world) {
        super(type, world);
    }

    public EntityZoragonBomb(EntityType<? extends ThrowableProjectile> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world);
    }

    public EntityZoragonBomb(EntityType<? extends ThrowableProjectile> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

    @Override
    protected void onHit(HitResult rayTraceResult) {
        if(tickCount != 1 || tickCount != 0) {
            if (!this.level.isClientSide) {
                this.level.explode(this, this.xo, this.yo, this.zo, 3, false, Explosion.BlockInteraction.BREAK);
                this.kill();
            }
        }
    }
}
