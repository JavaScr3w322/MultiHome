import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Iterator;

public class Listener extends PluginListener
{
	public class homes {
		String name;
		double[] x = new double[6];
		double[] y = new double[6];
		double[] z = new double[6];
		float[] pitch = new float[6];
		float[] rotation = new float[6];
<<<<<<< HEAD
		boolean[] valid = new boolean [6];
	 
	 
	 }
	HashMap<String, homes> hashmap = new HashMap<String, homes>();
	 
	 Server srv = etc.getServer();
     private Logger log = Logger.getLogger("Minecraft");

   private void SaveHomes() {
       String loc = new String("MultiSetHomes.txt");

       try {
           BufferedWriter bw = new BufferedWriter(new FileWriter(loc, false));
           Iterator iterator = hashmap.keySet().iterator();
           
           while (iterator.hasNext()) {
        	   String name = (String)iterator.next();
        	   homes h = hashmap.get(name);
//        	   homes h = (homes)iterator.next();
        	   
        	   for (int which = 1; which <= 5; which++) {
        		   StringBuilder builder = new StringBuilder();

        		   builder.append(h.name);
        		   builder.append(':');
        		   builder.append(which);
        		   builder.append(':');
        		   builder.append(h.x[which]);
        		   builder.append(':');
        		   builder.append(h.y[which]);
        		   builder.append(':');
        		   builder.append(h.z[which]);
        		   builder.append(':');
        		   builder.append(h.pitch[which]);
	               builder.append(':');
	               builder.append(h.rotation[which]);
	               builder.append(':');
	               builder.append(h.valid[which]);
	               
	               bw.append(builder.toString());
	               bw.newLine();
        	   
        	   }
           }
           
           bw.close();
       } catch (Exception e) {
           this.log.info("Exception while writing multihomes to " + loc + ": " + e);
       }
   }

   private int LoadHomes() {
       String location = new String("MultiSetHomes.txt");              		

       if (new File(location).exists()) {
           try {
               Scanner scanner = new Scanner(new File(location));
               while (scanner.hasNextLine()) {
                   String line = scanner.nextLine().trim();
                   if (line.startsWith("#") || line.isEmpty()) {
                       continue;
                   }
                   String[] split = line.split(":");
                   if (split.length < 8) {
                       continue;
                   }
                   String name = split[0];
                   homes h = (homes) hashmap.get(name);
                   if (h == null) {
                 	  h = new homes();
                 	  h.name = name;
                 	  hashmap.put(name, h);
                   }
                   int which = Integer.parseInt(split[1]);
                   h.x[which] = Double.parseDouble(split[2]);
                   h.y[which] = Double.parseDouble(split[3]);
                   h.z[which] = Double.parseDouble(split[4]);
                   h.pitch[which] = Float.parseFloat(split[5]);
                   h.rotation[which] = Float.parseFloat(split[6]);
                   h.valid[which] = Boolean.parseBoolean(split[7]);
               }
               scanner.close();
           this.log.info("MultiHome v1.0.5 successfully loaded 'MultiSetHomes.txt'");
           
           } catch (Exception e) {
               this.log.info("Exception while reading multihomes from " + location + ": " + e);
           }
       }

	   return 0;
   }

   int loaded = this.LoadHomes();
   
