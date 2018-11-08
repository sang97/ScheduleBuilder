package model;

/**
 * Event interface
 * 
 * @author Sang Nguyen
 * @version 1.0
 */
import java.util.*;

public interface Event extends Comparable<Event> {
    public String getName();

    public Interval getTime();

    public List<DayOfWeek> getDayOfEvent();
    
}
