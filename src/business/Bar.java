package business;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import persistence.Cliente;
import persistence.ClienteSocio;

public class Bar {
	// Cliente s�cio: super() e n�mero de s�cio
	// Funcionalidades do bar: Consultar pessoas no bar, identificar por CPF,
	// quantidade, distribui��o percentual por genero
	// diferencia��o de status de s�cio. Para sair, o cliente informa o CPF.
	Set<Cliente> clientesNoBar;
	Set<Cliente> clientesDoDia;

	public Bar() {
		super();
		this.clientesNoBar = new HashSet<>();
		this.clientesDoDia = new HashSet<>();
	}

	// Retorna os clientes no bar
	public StringBuilder getClientesNoBar() {
		StringBuilder aux = new StringBuilder();
		for (Cliente c : clientesNoBar) {
			aux.append(c.toString() + "\n");
		}
		return aux;
	}

	// Metodo para registrar um cliente
	public void cadastroCliente(Cliente c) {
		clientesNoBar.add(c);
		clientesDoDia.add(c);
	}

	// Retorna numero de pessoas no bar
	public int qntdDePessoas() {
		return clientesNoBar.size();
	}

	// Identificar por CPF
	public Cliente retornaCliente(String cpf) {
		for (Cliente cliente : clientesNoBar) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		throw new IllegalArgumentException("CPF n�o encontrado!");
	}

	// Retorna distribui��o por g�nero %
	public String retornaDistribuicaoGenero() {
		int homens = 0;

		for (Cliente cliente : clientesNoBar) {
			if (cliente.getGenero().equals("Masculino")) {
				homens++;
			}
		}
		return "Quantidade de homens: " + (homens * 100) / clientesNoBar.size() + "%" + "\nQuantidade de mulheres: "
				+ ((clientesNoBar.size() - homens) * 100) / clientesNoBar.size() + "%";
	}

	// Retorna quantidade de socios
	public String qntdDeSocios() {
		int qntd = 0;
		for (Cliente cliente : clientesNoBar) {
			if (cliente instanceof ClienteSocio) {
				qntd++;
			}
		}
		return qntd + " clientes s�o s�cios no bar e " + (clientesNoBar.size() - qntd) + " n�o s�o s�cios";

	}

	// Saida de cliente
	public void removeCliente(String cpf) {
		if (retornaCliente(cpf) != null) {
			clientesNoBar.remove(retornaCliente(cpf));
		} else {
			throw new IllegalArgumentException("O cliente n�o est� no bar.");

		}
	}

	// Fecha bar e coloca no arquivo texto todos os clientes do dia
	public void fechaBar() throws IOException {
		BufferedWriter  out = new BufferedWriter (new FileWriter("src/persistence/clientesQueEstiveramNoBar.txt"));
		for (Cliente c : clientesDoDia) {
			out.write(c.toString());
			out.newLine();
		}
	out.close();
	}

}
