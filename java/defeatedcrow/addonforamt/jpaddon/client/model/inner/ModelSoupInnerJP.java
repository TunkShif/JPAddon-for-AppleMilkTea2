package defeatedcrow.addonforamt.jpaddon.client.model.inner;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSoupInnerJP extends ModelBase {
	// fields
	ModelRenderer gu1;
	ModelRenderer gu2;
	ModelRenderer gu3;

	public ModelSoupInnerJP() {
		textureWidth = 64;
		textureHeight = 32;

		gu1 = new ModelRenderer(this, 0, 0);
		gu1.addBox(-2.5F, 1.5F, -1.5F, 5, 2, 3);
		gu1.setRotationPoint(0F, 16F, 0F);
		gu1.setTextureSize(64, 32);
		gu1.mirror = true;
		setRotation(gu1, 0F, -0.0523599F, -0.0349066F);
		gu2 = new ModelRenderer(this, 18, 0);
		gu2.addBox(2F, 1.5F, -1F, 2, 2, 2);
		gu2.setRotationPoint(0F, 16F, 0F);
		gu2.setTextureSize(64, 32);
		gu2.mirror = true;
		setRotation(gu2, 0F, -0.0698132F, -0.1745329F);
		gu3 = new ModelRenderer(this, 0, 6);
		gu3.addBox(3F, 3F, -2F, 3, 0, 4);
		gu3.setRotationPoint(0F, 16F, 0F);
		gu3.setTextureSize(64, 32);
		gu3.mirror = true;
		setRotation(gu3, 0F, -0.0698132F, -0.4363323F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		gu1.render(f5);
		gu2.render(f5);
		gu3.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	}

}
