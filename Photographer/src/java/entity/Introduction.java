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
 * The class object of Introduction, all properties have <code>get</code>
 * <code>set</code> method
 *
 * @author TungCTHE141487
 */
public class Introduction {

    /**
     * Information of image
     */
    private String image;
    /**
     * Information of entry
     */
    private String entry;
    /**
     * Information of aboutMe
     */
    private String aboutMe;

    public Introduction() {
    }

    /**
     * Constructor with parameter
     *
     * @param image the image of <code>Introduction</code> object, it is a
     * <code>java.lang.String</code> object
     * @param entry the entry of <code>Introduction</code> object, it is a
     * <code>java.lang.String</code> object
     * @param aboutme the aboutMe of <code>Introduction</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public Introduction(String image, String entry, String aboutme) {
        this.image = image;
        this.entry = entry;
        this.aboutMe = aboutme;
    }

    /**
     * Get value from image attribute of <code>Introduction</code> object
     *
     * @return image attribute of <code>Introduction</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public String getImage() {
        return image;
    }

    /**
     * Set value to image attribute of <code>Introduction</code> object
     *
     * @param image the image of <code>Introduction</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get value from image attribute of <code>Introduction</code> object
     *
     * @return entry attribute of <code>Introduction</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public String getEntry() {
        return entry;
    }

    /**
     * Set value to entry attribute of <code>Introduction</code> object
     *
     * @param entry the entry of <code>Introduction</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public void setEntry(String entry) {
        this.entry = entry;
    }

    /**
     * Get value from aboutMe attribute of <code>Introduction</code> object
     *
     * @return aboutMe attribute of <code>Introduction</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public String getAboutme() {
        return aboutMe;
    }

    /**
     * Set value to aboutMe attribute of <code>Introduction</code> object
     *
     * @param aboutme the aboutMe of <code>Introduction</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public void setAboutme(String aboutme) {
        this.aboutMe = aboutme;
    }
}
