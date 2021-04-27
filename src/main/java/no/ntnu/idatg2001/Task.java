package no.ntnu.idatg2001;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {

    /**
     * All the fields of the Task object.
     */
    private static final long serialVersionID = 1L;

    private String title;
    private String priority;
    private String description;
    private String category;
    private LocalDate startDate;
    private LocalDate endDate;

    private String doingStatus;


    /**
     * The constructor for the task object.
     * @param title
     * @param priority
     * @param description
     * @param category
     * @param startDate
     * @param endDate
     */
    public Task(String title, String priority, String description, String category, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.priority = priority;
        this.description = description;
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        doingStatus = "todo";
    }

    /**
     * Returns the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the priority.
     * @return
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets the priority.
     * @param priority
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * Returns the description.
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the category.
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category.
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Returns the start date.
     * @return
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     * @param startDate
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Returns the end date.
     * @return
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date.
     * @param endDate
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Returns the doing status.
     * @return
     */
    public String getDoingStatus() {
        return doingStatus;
    }

    /**
     * Sets the doing status to one of the three possibilities.
     * @param status
     */
    public void setDoingStatus(String status) {
        if (status.equalsIgnoreCase("toDo")) {
            doingStatus = "ToDo";
        } else if (status.equalsIgnoreCase("Doing")) {
            doingStatus = "Doing";
        } else if (status.equalsIgnoreCase("Done")) {
            doingStatus = "Done";
        } else {
            System.out.println("Doing status not changed due to invalid input");
        }

    }

    /**
     * Returns the information about the task as a reformed string.
     * @return
     */
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
