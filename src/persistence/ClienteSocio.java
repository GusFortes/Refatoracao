package persistence;

public class ClienteSocio extends Cliente {

	private int numeroSocio;
	
	public ClienteSocio(String nome, String cpf, int idade, String genero, int numeroSocio) {
		super(nome, cpf, idade, genero);
	this.numeroSocio = numeroSocio;
	}

	public int getNumeroSocio() {
		return numeroSocio;
	}
	
	
	
	

}
