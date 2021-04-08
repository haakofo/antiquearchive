package no.ntnu.idatg2001;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    private static final long serialVersionID = 1L;

    private String title;
    private String priority;
    private String description;
    private String category;
    private LocalDate startDate;
    private LocalDate endDate;

    private String doingStatus;



    public Task(String title, String priority, String description, String category, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.priority = priority;
        this.description = description;
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        doingStatus = "todo";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDoingStatus() {
        return doingStatus;
    }

    public void setDoingStatus(String status) {
        if (status.equalsIgnoreCase("toDo")) {
            doingStatus = "ToDo";
        } else if (status.equalsIgnoreCase("Doing")) {
            doingStatus = "Doing";
        } else if (status.equalsIgnoreCase("Done")) {
            doingStatus = "Done";
        } else {
            System.out.println("doing status not changed due to invalid input");
        }

    }

    @Override
    public String toString() {
        return "Task{ " + "\n" +
                "title:" + title + "\n" +
                "priority: " + priority + "\n" +
                "description: " + description + "\n" +
                "category: " + category + "\n" +
                "startDate: " + startDate + "\n" +
                "endDate: " + endDate + "\n" +
                "doing status: " + doingStatus + "\n" +
                '}';
    }
}
