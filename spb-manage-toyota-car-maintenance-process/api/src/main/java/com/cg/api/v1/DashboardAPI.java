package com.cg.api.v1;

import com.cg.domain.dto.DashboardDTO;
import com.cg.domain.dto.car.CarResDTO;
import com.cg.domain.dto.customer.CustomerResDTO;
import com.cg.domain.dto.service.billService.BillServiceResDTO;
import com.cg.domain.dto.staff.StaffResDTO;
import com.cg.domain.entity.customer.Customer;
import com.cg.domain.entity.staff.Staff;
import com.cg.service.bill.IBillServiceService;
import com.cg.service.car.ICarService;
import com.cg.service.customer.ICustomerService;
import com.cg.service.staff.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dashboards")
public class DashboardAPI {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICarService carService;

    @Autowired
    private IStaffService staffService;
    @Autowired
    private IBillServiceService billServiceService;
    @GetMapping
    public ResponseEntity<?> getAllInfoDashboard() {
        List<CustomerResDTO> customerResDTOS = customerService.findAllCustomerResDTO();
        List<CarResDTO> carResDTOS = carService.findAllCarResDTO();
        List<StaffResDTO> staffResDTOs = staffService.findAllStaffResDTO();
        List<BillServiceResDTO> billServiceResDTOS = billServiceService.fillAllBillServiceResDTO();

        DashboardDTO dashboardDTO = new DashboardDTO();

        if (customerResDTOS.isEmpty()) {
            dashboardDTO.setQuantityCustomer(0L);
        }
        if (carResDTOS.isEmpty()) {
            dashboardDTO.setQuantityCar(0L);
        }
        if (staffResDTOs.isEmpty()) {
            dashboardDTO.setQuantityStaff(0L);
        }
        if (billServiceResDTOS.isEmpty()) {
            dashboardDTO.setQuantityBillService(0L);
        }

        dashboardDTO.setQuantityCustomer(Long.valueOf(customerResDTOS.size()));
        dashboardDTO.setQuantityCar(Long.valueOf(carResDTOS.size()));
        dashboardDTO.setQuantityStaff(Long.valueOf(staffResDTOs.size()));
        dashboardDTO.setQuantityBillService(Long.valueOf(billServiceResDTOS.size()));


        return new ResponseEntity<>(dashboardDTO, HttpStatus.OK);
    }

}
