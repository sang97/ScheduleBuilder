/**
 * Event interface
 * 
 * @author Sang Nguyen
 * @version 1.0
 */
public interface Event extends Comparable<Event> {
    public String getName();

    public Interval getTime();

 
    public DayOfWeek[] getDayInWeek();
}