import java.util.Scanner;
import java.util.regex.Pattern;

public class VectorCalculator {
    public VectorCalculator(Scanner consoleScanner) {
        Boolean done = false;
        Pattern startingTokens = Pattern.compile("dir|unit|<|\\d|\\||exit");
        while (!done) {
            try {
                String curLine = consoleScanner.nextLine();
                Scanner curLineScanner = new Scanner(curLine);
                if (curLineScanner.hasNext(startingTokens)) {
                    parseExpression(curLineScanner);
                } else {
                    throw new Exception("Give me Something Good ");
                }
                if (curLine.equals("exit")) {
                    done = true;
                }
            }
            catch (Exception e) {
                System.out.print(e.getMessage());
            }
            System.out.print("\nEnter vector expression: ");
            consoleScanner = new Scanner(System.in);
        }
    }

    private static void parseExpression(Scanner consoleScanner) throws Exception {
        if (consoleScanner.hasNext("<")) {
            parseVectorExpression(consoleScanner);
        }
        else if (consoleScanner.hasNext("\\|")){
            parseNormExpression(consoleScanner);
        }
        else if (consoleScanner.hasNextDouble()) {
            parseScalarExpression(consoleScanner);
        }
        else if (consoleScanner.hasNext("dir")) {
            parseDirection(consoleScanner);
        }
        else if (consoleScanner.hasNext("unit")) {
            parseUnit(consoleScanner);
        }

    }

    private static void parseVectorExpression(Scanner consoleScanner) throws Exception {
        if(consoleScanner.hasNext("<")){
            Vector330 v = Vector330.parseVector(consoleScanner);

            if (consoleScanner.hasNext("\\+")){
                consoleScanner.next("\\+");
                Vector330 v2 = Vector330.parseVector(consoleScanner);
                Vector330 answer = v.add(v2);

                System.out.print("Result is " + answer.toString());
            }

            else if (consoleScanner.hasNext("\\-")) {
                consoleScanner.next("\\-");
                Vector330 v2 = Vector330.parseVector(consoleScanner);
                Vector330 answer = v.subtract(v2);
                System.out.print("Result is " + answer.toString());
            }

            else if (consoleScanner.hasNext(".")) {
                consoleScanner.next(".");
                Vector330 v2 = Vector330.parseVector(consoleScanner);
                double answer = v.dotProduct(v2);
                System.out.print("Result is " + answer);
            }
        }
    }
    private static void parseNormExpression(Scanner consoleScanner) throws Exception{
        if(consoleScanner.hasNext("\\|")){
            consoleScanner.next("\\|");
            Vector330 v = Vector330 .parseVector(consoleScanner);
            double magnitude = v.magnitude();

            System.out.print("Result is " + magnitude);
        }
        else {
            throw new Exception("Expression does not start with key, '|'");
        }
    }

    private static void parseScalarExpression(Scanner consoleScanner) throws Exception {
        if (consoleScanner.hasNextDouble()) {
            double scale = consoleScanner.nextDouble();
            consoleScanner.next("\\*");
            Vector330 v = Vector330.parseVector(consoleScanner);
            v = v.scale(scale);
            System.out.println("Result is " + v.toString());

        } else {
            throw new Exception("Scalar expression did not start with double");
        }
    }

    private static void parseDirection(Scanner consoleScanner) throws Exception {
        if (consoleScanner.hasNext("dir")) {
            consoleScanner.next("dir");
            Vector330 v = Vector330.parseVector(consoleScanner);
            double direct = v.direction();
            double degree = v.direction() * 180 / Math.PI;
            System.out.print("Result is " + direct + " (" + degree + ")");
        }
        else {
            throw new Exception("Expression does not start with keyword, 'dir'");
        }
    }

    private static void parseUnit(Scanner consoleScanner) throws Exception{
        if (consoleScanner.hasNext("unit")){
            consoleScanner.next("unit");
            Vector330 v = Vector330.parseVector(consoleScanner);
            v = v.normalize();
            System.out.print("Result is " + v.toString());
        }
        else {
            throw new Exception("Expression does not start with keyword, 'unit'");
        }
    }
}


