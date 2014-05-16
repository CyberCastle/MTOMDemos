
package cl.cc.service;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "DocumentManager", targetNamespace = "http://www.cybercastle.cl")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DocumentManager {


    /**
     * 
     * @param fileName
     * @return
     *     returns javax.activation.DataHandler
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "download", targetNamespace = "http://www.cybercastle.cl", className = "cl.cc.service.Download")
    @ResponseWrapper(localName = "downloadResponse", targetNamespace = "http://www.cybercastle.cl", className = "cl.cc.service.DownloadResponse")
    public DataHandler download(
        @WebParam(name = "fileName", targetNamespace = "")
        String fileName);

    /**
     * 
     * @param fileName
     * @param fileData
     */
    @WebMethod
    @RequestWrapper(localName = "upload", targetNamespace = "http://www.cybercastle.cl", className = "cl.cc.service.Upload")
    @ResponseWrapper(localName = "uploadResponse", targetNamespace = "http://www.cybercastle.cl", className = "cl.cc.service.UploadResponse")
    public void upload(
        @WebParam(name = "fileName", targetNamespace = "")
        String fileName,
        @WebParam(name = "fileData", targetNamespace = "")
        DataHandler fileData);

}