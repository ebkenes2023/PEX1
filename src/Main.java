import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Welcome to the Vector Calculator!\n");
        System.out.print("Enter vector expression: \n");
        Scanner s = new Scanner(System.in);
        VectorCalculator vc = new VectorCalculator(s);

    }
}
