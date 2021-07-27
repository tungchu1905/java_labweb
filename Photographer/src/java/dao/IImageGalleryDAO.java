/*
 * Copyright(C) 2005,  FPT University.
 * J3.L.P0017:
 * Photograph
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-06-20     1.0              TungCTHE141487      First Implement
 */
package dao;

import entity.ImageGallery;
import java.util.List;

/**
 * The interface of ImageGalleryDAO defines methods to get information from
 * ImageGallery table in database.
 *
 * @author TungCTHE141487
 */
public interface IImageGalleryDAO {

    /**
     * Get list of image of ImageGallery object by id <br>
     * All the image gallery will card listed returned the result contain a list
     * of <code> entity.ImageGallery </code> objects with image, galleryId
     *
     * @param id the id image of Gallery, it is an int
     * @return list of ImageGallery object, it is a <code>java.util.List</code>
     * object
     * @throws java.lang.Exception
     */
    public List<ImageGallery> getImageByGallery(int id) throws Exception;

    /**
     * Paginate by the number of ImageGallery object <br>
     * All the ImageGallery will card listed returned the result contain a list
     * of <code> entity.ImageGallery </code> objects with image, galleryId
     *
     * @param pageIndex the index of page, it is an int
     * @param pageSize the size of page, it is an int
     * @param galId the id of a Gallery, it is an int
     * @return list of ImageGallery object, it is a <code>java.util.List</code>
     * object
     * @throws java.lang.Exception
     */
    public List<ImageGallery> pagging(int pageIndex, int pageSize, int galId) throws Exception;

    /**
     * Get number of result of ImageGallery object by id
     *
     * @param galId the id of a Gallery, it is an int
     * @return a number of result ImageGallery object, it is an int
     * @throws java.lang.Exception
     */
    public int numberOfResult(int galId) throws Exception;
}
