/*
 * Copyright(C) 2005,  FPT University.
 * J3.L.P0017:
 * Photograph
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-06-20     1.0              TungCTHE141487      First Implement
 */
package dao.impl;

import context.DBContext;
import dao.IGalleryDAO;
import entity.Gallery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class implement from IGalleryDAO contains methods to get information from
 * Gallery table in database.
 *
 * @author TungCTHE141487
 */
public class GalleryDAO extends DBContext implements IGalleryDAO {

    /**
     * Get top recent gallery of <code>Gallery</code> object <br>
     * All the gallery will card listed returned the result contain a list
     * of <code> entity.Gallery </code> objects with id, name, description,
     * images
     *
     * @param topNumber the number of Gallery. It is a <code>int</code>
     * primitive type
     * @return 3 galleries of Gallery object, it is a
     * <code>java.util.List</code> object.
     * @throws java.lang.Exception
     */
    @Override
    public List<Gallery> getTopGallery(int topNumber) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select top (?) * from Gallery";
        List<Gallery> list = new ArrayList<>();

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, topNumber);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gallery ga = new Gallery(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        getImagePath() + rs.getString("image"));

                list.add(ga);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // Close resultSet, preparedStatement and connection
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return list;
    }

    /**
     * Paginate by number of gallery in <code>Gallery</code> object <br>
     * All the gallery will card listed returned the result contain a list
     * of <code> entity.Gallery </code> objects with id, name, description,
     * images
     *
     * @param pageIndex the index of page, it is an <code>int</code> 
     * @param pageSize the size of page, it is an <code>int</code> 
     * @return list of pictures paginate, it is a <code>java.util.List</code>
     * object.
     * @throws java.lang.Exception
     */
    @Override
    public List<Gallery> pagging(int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Gallery> list = new ArrayList<>();
        //get value between start to end
        int start = (pageIndex - 1) * pageSize + 1;
        int end = pageIndex * pageSize;
        String sql = "select * from (select ROW_NUMBER() over (order by id ASC) as No,\n"
                + " * from Gallery) as x where No between ? and ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, start);
            ps.setObject(2, end);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gallery g = new Gallery(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        getImagePath() + rs.getString("image"));
                list.add(g);
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            //Close connection, preparedStatement and resultSet
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    /**
     * Get number of result <code>Gallery</code> object by id
     *
     * @return number result of Gallery object, it is an int
     * @throws java.lang.Exception
     */
    @Override
    public int numberOfResult() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select count(id) from Gallery";
        int count = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // Close connection, preparedStatement and resultSet
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return count;
    }

    /**
     * Get gallery of Gallery object by id
     *
     * @param id the id of Gallery. It is a <code>int</code> primitive type
     * @return get the gallery by id, it is a <code>Gallery</code> object
     * @throws java.lang.Exception
     */
    @Override
    public Gallery getGalleryByID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Gallery where id = ?";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gallery ga = new Gallery(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("image"));

                return ga;
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(GalleryDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // Close connection, preparedStatement and resultSet
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return null;
    }

}
