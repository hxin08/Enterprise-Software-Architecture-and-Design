package edu.stevens.cs548.clinic.domain;


public class ProviderFactory implements IProviderFactory {
	public Provider createProvider(long pid, String name, String specialization){
		Provider p = new Provider();
		p.setNPI(pid);
		p.setName(name);
		p.setSpecialization(specialization);
		return null;
	}
}
