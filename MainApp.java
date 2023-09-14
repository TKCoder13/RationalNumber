public class MainApp {

    public static void main(String[] args) {
        RationalNumberInterface lhs = new RationalNumber(1, 2);
        RationalNumberInterface rhs = new RationalNumber(3, 4);

        System.out.println(lhs.toString());
        RationalNumberInterface result;

        result = lhs.add(rhs);
        System.out.print("(" + lhs + ") + (" + rhs + ") = ");
        System.out.println("(" + result + ")");

        result = lhs.sub(rhs);
        System.out.print("(" + lhs + ") - (" + rhs + ") = ");
        System.out.println("(" + result + ")");

        result = lhs.mult(rhs);
        System.out.print("(" + lhs + ") * (" + rhs + ") = ");
        System.out.println("(" + result + ")");

        result = lhs.div(rhs);
        System.out.print("(" + lhs + ") / (" + rhs + ") = ");
        System.out.println("(" + result + ")");

        try {
            rhs = new RationalNumber();
            System.out.print("(" + lhs + ") / (" + rhs + ") = ");
            result = lhs.div(rhs);
            System.out.println("(" + result + ")");
        } catch (ArithmeticException e) {
            System.out.println(e);
        }

        System.out.print("(" + lhs + ") == (" + rhs + ") = ");
        System.out.println((lhs.equals(rhs) ? "true" : "false"));

        rhs = new RationalNumber(lhs);
        System.out.print("(" + lhs + ") == (" + rhs + ") = ");
        System.out.println((lhs.equals(rhs) ? "true" : "false"));

        lhs = new RationalNumber(5, 12);
        double dresult = lhs.sqrt();

        System.out.println(Math.sqrt((double)lhs.getNumerator() / (double)lhs.getDenominator()) + " == " + dresult);

    }
}
