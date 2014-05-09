package LightProcessing.resources.mods.ltp.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMachineCore extends ModelBase {

	// fields
	public static ModelRenderer top;
	public static ModelRenderer bottom;
	public static ModelRenderer beam1;
	public static ModelRenderer beam2;
	public static ModelRenderer beam3;
	public static ModelRenderer beam4;
	public static ModelRenderer support;
	public static ModelRenderer hub;
	public static ModelRenderer axel1;
	public static ModelRenderer gear11z;
	public static ModelRenderer gear12z;
	public static ModelRenderer axel2;
	public static ModelRenderer gear21z;
	public static ModelRenderer gear22z;
	public static ModelRenderer axel3;
	public static ModelRenderer gear31x;
	public static ModelRenderer gear32x;
	public static ModelRenderer axel4;
	public static ModelRenderer gear41x;
	public static ModelRenderer gear42x;

	public ModelMachineCore() {
		textureWidth = 64;
		textureHeight = 64;

		top = new ModelRenderer(this, 0, 0);
		top.addBox(-8F, 0F, -8F, 16, 1, 16);
		top.setRotationPoint(0F, 8F, 0F);
		top.setTextureSize(64, 64);
		top.mirror = true;
		setRotation(top, 0F, 0F, 0F);
		bottom = new ModelRenderer(this, 0, 0);
		bottom.addBox(-8F, 0F, -8F, 16, 1, 16);
		bottom.setRotationPoint(0F, 23F, 0F);
		bottom.setTextureSize(64, 64);
		bottom.mirror = true;
		setRotation(bottom, 0F, 0F, 0F);
		beam1 = new ModelRenderer(this, 0, 17);
		beam1.addBox(0F, -7F, 0F, 1, 14, 1);
		beam1.setRotationPoint(-8F, 16F, -8F);
		beam1.setTextureSize(64, 64);
		beam1.mirror = true;
		setRotation(beam1, 0F, 0F, 0F);
		beam2 = new ModelRenderer(this, 0, 17);
		beam2.addBox(0F, -7F, 0F, 1, 14, 1);
		beam2.setRotationPoint(-8F, 16F, 7F);
		beam2.setTextureSize(64, 64);
		beam2.mirror = true;
		setRotation(beam2, 0F, 0F, 0F);
		beam3 = new ModelRenderer(this, 0, 17);
		beam3.addBox(0F, -7F, 0F, 1, 14, 1);
		beam3.setRotationPoint(7F, 16F, -8F);
		beam3.setTextureSize(64, 64);
		beam3.mirror = true;
		setRotation(beam3, 0F, 0F, 0F);
		beam4 = new ModelRenderer(this, 0, 17);
		beam4.addBox(0F, -7F, 0F, 1, 14, 1);
		beam4.setRotationPoint(7F, 16F, 7F);
		beam4.setTextureSize(64, 64);
		beam4.mirror = true;
		setRotation(beam4, 0F, 0F, 0F);
		support = new ModelRenderer(this, 0, 42);
		support.addBox(-1F, -2F, -1F, 2, 14, 2);
		support.setRotationPoint(0F, 11F, 0F);
		support.setTextureSize(64, 64);
		support.mirror = true;
		setRotation(support, 0F, 0F, 0F);
		hub = new ModelRenderer(this, 8, 50);
		hub.addBox(-2F, -2F, -2F, 4, 4, 4);
		hub.setRotationPoint(0F, 16F, 0F);
		hub.setTextureSize(64, 64);
		hub.mirror = true;
		setRotation(hub, 0F, 0F, 0F);
		axel1 = new ModelRenderer(this, 0, 36);
		axel1.addBox(-1F, -1F, -1F, 2, 2, 4);
		axel1.setRotationPoint(0F, 16F, -5F);
		axel1.setTextureSize(64, 64);
		axel1.mirror = true;
		setRotation(axel1, 0F, 0F, 0F);
		gear11z = new ModelRenderer(this, 4, 17);
		gear11z.addBox(-5F, -5F, 0F, 10, 10, 1);
		gear11z.setRotationPoint(0F, 16F, -7F);
		gear11z.setTextureSize(64, 64);
		gear11z.mirror = true;
		setRotation(gear11z, 0F, 0F, 0.7853982F);
		gear12z = new ModelRenderer(this, 4, 17);
		gear12z.addBox(-5F, -5F, 0F, 10, 10, 1);
		gear12z.setRotationPoint(0F, 16F, -7F);
		gear12z.setTextureSize(64, 64);
		gear12z.mirror = true;
		setRotation(gear12z, 0F, 0F, 0F);
		axel2 = new ModelRenderer(this, 0, 36);
		axel2.addBox(-1F, -1F, -1F, 2, 2, 4);
		axel2.setRotationPoint(0F, 16F, 3F);
		axel2.setTextureSize(64, 64);
		axel2.mirror = true;
		setRotation(axel2, 0F, 0F, 0F);
		gear21z = new ModelRenderer(this, 4, 17);
		gear21z.addBox(-5F, -5F, 0F, 10, 10, 1);
		gear21z.setRotationPoint(0F, 16F, 6F);
		gear21z.setTextureSize(64, 64);
		gear21z.mirror = true;
		setRotation(gear21z, 0F, 0F, 0F);
		gear22z = new ModelRenderer(this, 4, 17);
		gear22z.addBox(-5F, -5F, 0F, 10, 10, 1);
		gear22z.setRotationPoint(0F, 16F, 6F);
		gear22z.setTextureSize(64, 64);
		gear22z.mirror = true;
		setRotation(gear22z, 0F, 0F, 0.7853982F);
		axel3 = new ModelRenderer(this, 0, 32);
		axel3.addBox(-1F, -1F, -1F, 4, 2, 2);
		axel3.setRotationPoint(3F, 16F, 0F);
		axel3.setTextureSize(64, 64);
		axel3.mirror = true;
		setRotation(axel3, 0F, 0F, 0F);
		gear31x = new ModelRenderer(this, 26, 17);
		gear31x.addBox(0F, -5F, -5F, 1, 10, 10);
		gear31x.setRotationPoint(6F, 16F, 0F);
		gear31x.setTextureSize(64, 64);
		gear31x.mirror = true;
		setRotation(gear31x, 0.3926991F, 0F, 0F);
		gear32x = new ModelRenderer(this, 26, 17);
		gear32x.addBox(0F, -5F, -5F, 1, 10, 10);
		gear32x.setRotationPoint(6F, 16F, 0F);
		gear32x.setTextureSize(64, 64);
		gear32x.mirror = true;
		setRotation(gear32x, -0.3926991F, 0F, 0F);
		axel4 = new ModelRenderer(this, 0, 32);
		axel4.addBox(-1F, -1F, -1F, 4, 2, 2);
		axel4.setRotationPoint(-5F, 16F, 0F);
		axel4.setTextureSize(64, 64);
		axel4.mirror = true;
		setRotation(axel4, 0F, 0F, 0F);
		gear41x = new ModelRenderer(this, 26, 17);
		gear41x.addBox(0F, -5F, -5F, 1, 10, 10);
		gear41x.setRotationPoint(-7F, 16F, 0F);
		gear41x.setTextureSize(64, 64);
		gear41x.mirror = true;
		setRotation(gear41x, -0.3926991F, 0F, 0F);
		gear42x = new ModelRenderer(this, 26, 17);
		gear42x.addBox(0F, -5F, -5F, 1, 10, 10);
		gear42x.setRotationPoint(-7F, 16F, 0F);
		gear42x.setTextureSize(64, 64);
		gear42x.mirror = true;
		setRotation(gear42x, 0.3926991F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		top.render(f5);
		bottom.render(f5);
		beam1.render(f5);
		beam2.render(f5);
		beam3.render(f5);
		beam4.render(f5);
		support.render(f5);
		hub.render(f5);
		axel1.render(f5);
		gear11z.render(f5);
		gear12z.render(f5);
		axel2.render(f5);
		gear21z.render(f5);
		gear22z.render(f5);
		axel3.render(f5);
		gear31x.render(f5);
		gear32x.render(f5);
		axel4.render(f5);
		gear41x.render(f5);
		gear42x.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	private static void addRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX += x;
		model.rotateAngleY += y;
		model.rotateAngleZ += z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	static float R = 0.05F;

	public static void rotate() {
		addRotation(axel1, 0, 0, R);
		addRotation(gear11z, 0, 0, R);
		addRotation(gear12z, 0, 0, R);
		addRotation(axel2, 0, 0, R * -1);
		addRotation(gear21z, 0, 0, R * -1);
		addRotation(gear22z, 0, 0, R * -1);
		addRotation(axel3, R, 0, 0);
		addRotation(gear31x, R, 0, 0);
		addRotation(gear32x, R, 0, 0);
		addRotation(axel4, R * -1, 0, 0);
		addRotation(gear41x, R * -1, 0, 0);
		addRotation(gear42x, R * -1, 0, 0);

	}

}
