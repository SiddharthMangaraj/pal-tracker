package io.pivotal.pal.tracker;

import java.util.HashMap;
import java.util.List;

public interface TimeEntryRepository  {

    public TimeEntry create(TimeEntry timeEntry);
    public TimeEntry find(long timeEntryId);
    public List list();
    public TimeEntry update(long timeEntryId,TimeEntry timeEntry);
    public void delete(long timeEntryId);
}