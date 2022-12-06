package put.cs.jsontools.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import put.cs.jsontools.services.MinifierService;

@RestController
@RequestMapping(MinifierController.BASE_URL)
public class MinifierController {
    public static final String BASE_URL = "/api/v1/minifier";

    private final MinifierService minifierService;

    public MinifierController(MinifierService minifierService) {
        this.minifierService = minifierService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String minifyJson(@RequestBody String json){
        return minifierService.getMinificatedJson(json);
    }

}
