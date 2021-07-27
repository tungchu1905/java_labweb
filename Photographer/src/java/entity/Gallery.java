/*
 * Copyright(C) 2005,  FPT University.
 * J3.L.P0017:
 * Photograph
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-06-20     1.0              TungCTHE141487      First Implement
 */
package entity;

/**
 * The class object of Gallery, all properties have <code>get</code>
 * <code>set</code> method
 *
 * @author TungCTHE141487
 */
public class Gallery {

    /**
     * information of id
     */
    private int id;
    /**
     * information of name
     */
    private String name;
    /**
     * information of description
     */
    private String description;
    /**
     * information of image
     */
    private String image;

    /**
     * Constructor without parameter
     */
    public Gallery() {
    }

    /**
     * Constructor with parameter
     *
     * @param id the id of <code>Gallery</code> object, it is an
     * <code>int</code> type
     * @param name the name of <code>Gallery</code> object, it is a
     * <code>java.lang.String</code>
     * @param description the description of <code>Gallery</code> object, it is
     * a <code>java.lang.String</code>
     * @param image the image of <code>Gallery</code> object, it is a
     * <code>java.lang.String</code>
     */
    public Gallery(int id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    /**
     * Get value from id attribute of <code>Gallery</code> object
     *
     * @return id of <code>Gallery</code> object, it is a <code>int</code>
     * primitive type
     */
    public int getId() {
        return id;
    }

    /**
     * Set value to id attribute of <code>Gallery</code> object
     *
     * @param id the id of <code>Gallery</code> object, it is a <code>int</code>
     * primitive type
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from name attribute of <code>Gallery</code> object
     *
     * @return name of <code>Gallery</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public String getName() {
        return name;
    }

    /**
     * Set value to name attribute of <code>Gallery</code> object
     *
     * @param name the name of <code>Gallery</code> object, it is a
     * <code>java.lang.String</code>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get value from description attribute of <code>Gallery</code> object
     *
     * @return description of <code>Gallery</code> object, it is a
     * <code>java.lang.String</code>
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set value to attribute description of <code>Gallery</code> object
     *
     * @param description the description of <code>Gallery</code> object. It is
     * a <code>java.lang.String</code>
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get value from image attribute of <code>Gallery</code> object
     *
     * @return image of <code>Gallery</code> object, it is a
     * <code>java.lang.String</code>
     */
    public String getImage() {
        return image;
    }

    /**
     * Set value to image attribute of <code>Gallery</code> object
     *
     * @param image the image of <code>Gallery</code> object, it is a
     * <code>java.lang.String</code>
     */
    public void setImage(String image) {
        this.image = image;
    }
}
