package msultont.JFood.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This is the homepage controller for web application of JFood.
 *
 * @author Muhammad Sulton Tauhid
 * @version May 12th, 2020
 */

@Controller
@RequestMapping("")
public class HomepageController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(@RequestParam(name = "name", required = false, defaultValue = "unknown") String name, Model model) {
        model.addAttribute("name", name);
        return "Homepage";
    }

}