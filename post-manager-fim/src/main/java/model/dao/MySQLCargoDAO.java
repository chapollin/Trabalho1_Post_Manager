package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.Cargo;
import model.ModelException;
import model.User;

public class MySQLCargoDAO implements CargoDAO {

	@Override
	public boolean save(Cargo cargo) throws ModelException {
		
		DBHandler db = new DBHandler();
		
		String sqlInsert = "INSERT INTO cargos VALUES  (DEFAULT, ?, ?, ?, ?)";
		db.prepareStatement(sqlInsert);
		db.setString(1, cargo.getNomeCargo());
		db.setString(2, cargo.getDescricaoCargo());
		db.setString(3, String.valueOf(cargo.getSalarioCargo()));
		db.setString(4, String.valueOf(cargo.getCargaHorariaSemanalCargo()));
		  
		return db.executeUpdate() > 0;
	}

	@Override
	public boolean update(Cargo cargo) throws ModelException {
		
		DBHandler db = new DBHandler();
		/*
		String sqlUpdate = "UPDATE users "
				         	+ "SET nome = ?, "
				         	+ "sexo = ?, "
				         	+ "email = ? "
				         + "WHERE id = ?";
		*/
		String sqlUpdate = "UPDATE cargos SET nomeCargo=?, descricaoCargo=?,salarioCargo=?,cargaHorariaSemanalCargo=? WHERE  idCargo=?";
		
		db.prepareStatement(sqlUpdate);
		
		db.setString(1, cargo.getNomeCargo());
		db.setString(2, cargo.getDescricaoCargo());
		db.setString(3, String.valueOf(cargo.getSalarioCargo()));
		db.setString(4, String.valueOf(cargo.getCargaHorariaSemanalCargo()));
		db.setInt(5, cargo.getIdCargo());
		
		return db.executeUpdate() > 0;
	}

	@Override
	public boolean delete(Cargo cargo) throws ModelException {
		
		DBHandler db = new DBHandler();
		
		String sqlDelete = " DELETE FROM cargos "
		                 + " WHERE idCargo = ?";

		db.prepareStatement(sqlDelete);		
		db.setInt(1, cargo.getIdCargo());
		
		return db.executeUpdate() > 0;
	}
	@Override
	public List<Cargo> listAll() throws ModelException {
	
		DBHandler db = new DBHandler();
		
		List<Cargo> cargo = new ArrayList<Cargo>();
			
		// Declara um instrução SQL
		//String sqlQuery = "SELECT * FROM users";
		String sqlQuery = "SELECT * FROM cargos";
		
		
		db.createStatement();
	
		db.executeQuery(sqlQuery);

		while (db.next()) {
			Cargo c = createCargo(db);
			c.setNomeCargo(db.getString("nomeCargo"));
			//ystem.out.println("passei aqui");
			c.setDescricaoCargo(db.getString("descricaoCargo"));
			c.setIdCargo(Integer.parseInt(db.getString("idCargo")));
			c.setCargaHorariaSemanalCargo(Double.parseDouble(db.getString("cargaHorariaSemanalCargo")));
			c.setSalarioCargo(Double.parseDouble(db.getString("salarioCargo")));
			cargo.add(c);
			
		}
		
		return cargo;
	}

	@Override
	public Cargo findById(int id) throws ModelException {
		
		DBHandler db = new DBHandler();
				
		//String sql = "";
		String sql = "SELECT * FROM cargos WHERE idCargo = ?";
		
		db.prepareStatement(sql);
		db.setInt(1, id);
		db.executeQuery();
		
		Cargo u = null;
		while (db.next()) {
			u = createCargo(db);
			break;
		}
		
		return u;
	}
	
	private Cargo createCargo(DBHandler db) throws ModelException {
		Cargo u = new Cargo(db.getInt("idCargo"));
		u.setNomeCargo(db.getString("nomeCargo"));
		u.setDescricaoCargo(db.getString("descricaoCargo"));
		u.setSalarioCargo(Double.parseDouble(db.getString("salarioCargo")));
		u.setCargaHorariaSemanalCargo(Double.parseDouble(db.getString("cargaHorariaSemanalCargo")));
		
		return u;
	}

	


}
