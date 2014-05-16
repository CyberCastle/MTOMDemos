package cl.cc;

import com.sun.xml.ws.developer.StreamingAttachment;
import com.sun.xml.ws.developer.StreamingDataHandler;
import java.io.File;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.soap.MTOM;

/**
 *
 * @author CyberCastle
 */
@StreamingAttachment(parseEagerly = true, memoryThreshold = 4000000L, dir="/var/tmp")
@WebService(name = "DocumentManager", serviceName = "DocumentManagerService", targetNamespace = "http://www.cybercastle.cl")
@MTOM
public class DocumentManager {

    @WebMethod(operationName = "upload")
    public void upload(@WebParam(name = "fileName") String fileName,
            @WebParam(name = "fileData")
            @XmlMimeType("application/octet-stream") DataHandler data) {

        try {
            StreamingDataHandler dh = (StreamingDataHandler) data;
            System.out.println("File Uploaded: " + fileName);
            File file = new File("/Users/CyberCastle/tmp/" + fileName);
            dh.moveTo(file);
            dh.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    @WebMethod(operationName = "download")
    @XmlMimeType("application/octet-stream")
    public DataHandler download(@WebParam(name = "fileName") String fileName) {
        return  new DataHandler(new FileDataSource("/Users/CyberCastle/tmp/" + fileName));
    }
}

//http://download.oracle.com/docs/cd/E12839_01/web.1111/e13734/mtom.htm
