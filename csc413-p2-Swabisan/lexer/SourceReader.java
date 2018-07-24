package lexer;

import java.io.*;

/**
*  This class is used to manage the source program input stream;
*  each read request will return the next usable character; it
*  maintains the source column position of the character
*/
public class SourceReader {
  private BufferedReader source;
// line number of source program
  private int lineno = 0,
  // position of last character processed
  position;
  // if true then last character read was newline
  private boolean isPriorEndLine = true;
  // so read in the next line
  private String nextLine;
  private StringBuilder builder;


  // public static void main( String args[] ) {
  //   SourceReader s = null;
  //   try {
  //     s = new SourceReader( "t" );
  //
  //     while( true ) {
  //       char ch = s.read();
  //       System.out.println( "Char: " + ch + " Line: " + s.lineno + "position: " + s.position );
  //     }
  //   } catch (Exception e) {}
  //
  //   if( s != null ) {
  //     s.close();
  //   }
  // }

  /**
  *  Construct a new SourceReader
  *  @param sourceFile the String describing the user's source file
  *  @exception IOException is thrown if there is an I/O problem
  */
  public SourceReader( String sourceFile ) throws IOException {
    System.out.println( "Source file: " + sourceFile );
    System.out.println( "user.dir: " + System.getProperty( "user.dir" ));
    source = new BufferedReader( new FileReader( sourceFile ));
    builder = new StringBuilder();
  }

  void close() {
    try {
      source.close();
    } catch( Exception e ) {}
  }

  /**
  *  read next char; track line #, character position in line<br>
  *  return space for newline
  *  @return the character just read in
  *  @IOException is thrown for IO problems such as end of file
  */
  public char read() throws IOException {
    if( isPriorEndLine ) {
      lineno++;
      position = -1;
      nextLine = source.readLine();

      if( nextLine != null ) {
        System.out.println( "READLINE:   " + nextLine );

        builder.append( String.format( "\n%d: %s", lineno, nextLine ) );
      }

      isPriorEndLine = false;
    }

    if( nextLine == null ) {
      // hit eof or some I/O problem
      throw new IOException();
    }

    if( nextLine.length() == 0) {
      isPriorEndLine = true;
      return ' ';
    }
    position++;

    if( position >= nextLine.length() ) {
      isPriorEndLine = true;
      return ' ';
    }

    return nextLine.charAt( position );
  }

  /**
  *  @return the position of the character just read in
  */
  public int getPosition() {
    return position;
  }

  /**
  *  @return the line number of the character just read in
  */
  public int getLineno() {
    return lineno;
  }

  @Override
  public String toString() {
    return builder.toString();
  }
}
