import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleParenthesesTest {

  @Test
  public void testSimpleExpressionWithParens() {
    Evaluator instance = new Evaluator();

    final String expression = "(0+2+3)*4+0";
    final int result = 20;

    assertEquals( instance.eval( expression ), result );
  }

}
