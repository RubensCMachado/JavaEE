package testes;

import java.util.List;

import dao.ClienteDao;
import modelo.Cliente;

public class TesteExcluirCliente {
	public static void main(String[] args) {	
		
		ClienteDao dao = new ClienteDao();
		
		try {			
			List<Cliente> clientes = dao.getClientes();

			for (Cliente cliente : clientes) {
				//só um
				if (cliente.getId() == 1) {
					dao.excluir(cliente);
				}
				
				//todos
				//dao.excluir(cliente);
			}			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			dao.fecharConexao();
		}
	}
}
