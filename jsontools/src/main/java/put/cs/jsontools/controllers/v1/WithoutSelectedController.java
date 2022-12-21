package put.cs.jsontools.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import put.cs.jsontools.services.WithoutSelectedService;


@RestController
@RequestMapping(WithoutSelectedController.BASE_URL)
public class WithoutSelectedController {
    public static final String BASE_URL = "/api/v1/withoutselected";

    private final WithoutSelectedService withoutSelectedService;

    public WithoutSelectedController(WithoutSelectedService withoutSelectedService) {
        this.withoutSelectedService = withoutSelectedService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String withoutSelectedJson(@RequestBody String json, @RequestParam String keys) {
        return withoutSelectedService.getWithoutSelectedJson(json, keys);
    }
}
