package com.example.springwsdemo;

import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SOAPActionHandler implements SOAPHandler<SOAPMessageContext> {
    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outbound) {
            // or remove it completely
            Map<String, List<String>> headers = (Map<String, List<String>>)
                    context.get(MessageContext.HTTP_REQUEST_HEADERS);
            if (headers != null) {
                headers.remove("soapaction");
            }
            context.remove(BindingProvider.SOAPACTION_URI_PROPERTY);
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }
}
