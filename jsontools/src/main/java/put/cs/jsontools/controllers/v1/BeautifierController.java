package put.cs.jsontools.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import put.cs.jsontools.services.BeautifierService;

@RestController
@RequestMapping(BeautifierController.BASE_URL)
public class BeautifierController {
    public static final String BASE_URL = "/api/v1/beautifier";

    private final BeautifierService beautifierService;

    public BeautifierController(BeautifierService beautifierService) {
        this.beautifierService = beautifierService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String beautifyJson(@RequestBody String json){
        return beautifierService.getBeautifiedJson(json);
    }

}
