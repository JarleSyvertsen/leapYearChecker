import org.example.leapYearTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestValidLeapYear {

   public static int[] NonDivisibleBy4Years() {
       int[] years = {1,2,3,5,10,25,75,90,150,310,1501};

       return years;
   }
    public static int[] FourHundredYears() {
        int[] years = {400,800,1200,1600,2000,2400,2800,3200};

        return years;
    }

    public static Stream DivisibleBy4Not100() {
        return Stream.of(
                Arguments.of(4, true),
                Arguments.of(16, true),
                Arguments.of(100, false),
                Arguments.of(320, true),
                Arguments.of(500, false)
                );
    }
    public static Stream DivisibleBy100Not400() {
        return Stream.of(
                Arguments.of(100, false),
                Arguments.of(200, false),
                Arguments.of(400, true),
                Arguments.of(1000, false),
                Arguments.of(1200, true),
                Arguments.of(1800, false),
                Arguments.of(2000, true)
                );
    }

    @ParameterizedTest
    @MethodSource("DivisibleBy4Not100")
    public void trueWhenDivisbleBy4Not100(int year, Boolean expected) {
        Assertions.assertEquals(expected, leapYearTester.isLeapYear(year));
    }

    @ParameterizedTest
    @MethodSource("DivisibleBy100Not400")
    public void falseWhenDivisibleBy100ButNot400(int year, Boolean expected) {
        Assertions.assertEquals(expected, leapYearTester.isLeapYear(year));
    }

    @ParameterizedTest
    @MethodSource("FourHundredYears")
    public void trueWhenDivisbleBy400(int year) {
        Assertions.assertTrue(leapYearTester.isLeapYear(year));
    }

    @ParameterizedTest
    @MethodSource("NonDivisibleBy4Years")
    public void falseWhenNotDivisbleBy4(int year) {
        Assertions.assertFalse(leapYearTester.isLeapYear(year));
    }

}
