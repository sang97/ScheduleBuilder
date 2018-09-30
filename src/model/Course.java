package model;

import java.util.*;

public class Course implements Event {
    private Integer crn;
    private String name;
    private String title;
    private String type;
    private Integer seats;
    private Integer capacity;
    private String instructorName;

    private List<DayOfWeek> days;
    private Interval time;
    private String location;
    private String exam;

    private Integer priority; // used to generate schedule, course with higher
    // priority will be always in the schedule

    private Instructor instructor;
    private CourseInfo courseInfo;


    @Override
    public int compareTo(Event anotherEvent) {
        // TODO Auto-generated method stub
        return this.time.compareTo(anotherEvent.getTime());
    }


    @Override
    public List<DayOfWeek> getDayOfWeek() {
        return days;
    }


    @Override
    public String toString() {
        return name + " " + time.startTime + "-" + time.endTime;
    }


    @Override
    public String getName() {
        return name;
    }


    @Override
    public Interval getTime() {
        return time;
    }


    public Integer getCrn() {
        return crn;
    }


    public String getType() {
        return type;
    }


    public Integer getSeats() {
        return seats;
    }


    public Integer getCapacity() {
        return capacity;
    }


    public List<DayOfWeek> getDays() {
        return days;
    }


    public void setDays(List<DayOfWeek> days) {
        this.days = days;
    }


    public String getLocation() {
        return location;
    }


    public String getExam() {
        return exam;
    }


    public Integer getPriority() {
        return priority;
    }


    public Instructor getInstructor() {
        return instructor;
    }


    public CourseInfo getCourseInfo() {
        return courseInfo;
    }


    public void setCrn(Integer crn) {
        this.crn = crn;
    }


    public void setType(String type) {
        this.type = type;
    }


    public void setSeats(Integer seats) {
        this.seats = seats;
    }


    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


    public void setTime(Interval time) {
        this.time = time;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public void setExam(String exam) {
        this.exam = exam;
    }


    public void setPriority(Integer priority) {
        this.priority = priority;
    }


    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


    public void setCourseInfo(CourseInfo courseInfo) {
        this.courseInfo = courseInfo;
    }


    public String getInstructorName() {
        return instructorName;
    }


    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Course))
            return false;
        
        Course course = (Course) obj;
        
        return name.equals(course.getName()) && time.equals(course.getTime());
    }
    
    

}
