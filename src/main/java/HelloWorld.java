import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class HelloWorld {

    public boolean isLengthGreaterThan(String s, int length) {
        return s != null && s.length() >= length;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        double x = 1.2;
        double y = 0.1;
        System.out.println(x - y);

        String val;
        BigDecimal xbd = new BigDecimal(String.valueOf(1.2));
        BigDecimal ybd = new BigDecimal(y + "");
        System.out.println(xbd.subtract(ybd));

        String name = "Dolly";
        System.out.printf("Hello, %s!%n", name);

        String myString = new StringBuilder()
            .append("1313 Mockingbird Lane")
                .append("New York")
                .append("NY")
                .toString();

//        Scanner input = new Scanner(System.in);
//        String line = input.nextLine();
//        System.out.printf("Hello, %s!%n", line);

        System.out.println(Integer.MAX_VALUE);
        byte b1 = Byte.MAX_VALUE;
        System.out.println("Byte max: " + b1);
        b1++;
        System.out.println("b1++: " + b1);

        double amount = 1234567.8901234;
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println(nf.format(amount));
        System.out.println(nf.getClass());

        nf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(nf.format(amount));
        nf = NumberFormat.getCurrencyInstance(new Locale("hin", "IN"));
        System.out.println(nf.format(amount));

        int k = 3;
        System.out.println("Post: " + k++);
        System.out.println("Val : " + k);
        System.out.println("Pre : " + (++k));

    }
}
