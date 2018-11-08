package model;
import java.util.*;

public class Schedule {
    // key is day in a week
    // value is a tree map where we keep track of start and end time of an
    // event so that none of them is duplicated
    Map<Integer, TreeMap<Integer, Integer>> availableTime;

    // store the events from Monday-Sunday
    List<LinkedList<Event>> schedule;

    // the total number of events in the schedule
    int numberOfEvent;
    
    //all the event in the schedule
    Set<String> allEventsName;
    
    public int getNumberOfEvent() {
        return numberOfEvent;
    }
    
    public Schedule() {
        availableTime = new HashMap<>();
        schedule = new ArrayList<>();
        allEventsName = new HashSet<>();
        numberOfEvent = 0;

        // Monday to Sunday (0 to 6)
        for (int i = 0; i < 7; i++) {
            availableTime.put(i, new TreeMap<Integer, Integer>());
            schedule.add(new LinkedList<Event>());
        }
    }


    public boolean addEvent(Event newEvent) {
        if (!checkAvailibity(newEvent)) {
            return false;
        }

        List<DayOfWeek> eventDayInWeek = newEvent.getDayOfEvent();

        for (DayOfWeek weekDay : eventDayInWeek) {
            int day = weekDay.getDayNumber();
            TreeMap<Integer, Integer> currentDay = availableTime.get(day);
            Interval newInterval = newEvent.getTime();
            int start = newInterval.startTime;
            int end = newInterval.endTime;

            currentDay.put(start, end);
            schedule.get(day).add(newEvent);
            Collections.sort(schedule.get(day));
        }
        
        allEventsName.add(newEvent.getName());
        numberOfEvent++;
        return true;
    }


    private boolean checkAvailibity(Event newEvent) {
        if (allEventsName.contains(newEvent.getName())) return false;
        
        List<DayOfWeek> eventDayInWeek = newEvent.getDayOfEvent();
        for (DayOfWeek weekDay : eventDayInWeek) {
            int day = weekDay.getDayNumber();
            TreeMap<Integer, Integer> currentDay = availableTime.get(day);
            Interval newInterval = newEvent.getTime();
            int start = newInterval.startTime;
            int end = newInterval.endTime;

            Integer prev = currentDay.floorKey(start), next = currentDay
                .ceilingKey(start);

            if (!((prev == null || currentDay.get(prev) < start)
                && (next == null || end < next))) {
                return false;
            }
        }
        return true;
    }


    /**
     * public void deleteEvent(Event event) {
     * DayOfWeek[] eventDayInWeek = event.getDayInWeek();
     * for (int day : eventDayInWeek) {
     * TreeMap<Integer, Integer> currentDay = availableTime.get(day);
     * Interval interval = event.getInterval();
     * currentDay.remove(interval.startTime);
     * schedule.get(day).remove(event);
     * }
     * numberOfEvent--;
     * }
     * 
     * public int getNumberOfEvent() {
     * return numberOfEvent;
     * }
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((availableTime == null) ? 0 : availableTime.hashCode());
        result = prime * result + numberOfEvent;
        result = prime * result + ((schedule == null)
            ? 0
            : schedule.hashCode());
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
        Schedule other = (Schedule)obj;
        if (availableTime == null) {
            if (other.availableTime != null)
                return false;
        }
        else if (!availableTime.equals(other.availableTime))
            return false;
        if (numberOfEvent != other.numberOfEvent)
            return false;
        if (schedule == null) {
            if (other.schedule != null)
                return false;
        }
        else if (!schedule.equals(other.schedule))
            return false;
        return true;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();

        DayOfWeek[] dayOfWeek = DayOfWeek.arrayOfWeek();
        for (int i = 0; i < 5; i++) {
            sb.append(dayOfWeek[i].toStringShortForm() + ": ");
            LinkedList<Event> currDay = schedule.get(i);

            for (int j = 0; j < currDay.size(); j++) {
                sb.append(currDay.get(j).toString() + " ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }

}
