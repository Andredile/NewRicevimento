package newricevimento;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/


import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
/**
 *
 * @author carlo
 */


public class Parser {
    
    private List<Docente> docenti;
    
    public Parser() {
        docenti = new ArrayList();
    }
    
    public List<Docente> parseDocument(String file,String giorno)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(file);
        root = document.getDocumentElement();
        List<Docente> lista = new ArrayList();
        
        // generazione della lista degli elementi "docente"
        nodelist = root.getElementsByTagName("tr");
        String nome=null,giorno_ricevimento=null,ora=null,nota=null;
        int id=0;
        if(nodelist != null && nodelist.getLength() > 0){
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                NodeList nl = element.getElementsByTagName("td");
                if(nl != null && nl.getLength() > 0){
                    for(int o = 0; o < nl.getLength(); o++){
                        element = (Element)nl.item(o);
                        if(!element.getTextContent().equals(null)){
                            switch(o){
                                case 0:
                                    id = Integer.parseInt(element.getTextContent());
                                    break;
                                case 1:
                                    nome = element.getTextContent();
                                    break;
                                case 2:
                                    giorno_ricevimento = element.getTextContent();
                                    break;
                                case 3:
                                    ora = element.getTextContent();
                                    break;
                                default:
                                    nota = element.getTextContent();
                            }
                        }
                        
                    }
                    Docente docente = new Docente(id, nome, giorno_ricevimento, ora, nota);
                    if(giorno.equals(giorno_ricevimento))
                    lista.add(docente);
                }
            }
        }
        return lista;
    }
    private String getLink(Element element)
    {
        return element.getAttribute("href");
    }
}
