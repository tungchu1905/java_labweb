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

/**
 * The interface of ViewCounterDAO defines methods to get information from
 * View table in database.
 * 
 * @author TungCTHE141487
 */
public interface IViewsCountDAO {

    /**
     * Get count of views when user enter the web
     *
     * @return a number of view, it is an int
     * @throws java.lang.Exception
     */
    public int getViewsCount() throws Exception;

    /**
     * Update count of views when user enter the web
     *
     * @throws java.lang.Exception
     */
    public void updateViewsCount() throws Exception;
}
