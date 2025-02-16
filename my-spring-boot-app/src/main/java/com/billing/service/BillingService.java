package com.billing.service;

import com.billing.model.Billing;
import java.util.List;

public interface BillingService {
    List<Billing> getAllBillings();
    Billing getBillingById(Long id);
    Billing createBilling(Billing billing);
    Billing updateBilling(Long id, Billing billing);
    void deleteBilling(Long id);
}