package io.cote.mcp.thinktool;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThinkToolWeb {

    @GetMapping("/")
    public String index(@RequestParam(required = false) String thoughts) {
        return "ThinkTool is running. Thoughts passed in: "+thoughts;
    }
}
