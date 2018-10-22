package puzzles.simplepuzzles;

/**
 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
 * <p>
 * Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.
 * <p>
 * Input format: hh:mm:ssAM or hh:mm:ssPM, where 01 <= hh <= 12, 00 <= mm, ss <= 59
 */
public class TimeConversion {
    static String timeConversion(String str) {

        if (str.charAt(8) == 'A') {
            if (str.substring(0, 2).equals("12")) {
                return "00" + str.substring(2, str.length() - 2);
            }

            return str.substring(0, str.length() - 2);
        }

        if (str.substring(0, 2).equals("12")) {
            return "12" + str.substring(2, str.length() - 2);
        }

        Integer hours = Integer.parseInt(str.substring(0, 2)) + 12;
        return hours.toString() + str.substring(2, str.length() - 2);
    }
}
