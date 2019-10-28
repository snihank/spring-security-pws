package com.company.ShakibKarimU1Capstone.dao;

import com.company.ShakibKarimU1Capstone.model.Invoice;

import java.util.List;

public interface InvoiceDao {

    Invoice createInvoice(Invoice invoice);

    Invoice getInvoice(int invoiceId);

    List<Invoice> getAllInvoices();

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int invoiceId);

}
