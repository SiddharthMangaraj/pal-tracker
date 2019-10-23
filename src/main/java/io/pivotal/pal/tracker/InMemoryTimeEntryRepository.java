package io.pivotal.pal.tracker;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository  {

    long  counter = 1L;
    HashMap<Long, TimeEntry> timeEntryMap =new HashMap();

    public TimeEntry create(TimeEntry timeEntry) {

        long id = counter++;

        timeEntry.setId(id);

        timeEntryMap.put(id,timeEntry);

        return timeEntry;

    }
    public TimeEntry find(Long timeEntryId){
        return timeEntryMap.get(timeEntryId);
    }
    public List<TimeEntry> list(){
        return new ArrayList< TimeEntry>(timeEntryMap.values());
    }
    public TimeEntry update(Long timeEntryId,TimeEntry timeEntry){
        TimeEntry timeEntry1=timeEntryMap.get(timeEntryId);
        if(timeEntry1!=null) {
            timeEntry1.setProjectId(timeEntry.getProjectId());
            timeEntry1.setUserId(timeEntry.getUserId());
            timeEntry1.setDate(timeEntry.getDate());
            timeEntry1.setHours(timeEntry.getHours());
            return timeEntry1;
        }
        else
        {
            return null;
        }
    }
    public void delete(Long timeEntryId){
        timeEntryMap.remove(timeEntryId);

    }
}
