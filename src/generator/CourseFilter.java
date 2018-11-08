package generator;

import java.util.*;
import model.Event;

public class CourseFilter {

    /**
     * Add all the course with a given list of name
     * 
     * @param allCourses
     *            the data of all course
     * @param nameList
     *            name list of the course
     * @param courseList
     *            list of course
     */
    public static void filterClassWithCourseName(
        List<Event> allCourses,
        List<String> nameList,
        List<Event> courseList) {
        for (Event course : allCourses) {
            String str = course.getName();

            if (nameList.contains(str)) {
                courseList.add(course);
            }
        }
    }
    
    

}
