import java.util.List;
import java.util.ArrayList;


public class Team {
  private String mTeamName;
  private static List<Team> instances = new ArrayList<Team>();

   public Team(String name) {
     mTeamName = name;
     instances.add(this);
   }

   public String getName() {
     return mTeamName;
   }

   public static List<Team> all() {
     return instances;
   }
}
