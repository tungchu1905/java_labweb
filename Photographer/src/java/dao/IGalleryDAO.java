/*
 * Copyright(C) 2005,  FPT University.
 * J3.L.P0017:
 * Photograph
 *
 * Record of change:
 * DATE          Version             AUTHOR            DESCRIPTION
 * 2021-06-20     1.0              TungCTHE141487      First Implement
 */
package dao;

import entity.Gallery;
import java.util.List;

/**
 * The interface of GalleryDAO defines methods to get information from Gallery
 * table in database.
 *
 * @author TungCTHE141487
 */
public interface IGalleryDAO {

    /**
     * Get top recent gallery of Gallery object <br>
     * All the gallery will card listed returned the result contain a list
     * of <code> entity.Gallery </code> objects with id, name, description,
     * images
     *
     * @param topNumber the number of news recent, it is an int
     * @return list of gallery objects, it is a <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    public List<Gallery> getTopGallery(int topNumber) throws Exception;

    /**
     * Paginate by number of gallery in Gallery object <br>
     * All the gallery will card listed returned the result contain a list
     * of <code> entity.Gallery </code> objects with id, name, description,
     * images
     *
     * @param pageIndex the index of page, it is an int 
     * @param pageSize the size of page, it is an int
     * @return list of Gallery object, it is a <code>java.util.List</code>
     * object
     * @throws java.lang.Exception
     */
    public List<Gallery> pagging(int pageIndex, int pageSize) throws Exception;

    /**
     * Display number of Result
     *
     * @return number of result of gallery object, it is an int
     * @throws java.lang.Exception
     */
    public int numberOfResult() throws Exception;

    /**
     * Get gallery of Gallery object by id
     *
     * @param id the id of a Gallery. It is a <code>int</code> primitive type
     * @return a Gallery object
     * @throws java.lang.Exception
     */
    public Gallery getGalleryByID(int id) throws Exception;
}
