package divinerpg.client.models.iceika;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import static divinerpg.util.ClientUtils.createLocation;

public class ModelSeng<T extends Entity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = createLocation("seng");
	private final ModelPart seng, head, frontRightLeg, frontLeftLeg, backRightLeg, backLeftLeg, tail;

	public ModelSeng(EntityRendererProvider.Context context) {
		ModelPart root = context.bakeLayer(LAYER_LOCATION);
		this.seng = root.getChild("seng");
		this.head = root.getChild("head");
		this.tail = root.getChild("tail");
		this.frontRightLeg = root.getChild("frontRightLeg");
		this.frontLeftLeg = root.getChild("frontLeftLeg");
		this.backRightLeg = root.getChild("backRightLeg");
		this.backLeftLeg = root.getChild("backLeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Seng = partdefinition.addOrReplaceChild("seng", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 14.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition Torso = Seng.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(52, 20).addBox(-4.0F, 1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(52, 20).addBox(2.0F, 1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -7.0F, -10.0F, 8.0F, 8.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 1.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(50, 48).addBox(-3.0F, -1.0F, -6.5F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 46).addBox(-4.0F, -7.0F, -3.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(47, 11).addBox(3.0F, -7.0F, -3.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(32, 52).addBox(-4.5F, -6.0F, -7.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-4.0F, -5.0F, -6.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(-4.0F, 2.0F, -6.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, -9.0F));

		PartDefinition FrontRightLeg = partdefinition.addOrReplaceChild("frontRightLeg", CubeListBuilder.create().texOffs(0, 39).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 11.0F, -5.0F));

		PartDefinition FrontLeftLeg = partdefinition.addOrReplaceChild("frontLeftLeg", CubeListBuilder.create().texOffs(28, 26).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 11.0F, -5.0F));

		PartDefinition BackRightLeg = partdefinition.addOrReplaceChild("backRightLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 12.0F, 8.0F));

		PartDefinition BackLeftLeg = partdefinition.addOrReplaceChild("backLeftLeg", CubeListBuilder.create().texOffs(16, 42).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 12.0F, 8.0F));

		PartDefinition Tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, 10.0F));

		PartDefinition TailSeg1 = Tail.addOrReplaceChild("TailSeg1", CubeListBuilder.create().texOffs(44, 26).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TailSeg2 = TailSeg1.addOrReplaceChild("TailSeg2", CubeListBuilder.create().texOffs(44, 33).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 2.0F));

		PartDefinition TailSeg3 = TailSeg2.addOrReplaceChild("TailSeg3", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 4.0F));

		PartDefinition TailClub = TailSeg3.addOrReplaceChild("TailClub", CubeListBuilder.create().texOffs(34, 0).addBox(0.0F, -3.0F, 1.3333F, 0.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(26, 0).addBox(-3.0F, 0.0F, 1.3333F, 6.0F, 0.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(38, 40).addBox(-1.0F, -1.0F, 1.3333F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.6667F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = headPitch * ((float)Math.PI / 180F);
		this.frontLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.backLeftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.frontRightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.backRightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.tail.xRot = ((float)Math.PI / 4F);
		this.tail.yRot = Mth.cos(ageInTicks * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		seng.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		frontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		frontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}