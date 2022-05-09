package interfacesDAO;

import java.util.Collection;

import model.Dao.DietaDAO;
import model.DataObject.Dieta;


public interface IDietaDAO {

	boolean createDieta(Dieta d);
	Collection<Dieta> get();
	int updateDieta(Dieta d);
	boolean delete(Dieta d);
	
}
