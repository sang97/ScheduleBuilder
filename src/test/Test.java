package test;

import java.util.*;
import generator.CourseFilter;
import generator.ScheduleGenerator;
import model.Event;
import parser.HtmlParser;
import student.TestCase;

public class Test extends TestCase {
    HtmlParser parser;
    ScheduleGenerator sg;
    List<Event> allCourses;
    
    public void setUp() {
        parser = new HtmlParser();
        sg = new ScheduleGenerator();
    }
    
    public void test() {
        parser.beginParse();
        allCourses = parser.getAllCourses();
        
        List<String> nameList = new ArrayList<String>();
        
        nameList.add("CS-3214");
        ///nameList.add("CS-3114");
        //nameList.add("CS-4104");
        //nameList.add("CS-4604");
        //nameList.add("CS-3704");
        
        List<Event> courseList = new ArrayList<Event>();
        
        CourseFilter.filterClassWithCourseName(allCourses, nameList, courseList);
        
        sg.setEventList(courseList);
        
        sg.generateSchedule();

        System.out.println(sg.getAllSchedule().size());

        for (int i = 0; i < sg.getAllSchedule().size(); i++) {
            System.out.println(sg.getAllSchedule().get(i).toString());
        }
    }
}
