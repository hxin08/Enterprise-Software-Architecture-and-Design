package edu.stevens.cs548.clinic.service.web.soap.provider;


import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import edu.stevens.cs548.clinic.domain.IProviderDAO.ProviderExn;
import edu.stevens.cs548.clinic.service.dto.provider.ProviderDTO;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderServiceExn;

@WebService(name = "IProviderWebPort", 
targetNamespace = "http://cs548.stevens.edu/clinic/service/web/soap/provider")

public interface IProviderWebService {
	@WebMethod(operationName = "create")
	public long createProvider(String name, long NPI)
			throws ProviderServiceExn, ProviderExn;

	@WebMethod
	@WebResult(name = "ProviderDto", targetNamespace = "http://cs548.stevens.edu/clinic/schemas/provider")
	public ProviderDTO[] getProviderByName(String name);

	@WebMethod
	@WebResult(name = "ProviderDto", targetNamespace = "http://cs548.stevens.edu/clinic/schemas/provider")
	public ProviderDTO getProviderByNPI(long NPI) throws ProviderServiceExn;

	@WebMethod
	@WebResult(name = "ProviderDto", targetNamespace = "http://cs548.stevens.edu/clinic/schemas/provider")
	public TreatmentDto createTreatmentByIdNPI(long id, long NPI,
			TreatmentDto tdo);

	@WebMethod
	public long deleteProvider(String name, long id) throws ProviderServiceExn;

	public TreatmentDto[] getTreatments(long id, long[] tids, long NPI)
			throws ProviderNotFoundExn, ProviderServiceExn;
	@WebMethod
	public String siteInfo();
}
