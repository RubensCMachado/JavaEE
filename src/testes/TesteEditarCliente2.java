
package testes;

import dao.ClienteDao;
import modelo.Cliente;

public class TesteEditarCliente2 {

	public static void main(String[] args) {

		ClienteDao clienteDao = new ClienteDao();
		Cliente clienteById = clienteDao.getClientesById(new Cliente(1L));
		
		try {
			imp("Antes => ", clienteById);

			clienteById.setNome("Alison C444");
			clienteDao.editar(clienteById);

			imp("Depois =>  ", clienteById);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clienteDao.fecharConexao();
		}

	}

	private static void imp(String tipo, Cliente cliente) {
		System.out.println(tipo + " " + cliente);

	}

}



