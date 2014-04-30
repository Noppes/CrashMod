package noppes.crash;

import java.util.List;
import java.util.Random;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class CommandCrash extends CommandBase{
	private Random random = new Random();
	@Override
	public String getCommandName() {
		return "crash";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "/crash <player> [1-9]";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		if(var2.length < 1)
			return;
		EntityPlayerMP player = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(var2[0]);
		if(player == null){
			var1.addChatMessage(new ChatComponentText("Unknown user"));
			return;
		}
		int i = random.nextInt(9);
		if(var2.length > 1){
			try{
			i = Integer.parseInt(var2[1]);	
			}
			catch(NumberFormatException ex){
				var1.addChatMessage(new ChatComponentText("Needs to be a number"));
			}
			
		}
		Server.sendData(player, i);
	}
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
    	if(par2ArrayOfStr.length == 1)
    		return getListOfStringsMatchingLastWord(par2ArrayOfStr, MinecraftServer.getServer().getAllUsernames());
    	return null;
    }
	
}
