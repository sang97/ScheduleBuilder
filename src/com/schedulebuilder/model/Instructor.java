package com.schedulebuilder.model;

import java.util.*;

/**
 * this class used to represent an instructor 
 * @author Sang Nguyen
 * @version 1.0
 */


public class Instructor {
    private String name;
    
    private String description;
    
    private CourseInfo[] courseTeach;
    
    private int overallGPA;
    
    private Map<CourseInfo, Integer> gpaForCourses;
    
    private Map<AcademicTerm, Integer> gpaForTerms;
    
    private Instructor(String name) {
        this.name = name;
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

    public CourseInfo[] getCourseTeach() {
        return courseTeach;
    }

    public void setCourseTeach(CourseInfo[] courseTeach) {
        this.courseTeach = courseTeach;
    }

    public int getOverallGPA() {
        return overallGPA;
    }

    public void setOverallGPA(int overallGPA) {
        this.overallGPA = overallGPA;
    }

    public Map<CourseInfo, Integer> getGpaForCourses() {
        return gpaForCourses;
    }

    public void setGpaForCourses(Map<CourseInfo, Integer> gpaForCourses) {
        this.gpaForCourses = gpaForCourses;
    }

    public Map<AcademicTerm, Integer> getGpaForTerms() {
        return gpaForTerms;
    }

    public void setGpaForTerms(Map<AcademicTerm, Integer> gpaForTerms) {
        this.gpaForTerms = gpaForTerms;
    }
    
    
    
}
