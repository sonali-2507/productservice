package com.ecommerce.product_service.inheritaneExample.joinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_ta")

public class TA extends User {
    private String startTime;
    private String endTime;
}
