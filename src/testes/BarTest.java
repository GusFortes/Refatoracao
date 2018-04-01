package testes;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Executable;

import org.junit.jupiter.api.Test;

import bar.Cliente;
import bar.ClienteSocio;
import bar.Bar;

class BarTest {

	@Test
	public void testCadastraERetornaClienteCpf() {
		Bar b = new Bar();
		b.cadastroCliente(new Cliente("Jonas", "024.479.780-30", 49, "Masculino"));
		assertEquals("024.479.780-30", b.retornaCliente("024.479.780-30").getCpf());

	}

	@Test
	public void testQntdClientesNoBar() {
		Bar b = new Bar();
		b.cadastroCliente(new Cliente("Jonas", "024.479.780-30", 49, "Masculino"));
		b.cadastroCliente(new Cliente("Jonas", "024.479.780-30", 49, "Masculino"));
		b.cadastroCliente(new Cliente("Jonas", "024.479.780-30", 49, "Masculino"));
		assertEquals(3, b.qntdDePessoas());

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
	public void testQntdSocios() {
		Bar b = new Bar();
		b.cadastroCliente(new Cliente("Jonas", "024.479.780-30", 49, "Masculino"));
		b.cadastroCliente(new ClienteSocio("Jonas", "024.479.780-30", 49, "Masculino", 24));
		assertEquals("1 clientes são sócios no bar e 1 não são sócios", b.qntdDeSocios());
	}
	
	@Test 
	public void testRemoveCliente() {
		Bar b = new Bar();
		b.cadastroCliente(new Cliente("Jonas", "024.479.780-30", 49, "Masculino"));
		b.cadastroCliente(new Cliente("Patricia", "054.567.874-66", 25, "Feminino"));
		assertEquals("024.479.780-30",b.retornaCliente("024.479.780-30").getCpf());
		b.removeCliente("024.479.780-30");
		assertThrows(IllegalArgumentException.class, () -> b.retornaCliente("024.479.780-30"));
	}
	

}
