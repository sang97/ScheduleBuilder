package generator;

import java.util.*;
import model.Event;

public class CourseFilter {
    
    public static List<Event> filterClassWithName(List<Event> allCourses, List<String> nameList) {
        List<Event> courseList = new ArrayList<Event>();
        
        for (Event course : allCourses) {
            String str = course.getName();
            
            if (nameList.contains(str)) {
                courseList.add(course);
            }
        }
        return courseList;
    }
}
