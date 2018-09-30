import java.util.*;

/**
 * this class used to represent an instructor
 * 
 * @author Sang Nguyen
 * @version 1.0
 */

public class Instructor {
    private String name;

    private String description;

    private Integer overallGPA;

    private List<CourseInfo> courseTeach;

    private Map<CourseInfo, Integer> gpaForCourses;

    private Map<AcademicTerm, Integer> gpaForTerms;


    private Instructor(String name) {
        this.name = name;
        courseTeach = new ArrayList<CourseInfo>();
        gpaForCourses = new HashMap<CourseInfo, Integer>();
        gpaForTerms = new TreeMap<AcademicTerm, Integer>();
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public List<CourseInfo> getCourseTeach() {
        return courseTeach;
    }


    public Integer getOverallGPA() {
        return overallGPA;
    }


    public void setOverallGPA(Integer overallGPA) {
        this.overallGPA = overallGPA;
    }

    /**
     * add new course with no average GPA
     */
    public void addCourse(CourseInfo newCourse) {
        this.addCourse(newCourse, null);
    }
    
    /**
     * add new course with average GPA
     */
    public void addCourse(CourseInfo newCourse, Integer averageGPA) {
        if (!courseTeach.contains(newCourse)) {
            courseTeach.add(newCourse);
            gpaForCourses.put(newCourse, averageGPA);
        }
    }

    /**
     * remove course 
     */
    public void removeCourse(CourseInfo removeCourse) {
        if (courseTeach.contains(removeCourse)) {
            courseTeach.remove(removeCourse);
            gpaForCourses.remove(removeCourse);
        }
    }

    }
