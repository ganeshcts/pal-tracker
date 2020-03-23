package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long, TimeEntry> inMemRepo = new HashMap<Long, TimeEntry>();

    @Override
    public TimeEntry find(long timeEntryId) {

        TimeEntry timeEntry = inMemRepo.get(timeEntryId);
        return timeEntry;
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        inMemRepo.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry update(long eq, TimeEntry timeEntry) {

        TimeEntry existingEntry = inMemRepo.get(eq);
        if (existingEntry == null)
            return null;
        timeEntry.setId(eq);
        inMemRepo.replace(eq, existingEntry, timeEntry);
        existingEntry = inMemRepo.get(eq);
        System.out.println("updated project id: " + existingEntry.getProjectId());
        return inMemRepo.get(eq);
    }

    @Override
    public void delete(long timeEntryId) {

        TimeEntry timeEntryOriginal = inMemRepo.get(timeEntryId);
        if (timeEntryOriginal == null) {
            throw new RuntimeException(timeEntryId + " not found.");
        }
        inMemRepo.remove(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {

        List<TimeEntry> timeEntryList = new ArrayList<TimeEntry>(inMemRepo.values());
        return timeEntryList;
    }
}
