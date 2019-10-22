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
        return new ResponseEntity(newTimeEntry,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity read(@PathVariable long timeEntryId) {
        TimeEntry newTimeEntry = timeEntryRepository.find(timeEntryId);
        if(newTimeEntry!=null) {
            return new ResponseEntity(newTimeEntry, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(newTimeEntry, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping()
    public ResponseEntity list() {
        List<TimeEntry> timeEntryList = timeEntryRepository.list();
        return new ResponseEntity(timeEntryList,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable long timeEntryId,@RequestBody TimeEntry expected) {
        TimeEntry newTimeEntry = timeEntryRepository.update(timeEntryId,expected);
        if(newTimeEntry!=null) {
            return new ResponseEntity(newTimeEntry, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(newTimeEntry, HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity(null,HttpStatus.NO_CONTENT);
    }
}
