package com.sergiopz.xpathquerytool;

import java.io.IOException;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathQueryTool {
  public void launchQuery(String xPathQuery, String filePathXml, QName returnType, JTextArea txtArea, JCheckBox distinct_chkBox) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(filePathXml);
    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPath xpath = xPathFactory.newXPath();
    boolean distinct = distinct_chkBox.isSelected();
    XPathExpression xPathExpr = xpath.compile(xPathQuery);
    if (returnType.equals(XPathConstants.BOOLEAN)) {
      boolean result = ((Boolean)xPathExpr.evaluate(doc, returnType)).booleanValue();
      printXpathResult(result, txtArea);
    } 
    if (returnType.equals(XPathConstants.NODESET)) {
      NodeList result = (NodeList)xPathExpr.evaluate(doc, returnType);
      distinct_chkBox.setEnabled(true);
      printXpathResult(result, txtArea, distinct);
    } 
    if (returnType.equals(XPathConstants.NODE)) {
      Node result = (Node)xPathExpr.evaluate(doc, returnType);
      printXpathResult(result, txtArea);
    } 
    if (returnType.equals(XPathConstants.NUMBER)) {
      Double result = (Double)xPathExpr.evaluate(doc, returnType);
      printXpathResult(result, txtArea);
    } 
    if (returnType.equals(XPathConstants.STRING)) {
      String result = (String)xPathExpr.evaluate(doc, returnType);
      printXpathResult(result, txtArea);
    } 
  }
  
  public void printXpathResult(NodeList result, JTextArea txtArea, boolean distinct) {
    NodeList nodes = result;
    String resultText = "";
    for (int i = 0; i < nodes.getLength(); i++) {
      if (distinct) {
        if (null != nodes.item(i).getNodeValue() && !resultText.contains(nodes.item(i).getNodeValue()))
          resultText = resultText + nodes.item(i).getNodeValue() + System.getProperty("line.separator"); 
      } else {
        resultText = resultText + nodes.item(i).getNodeValue() + System.getProperty("line.separator");
      } 
    } 
    txtArea.setText(resultText);
  }
  
  public void printXpathResult(boolean result, JTextArea txtArea) {
    txtArea.setText(String.valueOf(result));
  }
  
  public void printXpathResult(Double result, JTextArea txtArea) {
    txtArea.setText(String.valueOf(result));
  }
  
  public void printXpathResult(String result, JTextArea txtArea) {
    txtArea.setText(result);
  }
  
  public void printXpathResult(Node result, JTextArea txtArea) {
    txtArea.setText(result.getNodeValue());
  }
}
