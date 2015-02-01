package edu.stevens.cs548.clinic.service.web.soap.provider;


import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebService;

import edu.stevens.cs548.clinic.service.dto.provider.ProviderDTO;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderServiceRemote;

@WebService(
		endpointInterface="edu.stevens.cs548.clinic.service.web.soap.provider.IProviderWebService",
		targetNamespace="http://cs548.stevens.edu/clinic/service/web/soap/provider",
		serviceName="ProviderWebService",
		portName="ProviderWebPort")

public class ProviderWebService implements IProviderWebService{
	
	@EJB(beanName="ProviderServiceBean")
	IProviderServiceRemote service;
	
	@Override
	public long createProvider (String name, long NPI) {
		return service.createProvider(name, NPI);
	}
	
	@Override
	public ProviderDTO[] getProviderByName (String name) {
		return service.getProviderByName(name);
	}
	
	@Override
	public ProviderDTO getProviderByNPI (long NPI) throws ProviderServiceExn {
		return service.getProviderByNPI(NPI);
	}
	
	@Override
	public TreatmentDto createTreatmentByIdNPI(long id, long NPI, TreatmentDto tdo) {
		return service.createTreatmentByIdNPI(id, NPI, tdo);
	}
	
	@Override
	public long deleteProvider (String name, long id) throws ProviderServiceExn {
		return service.deleteProvider(name, id);
	}
	
	@Override
	public TreatmentDto[] getTreatments(long id, long[] tids, long NPI) throws ProviderNotFoundExn, ProviderServiceExn {
		return service.getTreatments(id, tids, NPI);
	}
	
	@Resource(name="SiteInfo")
	private String siteInformation;
	
	@Override
	public String siteInfo() {
		return service.siteInfo();
	}
}
