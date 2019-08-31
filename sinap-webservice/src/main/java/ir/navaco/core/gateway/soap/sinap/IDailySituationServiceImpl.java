package ir.navaco.core.gateway.soap.sinap;

@javax.jws.WebService(
        serviceName = "DailySituationService",
        targetNamespace = "http://tempuri.org/",
        wsdlLocation = "classpath:wsdl/dailysituation.wsdl",
        endpointInterface = "ir.navaco.core.gateway.soap.sinap.IDailySituationService")

public class IDailySituationServiceImpl implements IDailySituationService {
    @Override
    public String insert(DailySituation dailySituation) throws IDailySituationServiceInsertSinapExceptionFaultFaultMessage {
        if (dailySituation.getBranchCode() == null) {
            SinapException sinapException = new SinapException();
            sinapException.setErrorCode(611);
            throw new IDailySituationServiceInsertSinapExceptionFaultFaultMessage(
                    "Branch code is null", sinapException);
        }
        return "123456789";
    }
}
