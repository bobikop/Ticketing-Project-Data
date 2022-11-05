package com.cydeo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isDeleted = false;

    @Column(nullable = false, updatable = false)
    private LocalDateTime insertDateTime;
    @Column(nullable = false, updatable = false)
    private Long insertUserId;
    @Column(nullable = false)
    private LocalDateTime lastUpdateDateTime;
    private Long lastUpdateUserId;

    // after we create the user will take a current time
    @PrePersist  // when we try to save this methid will executed
    private void onPrePersist(){
        this.insertDateTime = LocalDateTime.now();
        this .lastUpdateDateTime = LocalDateTime.now();
        this.insertUserId=1L;
        this.lastUpdateUserId = 1L;
    }

    @PreUpdate // when we try to update this method will update
    private void onPreUpdate(){ // this method we need dto be executed whenever we update created object
        this.lastUpdateDateTime = LocalDateTime.now();
        this.lastUpdateUserId = 1L;
    }

}
