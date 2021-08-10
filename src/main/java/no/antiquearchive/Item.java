package no.antiquearchive;

import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Serializable {

    /**
     * All the fields of the Task object.
     */
    private static final long serialVersionID = 1L;

    private String modelAlias;
    private String description;
    private String briefDescription;
    private String category;


    /**
     * The constructor for the task object.
     * @param modelAlias
     * @param briefDescription
     * @param description
     * @param category
     */
    public Item(String modelAlias, String description, String category, String briefDescription) {
        this.modelAlias = modelAlias;
        this.description = description;
        this.category = category;
        this.briefDescription = briefDescription;
    }

    /**
     * Returns the title.
     */
    public String getModelAlias() {
        return modelAlias;
    }

    /**
     * Sets the title.
     * @param modelAlias
     */
    public void setModelAlias(String modelAlias) {
        this.modelAlias = modelAlias;
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
     * Returns the information about the task as a reformed string.
     * @return
     */
    @Override
    public String toString()
    {
        return "Task{ " + "\n" +
                "title:" + modelAlias + "\n" +
                "priority: " + briefDescription + "\n" +
                "category: " + category + "\n" +
                '}';
    }
}
