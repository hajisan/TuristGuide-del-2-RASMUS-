package kea.labr.touristguide.Model;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {

    private String name;
    private String description;
    private List<Tags> tags;
    private String city;

    public TouristAttraction() {

    }

    public TouristAttraction(String name, String description, String city) {
        setName(name);
        setDescription(description);
        setCity(city);
        tags = new ArrayList<>();
    }

    // getters:
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public String getCity() {
        return city;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.description;
    }

}
