package pl.fakturomat.tools.converters;

import pl.fakturomat.database.models.Invoice;
import pl.fakturomat.database.modelsfx.InvoiceFx;

public abstract class InvoiceConverter {
  /**
   * Convert.
   * @param invoiceFx InvoiceFx.
   * @return Inoice.
   */
  public static Invoice convertToInvoice(InvoiceFx invoiceFx) {
    Invoice invoice = new Invoice();
    invoice.setId(invoiceFx.getInvoiceId());
    invoice.setData(DateConverters.convertToDate(invoiceFx.getDate()));
    invoice.setSeller(SellerConverter.convertToSeller(invoiceFx.getSellerFx()));
    invoice.setClient(ClientConverter.convertToClient(invoiceFx.getClientFx()));
    return invoice;
  }

  /**
   * Covnert.
   * @param invoice Invoice.
   * @return InvoiceFx.
   */
  public static InvoiceFx convertToInvoiceFx(Invoice invoice) {
    InvoiceFx invoiceFx = new InvoiceFx();
    invoiceFx.setInvoiceId(invoice.getId());
    invoiceFx.setDate(DateConverters.convertToLocalDate(invoice.getDate()));
    invoiceFx.setSellerFx(SellerConverter.convertToSellerFx(invoice.getSeller()));
    invoiceFx.setClientFx(ClientConverter.convertToClientFx(invoice.getClient()));
    return invoiceFx;
  }
}
