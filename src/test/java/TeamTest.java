import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Test
  public void Team_instantiatesCorrectly_true() {
    Team newTeam = new Team("");
    assertEquals(true, newTeam instanceof Team);
  }
  @Test
  public void Team_instantiatesWithString_String() {
    Team newTeam = new Team("Lightning");
    assertEquals("Lightning", newTeam.getName());
  }

  @Test
  public void Team_returnsAllInstances_true() {
    Team oneTeam = new Team("Lightning");
    Team twoTeam = new Team("Thunder");
    assertEquals(true, Team.all().contains(oneTeam));
    assertEquals(true, Team.all().contains(twoTeam));
  }
}
