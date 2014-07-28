package LightProcessing.common.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStabilizer extends ModelBase
{
    ModelRenderer Base;
    ModelRenderer Post;
    ModelRenderer Strut1;
    ModelRenderer Strut2;
    ModelRenderer Strut3;
    ModelRenderer Strut4;
    ModelRenderer Support1;
    ModelRenderer Support2;
    ModelRenderer Support3;
    ModelRenderer Support4;
    ModelRenderer Brace1;
    ModelRenderer Brace2;
    ModelRenderer Brace3;
    ModelRenderer Brace4;
    ModelRenderer Top;
    ModelRenderer TopSupport1;
    ModelRenderer TopSupport2;
    ModelRenderer TopSupport3;
    ModelRenderer TopSupport4;
  
  public ModelStabilizer()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(-4F, 0F, -4F, 8, 1, 8);
      Base.setRotationPoint(0F, 23F, 0F);
      Base.setTextureSize(128, 128);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Post = new ModelRenderer(this, 0, 9);
      Post.addBox(-1F, 0F, -1F, 2, 9, 2);
      Post.setRotationPoint(0F, 14F, 0F);
      Post.setTextureSize(128, 128);
      Post.mirror = true;
      setRotation(Post, 0F, 0F, 0F);
      Strut1 = new ModelRenderer(this, 8, 9);
      Strut1.addBox(-0.5F, 0F, -0.5F, 1, 9, 1);
      Strut1.setRotationPoint(0F, 15.5F, 0F);
      Strut1.setTextureSize(128, 128);
      Strut1.mirror = true;
      setRotation(Strut1, -0.4014257F, 0F, 0F);
      Strut2 = new ModelRenderer(this, 8, 9);
      Strut2.addBox(-0.5F, 0F, -0.5F, 1, 9, 1);
      Strut2.setRotationPoint(0F, 15.5F, 0F);
      Strut2.setTextureSize(128, 128);
      Strut2.mirror = true;
      setRotation(Strut2, 0.4014257F, 0F, 0F);
      Strut3 = new ModelRenderer(this, 8, 9);
      Strut3.addBox(-0.5F, 0F, -0.5F, 1, 9, 1);
      Strut3.setRotationPoint(0F, 15.5F, 0F);
      Strut3.setTextureSize(128, 128);
      Strut3.mirror = true;
      setRotation(Strut3, 0F, 0F, -0.4014257F);
      Strut4 = new ModelRenderer(this, 8, 9);
      Strut4.addBox(-0.5F, 0F, -0.5F, 1, 9, 1);
      Strut4.setRotationPoint(0F, 15.5F, 0F);
      Strut4.setTextureSize(128, 128);
      Strut4.mirror = true;
      setRotation(Strut4, 0F, 0F, 0.4014257F);
      Support1 = new ModelRenderer(this, 0, 20);
      Support1.addBox(-0.5F, 0F, -0.5F, 1, 9, 1);
      Support1.setRotationPoint(0F, 15.5F, 0F);
      Support1.setTextureSize(128, 128);
      Support1.mirror = true;
      setRotation(Support1, 0F, -0.7853982F, 1.047198F);
      Support2 = new ModelRenderer(this, 0, 20);
      Support2.addBox(-0.5F, 0F, -0.5F, 1, 9, 1);
      Support2.setRotationPoint(0F, 15.5F, 0F);
      Support2.setTextureSize(128, 128);
      Support2.mirror = true;
      setRotation(Support2, 0F, 0.7853982F, 1.047198F);
      Support3 = new ModelRenderer(this, 0, 20);
      Support3.addBox(-0.5F, 0F, -0.5F, 1, 9, 1);
      Support3.setRotationPoint(0F, 15.5F, 0F);
      Support3.setTextureSize(128, 128);
      Support3.mirror = true;
      setRotation(Support3, 0F, 2.356194F, 1.047198F);
      Support4 = new ModelRenderer(this, 0, 20);
      Support4.addBox(-0.5F, 0F, -0.5F, 1, 9, 1);
      Support4.setRotationPoint(0F, 15.5F, 0F);
      Support4.setTextureSize(128, 128);
      Support4.mirror = true;
      setRotation(Support4, 0F, -2.356194F, 1.032071F);
      Brace1 = new ModelRenderer(this, 4, 20);
      Brace1.addBox(-1F, 0F, -1F, 2, 6, 2);
      Brace1.setRotationPoint(-6F, 18F, 6F);
      Brace1.setTextureSize(128, 128);
      Brace1.mirror = true;
      setRotation(Brace1, 0F, 0F, 0F);
      Brace2 = new ModelRenderer(this, 5, 20);
      Brace2.addBox(-1F, 0F, -1F, 2, 6, 2);
      Brace2.setRotationPoint(-6F, 18F, -6F);
      Brace2.setTextureSize(128, 128);
      Brace2.mirror = true;
      setRotation(Brace2, 0F, 0F, 0F);
      Brace3 = new ModelRenderer(this, 5, 20);
      Brace3.addBox(-1F, 0F, -1F, 2, 6, 2);
      Brace3.setRotationPoint(6F, 18F, -6F);
      Brace3.setTextureSize(128, 128);
      Brace3.mirror = true;
      setRotation(Brace3, 0F, 0F, 0F);
      Brace4 = new ModelRenderer(this, 5, 20);
      Brace4.addBox(-1F, 0F, -1F, 2, 6, 2);
      Brace4.setRotationPoint(6F, 18F, 6F);
      Brace4.setTextureSize(128, 128);
      Brace4.mirror = true;
      setRotation(Brace4, 0F, 0F, 0F);
      Top = new ModelRenderer(this, 32, 0);
      Top.addBox(-8F, 0F, -8F, 16, 1, 16);
      Top.setRotationPoint(0F, 8F, 0F);
      Top.setTextureSize(128, 128);
      Top.mirror = true;
      setRotation(Top, 0F, 0F, 0F);
      TopSupport1 = new ModelRenderer(this, 0, 20);
      TopSupport1.addBox(-0.5F, 0F, -0.5F, 1, 9, 1);
      TopSupport1.setRotationPoint(0F, 15.5F, 0F);
      TopSupport1.setTextureSize(128, 128);
      TopSupport1.mirror = true;
      setRotation(TopSupport1, 0F, 2.356194F, 2.460914F);
      TopSupport2 = new ModelRenderer(this, 0, 20);
      TopSupport2.addBox(-0.5F, 0F, -0.5F, 1, 9, 1);
      TopSupport2.setRotationPoint(0F, 15.5F, 0F);
      TopSupport2.setTextureSize(128, 128);
      TopSupport2.mirror = true;
      setRotation(TopSupport2, 0F, -0.7853982F, 2.460914F);
      TopSupport3 = new ModelRenderer(this, 0, 20);
      TopSupport3.addBox(-0.5F, 0F, -0.5F, 1, 9, 1);
      TopSupport3.setRotationPoint(0F, 15.5F, 0F);
      TopSupport3.setTextureSize(128, 128);
      TopSupport3.mirror = true;
      setRotation(TopSupport3, 0F, 0.7853982F, 2.460914F);
      TopSupport4 = new ModelRenderer(this, 0, 20);
      TopSupport4.addBox(-0.5F, 0F, -0.5F, 1, 9, 1);
      TopSupport4.setRotationPoint(0F, 15.5F, 0F);
      TopSupport4.setTextureSize(128, 128);
      TopSupport4.mirror = true;
      setRotation(TopSupport4, 0F, -2.356194F, 2.460914F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    Post.render(f5);
    Strut1.render(f5);
    Strut2.render(f5);
    Strut3.render(f5);
    Strut4.render(f5);
    Support1.render(f5);
    Support2.render(f5);
    Support3.render(f5);
    Support4.render(f5);
    Brace1.render(f5);
    Brace2.render(f5);
    Brace3.render(f5);
    Brace4.render(f5);
    Top.render(f5);
    TopSupport1.render(f5);
    TopSupport2.render(f5);
    TopSupport3.render(f5);
    TopSupport4.render(f5);
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

}
