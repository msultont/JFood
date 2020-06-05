package msultont.JFood;

@SuppressWarnings("serial")
public class LocationNotFoundException extends Exception{

    private String city_error;

    public LocationNotFoundException(String city_input) {
        super("Location ");
        this.city_error = city_input;
    }

    public String getMessage() {
        return super.getMessage() + city_error + ": not found.";
    }
    
}