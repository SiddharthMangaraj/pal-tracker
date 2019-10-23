package io.pivotal.pal.tracker;

import java.util.HashMap;
import java.util.List;

public interface TimeEntryRepository  {

    public TimeEntry create(TimeEntry timeEntry);
    public TimeEntry find(Long timeEntryId);
    public List list();
    public TimeEntry update(Long timeEntryId,TimeEntry timeEntry);
    public void delete(Long timeEntryId);
}
