
public class Course implements Event {
    private int crn;
    private String name;
    private String title;
    private String type;
    private int courseHour;
    private int seats;
    private int capacity;
    private String instructor;
    private DayOfWeek[] days;
    private Interval time;
    private String location;
    private String exam;

    private int priority;

    public Course(String courseName, Interval courseInterval) {
        this(courseName, courseInterval, new DayOfWeek[] { DayOfWeek.MONDAY },
            0);
    }


    public Course(
        String courseName,
        Interval courseInterval,
        DayOfWeek[] courseDayInWeek) {
        this(courseName, courseInterval, courseDayInWeek, 0);
    }


    public Course(
        String courseName,
        Interval courseInterval,
        DayOfWeek[] courseDays,
        int coursePriority) {
        name = courseName;
        time = courseInterval;
        days = courseDays;
        priority = coursePriority;
    }


    @Override
    public DayOfWeek[] getDayInWeek() {
        return days;
    }


    @Override
    public String toString() {
        return name;
    }


    @Override
    public String getName() {
        return name;
    }


    @Override
    public Interval getTime() {
        return time;
    }


    @Override
    public int compareTo(Event anotherEvent) {
        // TODO Auto-generated method stub
        int intervalComp = this.time.compareTo(anotherEvent.getTime());
        return (intervalComp == 0)
            ? this.name.compareTo(anotherEvent.getName())
            : intervalComp;
    }

}
