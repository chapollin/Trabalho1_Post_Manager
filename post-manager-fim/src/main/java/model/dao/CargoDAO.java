package model.dao;

import java.util.List;

import model.Cargo;
import model.ModelException;
import model.User;

public interface CargoDAO {
	boolean save(Cargo post) throws ModelException ;
	boolean update(Cargo post) throws ModelException;
	boolean delete(Cargo post) throws ModelException;
	List<Cargo> listAll() throws ModelException;
	Cargo findById(int id) throws ModelException;
}
