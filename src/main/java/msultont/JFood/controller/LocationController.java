package msultont.JFood.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import msultont.JFood.*;

/**
 * 
 */

@RequestMapping("/location")
@RestController
public class LocationController {
    
    @RequestMapping("")
    public String indexPage() {
        return "Hello, you are in the location page";
    }

    @RequestMapping("/listLocation")
    public ArrayList<Location> getAllLocation() {
        return DatabaseLocation.getLocationDatabases();
    }

}