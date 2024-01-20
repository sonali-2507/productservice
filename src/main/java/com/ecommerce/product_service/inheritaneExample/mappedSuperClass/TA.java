package com.ecommerce.product_service.inheritaneExample.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_ta")
public class TA extends User{
    private String startTime;
    private String endTime;
}
