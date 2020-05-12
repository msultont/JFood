package msultont.JFood;

/**
 * Exception class when spesific food isn't found when spesific food object is invoked.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

public class FoodNotFoundException extends Exception {
    // Instances variable to save food's id.
    private int food_error;

    /**
     * @param food_input  input the food id to show the error within the exception.
     */
    public FoodNotFoundException(int food_input) {
        super("Food ID: ");
        this.food_error = food_input;
    }

    /**
     * Recall the exception message to the error.
     */
    public String getMessage() {
        return super.getMessage() + food_error + " not found";
    }
}