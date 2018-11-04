package pl.fakturomat.tools.converters;

import pl.fakturomat.dataBase.models.Invoice;
import pl.fakturomat.dataBase.modelsFx.InvoiceFx;

public abstract class InvoiceConventer {
  public static Invoice convertToInvoice(InvoiceFx invoiceFx){
    Invoice invoice = new Invoice();
    invoice.setId(invoiceFx.getInvoiceId());
    invoice.setData(DateConventers.convertToDate(invoiceFx.getDate()));
    invoice.setSeller(SellerConverter.convertToSeller(invoiceFx.getSellerFx()));
    invoice.setClient(ClientConverter.convertToClient(invoiceFx.getClientFx()));
    return invoice;
  }

  public static InvoiceFx convertToInvoiceFx(Invoice invoice){
    InvoiceFx invoiceFx = new InvoiceFx();
    invoiceFx.setInvoiceId(invoice.getId());
    invoiceFx.setDate(DateConventers.convertToLocalDate(invoice.getDate()));
    invoiceFx.setSellerFx(SellerConverter.convertToSellerFx(invoice.getSeller()));
    invoiceFx.setClientFx(ClientConverter.convertToClientFx(invoice.getClient()));
    return invoiceFx;
  }
}
