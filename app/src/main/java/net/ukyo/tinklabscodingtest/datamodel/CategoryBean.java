package net.ukyo.tinklabscodingtest.datamodel;

/**
 * Created by ukyo on 2017/7/12.
 * <p>
 * data model: Category as JavaBean type
 */

public class CategoryBean {

    private String imagePath;
    private String title;
    private String description;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
