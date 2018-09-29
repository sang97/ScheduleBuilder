
public class CourseInfo {
    private String name;
    private String title;
    private Integer creditHours;
    
    public CourseInfo() {
        this(null, null, null);
    }
    
    public CourseInfo(String courseName, String courseTitle, Integer courseCreditHours) {
        name = courseName;
        title = courseTitle;
        creditHours = courseCreditHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }
    
    
    
}