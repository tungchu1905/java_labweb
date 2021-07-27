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

import entity.Share;
import java.util.List;

/**
 * This is the interface of ShareDAO defines method to get information from Share
 * table in database.
 *
 * @author TungCTHE141487
 */
public interface IShareDAO {

    /**
     * Get list information of Share object <br>
     * All the information of share object will card listed returned the result
     * contain a list of <code> entity.Share </code> objects with icon,
     * socialNetwork, url
     *
     * @return list of Share object, it is a <code>java.util.List</code> object
     * @throws java.lang.Exception
     */
    public List<Share> getShare() throws Exception;
}
