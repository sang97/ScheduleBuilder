package model;
/**
 * represents the time interval
 * 
 * convert time to integer
 * for instance 1:00 -> 100
 *              13:00 -> 1300
 *              
 *              which makes easier to compare
 * @author Sang Nguyen
 * @version 1.0
 *
 */


public class Interval implements Comparable<Interval> {
    int startTime;
    int endTime;
    
    public Interval(int start, int end) {
        
        startTime = start;
        endTime = end;
    }
    
    @Override
    public int compareTo(Interval other) {
        return this.startTime - other.startTime;
    }
    
}
