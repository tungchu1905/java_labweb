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
 * The class object of Information, all properties have <code>get</code>
 * <code>set</code> method
 *
 * @author TungCTHE141487
 */
public class Information {

    /**
     * Information of address
     */
    private String address;
    /**
     * Information of city
     */
    private String city;
    /**
     * Information of country
     */
    private String country;
    /**
     * Information of telephone
     */
    private String tel;
    /**
     * Information of email
     */
    private String email;
    /**
     * Information of image
     */
    private String image;

    /**
     * Constructor without parameter
     */
    public Information() {
    }

    /**
     * Constructor with parameter
     *
     * @param address the address of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     * @param city the city of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     * @param country the country of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     * @param tel the tel of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     * @param email the email of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     * @param image the image of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public Information(String address, String city, String country, String tel, String email, String image) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.tel = tel;
        this.email = email;
        this.image = image;
    }

    /**
     * Get value from address attribute of <code>Information</code> object
     *
     * @return address attribute of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set value to address attribute of <code>Information</code> object
     *
     * @param address the address of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get value from city attribute of <code>Information</code> object
     *
     * @return city attribute of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public String getCity() {
        return city;
    }

    /**
     * Set value to city attribute of <code>Information</code> object
     *
     * @param city the city of a <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get value from country attribute of <code>Information</code> object
     *
     * @return country attribute of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set value to country attribute of <code>Information</code> object
     *
     * @param country the country of <code>Information</code> object, it is a
     * <code>java.lang.String</code>object
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get value from Telephone Number attribute of <code>Information</code>
     * object
     *
     * @return tel attribute of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public String getTel() {
        return tel;
    }

    /**
     * Set value to Telephone Number attribute of <code>Information</code>
     * object
     *
     * @param tel the tel of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Get value from email attribute of <code>Information</code> object
     *
     * @return email attribute of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set value to email attribute of <code>Information</code> object
     *
     * @param email the email of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get value from image attribute of <code>Information</code> object
     *
     * @return image attribute of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public String getImage() {
        return image;
    }

    /**
     * Set value to image attribute of <code>Information</code> object
     *
     * @param image the image of <code>Information</code> object, it is a
     * <code>java.lang.String</code> object
     */
    public void setImage(String image) {
        this.image = image;
    }

}
