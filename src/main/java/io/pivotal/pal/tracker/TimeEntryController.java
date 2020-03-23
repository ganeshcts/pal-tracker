package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private long count = 1;

    @Autowired
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController() {
    }

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {

        timeEntryToCreate.setId(this.count);
        this.count++;
        TimeEntry createdTimeEntry = timeEntryRepository.create(timeEntryToCreate);
        System.out.println(createdTimeEntry.getId());
        System.out.println(createdTimeEntry.getUserId());
        System.out.println(createdTimeEntry.getDate());
        System.out.println(createdTimeEntry.getHours());
        return new ResponseEntity(createdTimeEntry, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable(value = "id") long timeEntryId) {

        TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);
        if (timeEntry == null) {
            return new ResponseEntity<>(timeEntry, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(timeEntry);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") long timeEntryId, @RequestBody TimeEntry expected) {

        TimeEntry updatedTimeEntry = timeEntryRepository.update(timeEntryId, expected);
        if (updatedTimeEntry == null) {
            return new ResponseEntity<>(updatedTimeEntry, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updatedTimeEntry, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<List<TimeEntry>>(timeEntryRepository.list(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") long timeEntryId) {

        timeEntryRepository.delete(timeEntryId);
        TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);
        if (timeEntry == null) {

            return new ResponseEntity<>(timeEntry, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(timeEntry, HttpStatus.NOT_FOUND);
    }
}
