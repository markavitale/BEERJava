import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// specify a runner class: Suite.class
@RunWith(Suite.class)

// specify an array of test classes
@Suite.SuiteClasses({
  GameTest.class, 
  ItemTest.class,
  PlayerTest.class,
  RegionTest.class,
  ViewTest.class}
 // LauncherTest.class}
)

public class AllTests {

}
