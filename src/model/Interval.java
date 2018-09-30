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
    Integer startTime;
    Integer endTime;
    
    public Interval(Integer start, Integer end) {
        
        startTime = start;
        endTime = end;
    }
    
    @Override
    public int compareTo(Interval other) {
        return this.startTime - other.startTime;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
        result = prime * result + ((startTime == null)
            ? 0
            : startTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Interval other = (Interval)obj;
        if (endTime == null) {
            if (other.endTime != null)
                return false;
        }
        else if (!endTime.equals(other.endTime))
            return false;
        if (startTime == null) {
            if (other.startTime != null)
                return false;
        }
        else if (!startTime.equals(other.startTime))
            return false;
        return true;
    }
    
    
    
}
