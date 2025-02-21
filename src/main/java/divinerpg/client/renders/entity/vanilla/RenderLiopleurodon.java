package divinerpg.client.renders.entity.vanilla;


import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Vector3f;
import divinerpg.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderLiopleurodon extends MobRenderer<EntityLiopleurodon, ModelLiopleurodon> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/liopleurodon.png");

    public RenderLiopleurodon(Context context) {
        super(context, new ModelLiopleurodon(context), 2.0F);
    }

    protected void scale(EntityLiopleurodon entity, PoseStack matrixStackIn, float partialTickTime) {
        if(entity instanceof EntityLiopleurodon){
            matrixStackIn.mulPose(Vector3f.XN.rotationDegrees(180));
            matrixStackIn.translate(0, 1.0F, 0);
        }
    }

    public ResourceLocation getTextureLocation(EntityLiopleurodon entity) {
        return TEXTURE;
    }
}