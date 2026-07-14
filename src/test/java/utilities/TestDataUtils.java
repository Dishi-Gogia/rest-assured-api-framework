package utilities;

/**
 * Utility class for generating dynamic test data.
 */
public class TestDataUtils {
	
	 /**
     * Generates a unique email address using current timestamp.
     * Example:
     * user1719054321234@gmail.com
      * @return Unique email address
     */
	
    public static String generateEmail() {

        return "user"
                + System.currentTimeMillis()
                + "@gmail.com";
    }

	
}