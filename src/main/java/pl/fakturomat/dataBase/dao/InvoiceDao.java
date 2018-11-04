package pl.fakturomat.dataBase.dao;

import pl.fakturomat.dataBase.models.Invoice;

public class InvoiceDao extends CommonDao <Invoice> {
  public InvoiceDao() {
    super(Invoice.class);
  }
}
