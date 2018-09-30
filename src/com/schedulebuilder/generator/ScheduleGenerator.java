package com.schedulebuilder.generator;

import java.util.*;

import com.schedulebuilder.model.Event;
import com.schedulebuilder.model.Schedule;

public class ScheduleGenerator {
    public List<Schedule> generator;
    List<Event> eventList;
    HashSet<Schedule> set;
    
    
    public ScheduleGenerator() {
        this(null);
    }
    
    public ScheduleGenerator(List<Event> newEventList) {
        init(newEventList);
    }
    
    public void init(List<Event> newEventList) {
        generator = new ArrayList<Schedule>();
        eventList = newEventList;
        set = new HashSet<Schedule>();
    }
    
    public void generateSchedule() {
        createPermutation(new ArrayList<Event>());
    }
    
    private void createPermutation(List<Event> tempList) {
        if (tempList.size() == eventList.size()) {
            //a new permutation is generated, start adding event to the schedule
            
            //create a temporary schedule, 
            Schedule tempSchedule = new Schedule();
            
            for (int i = 0; i < tempList.size(); i++) {
                Event currEvent = tempList.get(i);
                tempSchedule.addEvent(currEvent);
            }
            if (!set.contains(tempSchedule)) {
                generator.add(tempSchedule);
                set.add(tempSchedule);
            }
        }
        else {
            
            //recursive method to create all the permutation of the event list we have
            for (int i = 0; i < eventList.size(); i++) {
                Event tempEvent = eventList.get(i);
                if (tempList.contains(tempEvent)) continue;
                tempList.add(tempEvent);
                createPermutation(tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    
    public void setEventList(List<Event> newEventList) {
        eventList = newEventList;
    }
}
