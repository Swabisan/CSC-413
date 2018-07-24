
package interpreter;

import interpreter.ByteCode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader {

    private BufferedReader byteSource;
    private short lineNo; // for debugging purposes, unused otherwise

    ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        lineNo = 0;

        // declare a program object
        Program program = new Program();

        // declare tokenizer and init w/ first line
        StringTokenizer tokenizer = tokenizeNextLine(null);
        lineNo++;

        // loops until tokenizer loads empty line
        while (tokenizer != null) {
            // first word of each line is a key for the byteCode class name
            String className = CodeTable.getClassName(tokenizer.nextToken());

            // create byteCode instance
            try {
                ByteCode byteCode = (ByteCode)(Class.forName("interpreter.ByteCode."+className).newInstance());

                ArrayList<String> argumentsList = new ArrayList<>();

                // populate args list
                while (tokenizer.hasMoreTokens()) {
                    argumentsList.add(tokenizer.nextToken());
                }

                // parse args into byteCode
                byteCode.init(argumentsList);

                // push byteCode into program
                program.addCode(byteCode);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error in loadCodes() -> cannot create byteCode: "+className+". Exiting program.");
                System.exit(-1);
            }

            // load next line into tokenizer
            tokenizer = tokenizeNextLine(tokenizer);
            lineNo++;
        }

        program.resolveAddress(program);
        return program;
    }

    // loads next line from source file into tokenizer
    // returns null if file is empty
    private StringTokenizer tokenizeNextLine(StringTokenizer tokenizer) {
        try {
            tokenizer = new StringTokenizer(byteSource.readLine());
        } catch (NullPointerException e) {
            // source file is empty
            return null;
        } catch (IOException e) {
            // source file doesn't exist
            e.printStackTrace();
            System.out.println("Error loading next Line -> srcLine["+lineNo+"]. Exiting Program.");
            System.exit(-1);
        }
        return tokenizer;
    }

}