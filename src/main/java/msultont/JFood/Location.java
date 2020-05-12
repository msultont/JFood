package msultont.JFood;

/**
 * This class will create a location for Seller class. The seller distributor will depend on this Location class.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */
public class Location {
    // Instances Variables
    private String province;
    private String description;
    private String city;

    /**
     * Constructor for objects of class Location
     * @param city  city
     * @param description  location description
     * @param province  province
     */
    public Location(String city, String province, String description) {
        this.city = city;
        this.province = province;
        this.description = description;
    }

    /**
     * This method will return the province.
     *
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method will return the city.
     * 
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * This method will return the description of the location.
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method will reassign the province.
     * 
     * @param province  province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * This method will reassign the city.
     * 
     * @param city  city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method will reassign the description of the location.
     * 
     * @param description  description of location.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method will print Location information.
     */
    @Override
    public String toString() {
        return "Provinsi = " + province + "Kota = " + city + "Deskripsi = " + description;
    }
}
