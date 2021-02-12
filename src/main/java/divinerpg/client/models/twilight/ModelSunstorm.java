package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelSunstorm<T extends Entity> extends SegmentedModel<T> {
    //fields
    ModelRenderer legR;
    ModelRenderer legL;
    ModelRenderer body;
    ModelRenderer armL;
    ModelRenderer armR;
    ModelRenderer staffPoleL;
    ModelRenderer staffCapL;
    ModelRenderer staffPoleR;
    ModelRenderer staffCapR;
    ModelRenderer neck;
    ModelRenderer head;
    ModelRenderer rayMid;
    ModelRenderer rayL;
    ModelRenderer rayR;
    ModelRenderer headSideL;
    ModelRenderer headSideR;
    ModelRenderer staffProng1L;
    ModelRenderer staffProng2L;
    ModelRenderer staffProng3L;
    ModelRenderer staffProng4L;
    ModelRenderer staffProng1R;
    ModelRenderer staffProng2R;
    ModelRenderer staffProng3R;
    ModelRenderer staffProng4R;
    ModelRenderer armSpikeL;
    ModelRenderer armSpikeR;
    ModelRenderer backSpine1;
    ModelRenderer backSpine2;
    ModelRenderer backSpine3;
  
  public ModelSunstorm()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      legR = new ModelRenderer(this, 0, 0);
      legR.addBox(-3F, 0F, -3F, 6, 16, 6);
      legR.setRotationPoint(-4F, 8F, 0F);
      legR.setTextureSize(128, 128);
      legR.mirror = true;
      setRotation(legR, 0F, 0F, 0F);
      legL = new ModelRenderer(this, 0, 0);
      legL.addBox(-3F, 0F, -3F, 6, 16, 6);
      legL.setRotationPoint(4F, 8F, 0F);
      legL.setTextureSize(128, 128);
      legL.mirror = true;
      setRotation(legL, 0F, 0F, 0F);
      body = new ModelRenderer(this, 24, 0);
      body.addBox(0F, 0F, 0F, 12, 20, 6);
      body.setRotationPoint(-6F, -12F, -3F);
      body.setTextureSize(128, 128);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      armL = new ModelRenderer(this, 0, 22);
      armL.addBox(-2F, 0F, -2F, 4, 16, 4);
      armL.setRotationPoint(6F, -10F, 0F);
      armL.setTextureSize(128, 128);
      armL.mirror = true;
      setRotation(armL, -1.047198F, 0F, 0F);
      armR = new ModelRenderer(this, 0, 22);
      armR.addBox(-2F, 0F, -2F, 4, 16, 4);
      armR.setRotationPoint(-6F, -10F, 0F);
      armR.setTextureSize(128, 128);
      armR.mirror = true;
      setRotation(armR, -1.047198F, 0F, 0F);
      staffPoleL = new ModelRenderer(this, 0, 104);
      staffPoleL.addBox(-1F, -9F, -17F, 2, 22, 2);
      staffPoleL.setRotationPoint(6F, -10F, 0F);
      staffPoleL.setTextureSize(128, 128);
      staffPoleL.mirror = true;
      setRotation(staffPoleL, 0.5235988F, 0F, 0F);
      staffCapL = new ModelRenderer(this, 8, 121);
      staffCapL.addBox(-3F, -7F, -19F, 6, 1, 6);
      staffCapL.setRotationPoint(6F, -10F, 0F);
      staffCapL.setTextureSize(128, 128);
      staffCapL.mirror = true;
      setRotation(staffCapL, 0.5235988F, 0F, 0F);
      staffPoleR = new ModelRenderer(this, 0, 104);
      staffPoleR.addBox(-1F, -9F, -17F, 2, 22, 2);
      staffPoleR.setRotationPoint(-6F, -10F, 0F);
      staffPoleR.setTextureSize(128, 128);
      staffPoleR.mirror = true;
      setRotation(staffPoleR, 0.5235988F, 0F, 0F);
      staffCapR = new ModelRenderer(this, 8, 121);
      staffCapR.addBox(-3F, -7F, -19F, 6, 1, 6);
      staffCapR.setRotationPoint(-6F, -10F, 0F);
      staffCapR.setTextureSize(128, 128);
      staffCapR.mirror = true;
      setRotation(staffCapR, 0.5235988F, 0F, 0F);
      neck = new ModelRenderer(this, 60, 0);
      neck.addBox(-3F, 0F, -3F, 6, 4, 6);
      neck.setRotationPoint(0F, -16F, 0F);
      neck.setTextureSize(128, 128);
      neck.mirror = true;
      setRotation(neck, 0F, 0F, 0F);
      head = new ModelRenderer(this, 60, 10);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, -16F, 0F);
      head.setTextureSize(128, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      rayMid = new ModelRenderer(this, 84, 0);
      rayMid.addBox(-2.5F, -15F, 0F, 5, 8, 1);
      rayMid.setRotationPoint(0F, -20F, 0F);
      rayMid.setTextureSize(128, 128);
      rayMid.mirror = true;
      setRotation(rayMid, 0F, 0F, 0F);
      rayL = new ModelRenderer(this, 84, 0);
      rayL.addBox(-2.5F, -15F, 0F, 5, 8, 1);
      rayL.setRotationPoint(0F, -20F, 0F);
      rayL.setTextureSize(128, 128);
      rayL.mirror = true;
      setRotation(rayL, 0F, 0F, 0.7853982F);
      rayR = new ModelRenderer(this, 84, 0);
      rayR.addBox(-2.5F, -15F, 0F, 5, 8, 1);
      rayR.setRotationPoint(0F, -20F, 0F);
      rayR.setTextureSize(128, 128);
      rayR.mirror = true;
      setRotation(rayR, 0F, 0F, -0.7853982F);
      headSideL = new ModelRenderer(this, 0, 67);
      headSideL.addBox(4F, -3F, -1F, 4, 2, 2);
      headSideL.setRotationPoint(0F, -16F, 0F);
      headSideL.setTextureSize(128, 128);
      headSideL.mirror = true;
      setRotation(headSideL, 0F, 0F, 0F);
      headSideR = new ModelRenderer(this, 0, 67);
      headSideR.addBox(-8F, -3F, -1F, 4, 2, 2);
      headSideR.setRotationPoint(0F, -16F, 0F);
      headSideR.setTextureSize(128, 128);
      headSideR.mirror = true;
      setRotation(headSideR, 0F, 0F, 0F);
      staffProng1L = new ModelRenderer(this, 32, 123);
      staffProng1L.addBox(2F, -11F, -14F, 1, 4, 1);
      staffProng1L.setRotationPoint(6F, -10F, 0F);
      staffProng1L.setTextureSize(128, 128);
      staffProng1L.mirror = true;
      setRotation(staffProng1L, 0.5235988F, 0F, 0F);
      staffProng2L = new ModelRenderer(this, 32, 123);
      staffProng2L.addBox(2F, -11F, -19F, 1, 4, 1);
      staffProng2L.setRotationPoint(6F, -10F, 0F);
      staffProng2L.setTextureSize(128, 128);
      staffProng2L.mirror = true;
      setRotation(staffProng2L, 0.5235988F, 0F, 0F);
      staffProng3L = new ModelRenderer(this, 32, 123);
      staffProng3L.addBox(-3F, -11F, -19F, 1, 4, 1);
      staffProng3L.setRotationPoint(6F, -10F, 0F);
      staffProng3L.setTextureSize(128, 128);
      staffProng3L.mirror = true;
      setRotation(staffProng3L, 0.5235988F, 0F, 0F);
      staffProng4L = new ModelRenderer(this, 32, 123);
      staffProng4L.addBox(-3F, -11F, -14F, 1, 4, 1);
      staffProng4L.setRotationPoint(6F, -10F, 0F);
      staffProng4L.setTextureSize(128, 128);
      staffProng4L.mirror = true;
      setRotation(staffProng4L, 0.5235988F, 0F, 0F);
      staffProng1R = new ModelRenderer(this, 32, 123);
      staffProng1R.addBox(2F, -11F, -14F, 1, 4, 1);
      staffProng1R.setRotationPoint(-6F, -10F, 0F);
      staffProng1R.setTextureSize(128, 128);
      staffProng1R.mirror = true;
      setRotation(staffProng1R, 0.5235988F, 0F, 0F);
      staffProng2R = new ModelRenderer(this, 32, 123);
      staffProng2R.addBox(2F, -11F, -19F, 1, 4, 1);
      staffProng2R.setRotationPoint(-6F, -10F, 0F);
      staffProng2R.setTextureSize(128, 128);
      staffProng2R.mirror = true;
      setRotation(staffProng2R, 0.5235988F, 0F, 0F);
      staffProng3R = new ModelRenderer(this, 32, 123);
      staffProng3R.addBox(-3F, -11F, -19F, 1, 4, 1);
      staffProng3R.setRotationPoint(-6F, -10F, 0F);
      staffProng3R.setTextureSize(128, 128);
      staffProng3R.mirror = true;
      setRotation(staffProng3R, 0.5235988F, 0F, 0F);
      staffProng4R = new ModelRenderer(this, 32, 123);
      staffProng4R.addBox(-3F, -11F, -14F, 1, 4, 1);
      staffProng4R.setRotationPoint(-6F, -10F, 0F);
      staffProng4R.setTextureSize(128, 128);
      staffProng4R.mirror = true;
      setRotation(staffProng4R, 0.5235988F, 0F, 0F);
      armSpikeL = new ModelRenderer(this, 0, 62);
      armSpikeL.addBox(2F, 6F, -1F, 6, 3, 2);
      armSpikeL.setRotationPoint(6F, -10F, 0F);
      armSpikeL.setTextureSize(128, 128);
      armSpikeL.mirror = true;
      setRotation(armSpikeL, -1.047198F, 0F, 0F);
      armSpikeR = new ModelRenderer(this, 0, 62);
      armSpikeR.addBox(-8F, 6F, -1F, 6, 3, 2);
      armSpikeR.setRotationPoint(-6F, -10F, 0F);
      armSpikeR.setTextureSize(128, 128);
      armSpikeR.mirror = true;
      setRotation(armSpikeR, -1.047198F, 0F, 0F);
      backSpine1 = new ModelRenderer(this, 0, 71);
      backSpine1.addBox(-1F, -7F, -1F, 2, 7, 2);
      backSpine1.setRotationPoint(0F, 5F, 2F);
      backSpine1.setTextureSize(128, 128);
      backSpine1.mirror = true;
      setRotation(backSpine1, -0.3839724F, 0F, 0F);
      backSpine2 = new ModelRenderer(this, 0, 71);
      backSpine2.addBox(-1F, -7F, -1F, 2, 7, 2);
      backSpine2.setRotationPoint(0F, -1F, 2F);
      backSpine2.setTextureSize(128, 128);
      backSpine2.mirror = true;
      setRotation(backSpine2, -0.3839724F, 0F, 0F);
      backSpine3 = new ModelRenderer(this, 0, 71);
      backSpine3.addBox(-1F, -7F, -1F, 2, 7, 2);
      backSpine3.setRotationPoint(0F, -7F, 2F);
      backSpine3.setTextureSize(128, 128);
      backSpine3.mirror = true;
      setRotation(backSpine3, -0.3839724F, 0F, 0F);
  }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(legR, legL, body, armL, armR, staffPoleL, staffCapL, staffPoleR, staffCapR, neck, head, rayMid, rayL, rayR, headSideL, headSideR, staffProng1L, staffProng2L, staffProng3L,
        staffProng4L, staffProng1R, staffProng2R, staffProng3R, staffProng4R, armSpikeL, armSpikeR, backSpine1, backSpine2, backSpine3);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(T e, float f, float f1, float f2, float f3, float f4)
  {
      //TODO - animate sunstorm arms
	this.legR.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.4F * f1);
	this.legL.rotateAngleX = (MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1);
  }

}
