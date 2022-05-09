package interfacesDAO;

import java.util.Collection;

import model.Dao.DietistaDAO;
import model.DataObject.Dietista;

public interface IDietistaDAO {

	//CRUD
	
	boolean createDietista(Dietista d) ;
	 boolean deleteDietista(Dietista d);
	boolean updatePassDietista(Dietista d);
	Dietista showAllDietistas();
	boolean validDietista(String user, String pass);
	
	
}
