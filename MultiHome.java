import java.util.logging.Logger;

public class MultiHome extends Plugin
{
	static final Listener l = new Listener();
	
				private Logger log = Logger.getLogger("Minecraft");
				private String name = "MultiHome";
				private String version = "v1.0.5";
				private String author = "JavaScr3w322";
	   public void enable()
	   {
		   this.log.info("Initialized " + this.name +" "+ this.version + " by " + this.author + "!");
	   // if file does not exist, create it. if it does exist, load it. 
	   }
	 
	   public void disable() {
		   this.log.info(this.name + this.version +" Disabled");
	   }
	
	   public void initialize() {
	     etc.getLoader().addListener(PluginLoader.Hook.COMMAND, l, this, 
	       PluginListener.Priority.MEDIUM);
	   }
 }