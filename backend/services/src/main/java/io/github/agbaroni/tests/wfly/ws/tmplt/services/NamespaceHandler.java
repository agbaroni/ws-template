package io.github.agbaroni.tests.wfly.ws.tmplt.services;

import java.io.StringWriter;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.jboss.logging.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class NamespaceHandler implements SOAPHandler<SOAPMessageContext> {

    private static final Logger logger = Logger.getLogger(NamespaceHandler.class);

    @Override
    public void close(MessageContext mc) {
	logger.info("close");
    }

    @Override
    public Set<QName> getHeaders() {
	logger.info("headers");

	return null;
    }

    @Override
    public boolean handleFault(SOAPMessageContext mc) {
	logger.info("fault");

	return false;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext mc) {
	try {
	    logger.info("message");

	    // DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    // Document d = db.parse(getClass().getResourceAsStream("/namespaces.xslt"));

	    StreamSource ss = new StreamSource(getClass().getResourceAsStream("/namespaces.xslt"));
	    TransformerFactory tf = TransformerFactory.newInstance();
	    Transformer t = tf.newTransformer(ss);

	    SOAPMessage m = mc.getMessage();
	    SOAPPart e = m.getSOAPPart();
	    // XPath p = XPathFactory.newInstance().newXPath();

	    // NodeList l = (NodeList) p.compile("/soapenv:Envelope/soapenv:Body/ser:getOutput").evaluate(e, XPathConstants.NODESET);

	    // logger.info(l.getLength());

	    // for (int i = 0; i < l.getLength(); ++i) {
	    // 	logger.info(l.item(i).getTextContent());
	    // }

	    StringWriter sw = new StringWriter();
	    DOMResult r = new DOMResult();
	    t.transform(new DOMSource(e), new StreamResult(sw));

	    logger.info(sw.toString());

	    // e.setContent(new DOMSource(r.getNode()));
	} catch (Exception e) {
	    logger.error(e, e);
	}

	return true;
    }
}
