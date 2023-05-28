package E3._Java_Advanced_Exam_22_Feb_2020.guild;
import java.util.ArrayList;
import java.util.List;

public class Guild {
    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster= new ArrayList<>();
    }

    private String name;
    private int capacity;
    private List<Player>roster;

    public void addPlayer(Player player){
        if(roster.size()<capacity){
            roster.add(player);
        }
    }
    public boolean removePlayer(String name){
        //return roster.removeIf(player -> player.getName().equals(name));
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name) && !player.getRank().equals("Member")) {
                player.setRank("Member");
                break;
            }
        }
    }
    public void demotePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name) && !player.getRank().equals("Trial")) {
                player.setRank("Trial");
                break;
            }
        }
    }
    public Player[] kickPlayersByClass(String clazz) {
        List<Player> removedPlayers = new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                removedPlayers.add(player);
            }
        }
        roster.removeAll(removedPlayers);
        return removedPlayers.toArray(new Player[0]);
    }

    public int count (){
        return roster.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the E3._Java_Advanced_Exam_22_Feb_2020.guild: ").append(name).append(":\n");
        for (Player player : roster) {
            sb.append(player).append("\n");
        }
        return sb.toString();
    }


}
