import java.util.HashMap;
public abstract class Operator {
  // The Operator class should contain an instance of a HashMap
  // This map will use keys as the tokens we're interested in,
  // and values will be instances of the Operators.

  // Example:
  // Where does this declaration go? What should its access level be?
  // Class or instance variable? Is this the right declaration?
  // HashMap operators = new HashMap();
  // operators.put( "+", new AdditionOperator() );
  // operators.put( "-", new SubtractionOperator() );

    private static final HashMap OPERATORS = new HashMap();
    static {
        OPERATORS.put(  "#", new HashOperator()             );
        OPERATORS.put(  "*", new MultiplicationOperator()   );
        OPERATORS.put(  "/", new DivisionOperator()         );
        OPERATORS.put(  "+", new AdditionOperator()         );
        OPERATORS.put(  "-", new SubtractionOperator()      );
        OPERATORS.put(  "^", new PowerOperator()            );
        OPERATORS.put(  "(", new OpenParenOperator()        );
        OPERATORS.put(  ")", new CloseParenOperator()       );
    }
    
    public static Operator getOperator(String token) {
        return (Operator) OPERATORS.get(token);
    }
    
  public abstract int priority();
  public abstract Operand execute( Operand op1, Operand op2 );

  public static boolean check( String token ) {
      return OPERATORS.containsKey(token);
  }
}
