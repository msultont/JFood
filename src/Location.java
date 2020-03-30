
/**
 * Location class will generate the spesific location for JFood restaurant.
 *
 * @author Muhammad Sulton Tauhid
 * @version February 27th, 2020
 */
public class Location {
    // Instances Variables
    private String province;
    private String description;
    private String city;

    /**
     * Constructor for objects of class Location
     */
    public Location(String city, String province, String description) {
        this.city = city;
        this.province = province;
        this.description = description;
    }

    /**
     * This method will return the province of the restaurant
     *
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method will return the city of restaurant
     * 
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * This method will return the description of the restaurant
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method will reassign the province of the restaurant
     * 
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * This method will reassign the city of the restaurant
     * 
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method will reassign the description of the restaurant
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method will print all the variables data to the terminal
     */
    @Override
    public String toString() {
        return "Provinsi = " + province + "Kota = " + city + "Deskripsi = " + description;
    }
}