   public boolean onCommand(Player p, Block b, String[] cmd)
   {
	   if ((cmd[0].equals("/multisethome")) || ((cmd[0].equals("/msh")) && (p.canUseCommand("/multisethome"))))
     {
    	 int which;
    	 
    	 if (cmd.length != 2) {
    		  p.sendMessage("ï¿½c'/multisethome' or '/msh' must be followed by 1,2,3,4, or 5");
    		 return true;
    	 
    	 
    	 }
    	 
    	
    	 
    	 
    	 which = Integer.parseInt(cmd[1]);
    	 if (which < 1 || which > 5) {
    		 p.sendMessage("ï¿½c'/multisethome' or '/msh' must be followed by 1,2,3,4, or 5");
    		 return true;
    	 
    	 }
      
	  
      p.sendMessage("ï¿½eYour number " + which + " MultiHome has been set to your current location.");
      
      homes h = (homes) hashmap.get(p.getName());
      if (h == null) {
      // make a new home obj
    	  h = new homes();
    	  h.name = p.getName();
    	  hashmap.put(p.getName(), h);
      }
      h.x[which] = p.getX();
      h.y[which] = p.getY();
      h.z[which] = p.getZ();
      h.pitch[which] = p.getPitch();
      h.rotation[which] = p.getRotation();
      h.valid[which] = true;
      SaveHomes();
      return true;
     }
     
	  
	   
     if ((cmd[0].equals("/multihome")) || ((cmd[0].equals("/mh")) && (p.canUseCommand("/multisethome"))))
     {
    	 int which;
    	 
       	 if (cmd.length != 2) {
       		 p.sendMessage("ï¿½c'/multihome' or '/mh' must be followed by 1,2,3,4, or 5");
       		 return true;
       	 }
   	 
       	 which = Integer.parseInt(cmd[1]);
       	 if (which > 5 || which < 1) {
       		 p.sendMessage("ï¿½c'/multihome' or '/mh' must be followed by 1,2,3,4, or 5");
       		 return true;
       	 }
    	 
   	 	 homes h = (homes) hashmap.get(p.getName());
   	 	 if (h == null) {
   	 		 p.sendMessage("ï¿½cYour number " + cmd[1] + " MultiHome Has not been set.");
   	 		 return true;
   	 	 }
    	 if (h.valid[which] == false){
    		 p.sendMessage("ï¿½cYour number " + cmd[1] + " MultiHome Has not been set.");
    		 return true;
    	 }
   	 	 p.teleportTo(new Location(h.x[which], h.y[which], h.z[which], h.rotation[which], h.pitch[which]));
    	    
    	 return true;
     }
     
         return false;
   }
=======
		String[] title = new String [6];
		Boolean[] valid = new Boolean [6];
	}

	HashMap<String, homes> hashmap = new HashMap<String, homes>();

	Server srv = etc.getServer();
	private Logger log = Logger.getLogger("Minecraft");

	private void SaveHomes() {
		String loc = new String("MultiSetHomes.txt");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(loc, false));
			Iterator iterator = hashmap.keySet().iterator();

			while (iterator.hasNext()) {
				String name = (String)iterator.next();
				homes h = hashmap.get(name);


				for (int which = 1; which <= 5; which++) {
					StringBuilder builder = new StringBuilder();

					builder.append(h.name);
					builder.append(':');
					builder.append(which);
					builder.append(':');
					builder.append(h.x[which]);
					builder.append(':');
					builder.append(h.y[which]);
					builder.append(':');
					builder.append(h.z[which]);
					builder.append(':');
					builder.append(h.pitch[which]);
					builder.append(':');
					builder.append(h.rotation[which]);
					builder.append(':');
					builder.append(h.valid[which]);
					builder.append(':');
					builder.append(h.title[which]);

					bw.append(builder.toString());
					bw.newLine();

				}
			}

			bw.close();
		} catch (Exception e) {
			this.log.info("Exception while writing multihomes to " + loc + ": " + e);
		}
	}

	private int LoadHomes() {
		String location = new String("MultiSetHomes.txt");              		

		if (new File(location).exists()) {
			try {
				Scanner scanner = new Scanner(new File(location));
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine().trim();
					if (line.startsWith("#") || line.isEmpty()) {
						continue;
					}
					String[] split = line.split(":");
					if (split.length < 8) {
						continue;
					}
					String name = split[0];
					homes h = (homes) hashmap.get(name);
					if (h == null) {
						h = new homes();
						h.name = name;
						hashmap.put(name, h);
					}
					int which = Integer.parseInt(split[1]);
					h.x[which] = Double.parseDouble(split[2]);
					h.y[which] = Double.parseDouble(split[3]);
					h.z[which] = Double.parseDouble(split[4]);
					h.pitch[which] = Float.parseFloat(split[5]);
					h.rotation[which] = Float.parseFloat(split[6]);
					h.valid[which] = Boolean.parseBoolean(split[7]);
					h.title[which] = split[8]; //need to parse?
				}
				scanner.close();
				this.log.info("MultiHome v1.1 successfully loaded 'MultiSetHomes.txt'");

			} catch (Exception e) {
				this.log.info("Exception while reading multihomes from " + location + ": " + e);
			}
		}

		return 0;
	}

	int loaded = this.LoadHomes();

	public boolean onCommand(Player p, String[] split)
	{
		if ((split[0].equalsIgnoreCase("/multisethome")) || ((split[0].equalsIgnoreCase("/msh")) && (p.canUseCommand("/multisethome"))))
		{
			int which;
			String t;

			if (split.length != 3) {
				p.sendMessage("¤c'/multisethome' or '/msh' must be followed by 1,2,3,4, or 5 and a title.");
				return true;
			}

			which = Integer.parseInt(split[1]);
			if (which < 1 || which > 5) {
				p.sendMessage("¤c'/multisethome' or '/msh' must be followed by 1,2,3,4, or 5");
				return false;   	 
			}
			t = split[2];
			
			p.sendMessage("¤eYour number " + which + " MultiHome has been set to your current location under the title " + t + ".");

			homes h = (homes) hashmap.get(p.getName());
			if (h == null) {
				// make a new home obj
				h = new homes();
				h.name = p.getName();
				hashmap.put(p.getName(), h);
			}
			h.title[which] = t;
			h.x[which] = p.getX();
			h.y[which] = p.getY();
			h.z[which] = p.getZ();
			h.pitch[which] = p.getPitch();
			h.rotation[which] = p.getRotation();
			h.valid[which] = true;
			SaveHomes();
			return true;
		}

		if ((split[0].equalsIgnoreCase("/multihome")) || ((split[0].equalsIgnoreCase("/mh")) && (p.canUseCommand("/multisethome"))))
		{
			int which;
			String t;
			
			if (split.length != 2) {
				p.sendMessage("¤c'/multihome' or '/mh' must be followed by a title.");
				return true;
			}

			t = split[1];
			
			homes h = (homes) hashmap.get(p.getName());
			if (h == null) {
				p.sendMessage("¤cYour number " + split[1] + " MultiHome Has not been set.");
				return true;
			}
			for (which = 1; which <= 5; which++) {
				if (h.title[which].equals(t))
					break;
			}
			if (which > 5) {
				p.sendMessage("¤cThe home title you entered is not valid (has not been set).");
				return true;
			}
			//if (h.valid[which] == false){
			// p.sendMessage("¤cYour number " + cmd[1] + " MultiHome Has not been set.");
			// return true;
			//}
			p.teleportTo(new Location(h.x[which], h.y[which], h.z[which], h.rotation[which], h.pitch[which]));

			return true;
		}

		if ((split[0].equalsIgnoreCase("/listmultihomes")) || ((split[0].equalsIgnoreCase("/lmh")) && (p.canUseCommand("/multisethome")))) {
				
			int which;
			//String t;
			
			homes h = (homes) hashmap.get(p.getName());
			if (h == null) {
				p.sendMessage("¤cYou have not set any MultiHomes.");
				return true;
			}
			
			p.sendMessage("Set MultiHomes:");
			for (which=1; which <= 5; which++) 
				//if (h.valid[which])
					p.sendMessage("¤cMultiHome " + which + " is titled '" + h.title[which] + "'");
					p.sendMessage("¤c(null means it has not been set.)");
			return true;
		}
		
		return false;
	}
>>>>>>> Version 1.1
 }