package practice.layerPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import practice.layerPractice.service.HandService;

// 컨트롤러 부턴 이후 jpa 하면서 수정
@Controller
public class HandController {

    private final HandService handService;

    @Autowired
    public HandController(HandService handService) {
        this.handService = handService;
    }
}
