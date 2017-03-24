import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Test
  public void Team_instantiatesCorrectly_true() {
    Team newTeam = new Team();
    assertEquals(true, newTeam instanceof Team);
  }

}
