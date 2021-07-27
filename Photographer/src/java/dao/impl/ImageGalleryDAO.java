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
import dao.IImageGalleryDAO;
import entity.ImageGallery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class implement from IImageGalleryDAO contains methods to get
 * information from ImageGallery table in database.
 *
 * @author TungCTHE141487
 */
public class ImageGalleryDAO extends DBContext implements IImageGalleryDAO {

    /**
     * Get list of image of ImageGallery object by id <br>
     * All the image gallery will card listed returned the result contain a list
     * of <code> entity.ImageGallery </code> objects with image, galleryId
     *
     * @param id the id image of Gallery, it is an int
     * @return all image of a gallery, it is a <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    @Override
    public List<ImageGallery> getImageByGallery(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from ImageGallery where gallery_id = ?";
        List<ImageGallery> list = new ArrayList<>();

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ImageGallery ig = new ImageGallery(getImagePath() + rs.getString("image"), rs.getInt("gallery_id"));
                list.add(ig);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ImageGalleryDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // Close connection, preparedStatement and resultSet
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }

        return list;
    }

    /**
     * Pagination with pageIndex, pageSize by number of ImageGallery object <br>
     * All the image gallery will card listed returned the result contain a list
     * of <code> entity.ImageGallery </code> objects with image, galleryId
     *
     * @param pageIndex the index of page, it is an int
     * @param pageSize the size of page, it is an int
     * @param galleryId the id of a Gallery, it is an int
     * @return list pictures paginate of ImageGallery object, it is a
     * <code>java.util.List</code>
     * @throws java.lang.Exception
     */
    @Override
    public List<ImageGallery> pagging(int pageIndex, int pageSize, int galleryId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ImageGallery> list = new ArrayList<>();
        //get value between start to end
        int start = (pageIndex - 1) * pageSize + 1;
        int end = pageIndex * pageSize;
        String sql = "select * from (select ROW_NUMBER() over (order by gallery_id ASC) as No,\n"
                + "                * from ImageGallery where gallery_id = ?) as x where No between ? and ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, galleryId);
            ps.setObject(2, start);
            ps.setObject(3, end);
            rs = ps.executeQuery();
            while (rs.next()) {
                ImageGallery g = new ImageGallery(getImagePath() + rs.getString("image"),
                        rs.getInt("gallery_id"));
                list.add(g);
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ImageGalleryDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // Close connection, preparedStatement and resultSet
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

    /**
     * Get number of result of ImageGallery object by id
     *
     * @param galleryId the id of a Gallery. It is a
     * <code>java.lang.Integer</code> primitive type
     * @return number result of ImageGallary object, it is an int
     * @throws java.lang.Exception
     */
    @Override
    public int numberOfResult(int galleryId) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select count(gallery_id) from ImageGallery where gallery_id = ?";
        int count = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, galleryId);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ImageGalleryDAO.class.getName()).log(Level.SEVERE, null, e);
            throw e;
        } finally {
            // Close connection, preparedStatement and resultSet
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return count;
    }

}
