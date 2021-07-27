/*
 * Copyright(C) 2005,  FPT University.
 * J3.L.P0017:
 * Photograph
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-06-20     1.0              TungCTHE141487      First Implement
 */
package listener;

import dao.IViewsCountDAO;
import dao.impl.ViewCounterDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * CountViewerListener count the access website from User
 *
 * @author TungCTHE141487
 */
public class CounterViewerListener implements HttpSessionListener {
    /**
     * Event to get user access website for count viewer
     *
     * @param se the <code>HttpSessionEvent</code> object
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        try {
            
            int viewer;
            IViewsCountDAO viewCountDAO = new ViewCounterDAO();
            // Get all view 
            viewer = viewCountDAO.getViewsCount();
            // Update View in database
            viewCountDAO.updateViewsCount();
            //Format 6 digits
            String viewFormat = String.format("%06d", viewer);
            ServletContext context = se.getSession().getServletContext();

            context.setAttribute("view", viewFormat);
        } catch (Exception e) {
            Logger.getLogger(CounterViewerListener.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    /**
     * No implement
     *
     * @param se the <code>HttpSessionEvent</code> object
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
