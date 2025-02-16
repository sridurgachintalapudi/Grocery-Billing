package com.billing.service.impl;

import com.billing.model.Billing;
import com.billing.service.BillingService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillingServiceImpl implements BillingService {

    private static final Logger logger = LoggerFactory.getLogger(BillingServiceImpl.class);

    private List<Billing> billings = new ArrayList<>();

    @Override
    public List<Billing> getAllBillings() {
        logger.debug("Getting all billings");
        return billings;
    }

    @Override
    public Billing getBillingById(Long id) {
        logger.debug("Getting billing by id: {}", id);
        Optional<Billing> billing = billings.stream().filter(b -> b.getId().equals(id)).findFirst();
        return billing.orElse(null);
    }

    @Override
    public Billing createBilling(Billing billing) {
        logger.debug("Creating billing for customer: {}", billing.getCustomerName());
        billings.add(billing);
        return billing;
    }

    @Override
    public Billing updateBilling(Long id, Billing billing) {
        logger.debug("Updating billing with id: {}", id);
        Billing existingBilling = getBillingById(id);
        if (existingBilling != null) {
            existingBilling.setCustomerName(billing.getCustomerName());
            existingBilling.setAmount(billing.getAmount());
        }
        return existingBilling;
    }

    @Override
    public void deleteBilling(Long id) {
        logger.debug("Deleting billing with id: {}", id);
        billings.removeIf(b -> b.getId().equals(id));
    }
}