package com.fedaruk.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fedaruk.utils.StringConvertor;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "Invoice")
@JsonPropertyOrder({"E100customerKey","InvoiceNumber","InvoiceCountry","ProductCode","InvoiceLines"})
public class Invoice implements Serializable {

    @JsonProperty(value = "InvoiceNumber")
    private String InvoiceNumber;
    @JsonProperty(value = "InvoiceCountry")
    private String InvoiceCountry;
    @JsonProperty(value = "E100customerKey")
    private String E100customerKey;
    @JsonProperty(value = "InvoiceLines")
    @JacksonXmlElementWrapper(useWrapping = false)
    private InvoiceLines InvoiceLines;


//    private double VATamount;
//    private double VATpersent;
//    private double VATBasis;

    public Invoice() {
    }

    public Invoice(String invoiceNumber, String invoiceCountry, String e100customerKey, com.fedaruk.model.InvoiceLines invoiceLines) {
        InvoiceNumber = invoiceNumber;
        InvoiceCountry = invoiceCountry;
        E100customerKey = e100customerKey;
        InvoiceLines = invoiceLines;
    }

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.InvoiceNumber = invoiceNumber;
    }

    public String getInvoiceCountry() {
        return InvoiceCountry;
    }

    public void setInvoiceCountry(String invoiceCountry) {
        this.InvoiceCountry = invoiceCountry;
    }

    public String getE100customerKey() {
        return E100customerKey;
    }

    public void setE100customerKey(String e100customerKey) {
        this.E100customerKey = e100customerKey;
    }

    public com.fedaruk.model.InvoiceLines getInvoiceLines() {
        return InvoiceLines;
    }

    public void setInvoiceLines(com.fedaruk.model.InvoiceLines invoiceLines) {
        InvoiceLines = invoiceLines;
    }

    //    public double getVATamount() {
//        return VATamount;
//    }
//
//    public void setVATamount(double VATamount) {
//        this.VATamount = VATamount;
//    }
//
//    public double getVATpersent() {
//        return VATpersent;
//    }
//
//    public void setVATpersent(double VATpersent) {
//        this.VATpersent = VATpersent;
//    }
//
//    public double getVATBasis() {
//        return VATBasis;
//    }
//
//    public void setVATBasis(double VATBasis) {
//        this.VATBasis = VATBasis;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(InvoiceNumber, invoice.InvoiceNumber) &&
                Objects.equals(E100customerKey, invoice.E100customerKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(InvoiceNumber, E100customerKey);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "InvoiceNumber='" + InvoiceNumber + '\'' +
                ", InvoiceCountry='" + InvoiceCountry + '\'' +
                ", E100customerKey='" + E100customerKey + '\'' +
                ", " + InvoiceLines +
                '}';
    }
}
