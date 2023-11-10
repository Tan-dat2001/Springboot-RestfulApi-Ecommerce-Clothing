package com.clothing.registration;


import com.clothing.response.GeneralApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RegistrationController {

    private RegistrationService registrationService;
    @Autowired
    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }
    @PostMapping("/registration")
    public GeneralApiResponse<?> signUpUser(@RequestBody RegistrationRequest registrationRequest){
        return new GeneralApiResponse<>("200", HttpStatus.OK, registrationService.register(registrationRequest));
    }

    @GetMapping("/registration/confirm")
    public GeneralApiResponse<?> confirm(@RequestParam("code") String code){
        return new GeneralApiResponse<>("200", HttpStatus.OK,registrationService.confirmCode(code));
    }

}
