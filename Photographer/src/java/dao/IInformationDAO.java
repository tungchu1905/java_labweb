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

import entity.Information;

/**
 * The interface of InformationDAO defines method to get information from
 * Information table in database.
 *
 * @author TungCTHE141487
 */
public interface IInformationDAO {

    /**
     * Get the content about information of Management in Information object
     *
     * @return the information of Information object
     * @throws java.lang.Exception
     */
    public Information getInformation() throws Exception;

}
