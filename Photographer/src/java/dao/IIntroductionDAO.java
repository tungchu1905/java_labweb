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

import entity.Introduction;

/**
 * The interface of IntroductionDAO defines method to get information from
 * Introduction table in database.
 * 
 * @author TungCTHE141487
 */
public interface IIntroductionDAO {
    /**
     * Get all information of Introduction object
     *
     * @return the information of Introduction object
     * @throws java.lang.Exception
     */
    public Introduction getIntroduction() throws Exception;
}
