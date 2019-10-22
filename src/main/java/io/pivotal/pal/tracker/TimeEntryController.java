package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntry) {
        TimeEntry newTimeEntry = timeEntryRepository.create(timeEntry);
        return new ResponseEntity(newTimeEntry,HttpStatus.OK);
    }

    public ResponseEntity read(long timeEntryId) {
        TimeEntry newTimeEntry = timeEntryRepository.find(timeEntryId);
        return new ResponseEntity(newTimeEntry,HttpStatus.OK);
    }

    public ResponseEntity list() {
        List<TimeEntry> timeEntryList = timeEntryRepository.list();
            return new ResponseEntity(timeEntryList,HttpStatus.OK);
    }

    public ResponseEntity update(long timeEntryId, TimeEntry expected) {
        TimeEntry newTimeEntry = timeEntryRepository.update(timeEntryId,expected);
        return new ResponseEntity(newTimeEntry,HttpStatus.OK);
    }

    public ResponseEntity delete(long timeEntryId) {
        TimeEntry newTimeEntry = timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity(newTimeEntry,HttpStatus.OK);
    }
}
