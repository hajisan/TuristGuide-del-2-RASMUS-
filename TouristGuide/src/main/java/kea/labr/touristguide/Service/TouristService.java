package kea.labr.touristguide.Service;

import kea.labr.touristguide.Model.Tags;
import kea.labr.touristguide.Repository.TouristRepository;
import kea.labr.touristguide.Model.TouristAttraction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAllTouristAttractions() {
        return touristRepository.getAllTouristAttractions();
    }


    public TouristAttraction findTouristAttractionByName(String name) {
        TouristAttraction touristAttraction = touristRepository.findTouristAttractionByName(name);
        return touristAttraction;
    }

    public void addAttraction(TouristAttraction attraction) {
        touristRepository.addAttraction(attraction);
    }

    public void updateTouristAttraction(String name, TouristAttraction updateTouristAttraction) {
        TouristAttraction updated = touristRepository.updateTouristAttraction(name, updateTouristAttraction);
        if (updated == null) {
            throw new IllegalArgumentException("Attraktionen med navnet '" + name + "' blev ikke fundet.");
        }
    }

    public TouristAttraction deleteTouristAttraction(String name) {
        return touristRepository.deleteTouristAttraction(name);
    }

    public List<Tags> getTags(String name) {
        return touristRepository.getTags(name);
    }

    public List<String> getCities() {
        return touristRepository.allCities();
    }

}



