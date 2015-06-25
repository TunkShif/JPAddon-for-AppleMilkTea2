package defeatedcrow.addonforamt.jpaddon.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBowlSoup extends ModelBase
{
	  //fields
	    ModelRenderer bottom1;
	    ModelRenderer bottom2;
	    ModelRenderer sideL;
	    ModelRenderer sideR;
	    ModelRenderer sideF;
	    ModelRenderer sideB;
	  
	  public ModelBowlSoup()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      bottom1 = new ModelRenderer(this, 0, 0);
	      bottom1.addBox(0F, 0F, 0F, 4, 1, 4);
	      bottom1.setRotationPoint(-2F, 23F, -2F);
	      bottom1.setTextureSize(64, 32);
	      bottom1.mirror = true;
	      setRotation(bottom1, 0F, 0F, 0F);
	      bottom2 = new ModelRenderer(this, 0, 0);
	      bottom2.addBox(0F, 0F, 0F, 8, 1, 8);
	      bottom2.setRotationPoint(-4F, 22F, -4F);
	      bottom2.setTextureSize(64, 32);
	      bottom2.mirror = true;
	      setRotation(bottom2, 0F, 0F, 0F);
	      sideL = new ModelRenderer(this, 0, 10);
	      sideL.addBox(0F, 0F, 0F, 1, 4, 6);
	      sideL.setRotationPoint(3F, 18F, -3F);
	      sideL.setTextureSize(64, 32);
	      sideL.mirror = true;
	      setRotation(sideL, 0F, 0F, 0F);
	      sideR = new ModelRenderer(this, 14, 10);
	      sideR.addBox(0F, 0F, 0F, 1, 4, 6);
	      sideR.setRotationPoint(-4F, 18F, -3F);
	      sideR.setTextureSize(64, 32);
	      sideR.mirror = true;
	      setRotation(sideR, 0F, 0F, 0F);
	      sideF = new ModelRenderer(this, 0, 20);
	      sideF.addBox(0F, -2F, 0F, 8, 4, 1);
	      sideF.setRotationPoint(-4F, 20F, -4F);
	      sideF.setTextureSize(64, 32);
	      sideF.mirror = true;
	      setRotation(sideF, 0F, 0F, 0F);
	      sideB = new ModelRenderer(this, 0, 25);
	      sideB.addBox(0F, 0F, 0F, 8, 4, 1);
	      sideB.setRotationPoint(-4F, 18F, 3F);
	      sideB.setTextureSize(64, 32);
	      sideB.mirror = true;
	      setRotation(sideB, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    bottom1.render(f5);
	    bottom2.render(f5);
	    sideL.render(f5);
	    sideR.render(f5);
	    sideF.render(f5);
	    sideB.render(f5);
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
