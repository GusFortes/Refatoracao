package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import persistence.Cliente;
import persistence.ClienteSocio;

class ClienteTest {

	@Test
	public void criaClienteCorretamente() {
		Cliente c = new Cliente("Juvenal", "02447967030", 22, "Masculino");
		assertEquals("Juvenal", c.getNome());
	}
	
	@Test
	public void criaClienteSocioCorretamente() {
		Cliente c = new ClienteSocio("Juvenal", "02447967030", 22, "Masculino", 1);
		assertEquals(1, ((ClienteSocio) c).getNumeroSocio());
	}
	
	

	
}
