package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.*;

import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;

import divinerpg.DivineRPG;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.ThrowableProjectile;

public class RenderDivineProjectile<T extends ThrowableProjectile> extends EntityRenderer<T> {
    protected final ResourceLocation TEXTURE;
    protected final RenderType renderType;
    
    public RenderDivineProjectile(final Context context, final String name) {
    	this(context, new ResourceLocation(DivineRPG.MODID, "textures/projectiles/" + name + ".png"));
    }
    public RenderDivineProjectile(final Context context) {
    	this(context, new ResourceLocation("textures/particle/generic_0.png"));
    }
    public RenderDivineProjectile(final Context context, final ResourceLocation texture) {
    	super(context);
    	this.TEXTURE = texture;
    	this.renderType = RenderType.entityCutoutNoCull(texture);
    }

    @Override
    public void render(T entity, float yaw, float partialTicks, PoseStack matrix, MultiBufferSource buffer, int packedLight) {
        super.render(entity, yaw, partialTicks, matrix, buffer, packedLight);
        matrix.pushPose();
        matrix.scale(0.5f, 0.5f, 0.5f);
        matrix.mulPose(this.entityRenderDispatcher.cameraOrientation());
        matrix.mulPose(Vector3f.YP.rotationDegrees(180.0F));
        PoseStack.Pose matrixEntry = matrix.last();
        Matrix4f matrix4f = matrixEntry.pose();
        Matrix3f normal = matrixEntry.normal();
        VertexConsumer vertexBuilder = buffer.getBuffer(renderType);

        pos(vertexBuilder, matrix4f, normal, packedLight, 0, 0, 0, 1);
        pos(vertexBuilder, matrix4f, normal, packedLight, 1, 0, 1, 1);
        pos(vertexBuilder, matrix4f, normal, packedLight, 1, 1, 1, 0);
        pos(vertexBuilder, matrix4f, normal, packedLight, 0, 1, 0, 0);
        matrix.popPose();
    }

    private static void pos(VertexConsumer vertexBuilder, Matrix4f matrix4f, Matrix3f normal, int lightmapUV, float x, float y, float u, float v) {
        vertexBuilder.vertex(matrix4f, x - 0.5F, y - 0.25f, 0).color(255, 255, 255, 255).uv(u, v).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(lightmapUV).normal(normal, 0, 1, 0).endVertex();
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return TEXTURE;
    }
}