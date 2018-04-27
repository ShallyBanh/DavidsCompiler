import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = "10/5";
        CharStream input = CharStreams.fromString(filePath);
        pabloLexer lex = new pabloLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        pabloParser parser = new pabloParser(tokens);
        pabloParser.ExpressionContext tree = parser.expression();
        Calculator aname = new Calculator();
        System.out.println(aname.visitExpression(tree));
    }
}

