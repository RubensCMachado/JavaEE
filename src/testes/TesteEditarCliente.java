package testes;

import java.util.List;

import dao.ClienteDao;
import modelo.Cliente;

public class TesteEditarCliente {
public static void main(String[] args) {	
		
		ClienteDao dao = new ClienteDao();
		
		try {			
			List<Cliente> clientes = dao.getClientesByNome("Joao");  //Só registro com nome = Joao
			//List<Cliente> clientes = dao.getClientes(); //Todos os registros

			for (Cliente cliente : clientes) {
				
				cliente.setNome(cliente.getNome() + " Editado");
				dao.editar(cliente);
			}
			
			List<Cliente> clientes2 = dao.getClientes();

			for (Cliente cliente : clientes2) {
				System.out.println("Id: " + cliente.getId());
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("E-mail: " + cliente.getEmail());
				System.out.println("Endereço: " + cliente.getEndereco());
				System.out.println("--------------------------------------");
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro: " + e.getMessage());

		} finally {
			dao.fecharConexao();
			
		}
	}
}
