public class Operand {
    private final int value;

  public Operand( String token ) {
      this.value = Integer.parseInt(token);
  }

  public Operand( int value ) {
      this.value = value;
  }

  public int getValue() {
      return this.value;
  }

  public static boolean check( String token ) {
      try {
          Integer.parseInt(token);
          return true;
      } catch (NumberFormatException e) {
          return false;
      }
  }
}
