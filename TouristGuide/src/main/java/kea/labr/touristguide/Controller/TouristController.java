package kea.labr.touristguide.Controller;

import kea.labr.touristguide.Model.Tags;
import kea.labr.touristguide.Model.TouristAttraction;
import kea.labr.touristguide.Service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/attractions")
    public String getAttractions(Model model) {
        model.addAttribute("attractions", touristService.getAllTouristAttractions());
        return "attractionList";
    }

    @GetMapping("/attractions/{name}")
    public String getAttractionByName(Model model, @PathVariable String name) {
        TouristAttraction touristAttraction = touristService.findTouristAttractionByName(name);
        model.addAttribute("attraction",touristAttraction);
        return "index";
    }

    @GetMapping("/attractions/add")
    public String addAttraction(Model model) {
        model.addAttribute("attraction", new TouristAttraction()); //Opretter tom attraktion
        model.addAttribute("tags", Tags.values()); //Henter tags-værdier
        return "newAttraction";
    }

    @PostMapping("/attractions/update")
    public String updateAttraction(@RequestParam("name") String name, @ModelAttribute TouristAttraction attraction) {
        touristService.updateTouristAttraction(name, attraction); //opdaterer attraktionen
        return "redirect:/attractions";
    }

    @PostMapping("/attractions/delete/{name}")
    public String deleteAttraction(Model model, @PathVariable String name) {
        TouristAttraction deletedAttraction = touristService.deleteTouristAttraction(name);
        model.addAttribute("attraction", deletedAttraction);
        return "redirect:/attractions";
    }

    @GetMapping("/attractions/{name}/edit")
    public String editAttraction(Model model, @PathVariable String name) {
        TouristAttraction touristAttraction = touristService.findTouristAttractionByName(name);
        if (touristAttraction == null) {
            throw new IllegalArgumentException("Ugyldigt attraktion");
        }
        model.addAttribute("attraction", touristAttraction);
        model.addAttribute("cities", touristService.getCities());
        model.addAttribute("tags", Tags.values());
        return "updateAttraction";
    }


    @PostMapping("/attractions/save")
    public String saveAttraction(@ModelAttribute TouristAttraction attraction, @RequestParam(required = false) List<Tags> tags) {
        if (tags != null) {
            attraction.setTags(tags);
        } else {
            attraction.setTags(new ArrayList<>());
        }
        touristService.addAttraction(attraction);
        return "redirect:/attractions";
    }

    @GetMapping("/attractions/{name}/tags")
    public String getTags(Model model, @PathVariable String name) {
        List<Tags> tags = touristService.getTags(name);
        model.addAttribute("tags",tags);
        return "tags";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
