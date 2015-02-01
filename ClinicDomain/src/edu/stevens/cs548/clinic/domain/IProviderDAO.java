package edu.stevens.cs548.clinic.domain;

import java.util.Date;
import java.util.List;


	public interface IProviderDAO {
	public static class ProviderExn extends Exception {
		private static final long serialVersionUID =1L;
		public ProviderExn (String msg) {
			super(msg);
		}
	} 
	public Provider getProviderByNPI (long pid) throws ProviderExn;
	
	public Provider getProviderByDbId (long id) throws ProviderExn;
	
	public List<Provider> getProviderByNameDob (String name, Date dob);
	
	public void addProvider (Provider pat) throws ProviderExn;
	
	public void deleteProvider (Provider pat) throws ProviderExn;
}
