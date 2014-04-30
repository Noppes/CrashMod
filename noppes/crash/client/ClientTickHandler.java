package noppes.crash.client;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class ClientTickHandler{
    protected static final ResourceLocation resource = new ResourceLocation("crash:textures/anus.jpg");
    protected static final ResourceLocation resource2 = new ResourceLocation("crash:textures/burned.jpg");
    protected static final ResourceLocation resource3 = new ResourceLocation("crash:textures/dog.jpg");
    protected static final ResourceLocation resource4 = new ResourceLocation("crash:textures/dog2.jpg");
    protected static final ResourceLocation resource5 = new ResourceLocation("crash:textures/dog3.jpg");
    protected static final ResourceLocation resource6 = new ResourceLocation("crash:textures/furries.jpeg");
    protected static final ResourceLocation resource7 = new ResourceLocation("crash:textures/goat.jpg");
    protected static final ResourceLocation resource8 = new ResourceLocation("crash:textures/hotdog.png");
    protected static final ResourceLocation resource9 = new ResourceLocation("crash:textures/sock.jpg");
	
	@SubscribeEvent
	public void onClientTick(TickEvent.RenderTickEvent event){
		if(ClientPacketHandler.resource > 0){
			renderPumpkinBlur(getResource(ClientPacketHandler.resource));
		}
	}

    private ResourceLocation getResource(int i) {
		if(i == 1)
			return resource;
		if(i == 2)
			return resource2;
		if(i == 3)
			return resource3;
		if(i == 4)
			return resource4;
		if(i == 5)
			return resource5;
		if(i == 6)
			return resource6;
		if(i == 7)
			return resource7;
		if(i == 8)
			return resource8;
		return resource9;
	}

	protected void renderPumpkinBlur(ResourceLocation resource)
    {
		Minecraft mc = Minecraft.getMinecraft();

        ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
        int k = scaledresolution.getScaledWidth();
        int l = scaledresolution.getScaledHeight();

        int width = scaledresolution.getScaledWidth();
        int height = scaledresolution.getScaledHeight();
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        mc.getTextureManager().bindTexture(resource);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, height, -90.0D, 0.0D, 1.0D);
        tessellator.addVertexWithUV(width, height, -90.0D, 1.0D, 1.0D);
        tessellator.addVertexWithUV(width, 0.0D, -90.0D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

}
