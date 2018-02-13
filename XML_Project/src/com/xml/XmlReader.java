package com.xml;

import com.bo.Line;
import com.bo.Rectangle;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.bo.Circle;
import com.bo.Figure;
import com.bo.Point;
import org.w3c.dom.Node;

public class XmlReader {
//        Line line=null;
//	Rectangle rect=null;
//        Circle cercle=null;
    Figure figure=new Figure();
    public Point[] getArtribut(Node node){
            Attr attrName,attrName1,attrName2,attrName3;
            NodeList nodeList = node.getChildNodes();
            Point[] points=new Point[2];
            int[] tab=new int[4];           
                                          System.out.println("node length"+nodeList.getLength());
                                          for(int j=0;j<nodeList.getLength();j++){
                                              if(nodeList.item(j).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
                                                  System.out.println("j:"+j);
                                                  System.out.println("Node:"+nodeList.item(j).getNodeName());
                                               if("pointA".equals(nodeList.item(j).getNodeName())){
                                                    Node PointA = nodeList.item(j);
                                                     attrName = ((Element) PointA).getAttributeNode("x");
                                                      attrName1 = ((Element) PointA).getAttributeNode("y");
                                                      tab[0]=Integer.parseInt(attrName.getTextContent());
                                                     tab[1]=Integer.parseInt(attrName1.getTextContent());
                                                 }
                                                  if("pointB".equals(nodeList.item(j).getNodeName())){
                                                     Node PointB = nodeList.item(j);
                                                      attrName2 = ((Element) PointB).getAttributeNode("x");
                                                     attrName3 = ((Element) PointB).getAttributeNode("y");
                                                     tab[2]=Integer.parseInt(attrName2.getTextContent());
                                                     tab[3]=Integer.parseInt(attrName3.getTextContent());
                                                 }
                                                  
				    	  
                                              }
                                              
				    	// line = (java.awt.Shape) new Line2D(x, y, 100, 100);
				      } 
                                          System.out.println(tab[0]+" y:"+tab[1]+"x2"+tab[2]+"y2"+tab[3]);
             Point p1=new Point(tab[0],tab[1]);
             Point p2=new Point(tab[2],tab[3]);
             points[0]=p1; points[1]=p2;
             return points;
              
    }
    public void read(String pFile) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException{
		DocumentBuilderFactory builderFactory =DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dbuilder=builderFactory.newDocumentBuilder();
			Document document = dbuilder.parse(new FileInputStream(pFile));
			NodeList rootNodes=document.getElementsByTagName("figures");
			org.w3c.dom.Node rootNode= rootNodes.item(0);
			NodeList childNodes=rootNode.getChildNodes();
			for(int i=0;i<childNodes.getLength();i++){
				if(childNodes.item(i).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
				      org.w3c.dom.Node childNode = childNodes.item(i);
				      if("rectangle".equals(childNode.getNodeName())){
				    	  System.out.println("this is rectangle");
                                          Point[] points=getArtribut(childNode);
                                          Rectangle rect = new Rectangle(points[0],points[1]);
                                          figure.add(rect);
				    	  //rect = new Rectangle(x, y,x2,y2);
				      }
				      if("ligne".equals(childNode.getNodeName())){
				    	  System.out.println("this is line");
                                         
                                          Point[] points=getArtribut(childNode);
                                          Line line=new Line(points[0],points[1]);
                                          System.out.println(line);
                                          figure.add(line);
                                          System.out.println(figure.getLines().get(0));
                                      }
				      if("circle".equals(childNode.getNodeName())){
				    	  System.out.println("this is Cercle");
                                          Point[] points=getArtribut(childNode);
                                          Circle cercle=new Circle(points[0],points[1]);
                                          figure.add(cercle);
				    	  //String s="g2.drawOval("+x+","+y+","+width+","+height+");";
				    	  
				      } 
				    }
			}
    } catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            
    }
   public Figure getFigure(){
       return figure;
   }
}
