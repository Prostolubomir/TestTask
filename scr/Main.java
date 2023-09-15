import java.util.Scanner;
public class Main {
    enum Operation{
        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type \'q\' to quit");

        while (true){
            String input = scanner.nextLine();

            if (input.equals("q")) break;

            String[] arr = input.split(" ");

            if (arr.length != 3){
                throw new ParseException("Invalid syntax");
            }

            int a, b;
            try {
                a = Integer.parseInt(arr[0]);
                b = Integer.parseInt(arr[2]);
            }
            catch (NumberFormatException e) {
                throw e;
            }

            if (a < 1 || a > 10 || b < 1 || b > 10){
                System.out.println("Numbers should be less than 11 and greater than 0");
                continue;
            }

            Operation operation;
            try {
                operation = GetOperationFromSign(arr[1]);
            }
            catch (ParseException e) {
                throw e;
            }

            int result = ExecuteOperation(a, b, operation);
            System.out.println(result);
        }
    }
    public static Operation GetOperationFromSign(String sign) throws ParseException {
        switch (sign){
            case "+": return Operation.PLUS;
            case "-": return Operation.MINUS;
            case "*": return Operation.MULTIPLY;
            case "/": return Operation.DIVIDE;
            default: throw new ParseException("Can't recognize the operation");
        }
    }
    public static int ExecuteOperation(int a, int b, Operation operation) {
        switch (operation){
            case PLUS: return a + b;
            case MINUS: return a - b;
            case MULTIPLY: return a * b;
        }
        return a / b;
    }
}
