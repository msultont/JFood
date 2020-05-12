package msultont.JFood;

/**
 * All list for food category.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

public enum FoodCategory {
    // Lists of provided food's cateogry.
    Beverages("Beverages"), Coffee("Coffee"), Western("Western"), Snacks("Snacks"), Rice("Rice"), Noodles("Noodles"),
    Bakery("Bakery"), Japanese("Japanese");

    private String category;

    private FoodCategory(String category) {
        this.category = category;
    }

    /**
     * Print food's category to check enum itself when it is invoked.
     */
    public String toString() {
        return category;
    }

}
