import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleExpressionTest {

  @Test
  public void testSimpleExpression() {
    Evaluator instance = new Evaluator();

    final String expression = "1+2*6";
    final int result = 13;

    assertEquals( instance.eval( expression ), result );
  }

}
