package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Vector3f;
import divinerpg.DivineRPG;
import divinerpg.blocks.arcana.BlockArcaniumExtractor;
import divinerpg.client.models.block.ModelArcaniumExtractor;
import divinerpg.tiles.furnace.TileEntityArcaniumExtractor;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.resources.ResourceLocation;

public class RenderArcaniumExtractor implements BlockEntityRenderer<TileEntityArcaniumExtractor> {
    private ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/model/arcanium_extractor.png");

    private final ModelArcaniumExtractor<?> model;
    public RenderArcaniumExtractor(BlockEntityRendererProvider.Context context) {
        this.model = new ModelArcaniumExtractor<>(context.bakeLayer(ModelArcaniumExtractor.LAYER_LOCATION));
    }

    @Override
    public void render(TileEntityArcaniumExtractor te, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 0D, 0.5D);
        poseStack.mulPose(Vector3f.YP.rotationDegrees(te.getBlockState().getValue(BlockArcaniumExtractor.FACING).toYRot()));
        VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(TEXTURE));
        model.renderToBuffer(poseStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();
    }
}
