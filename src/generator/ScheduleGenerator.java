package generator;

import java.util.*;
import model.Event;
import model.Schedule;

public class ScheduleGenerator {
    private List<Schedule> generator;
    private List<Event> eventList;
    private Set<Schedule> allSchedule;
    private Set<Event> eventAdded;

    public ScheduleGenerator() {
        this(null);
    }


    public ScheduleGenerator(List<Event> newEventList) {
        init(newEventList);
    }


    public void init(List<Event> newEventList) {
        generator = new ArrayList<Schedule>();
        eventList = newEventList;
        allSchedule = new HashSet<Schedule>();
        eventAdded = new HashSet<Event>();
    }


    public void generateSchedule() {
        findDistinctCourse(eventList);
        createPermutation(new ArrayList<Event>(), 0);
    }

    private void findDistinctCourse(List<Event> courses) {
        for (Event course : courses) {
            eventAdded.add(course);
        }
    }

    private void createPermutation(List<Event> tempList, int num) {
        if (num == eventAdded.size()) {
            // a new permutation is generated, start adding event to the
            // schedule

            // create a temporary schedule,
            Schedule tempSchedule = new Schedule();

            // add all the course to schedule
            for (int i = 0; i < tempList.size(); i++) {
                Event currEvent = tempList.get(i);
                tempSchedule.addEvent(currEvent);
            }

            // check if we already have the schedule in our schedule list
            if (!allSchedule.contains(tempSchedule)) {
                generator.add(tempSchedule);
                allSchedule.add(tempSchedule);
            }
        }
        else {

            // recursive method to create all the permutation of the event list
            // we have
            for (int i = 0; i < eventList.size(); i++) {
                Event tempEvent = eventList.get(i);
                if (tempList.contains(tempEvent)) {
                    continue;
                }
                tempList.add(tempEvent);
                createPermutation(tempList, num + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public void setEventList(List<Event> newEventList) {
        eventList = newEventList;
    }


    public List<Schedule> getAllSchedule() {
        Collections.sort(generator, new Comparator<Schedule>() {

            @Override
            public int compare(Schedule s1, Schedule s2) {
                // TODO Auto-generated method stub
                return s2.getNumberOfEvent() - s1.getNumberOfEvent();
            }
        
        });
        return generator;
    }
}
