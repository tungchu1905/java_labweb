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
 * The class object of Share, all properties have <code>get</code>
 * <code>set</code> method
 *
 * @author TungCTHE141487
 */
public class Share {

    /**
     * Information of icon
     */
    private String icon;
    /**
     * Information of socialNetwork
     */
    private String socialNetwork;
    /**
     * Information of url
     */
    private String url;

    /**
     * Constructor without parameter
     */
    public Share() {
    }

    /**
     * Constructor with parameter
     *
     * @param icon the icon of <code>Share</code> object , it is a
     * <code>java.lang.String</code> object
     * @param socialNetwork the name of <code>Share</code> object, it is a
     * <code>java.lang.String</code> object
     * @param url the url of <code>Share</code> object, it is a
     * <code>java.lang.String</code>object
     */
    public Share(String icon, String socialNetwork, String url) {
        this.icon = icon;
        this.socialNetwork = socialNetwork;
        this.url = url;
    }

    /**
     * Get value from icon attribute of <code>Share</code> object
     *
     * @return icon of <code>Share</code> object, it is a <code>java.lang.String</code>
     * object
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Set value to icon attribute of <code>Share</code> object
     *
     * @param icon the icon of <code>Share</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Get value from socialNetwork attribute of <code>Share</code> object
     *
     * @return socialNetwork name of <code>Share</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public String getSocialNetwork() {
        return socialNetwork;
    }

    /**
     * Set value to socialNetwork attribute of <code>Share</code> object
     *
     * @param socialNetwork the name of <code>Share</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    /**
     * Get value from url attribute of <code>Share</code> object
     *
     * @return url path of <code>Share</code> object <code>java.lang.String</code>object,
     * it is a <code>java.lang.String</code> object
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set value to url attribute of <code>Share</code> object
     *
     * @param url the url of <code>Share</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
