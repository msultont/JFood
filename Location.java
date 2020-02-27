
/**
 * Write a description of class Location here.
 *
 * @author Muhammad Sulton Tauhid
 * @version February 27th, 2020
 */
public class Location
{
    private String province;
    private String description;
    private String city;

    /**
     * Constructor for objects of class Location
     */
    public Location(String city, String province, String description)
    {
        this.city = city;
        this.province = province;
        this.description = description;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getProvince()
    {
        return province;
    }

    /**
     * 
     * @return
     */
    public String getCity()
    {
        return city;
    }

    /**
     * 
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * 
     */
    public void setProvince(String province) 
    {
        this.province = province;
    }

    /**
     * 
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * 
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * 
     */
    public void printData()
    {
        
    }
}
