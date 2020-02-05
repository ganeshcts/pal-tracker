package io.pivotal.pal.tracker;

import java.time.LocalDate;


public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;

    public TimeEntry() {

    }

    public long getProjectId() {
        return projectId;
    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {

        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    private int hours;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
