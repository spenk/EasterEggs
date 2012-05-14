import java.util.ArrayList;


public class EasterEggsListener extends PluginListener{
	Double reward;
	int itemage;
	PropertiesFile props = new PropertiesFile("plugins/config/EasterPlugin.properties");
	
	public void load(){
		reward = props.getDouble("Reward-Money",50.00);
		itemage = props.getInt("Item-Age-in-secs",100);
	}

	ArrayList<String> a = new ArrayList<String>();
	ArrayList<ItemEntity> s = new ArrayList<ItemEntity>();
	
    public boolean onCommand(Player player, String[] split) {
        if (split[0].equalsIgnoreCase("/seteggs") && player.canUseCommand("/eeadmin")) {
           if (a.contains(player.getName())) {
              a.remove(player.getName());
              player.notify("Cancelled eastereggs selection!");
           }else{
              a.add(player.getName());
              player.sendMessage("§2Started eastereggs selection");
           }
           return true;
        }
        return false;
     }
    public boolean onItemDrop(Player player,ItemEntity item){
    	if (item.getItem().getItemId() == 383 ){
    		if (a.contains(player.getName())){
        s.add(item);
        item.setAge(-itemage*1000);
        player.sendMessage("§2Item placed.");
             return false;
    		}
          }
      return false;
    }
    
    public boolean onItemPickUp(Player player, ItemEntity item) {
    	if (item.getItem().getItemId() == 383){
    		if (player.canUseCommand("/ee") && !a.contains(player.getName())){
              if (s.contains(item)) {
            	  etc.getServer().messageAll("§6"+player.getName()+"§3 Found an EasterEgg!");
            	  etc.getLoader().callCustomHook("dCBalance", new Object[] { "Player-Pay", player.getName(), (Double) reward});
            	 item.destroy();
            	 s.remove(item);
                 return true;
              }}
    		else{
    			return true;
    		}
    	}
        return false;
     }
}
