package edu.stevens.cs548.clinic.service.ejb;

import javax.jws.WebMethod;
import javax.jws.WebResult;

import edu.stevens.cs548.clinic.service.dto.provider.ProviderDTO;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;


public interface IProviderService {
	public class ProviderServiceExn extends Exception {
		private static final long serialVersionUID = 1L;
		
		public ProviderServiceExn (String m){
			super(m);
		}
	}
	
	public class ProviderNotFoundExn extends ProviderServiceExn{
		private static final long serialVersionUID = 1L;
		public ProviderNotFoundExn (String m){
			super(m);
		}
	}
	
	public class TreatmentNotFoundExn extends ProviderServiceExn{
		private static final long serialVersionUID = 1L;
		public TreatmentNotFoundExn (String m){
			super(m);
		}
	}
	
	public long createProvider (String name, long NPI);
	@WebMethod
	@WebResult(name="ProviderDto",
	targetNamespace="http://cs548.stevens.edu/clinic/schemas/provider")
	public ProviderDTO[] getProviderByName (String name);
	
	@WebMethod
	@WebResult(name="ProviderDto",
	targetNamespace="http://cs548.stevens.edu/clinic/schemas/provider")
	public ProviderDTO getProviderByNPI (long NPI) throws ProviderServiceExn;
	
	public TreatmentDto createTreatmentByIdNPI(long id, long NPI, TreatmentDto tdo);
	
	public long deleteProvider (String name, long id) throws ProviderServiceExn;
	
	public TreatmentDto[] getTreatments(long id, long[] tids, long NPI) throws ProviderNotFoundExn, ProviderServiceExn;
	
	public String siteInfo();
}
