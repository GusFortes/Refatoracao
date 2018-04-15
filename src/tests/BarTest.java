package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Executable;

import org.junit.jupiter.api.Test;

import business.Bar;
import persistence.Cliente;
import persistence.ClienteSocio;

class BarTest {

	@Test
	public void testCadastraERetornaClienteCpf() {
		Bar b = new Bar();
		b.cadastroCliente(new Cliente("Jonas", "024.479.780-30", 49, "Masculino"));
		assertEquals("024.479.780-30", b.retornaCliente("024.479.780-30").getCpf());

	}

	@Test
	public void testClienteJaNoBar() {
		Bar b = new Bar();
		b.cadastroCliente(new Cliente("Jonas", "024.479.780-30", 49, "Masculino"));
		assertThrows(IllegalArgumentException.class,
				() -> b.cadastroCliente(new Cliente("Jonas", "024.479.780-30", 49, "Masculino")));

	}

	@Test
	public void testRetornaClienteInvalido() {
		Bar b = new Bar();
		b.cadastroCliente(new Cliente("Jonas", "024.479.780-30", 49, "Masculino"));
		assertThrows(IllegalArgumentException.class, () -> b.retornaCliente("xxx"));
	}

	@Test
	public void testRetornaDistPorGenero() {
		Bar b = new Bar();
		b.cadastroCliente(new Cliente("Jonas", "024.479.780-30", 49, "Masculino"));
		b.cadastroCliente(new Cliente("Patricia", "054.567.874-66", 25, "Feminino"));
		assertEquals("Quantidade de homens: 50%\nQuantidade de mulheres: 50%", b.retornaDistribuicaoGenero());

	}

	@Test
	public void testQntdDeClientes() {
		Bar b = new Bar();
		b.cadastroCliente(new Cliente("Jonas", "024.479.780-30", 49, "Masculino"));
		b.cadastroCliente(new ClienteSocio("Jonas", "024.479.780-31", 49, "Masculino", 24));
		assertEquals(2, b.qntdDePessoas());
	}
	@Test
	public void testQntdSocios() {
		Bar b = new Bar();
		b.cadastroCliente(new Cliente("Jonas", "024.479.780-30", 49, "Masculino"));
		b.cadastroCliente(new ClienteSocio("Jonas", "024.479.780-31", 49, "Masculino", 24));
		assertEquals("1 clientes sao socios no bar e 1 nao sao socios", b.qntdDeSocios());
	}

	@Test
	public void testRemoveCliente() {
		Bar b = new Bar();
		b.cadastroCliente(new Cliente("Jonas", "024.479.780-30", 49, "Masculino"));
		b.cadastroCliente(new Cliente("Patricia", "054.567.874-66", 25, "Feminino"));
		assertEquals("024.479.780-30", b.retornaCliente("024.479.780-30").getCpf());
		b.removeCliente("024.479.780-30");
		assertThrows(IllegalArgumentException.class, () -> b.retornaCliente("024.479.780-30"));
	}

}
