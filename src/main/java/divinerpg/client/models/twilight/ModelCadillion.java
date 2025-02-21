package divinerpg.client.models.twilight;

import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.base.EntityDivineMonster;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelCadillion<T extends EntityDivineMonster> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("cadillion");
	private final ModelPart Head, Body, FrontRightLeg, FrontLeftLeg, BackRightLeg, BackLeftLeg;

	public ModelCadillion(Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(33, 33).addBox(-4.0F, -5.8F, -5.7F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(54, 12).addBox(-3.0F, -2.8F, -8.7F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.8F, -8.3F));

		Head.addOrReplaceChild("Horn_r1", CubeListBuilder.create().texOffs(14, 56).addBox(-1.0F, -7.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.7528F, -4.4743F, 0.3927F, 0.0F, 0.0F));

		Head.addOrReplaceChild("RightEar_r1", CubeListBuilder.create().texOffs(55, 31).addBox(0.0F, -6.47F, 1.0F, 6.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(38, 56).addBox(0.0F, -6.47F, 0.99F, 6.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -2.8F, -1.7F, 0.0F, 0.0F, -0.1309F));

		Head.addOrReplaceChild("LeftEar_r1", CubeListBuilder.create().texOffs(1, 56).addBox(-1.0F, -7.0F, 1.0F, 6.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 56).addBox(-1.0F, -7.0F, 0.99F, 6.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.8F, -1.7F, 0.0F, 0.0F, 0.1309F));

		Head.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(0, 15).addBox(-3.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.7F, -7.2F));

		partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 31).addBox(-4.0F, -4.5F, -8.75F, 8.0F, 8.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.5F, -5.5F, -9.25F, 11.0F, 12.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.5F, 0.75F));

		partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(50, 50).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, -6.0F));

		partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(41, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 13.0F, -6.0F));

		partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, 8.0F));

		partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(0, 31).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 13.0F, 8.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float)Math.PI);
        this.Head.xRot = headPitch / (180F / (float)Math.PI);
        
        this.FrontLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * limbSwingAmount);
        this.FrontRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * limbSwingAmount);
        this.BackLeftLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F) * limbSwingAmount);
        this.BackRightLeg.xRot = (float) (Math.cos(limbSwing * 0.6662F + Math.PI) * limbSwingAmount);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}