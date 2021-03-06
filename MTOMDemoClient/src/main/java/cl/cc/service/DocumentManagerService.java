
package cl.cc.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "DocumentManagerService", targetNamespace = "http://www.cybercastle.cl", wsdlLocation = "http://localhost:8080/MTOMDemoServer/DocumentManager?wsdl")
public class DocumentManagerService
    extends Service
{

    private final static URL DOCUMENTMANAGERSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(cl.cc.service.DocumentManagerService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = cl.cc.service.DocumentManagerService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/MTOMDemoServer/DocumentManager?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/MTOMDemoServer/DocumentManager?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        DOCUMENTMANAGERSERVICE_WSDL_LOCATION = url;
    }

    public DocumentManagerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DocumentManagerService() {
        super(DOCUMENTMANAGERSERVICE_WSDL_LOCATION, new QName("http://www.cybercastle.cl", "DocumentManagerService"));
    }

    /**
     * 
     * @return
     *     returns DocumentManager
     */
    @WebEndpoint(name = "DocumentManagerPort")
    public DocumentManager getDocumentManagerPort() {
        return super.getPort(new QName("http://www.cybercastle.cl", "DocumentManagerPort"), DocumentManager.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DocumentManager
     */
    @WebEndpoint(name = "DocumentManagerPort")
    public DocumentManager getDocumentManagerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.cybercastle.cl", "DocumentManagerPort"), DocumentManager.class, features);
    }

}
