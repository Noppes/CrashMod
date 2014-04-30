package noppes.crash.client;

import cpw.mods.fml.common.FMLCommonHandler;
import noppes.crash.CommonProxy;
import noppes.crash.Crash;

public class ClientProxy extends CommonProxy{

	@Override
	public void load(){
		Crash.Channel.register(new ClientPacketHandler());
		FMLCommonHandler.instance().bus().register(new ClientTickHandler());
	}
}
