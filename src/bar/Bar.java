package bar;

import java.util.HashSet;
import java.util.Set;

public class Bar {
//Cliente sócio: super() e número de sócio
//Funcionalidades do bar: Consultar pessoas no bar, identificar por CPF, quantidade, distribuição percentual por genero
						//diferenciação de status de sócio. Para sair, o cliente informa o CPF.
	Set<Cliente> clientesNoBar;

	public Bar() {
		super();
		this.clientesNoBar = new HashSet<>();
	}
	//Retorna os clientes no bar
	public StringBuilder getClientesNoBar() {
		StringBuilder aux = new StringBuilder();
		for(Cliente c: clientesNoBar) {
			aux.append(c.toString()+"\n");
		}
		return aux;
	}
	
	//Metodo para registrar um cliente
	public void cadastroCliente(Cliente c) {
		clientesNoBar.add(c);
	}
	
	
	//Retorna numero de pessoas no bar
	public int qntdDePessoas() {
		return clientesNoBar.size();
	}
	
	//Identificar por CPF
	public Cliente retornaCliente(String cpf) {
		for (Cliente cliente : clientesNoBar) {
			if(cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}throw new IllegalArgumentException("CPF não encontrado!");
	}
	
	//Retorna distribuição por gênero %
	public String retornaDistribuicaoGenero() {
		int homens = 0;
		
		for (Cliente cliente : clientesNoBar) {
			if(cliente.getGenero().equals("Masculino")) {
				homens ++;
			}
		}
			return "Quantidade de homens: "+ (homens*100)/clientesNoBar.size() + "\nQuantidade de mulheres:" + ((clientesNoBar.size() - homens)*100)/clientesNoBar.size();
			}
	
	//Retorna quantidade de socios
	public String qntdDeSocios() {
		int qntd = 0;
		for (Cliente cliente : clientesNoBar) {
			if(cliente instanceof ClienteSocio) {
				qntd++;
			}
		}
		return qntd + " clientes são sócios no bar e"  + (clientesNoBar.size()-qntd) + " não são sócios" ;
		
	}
	
	//Saida de cliente
	public void removeCliente(String cpf) {
		if(retornaCliente(cpf) != null) {
			clientesNoBar.remove(retornaCliente(cpf));
		} else {
			throw new IllegalArgumentException("O cliente não está no bar.");
			
		}
	}
	
	
}
