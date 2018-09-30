package parser;

import java.io.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import model.Course;
import model.CourseInfo;
import model.DayOfWeek;
import model.Event;
import model.Interval;
import java.util.*;

public class HtmlParser {

    List<Event> courses;


    public HtmlParser() {
        courses = new ArrayList<Event>();
    }


    public void parseCourse(Element tablerow) {
        Elements entries = tablerow.getElementsByClass("pldefault");
        switch (entries.size()) {
            case 0:
                // System.out.println("Header");
                return;
            case 2:
                // System.out.println("Comments");
                return;
            default:
        }

        try {
            int colspan = 1;

            Course newCourse = new Course();

            String crn = entries.get(0).child(1).text();
            newCourse.setCrn(Integer.valueOf(crn));

            String courseName = entries.get(1).child(0).text();
            newCourse.setName(courseName);

            String title = entries.get(2).text();
            newCourse.setTitle(title);

            String type = entries.get(3).text();
            newCourse.setType(type);

            String crHrs = entries.get(4).text();
            //newCourseInfo.setCreditHours(Integer.valueOf(crHrs));

            String seats = entries.get(5).child(0).child(0).text();
            //newCourse.setSeats(Integer.valueOf(seats));

            String capacity = entries.get(6).text();
            newCourse.setCapacity(Integer.valueOf(capacity));

            String instructor = entries.get(7).text();
            newCourse.setInstructorName(instructor);
            
            String days = entries.get(8).text();
            List<DayOfWeek> classDays = new ArrayList<>();
            
            for (char c : days.toCharArray()) {
                DayOfWeek temp = DayOfWeek.convertToDayOfWeekType(c);
                if (temp == null && classDays.size() == 0) break;
                else if (temp != null) {
                    classDays.add(temp);
                }
            }
            
            newCourse.setDays(classDays);
            
            
            String begin = "(ARR)";
            String end = "(ARR)";
            if (!entries.get(9).hasAttr("colspan")) {
                colspan = 0;
                begin = entries.get(9).text();
                end = entries.get(10).text();
                
                int startTime = getIntegerFromTime(begin);
                int endTime = getIntegerFromTime(end);
                
                Interval time = new Interval(startTime, endTime);
                
                newCourse.setTime(time);
                
            }
            String location = entries.get(11 - colspan).text();
            newCourse.setLocation(location);
            
            String exam = entries.get(12 - colspan).text();
            newCourse.setExam(exam);
            
            courses.add(newCourse);
        }
        catch (Exception ex) {
        }
    }
    
    private int getIntegerFromTime(String time) {
        int hours = 0;
        int minutes = 0;
        
        if (time.length() == 7) {
            hours = Integer.valueOf(time.substring(0, 2));
            time = time.substring(3);
        }
        else {
            hours = Integer.valueOf(time.substring(0, 1));
            time = time.substring(2);
        }
        
        minutes = Integer.valueOf(time.substring(0, 2));
        time = time.substring(2);
        
        if (time.equals("PM") && hours != 12) {
            hours += 12;
        }
        
        return hours * 100 + minutes;
    }


    public void beginParse() {
        try {
            File input = new File("extras/timetable.html");
            Document doc = Jsoup.parse(input, "UTF-8");

            Elements tables = doc.getElementsByClass("plaintable");
            Element table = tables.iterator().next().child(0);
            for (Element tablerow : table.children()) {
                parseCourse(tablerow);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public List<Event> getAllCourses() {
        return courses;
    }
}
