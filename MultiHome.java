import java.util.logging.Logger;

public class MultiHome extends Plugin
{
	static final Listener l = new Listener();
	
				private Logger log = Logger.getLogger("Minecraft");
				private String name = "MultiHome";
				static String version = "v1.1";
				private String author = "JavaScr3w322";
	   
		public void enable()
	   {
		   this.log.info("Initialized " + this.name +" "+ this.version + "!");
	   
		   etc.getInstance().addCommand("/multisethome or /msh", "- Sets a multihome to your current location. Requires a name and number.");
		   etc.getInstance().addCommand("/multihome or /mh", "- Teleports you to a set multihome.");
		   etc.getInstance().addCommand("/listmultihomes or /lmh", "- Lists set multihomes.");
	   }
	 
	   public void disable() {
		   this.log.info(this.name + this.version +" Disabled");
	   
		   etc.getInstance().removeCommand("/multisethome or /msh");
		   etc.getInstance().removeCommand("/multihome or /mh");
		   etc.getInstance().removeCommand("/listmultihomes or /lmh");
	   }
	
	   public void initialize() {
	     
		   etc.getLoader().addListener(PluginLoader.Hook.COMMAND, l, this, 
	       PluginListener.Priority.MEDIUM);
	   }
 }