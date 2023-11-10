package com.clothing.registration.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfirmationCodeService {

    private ConfirmationCodeRepository confirmationCodeRepository;
    @Autowired
    public ConfirmationCodeService(ConfirmationCodeRepository confirmationCodeRepository){
        this.confirmationCodeRepository = confirmationCodeRepository;
    }

    public void saveConfirmationCode(ConfirmationCode code){
        confirmationCodeRepository.save(code);
    }

    public Optional<ConfirmationCode> getCode(String code){
        return confirmationCodeRepository.findByCode(code);
    }

    public int setConfirmedAt(String code){
        return confirmationCodeRepository.updateConfirmedAt(code, LocalDateTime.now());
    }

}
