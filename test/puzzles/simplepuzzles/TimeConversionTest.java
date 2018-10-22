package puzzles.simplepuzzles;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeConversionTest {

    @Test
    public void testTimeConversion() throws Exception {
        assertEquals("00:00:00", TimeConversion.timeConversion("12:00:00AM"));
        assertEquals("12:00:00", TimeConversion.timeConversion("12:00:00PM"));
        assertEquals("03:00:00", TimeConversion.timeConversion("03:00:00AM"));
        assertEquals("15:00:00", TimeConversion.timeConversion("03:00:00PM"));
    }
}