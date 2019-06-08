package com.fedaruk.strategy;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fedaruk.model.InvoicesHolder;
import com.fedaruk.utils.Utils;

import java.io.File;
import java.io.IOException;

public class XMLSerializationStrategyImpl implements SerializationStrategy {

    @Override
    public void serializeObject(File destination, InvoicesHolder holder) throws IOException {
        XmlMapper mapper = new XmlMapper();
        Utils.calculateValuesForInvoices(holder);
        mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        mapper.writerWithDefaultPrettyPrinter().writeValue(destination, holder);
    }

    @Override
    public InvoicesHolder deserializeObject(File source) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(source, InvoicesHolder.class);
    }
}
