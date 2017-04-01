/*
 * Name: Patrick Liu
 * Date: 4-1-17
 */

package botfiles;


import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.*;
import sx.blah.discord.util.DiscordException;
import de.btobastian.sdcf4j.*;
import de.btobastian.sdcf4j.handler.Discord4JHandler;

class BotCommands implements CommandExecutor{
	//define commands
	@Command(aliases = {"!play"}, requiresMention = false, async = true)
	static void playCommand(String[] args){
		
	}
	
	@Command(aliases = ("!warn"))
	static String warnCommand(String[] args){
		if(args.length < 1){
			return "Usage: !warn [user] [reason]";
		}
		else{
			return args[0] + "has been warned.";
		}
	}
}

public class Bot{
	
	static IDiscordClient client;
	//String prefix = "!";
	

		
	
	/*------------------------------------------------------------*/
	public static IDiscordClient getClient(String token, boolean login) throws DiscordException{
		ClientBuilder clientBuilder = new ClientBuilder();
		clientBuilder.withToken(token);
		if(login){
			return clientBuilder.login();
		}
		else{
			return clientBuilder.build();
		}
	}
	
	@EventSubscriber
	public void onMessageReceived(MessageReceivedEvent evt) throws DiscordException{
		
		//get every message
		IMessage msg = evt.getMessage();
		String msgString = msg.getFormattedContent();
		


		
		
		
		
		
		
	}
	
	public static void main(String args[]) throws DiscordException{
		client = getClient(args[0], true);
		CommandHandler handler = new Discord4JHandler(client);
		handler.registerCommand(new BotCommands());
	}
}
