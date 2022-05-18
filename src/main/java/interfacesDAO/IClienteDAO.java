package interfacesDAO;

import java.util.Collection;

import model.Dao.ClienteDAO;
import model.DataObject.Clientes;

public interface IClienteDAO {

	boolean createCliente(Clientes c);
	Collection<Clientes> getAllClientes();
	boolean updateAll(Clientes c);
	boolean updateName(Clientes c);
	boolean updateApellidos(Clientes c);
	boolean updateEdad(Clientes c);
	boolean updateAltura(Clientes c);
	boolean updatePeso(Clientes c);
	boolean updateGenero(Clientes c);
	boolean updateMotivoDieta(Clientes c);
	boolean updateAlergia(Clientes c);
	boolean updateDieta(Clientes c);
	boolean updateDietista(Clientes c);
	boolean delete(Clientes c);
	
}
