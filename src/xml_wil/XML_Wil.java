
package xml_wil;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class XML_Wil {

    @XmlRootElement(name = "wil")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Wil{
        
        @XmlElement(name = "H1")
        private List<H1> h1 = null;

        public List<H1> getH1() {
            return h1;
        }

        public void setH1(List<H1> h1) {
            this.h1 = h1;
        }
    }
    
    @XmlRootElement(name = "H1")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class H1{

        @XmlElement(name = "h")
        private H h;
        
        @XmlElement(name = "body")
        private String body;
        
        @XmlElement(name = "tail")
        private Tail tail;

        /**
         * @return the h
         */
        public H getH() {
            return h;
        }

        /**
         * @param h the h to set
         */
        public void setH(H h) {
            this.h = h;
        }

        /**
         * @return the body
         */
        public String getBody() {
            return body;
        }

        /**
         * @param body the body to set
         */
        public void setBody(String body) {
            this.body = body.replaceAll("\\<.*?>","");
        }
    }
    
    @XmlRootElement(name = "h")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class H{
        
        @XmlElement(name = "key1")
        private String key1;
        
        @XmlElement(name = "key2")
        private String key2;

        /**
         * @return the key1
         */
        public String getKey1() {
            return key1;
        }

        /**
         * @param key1 the key1 to set
         */
        public void setKey1(String key1) {
            this.key1 = key1;
        }

        /**
         * @return the key2
         */
        public String getKey2() {
            return key2;
        }

        /**
         * @param key2 the key2 to set
         */
        public void setKey2(String key2) {
            this.key2 = key2;
        }
    }
    
    @XmlRootElement(name = "tail")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Tail{
        
        @XmlElement(name = "L")
        private String L;
        
        @XmlElement(name = "pc")
        private String pc;

        /**
         * @return the L
         */
        public String getL() {
            return L;
        }

        /**
         * @param L the L to set
         */
        public void setL(String L) {
            this.L = L;
        }

        /**
         * @return the pc
         */
        public String getPc() {
            return pc;
        }

        /**
         * @param pc the pc to set
         */
        public void setPc(String pc) {
            this.pc = pc;
        }
      
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Wil wil;
        List<H1> list;
        int total = 0;
        
        try{
            JAXBContext context = JAXBContext.newInstance(Wil.class);
            Unmarshaller unMarshaller = context.createUnmarshaller();
            wil = (Wil) unMarshaller.unmarshal(new FileInputStream("C:\\src_sanskrit\\wil.xml"));
            list = wil.getH1();
            System.out.println("size="+list.size());
            
            for(Object obj: list){
                H1 h1 = (H1)obj;
                total +=h1.getBody().length() + h1.getH().getKey1().length();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("total="+total);
    }
    
    
    
}
