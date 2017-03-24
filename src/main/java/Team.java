import java.util.List;
import java.util.ArrayList;


public class Team {
  private String mTeamName;
  private static List<Team> instances = new ArrayList<Team>();
  private int mId;
  private List<Member> mMembers;


   public Team(String name) {
     mTeamName = name;
     instances.add(this);
     mId = instances.size();
     mMembers = new ArrayList<Member>();
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

   public static Team find(int id) {
     return instances.get(id - 1);
   }

   public List<Member> getMembers() {
     return mMembers;
   }

   public void addMember (Member member) {
     mMembers.add(member);
   }
}
