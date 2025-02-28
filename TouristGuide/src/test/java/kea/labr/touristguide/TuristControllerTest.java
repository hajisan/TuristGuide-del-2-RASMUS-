package kea.labr.touristguide;

import kea.labr.touristguide.Controller.TouristController;
import kea.labr.touristguide.Model.TouristAttraction;
import kea.labr.touristguide.Service.TouristService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TouristController.class)
class TouristControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TouristService touristService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testGetAttractionByName() throws Exception {
        // Arrange
        String name = "Tivoli";
        TouristAttraction attraction = new TouristAttraction(name, "Forlystelsespark midt i København centrum");
        when(touristService.findTouristAttractionByName(name)).thenReturn(attraction);

        mockMvc.perform(get("/attractions/{name}", name))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))  // ✅ Tjekker at "index.html" returneres
                .andExpect(model().attributeExists("attraction"))  // ✅ Tjekker at model-objektet er til stede
                .andExpect(model().attribute("attraction", attraction));  // ✅ Tjekker at attraktionen er i model

    }
}
