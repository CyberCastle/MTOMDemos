package cl.cc.utils;

import cl.cc.service.DocumentManager;
import cl.cc.service.DocumentManagerService;
import com.sun.xml.ws.developer.JAXWSProperties;
import com.sun.xml.ws.developer.StreamingAttachmentFeature;
import com.sun.xml.ws.developer.StreamingDataHandler;
import java.io.File;
import java.util.Map;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.MTOMFeature;

/**
 *
 * @author CyberCastle
 */
public class Run {

    public static void main(String[] arg) {

        DocumentManagerService service = new DocumentManagerService();
        MTOMFeature feature = new MTOMFeature();
        StreamingAttachmentFeature stf = new StreamingAttachmentFeature("/var/tmp", true, 4000000L);
        DocumentManager port = service.getDocumentManagerPort(feature, stf);
        Map<String, Object> ctxt = ((BindingProvider) port).getRequestContext();
        ctxt.put(JAXWSProperties.HTTP_CLIENT_STREAMING_CHUNK_SIZE, 8192);
        DataHandler dh = new DataHandler(new FileDataSource("/Users/CyberCastle/tmp/1849695229_Ruby.pdf"));
        port.upload("uploaded.pdf", dh);

        StreamingDataHandler sdh = (StreamingDataHandler) port.download("uploaded.pdf");
        try {
            File file = new File("/Users/CyberCastle/tmp/downloaded.pdf");
            sdh.moveTo(file);
            sdh.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
