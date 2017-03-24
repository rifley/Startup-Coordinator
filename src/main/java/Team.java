import java.util.List;
import java.util.ArrayList;


public class Team {
  private String mTeamName;
  private static List<Team> instances = new ArrayList<Team>();
  private int mId;
  

   public Team(String name) {
     mTeamName = name;
     instances.add(this);
     mId = instances.size();
   }

   public String getName() {
     return mTeamName;
   }

   public static List<Team> all() {
     return instances;
   }

   public static void clear() {
     instances.clear();
   }

   public int getId() {
     return mId;
   }
}
