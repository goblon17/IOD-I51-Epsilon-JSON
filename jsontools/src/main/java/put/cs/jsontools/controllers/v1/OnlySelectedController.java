package put.cs.jsontools.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import put.cs.jsontools.services.OnlySelectedService;

@RestController
@RequestMapping(OnlySelectedController.BASE_URL)
public class OnlySelectedController {
    public static final String BASE_URL = "/api/v1/onlyselected";
    private final OnlySelectedService onlySelectedService;

    public OnlySelectedController(OnlySelectedService onlySelectedService) {
        this.onlySelectedService = onlySelectedService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String withoutSelectedJson(@RequestBody String json, @RequestParam String keys) {
        return onlySelectedService.getOnlySelectedJson(json, keys);
    }
}
