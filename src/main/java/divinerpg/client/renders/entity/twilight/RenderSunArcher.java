package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelSunArcher;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.eden.EntitySunArcher;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderSunArcher extends MobRenderer<EntitySunArcher, ModelSunArcher<EntitySunArcher>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/sun_archer.png");

    public RenderSunArcher(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelSunArcher<EntitySunArcher>(), 0.8F);
        this.addLayer(new SunArcherBowLayer(this));
    }

    @Override
    public ResourceLocation getEntityTexture(EntitySunArcher entity) {
        return TEXTURE;
    }

}