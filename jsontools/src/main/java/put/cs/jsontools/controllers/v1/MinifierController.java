package put.cs.jsontools.controllers.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MinifierController.BASE_URL)
public class MinifierController {
    public static final String BASE_URL = "/api/v1/minifier";



}