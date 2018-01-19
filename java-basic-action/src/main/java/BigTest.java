import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BigTest {


    public static void main(String[] args) {

        System.out.println(0.05 + 0.01);
        System.out.println(1.0 - 0.42);
        System.out.println(4.015 * 100);
        System.out.println(123.3 / 100);

        System.out.println(Math.round(4.015 * 100) / 100.0);


        System.out.println(4.015 * 100); //401.49999999999994
        System.out.println(new DecimalFormat("0.000").format(4.015 * 100)); //402.500


        System.out.println("-------------------------");


        System.out.println(new BigDecimal("0.05").add(new BigDecimal("0.01")));         //0.06
        System.out.println(new BigDecimal("1.0").subtract(new BigDecimal("0.42")));     //0.58
        System.out.println(new BigDecimal("4.015").multiply(new BigDecimal("100")));    //401.500
        System.out.println(new BigDecimal("123.3").divide(new BigDecimal("100")));     //1.233


        System.out.println("--------------------------\n\n");

        System.out.println(new BigDecimal(0.05).add(new BigDecimal(0.01)));
        System.out.println(new BigDecimal(1.0).subtract(new BigDecimal(0.42)));
        System.out.println(new BigDecimal(4.015).multiply(new BigDecimal(100)));
        System.out.println(new BigDecimal(123.3).divide(new BigDecimal(100)));

        System.out.println("--------------------------\n\n");

        //建立货币格式化引用
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        //建立百分比格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();
        //百分比小数点最多3位
        percent.setMaximumFractionDigits(3);

        BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
        BigDecimal interestRate = new BigDecimal("0.008");  //利率
        BigDecimal interest = loanAmount.multiply(interestRate);

        System.out.println("贷款:\t" + currency.format(loanAmount));
        System.out.println("利率:\t" + percent.format(interestRate));
        System.out.println("利息:\t" + currency.format(interest));


    }

}
