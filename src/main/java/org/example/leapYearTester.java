package org.example;

public class leapYearTester {
    public static Boolean isLeapYear(int year) {
        // Divisible by 400 is an isolated requirement, so it makes sense running this first.
        if (year % 400 == 0) {
            return true;
        }
        // Here we originally test requirement 1, but all "non-divisible by 4" also fail this, so we meet requirement 3.
        // Furthermore, divisible by 100 but not 400 fails this, as it did not pass the first test, meaning we also
        // get the forth requirement for "free". Nice.

        if (year % 4 == 0 && !(year % 100 == 0)) {
            return true;
        }

        return false;
    }
}
