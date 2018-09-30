import java.util.*;

public class Schedule {
    // key is day in a week
    // value is a tree map where we keep track of start and end time of an
    // event so that none of them is duplicated
    HashMap<Integer, TreeMap<Integer, Integer>> mapping;

    // store the events from Monday-Sunday
    ArrayList<LinkedList<Event>> schedule;

    // the total number of events in the schedule
    int numberOfEvent;


    public Schedule() {
        mapping = new HashMap<>();
        schedule = new ArrayList<>();
        numberOfEvent = 0;

        // Monday to Sunday (0 to 6)
        for (int i = 0; i < 7; i++) {
            mapping.put(i, new TreeMap<Integer, Integer>());
            schedule.add(new LinkedList<Event>());
        }
    }


    public boolean addEvent(Event newEvent) {
        if (!checkAvailibity(newEvent)) {
            return false;
        }

        DayOfWeek[] eventDayInWeek = newEvent.getDayInWeek();

        for (DayOfWeek weekDay : eventDayInWeek) {
            int day = weekDay.getDayNumber();
            TreeMap<Integer, Integer> currentDay = mapping.get(day);
            Interval newInterval = newEvent.getTime();
            int start = newInterval.startTime;
            int end = newInterval.endTime;

            currentDay.put(start, end);
            schedule.get(day).add(newEvent);
            Collections.sort(schedule.get(day));
        }

        numberOfEvent++;
        return true;
    }


    private boolean checkAvailibity(Event newEvent) {
        DayOfWeek[] eventDayInWeek = newEvent.getDayInWeek();

        for (DayOfWeek weekDay : eventDayInWeek) {
            int day = weekDay.getDayNumber();
            TreeMap<Integer, Integer> currentDay = mapping.get(day);
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
     * TreeMap<Integer, Integer> currentDay = mapping.get(day);
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
        result = prime * result + ((mapping == null) ? 0 : mapping.hashCode());
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
        if (mapping == null) {
            if (other.mapping != null)
                return false;
        }
        else if (!mapping.equals(other.mapping))
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

        DayOfWeek[] dayOfWeek = DayOfWeek.arrayDayOfWeek();
        for (int i = 0; i < 7; i++) {
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
