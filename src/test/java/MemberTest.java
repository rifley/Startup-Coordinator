import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {

  @Before
  public void wipeIt(){
    Member.clear();
  }

  @Test
  public void Member_instantiatesCorrectly_true() {
    Member newMember = new Member("");
    assertEquals(true, newMember instanceof Member);
  }

  @Test
  public void memberName_instantiatesWithString_String() {
    Member newMember = new Member("Todd");
    assertEquals("Todd", newMember.getName());
  }

  @Test
  public void all_returnsAllInstances_true () {
    Member oneMember = new Member("Todd");
    Member twoMember = new Member("Janet");
    assertEquals(true, Member.all().contains(oneMember));
    assertEquals(true, Member.all().contains(twoMember));
  }

  @Test
  public void clear_clearsAllObjectsInInstance_int() {
    Member oneMember = new Member("Janet");
    Member.clear();
    assertEquals(0, Member.all().size());
  }

  @Test
  public void id_getIdOfInstance_int () {
    Member oneMember = new Member("Janet");
    Member twoMember = new Member("Todd");
    assertEquals(2, twoMember.getId());
  }

  @Test
  public void find_returnsCorrectMemberObject_Member() {
    Member oneMember = new Member("Todd");
    Member twoMember = new Member("Janet");
    assertEquals(twoMember, Member.find(twoMember.getId()));
  }
}
