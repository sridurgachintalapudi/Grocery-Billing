package com.billing.controller;

import com.billing.model.Billing;
import com.billing.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/billings")
public class BillingController {

    private static final Logger logger = LoggerFactory.getLogger(BillingController.class);

    @Autowired
    private BillingService billingService;

    @GetMapping
    public List<Billing> getAllBillings() {
        logger.info("Fetching all billings");
        return billingService.getAllBillings();
    }

    @GetMapping("/{id}")
    public Billing getBillingById(@PathVariable Long id) {
        logger.info("Fetching billing with id: {}", id);
        return billingService.getBillingById(id);
    }

    @PostMapping
    public Billing createBilling(@RequestBody Billing billing) {
        logger.info("Creating new billing for customer: {}", billing.getCustomerName());
        return billingService.createBilling(billing);
    }

    @PutMapping("/{id}")
    public Billing updateBilling(@PathVariable Long id, @RequestBody Billing billing) {
        logger.info("Updating billing with id: {}", id);
        return billingService.updateBilling(id, billing);
    }

    @DeleteMapping("/{id}")
    public void deleteBilling(@PathVariable Long id) {
        logger.info("Deleting billing with id: {}", id);
        billingService.deleteBilling(id);
    }
}