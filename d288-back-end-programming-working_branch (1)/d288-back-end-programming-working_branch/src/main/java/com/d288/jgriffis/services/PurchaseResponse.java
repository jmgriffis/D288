package com.d288.jgriffis.services;

import com.d288.jgriffis.entities.StatusType;
import lombok.Data;

@Data
public class PurchaseResponse {
    private final String orderTrackingNumber;
    private StatusType status;
}
