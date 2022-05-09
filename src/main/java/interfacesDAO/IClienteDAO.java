package interfacesDAO;

import java.util.Collection;

import model.Dao.ClienteDAO;
import model.DataObject.Clientes;

public interface IClienteDAO {

	boolean createDietista(Clientes c);
	Collection<Clientes> getAllClientes();
	int updateDietista(Clientes c);
	boolean delete(Clientes c);
	
}
