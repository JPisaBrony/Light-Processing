
package LightProcessing.resources.mods.ltp.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelExtractor extends ModelBase
{
    ModelRenderer top;
    ModelRenderer bottom;
    ModelRenderer wall1;
    ModelRenderer wall2;
    ModelRenderer wall3;
    ModelRenderer wall4;
    ModelRenderer funnel;
    ModelRenderer beam;
    public static ModelRenderer slider1;
    public static ModelRenderer slider2;
    ModelRenderer output0;
    ModelRenderer output1;
    ModelRenderer output2;
    ModelRenderer output3;
    ModelRenderer output4;
    ModelRenderer base1;
    ModelRenderer base2;
    ModelRenderer base3;
    ModelRenderer base4;
  
  public ModelExtractor()
  {
    textureWidth = 64;
    textureHeight = 128;
    
      top = new ModelRenderer(this, 0, 0);
      top.addBox(-8F, 0F, -8F, 16, 1, 16);
      top.setRotationPoint(0F, 8F, 0F);
      top.setTextureSize(64, 128);
      top.mirror = true;
      setRotation(top, 0F, 0F, 0F);
      bottom = new ModelRenderer(this, 0, 0);
      bottom.addBox(-8F, 0F, -8F, 16, 1, 16);
      bottom.setRotationPoint(0F, 23F, 0F);
      bottom.setTextureSize(64, 128);
      bottom.mirror = true;
      setRotation(bottom, 0F, 0F, 0F);
      wall1 = new ModelRenderer(this, 0, 17);
      wall1.addBox(-8F, -1F, 0F, 18, 3, 1);
      wall1.setRotationPoint(-1F, 7F, -9F);
      wall1.setTextureSize(64, 128);
      wall1.mirror = true;
      setRotation(wall1, 0F, 0F, 0F);
      wall2 = new ModelRenderer(this, 0, 21);
      wall2.addBox(17F, -1F, -8F, 1, 3, 16);
      wall2.setRotationPoint(-9F, 7F, 0F);
      wall2.setTextureSize(64, 128);
      wall2.mirror = true;
      setRotation(wall2, 0F, 0F, 0F);
      wall3 = new ModelRenderer(this, 0, 17);
      wall3.addBox(-8F, -1F, 0F, 18, 3, 1);
      wall3.setRotationPoint(-1F, 7F, 8F);
      wall3.setTextureSize(64, 128);
      wall3.mirror = true;
      setRotation(wall3, 0F, 0F, 0F);
      wall4 = new ModelRenderer(this, 0, 21);
      wall4.addBox(0F, -1F, -8F, 1, 3, 16);
      wall4.setRotationPoint(-9F, 7F, 0F);
      wall4.setTextureSize(64, 128);
      wall4.mirror = true;
      setRotation(wall4, 0F, 0F, 0F);
      funnel = new ModelRenderer(this, 0, 59);
      funnel.addBox(-5F, -1F, -5F, 10, 2, 10);
      funnel.setRotationPoint(0F, 10F, 0F);
      funnel.setTextureSize(64, 128);
      funnel.mirror = true;
      setRotation(funnel, 0F, 0F, 0F);
      beam = new ModelRenderer(this, 0, 40);
      beam.addBox(-3F, -1F, -3F, 6, 13, 6);
      beam.setRotationPoint(0F, 11F, 0F);
      beam.setTextureSize(64, 128);
      beam.mirror = true;
      setRotation(beam, 0F, 0F, 0F);
      slider1 = new ModelRenderer(this, 0, 71);
      slider1.addBox(1F, -2F, -4F, 4, 4, 8);
      slider1.setRotationPoint(0F, 21F, 0F);
      slider1.setTextureSize(64, 128);
      slider1.mirror = true;
      setRotation(slider1, 0F, 0F, 0F);
      slider2 = new ModelRenderer(this, 24, 71);
      slider2.addBox(-5F, -2F, -4F, 4, 4, 8);
      slider2.setRotationPoint(0F, 21F, 0F);
      slider2.setTextureSize(64, 128);
      slider2.mirror = true;
      setRotation(slider2, 0F, 0F, 0F);
      output0 = new ModelRenderer(this, 0, 89);
      output0.addBox(-1F, -1F, 0F, 2, 2, 1);
      output0.setRotationPoint(0F, 16F, -4F);
      output0.setTextureSize(64, 128);
      output0.mirror = true;
      setRotation(output0, 0F, 0F, 0F);
      output1 = new ModelRenderer(this, 0, 83);
      output1.addBox(-3F, -3F, -1F, 6, 2, 4);
      output1.setRotationPoint(0F, 20F, -7F);
      output1.setTextureSize(64, 128);
      output1.mirror = true;
      setRotation(output1, 0F, 0F, 0F);
      output2 = new ModelRenderer(this, 0, 83);
      output2.addBox(-3F, -3F, -1F, 6, 2, 4);
      output2.setRotationPoint(0F, 16F, -7F);
      output2.setTextureSize(64, 128);
      output2.mirror = true;
      setRotation(output2, 0F, 0F, 0F);
      output3 = new ModelRenderer(this, 0, 92);
      output3.addBox(-3F, -3F, -1F, 2, 2, 4);
      output3.setRotationPoint(4F, 18F, -7F);
      output3.setTextureSize(64, 128);
      output3.mirror = true;
      setRotation(output3, 0F, 0F, 0F);
      output4 = new ModelRenderer(this, 0, 92);
      output4.addBox(-3F, -3F, -1F, 2, 2, 4);
      output4.setRotationPoint(0F, 18F, -7F);
      output4.setTextureSize(64, 128);
      output4.mirror = true;
      setRotation(output4, 0F, 0F, 0F);
      base1 = new ModelRenderer(this, 0, 102);
      base1.addBox(0F, 0F, -8F, 2, 1, 14);
      base1.setRotationPoint(5F, 22F, 1F);
      base1.setTextureSize(64, 128);
      base1.mirror = true;
      setRotation(base1, 0F, 0F, 0F);
      base2 = new ModelRenderer(this, 0, 102);
      base2.addBox(0F, 0F, -8F, 2, 1, 14);
      base2.setRotationPoint(-7F, 22F, 1F);
      base2.setTextureSize(64, 128);
      base2.mirror = true;
      setRotation(base2, 0F, 0F, 0F);
      base3 = new ModelRenderer(this, 0, 98);
      base3.addBox(0F, 0F, -8F, 10, 1, 3);
      base3.setRotationPoint(-5F, 22F, 12F);
      base3.setTextureSize(64, 128);
      base3.mirror = true;
      setRotation(base3, 0F, 0F, 0F);
      base4 = new ModelRenderer(this, 0, 98);
      base4.addBox(0F, 0F, -7F, 10, 1, 3);
      base4.setRotationPoint(-5F, 22F, 0F);
      base4.setTextureSize(64, 128);
      base4.mirror = true;
      setRotation(base4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    top.render(f5);
    bottom.render(f5);
    wall1.render(f5);
    wall2.render(f5);
    wall3.render(f5);
    wall4.render(f5);
    funnel.render(f5);
    beam.render(f5);
    slider1.render(f5);
    slider2.render(f5);
    output0.render(f5);
    output1.render(f5);
    output2.render(f5);
    output3.render(f5);
    output4.render(f5);
    base1.render(f5);
    base2.render(f5);
    base3.render(f5);
    base4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  public void pump(long animationOffset){
	  final long CYCLE_TIME_IN_MS = 2000;
	  final long HALF_CYCLE_TIME_IN_MS = CYCLE_TIME_IN_MS / 2;
	  final float START_SLIDER_POS = 0.0F;
	  final float MID_CYCLE_SLIDER_POS = -0.5F;
	  long time = (System.currentTimeMillis() + animationOffset) % CYCLE_TIME_IN_MS;
	  if (time < HALF_CYCLE_TIME_IN_MS) {
	    slider1.offsetY = START_SLIDER_POS + (time / (float)HALF_CYCLE_TIME_IN_MS) * (MID_CYCLE_SLIDER_POS - START_SLIDER_POS);
	  } else {
	    time -= HALF_CYCLE_TIME_IN_MS; 
	    slider1.offsetY = MID_CYCLE_SLIDER_POS + (time / (float)HALF_CYCLE_TIME_IN_MS) * (START_SLIDER_POS - MID_CYCLE_SLIDER_POS); 
	  }
	  slider2.offsetY = slider1.offsetY;
	}
  
}
