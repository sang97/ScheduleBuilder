package com.schedulebuilder.test;

import student.TestCase;
import java.util.*;

import com.schedulebuilder.generator.ScheduleGenerator;
import com.schedulebuilder.model.Event;
import com.schedulebuilder.model.Course;
import com.schedulebuilder.model.DayOfWeek;
import com.schedulebuilder.model.Interval;

public class GeneratorTest extends TestCase {
    ScheduleGenerator sg;


    public void setUp() {
        sg = new ScheduleGenerator();
    }


    public void test() {
        Event cs3333 = new Course("CS 3333", new Interval(1430, 1545),
            new DayOfWeek[] { DayOfWeek.MONDAY });
        Event cs3704 = new Course("CS 3704", new Interval(1430, 1545),
            new DayOfWeek[] { DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY });
        Event cs4444 = new Course("CS 4444", new Interval(1300, 1400),
            new DayOfWeek[] { DayOfWeek.MONDAY });
        Event cs4804 = new Course("CS 4804", new Interval(1325, 1415),
            new DayOfWeek[] { DayOfWeek.MONDAY });
        Event cs3214 = new Course("CS 3214", new Interval(1600, 1715),
            new DayOfWeek[] { DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY });

        List<Event> courseList = new ArrayList<Event>();
        courseList.add(cs3333);
        courseList.add(cs3704);
        courseList.add(cs4804);
        courseList.add(cs3214);
        courseList.add(cs4444);

        sg.setEventList(courseList);
        sg.generateSchedule();

        System.out.println(sg.generator.size());

        for (int i = 0; i < sg.generator.size(); i++) {
            System.out.println(sg.generator.get(i).toString());
        }
    }

}
