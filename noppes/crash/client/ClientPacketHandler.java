package noppes.crash.client;

import io.netty.buffer.ByteBufInputStream;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ReportedException;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;

public class ClientPacketHandler implements Runnable{
	private float master, players;
	public static int resource = -1;
	@SubscribeEvent
	public void onPacketData(ClientCustomPacketEvent event) {
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		ByteBufInputStream buf = new ByteBufInputStream(event.packet.payload());
		try {
			resource = buf.readInt();
			buf.close();
			Thread thread = new Thread(this);
			thread.start();
		} catch (IOException e) {
			
		}
		
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Minecraft mc = Minecraft.getMinecraft();
		resource = -1;
		mc.displayGuiScreen(new GuiCustomError("", "Minecraft Error"));
	}
}
