package io.pivotal.pal.tracker;

import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    @Override
    public TimeEntry find(long timeEntryId) {
        return null;
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        return null;
    }

    @Override
    public TimeEntry update(long eq, TimeEntry timeEntry) {
        return null;
    }

    @Override
    public void delete(long timeEntryId) {

    }

    @Override
    public List<TimeEntry> list() {
        return null;
    }
}
