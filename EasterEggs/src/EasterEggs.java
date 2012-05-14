import java.io.File;
import java.util.logging.Logger;


public class EasterEggs extends Plugin{
	  String name = "Easter Eggs";
	  String version = "1.1";
	  String author = "spenk";
	  static Logger log = Logger.getLogger("Minecraft");
	  
	  
public void initialize(){
File f = new File ("plugins/config"); f.mkdir();
EasterEggsListener listener = new EasterEggsListener();
log.info(this.name +" version "+ this.version + " by " +this.author+ " is initialized!");
etc.getLoader().addListener(PluginLoader.Hook.COMMAND, listener, this, PluginListener.Priority.MEDIUM);
etc.getLoader().addListener(PluginLoader.Hook.ITEM_DROP, listener, this, PluginListener.Priority.MEDIUM);
etc.getLoader().addListener(PluginLoader.Hook.ITEM_PICK_UP, listener, this, PluginListener.Priority.MEDIUM);
etc.getInstance().addCommand("/seteggs", "Set easter eggs");
listener.load();
}
public void enable(){
	log.info(this.name + " version " + this.version + " by " + this.author + " is enabled!");
}

public void disable(){
	log.info(this.name + " version " + this.version + " is disabled!");
  etc.getInstance().removeCommand("/seteggs");
}
}
