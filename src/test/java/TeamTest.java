import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Before
  public void wipeIt() {
    Team.clear();
  }


  @Test
  public void Team_instantiatesCorrectly_true() {
    Team newTeam = new Team("");
    assertEquals(true, newTeam instanceof Team);
  }
  @Test
  public void teamName_instantiatesWithString_String() {
    Team newTeam = new Team("Lightning");
    assertEquals("Lightning", newTeam.getName());
  }

  @Test
  public void all_returnsAllInstances_true() {
    Team oneTeam = new Team("Lightning");
    Team twoTeam = new Team("Thunder");
    assertEquals(true, Team.all().contains(oneTeam));
    assertEquals(true, Team.all().contains(twoTeam));
  }

  @Test
  public void listClear_clearsOutArrayList_true(){
    Team oneTeam = new Team("Lightning");
    Team.clear();
    assertEquals(0, Team.all().size());
  }

  @Test
  public void teamId_getsCorrectId_int() {
    Team oneTeam = new Team("Lightning");
    Team twoTeam = new Team("Thunder");
    assertEquals(2, twoTeam.getId());
  }

  @Test
  public void find_returnsCorrectTeamObject_Team() {
    Team oneTeam = new Team("Lightning");
    Team twoTeam = new Team("Thunder");
    assertEquals(twoTeam, Team.find(twoTeam.getId()));
  }
}
