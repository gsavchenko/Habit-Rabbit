package com.honeycomb.habitrabbit;

/**
 * Created by Jason on 08/03/2016.
 */
public class MainController {
    public dbConnection dbsrv;

    public MainController(dbConnection con) {
        this.dbsrv = con; // add db session to main controller.
    }
}
