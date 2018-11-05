package pl.fakturomat.database.dao;

import pl.fakturomat.database.models.Invoice;

public class InvoiceDao extends CommonDao<Invoice> {
  public InvoiceDao() {
    super(Invoice.class);
  }
}
