package com.clothing.registration.code;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ConfirmationCodeRepository extends JpaRepository<ConfirmationCode,Long> {

    Optional<ConfirmationCode> findByCode(String code);

    @Transactional
    @Modifying
    @Query("UPDATE ConfirmationCode c set c.confirmedAt = ?2 where c.code = ?1")
    int updateConfirmedAt(String code, LocalDateTime confirmedAt);

}
