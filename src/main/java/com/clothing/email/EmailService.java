package com.clothing.email;

import org.springframework.stereotype.Repository;

@Repository
public interface EmailService {
    String sendSimpleMail(EmailDetail details);

}
