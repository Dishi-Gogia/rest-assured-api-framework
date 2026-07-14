package endpoints;

/**
 * Routes class contains all API endpoint paths used
 * across the framework.
 *
 * Keeping endpoints in one place makes maintenance easy.
 * If an endpoint changes, update it here only.
 *
 * Author : Dishi Gogia
 */
public class Routes {

    public static final String GET_BOOKING="/booking/{id}";

    public static final String CREATE_BOOKING="/booking";

    public static final String AUTH="/auth";
    
    public static final String UPDATE_BOOKING = "/booking/{id}";

    public static final String PATCH_BOOKING = "/booking/{id}";

    public static final String DELETE_BOOKING = "/booking/{id}";

}
