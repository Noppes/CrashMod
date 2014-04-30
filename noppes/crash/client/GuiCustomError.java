package noppes.crash.client;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;

public class GuiCustomError extends GuiErrorScreen{

	public GuiCustomError(String par1Str, String par2Str) {
		super(par1Str, par2Str);
	}
	
    protected void actionPerformed(GuiButton p_146284_1_)
    {
        mc.theWorld.sendQuittingDisconnectingPacket();
        mc.loadWorld((WorldClient)null);
        mc.displayGuiScreen(new GuiMainMenu());
    }
}
