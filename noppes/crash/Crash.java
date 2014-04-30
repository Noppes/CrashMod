package noppes.crash;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Crash.MODID, version = Crash.VERSION)
public class Crash
{
    public static final String MODID = "crash";
    public static final String VERSION = "1.7.2";
    public static FMLEventChannel Channel;

    @SidedProxy(clientSide = "noppes.crash.client.ClientProxy", serverSide = "noppes.crash.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event){
        Channel = NetworkRegistry.INSTANCE.newEventDrivenChannel("CrashMod");
    	proxy.load();
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event){
    	event.registerServerCommand(new CommandCrash());
    }
}
