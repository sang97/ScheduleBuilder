package com.schedulebuilder.model;

/**
 * Enum type for day of week and values associated with them.
 * MONDAY (0) -> SUNDAY(6)
 * @author Sang Nguyen
 * @version 1.0
 */

public enum DayOfWeek {
    MONDAY(0), TUESDAY(1), WEDNESDAY(2), THURSDAY(3), FRIDAY(4), SATURDAY(5), SUNDAY(6);
    
    private int dayNumber;
    
    /**
     * constructor 
     * @param dayNumber
     */
    private DayOfWeek(int dayNumber) {
        this.dayNumber = dayNumber;
    }
    
    /**
     * get day number
     */
    public int getDayNumber() {
        return dayNumber;
    }
    
    /**
     * return English words for day
     */
    @Override
    public String toString() {
        switch(this.dayNumber) {
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            case 3:
                return "Thursday";
            case 4:
                return "Friday";
            case 5:
                return "Saturday";
            case 6:
                return "Sunday";
            default:
                return null;
        }
    }
    
    /**
     * short form
     */
    public String toStringShortForm() {
        switch(this.dayNumber) {
            case 0:
                return "Mon";
            case 1:
                return "Tue";
            case 2:
                return "Wed";
            case 3:
                return "Thu";
            case 4:
                return "Fri";
            case 5:
                return "Sat";
            case 6:
                return "Sun";
            default:
                return null;
                
                
        }
    }
    
    /**
     * convert letter to DayOfWeek type
     */
    public static DayOfWeek convertToDayOfWeekType(char letter) {
        switch(letter) {
            case 'M':
                return DayOfWeek.MONDAY;
            case 'T':
                return DayOfWeek.TUESDAY;
            case 'W':
                return DayOfWeek.WEDNESDAY;
            case 'R':
                return DayOfWeek.THURSDAY;
            case 'F':
                return DayOfWeek.FRIDAY;
            default:
                return null;
        }
    }
    
    
}
