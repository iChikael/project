package com.cg.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DashboardDTO {
    private Long quantityCustomer;
    private Long quantityCar;
    private Long quantityStaff;
    private Long quantityBillService;
}
