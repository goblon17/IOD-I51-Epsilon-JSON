package put.cs.jsontools.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import put.cs.jsontools.services.WithoutSelectedService;


@RestController
@RequestMapping(WithoutSelectedController.BASE_URL)
public class WithoutSelectedController {
    public static final String BASE_URL = "/api/v1/onlyselected";

    private final WithoutSelectedService onlySelectedService;

    public WithoutSelectedController(WithoutSelectedService onlySelectedService) {
        this.onlySelectedService = onlySelectedService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String onlySelectedJson(@RequestBody String json, @RequestParam String keys) {
        return onlySelectedService.getOnlySelectedJson(json, keys);
    }
}
