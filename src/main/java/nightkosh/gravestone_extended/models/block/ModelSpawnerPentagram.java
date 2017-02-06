package nightkosh.gravestone_extended.models.block;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import nightkosh.gravestone_extended.renderer.tileentity.TileEntitySpawnerRenderer;
import org.lwjgl.opengl.GL11;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModelSpawnerPentagram extends ModelSpawnerBase {

    private ModelRenderer pentagram;
    private ModelSkullCandle candle1;
    private ModelSkullCandle candle2;
    private ModelSkullCandle candle3;
    private ModelSkullCandle candle4;
    private ModelSkullCandle candle5;
    private ResourceLocation candleTexture;

    public ModelSpawnerPentagram(ResourceLocation candleTexture) {
        this.candleTexture = candleTexture;
        textureWidth = 32;
        textureHeight = 32;

        pentagram = new ModelRenderer(this, -32, -32);
        pentagram.addBox(0, 0, 0, 32, 0, 32);
        pentagram.setRotationPoint(-16, 24, -16);

        candle1 = new ModelSkullCandle();
        candle2 = new ModelSkullCandle();
        candle3 = new ModelSkullCandle();
        candle4 = new ModelSkullCandle();
        candle5 = new ModelSkullCandle();
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void renderAll() {
        pentagram.render(0.0625F);

        TileEntitySpawnerRenderer.instance.bindTextureByName(candleTexture);
        GL11.glPushMatrix();
        GL11.glTranslated(0, 0, 1);
        GL11.glRotated(180, 0, 1, 0);
        candle1.renderAll();
        GL11.glPopMatrix();

        TileEntitySpawnerRenderer.instance.bindTextureByName(candleTexture);
        GL11.glPushMatrix();
        GL11.glTranslated(0.95, 0, 0.3);
        GL11.glRotated(252, 0, 1, 0);
        candle2.renderAll();
        GL11.glPopMatrix();

        TileEntitySpawnerRenderer.instance.bindTextureByName(candleTexture);
        GL11.glPushMatrix();
        GL11.glTranslated(-0.95, 0, 0.3);
        GL11.glRotated(108, 0, 1, 0);
        candle3.renderAll();
        GL11.glPopMatrix();

        TileEntitySpawnerRenderer.instance.bindTextureByName(candleTexture);
        GL11.glPushMatrix();
        GL11.glTranslated(-0.59, 0, -0.8);
        GL11.glRotated(36, 0, 1, 0);
        candle4.renderAll();
        GL11.glPopMatrix();

        TileEntitySpawnerRenderer.instance.bindTextureByName(candleTexture);
        GL11.glPushMatrix();
        GL11.glTranslated(0.61, 0, -0.8);
        GL11.glRotated(-36, 0, 1, 0);
        candle5.renderAll();
        GL11.glPopMatrix();
    }
}
