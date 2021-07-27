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
 * The class object of ImageGallery, all properties have <code>get</code>
 * <code>set</code> method
 *
 * @author TungCTHE141487
 */
public class ImageGallery {

    /**
     * Information of image
     */
    private String image;
    /**
     * Information of image
     */
    private int galleryId;

    /**
     * Constructor without parameter
     */
    public ImageGallery() {
    }

    /**
     * Constructor with parameter
     *
     * @param image the image of <code>ImageGallery</code> object, it is a
     * <code>java.lang.String</code> object
     * @param galleryId the galleryId of <code>ImageGallery</code> object, it is
     * an <code>int</code>
     */
    public ImageGallery(String image, int galleryId) {
        this.image = image;
        this.galleryId = galleryId;
    }

    /**
     * Get value from image attribute of <code>ImageGallery</code> object
     *
     * @return image of a <code>ImageGallery</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public String getImage() {
        return image;
    }

    /**
     * Set value to image attribute of <code>ImageGallery</code> object
     *
     * @param image the image of a <code>ImageGallery</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get value from galleryId attribute of <code>ImageGallery</code> object
     *
     * @return galleryId of a <code>ImageGallery</code> object, it is an
     * <code>int</code>
     */
    public int getGalleryId() {
        return galleryId;
    }

    /**
     * Set value to GalleryId attribute of <code>ImageGallery</code> object
     *
     * @param galleryId the galleryId of <code>ImageGallery</code> object, it is
     * an <code>int</code>
     */
    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }
}
