import java.util.*;
import student.TestCase;

public class ScheduleTest extends TestCase {
    Schedule myCalendar;


    public void setUp() {
        myCalendar = new Schedule();
    }


    public void testAdd() {
        Event cs3704 = new Course("CS 3704", new Interval(1430, 1545));
        assertTrue(myCalendar.addEvent(cs3704));
        assertFalse(myCalendar.addEvent(cs3704));

        Event cs4804 = new Course("CS 4804", new Interval(1325, 1415));
        assertTrue(myCalendar.addEvent(cs4804));

        Event ran = new Course("ran", new Interval(1417, 1420));
        assertTrue(myCalendar.addEvent(ran));

    }


    public void testAdd2() {
    }


    public void testHashSet() {
        Event cs3704 = new Course("CS 3704", new Interval(1430, 1545));
        Event cs4804 = new Course("CS 4804", new Interval(1325, 1415));
        Event cs3333 = new Course("CS 3333", new Interval(1200, 1300));

        Schedule s1 = new Schedule();
        s1.addEvent(cs3704);
        s1.addEvent(cs4804);
        Schedule s2 = new Schedule();
        s2.addEvent(cs4804);
        s2.addEvent(cs3704);
        Schedule s3 = new Schedule();
        s3.addEvent(cs4804);
        s3.addEvent(cs3333);

        HashSet<Schedule> set = new HashSet<Schedule>();
        set.add(s1);
        set.add(s2);
        set.add(s3);

        assertEquals(set.size(), 2);
    }
}
