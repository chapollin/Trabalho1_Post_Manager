package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cargo;
import model.ModelException;
import model.User;
import model.dao.CargoDAO;
import model.dao.DAOFactory;
import model.dao.UserDAO;

@WebServlet(urlPatterns = {"/cargo", "/cargo/form", "/cargo/delete", "/cargo/insert", "/cargo/update"})
public class CargosController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getRequestURI();
		
		switch (action) {
		case "/post-manager/cargo/form": {
			listCargos(req);
			req.setAttribute("action", "insert");
			ControllerUtil.forward(req, resp, "/form-cargo.jsp");
			break;
		}
		case "/post-manager/cargo/update": {
			listCargos(req);
			Cargo cargo = loadCargo(req);
			req.setAttribute("cargo", cargo);
			req.setAttribute("action", "update");
			ControllerUtil.forward(req, resp, "/form-cargo.jsp");
			break;
		}
		default:
			listCargos(req);
			
			ControllerUtil.transferSessionMessagesToRequest(req);
		
			ControllerUtil.forward(req, resp, "/cargo.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getRequestURI();
		
		if (action == null || action.equals("") ) {
			ControllerUtil.forward(req, resp, "/cargo.jsp");
			return;
		}
		
		switch (action) {
		case "/post-manager/cargo/delete":
			deleteCargo(req, resp);
			break;	
		case "/post-manager/cargo/insert": {
			insertCargo(req, resp);
			System.out.println("passei aqui");
			break;
		}
		case "/post-manager/cargo/update": {
			updateCargo(req, resp);
			break;
		}
		default:
			System.out.println("URL inválida " + action);
			break;
		}
			
		ControllerUtil.redirect(resp, req.getContextPath() + "/cargo");
	}

	private Cargo loadCargo(HttpServletRequest req) {
		String cargoIdParameter = req.getParameter("idCargo");
		
		int cargoId = Integer.parseInt(cargoIdParameter);
		
		CargoDAO dao = DAOFactory.createDAO(CargoDAO.class);
		
		try {
			Cargo cargo = dao.findById(cargoId);
			
			if (cargo == null)
				throw new ModelException("cargo não encontrado para alteração");
			
			return cargo;
		} catch (ModelException e) {
			// log no servidor
			e.printStackTrace();
			ControllerUtil.errorMessage(req, e.getMessage());
		}
		
		return null;
	}
	
	private void listCargos(HttpServletRequest req) {
		CargoDAO dao = DAOFactory.createDAO(CargoDAO.class);
		
		List<Cargo> cargos = null;
		try {
			cargos = dao.listAll();
		} catch (ModelException e) {
			// Log no servidor
			e.printStackTrace();
		}
		
		if (cargos != null)
			req.setAttribute("cargos", cargos);
	}
	
	private void insertCargo(HttpServletRequest req, HttpServletResponse resp) {
		String nomeCargo = req.getParameter("nomeCargo");
		String descricaoCargo = req.getParameter("descricaoCargo");
		double salarioCargo = Double.parseDouble(req.getParameter("salarioCargo"));
		double cargaHorariaSemanalCargo = Double.parseDouble(req.getParameter("cargaHorariaSemanalCargo"));
		
		Cargo cargo = new Cargo();
		cargo.setNomeCargo(nomeCargo);
		cargo.setDescricaoCargo(descricaoCargo);
		cargo.setCargaHorariaSemanalCargo(cargaHorariaSemanalCargo);
		cargo.setSalarioCargo(salarioCargo);
		
		CargoDAO dao = DAOFactory.createDAO(CargoDAO.class);
		
		try {
			if (dao.save(cargo)) {
				ControllerUtil.sucessMessage(req, "Usu�rio '" + cargo.getNomeCargo() + "' salvo com sucesso.");
			}
			else {
				ControllerUtil.errorMessage(req, "Usu�rio '" + cargo.getNomeCargo() + "' n�o pode ser salvo.");
			}
				
		} catch (ModelException e) {
			// log no servidor
			e.printStackTrace();
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}
	
	private void updateCargo(HttpServletRequest req, HttpServletResponse resp) {
		String nomeCargo = req.getParameter("nomeCargo");
		String descricaoCargo = req.getParameter("descricaoCargo");
		double salarioCargo = Double.parseDouble(req.getParameter("salarioCargo"));
		double cargaHorariaSemanalCargo = Double.parseDouble(req.getParameter("cargaHorariaSemanalCargo"));
		
		Cargo cargo = loadCargo(req);
		cargo.setNomeCargo(nomeCargo);
		cargo.setDescricaoCargo(descricaoCargo);
		cargo.setCargaHorariaSemanalCargo(cargaHorariaSemanalCargo);
		cargo.setSalarioCargo(salarioCargo);
		
		CargoDAO dao = DAOFactory.createDAO(CargoDAO.class);
		
		try {
			if (dao.update(cargo)) {
				ControllerUtil.sucessMessage(req, "Usuário '" + cargo.getNomeCargo() + "' atualizado com sucesso.");
			}
			else {
				ControllerUtil.errorMessage(req, "Usuário '" + cargo.getNomeCargo() + "' não pode ser atualizado.");
			}
				
		} catch (ModelException e) {
			// log no servidor
			e.printStackTrace();
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}
	
	private void deleteCargo(HttpServletRequest req, HttpServletResponse resp) {
		String cargoIdParameter = req.getParameter("id");
		System.out.println(" aqui:" + cargoIdParameter);
		
		int cargoId = Integer.parseInt(cargoIdParameter);
		
		CargoDAO dao = DAOFactory.createDAO(CargoDAO.class);
		
		try {
			Cargo cargo = dao.findById(cargoId);
			
			if (cargo == null)
				throw new ModelException("Usuário não encontrado para deleção.");
			
			if (dao.delete(cargo)) {
				ControllerUtil.sucessMessage(req, "Usuário '" + cargo.getNomeCargo() + "' deletado com sucesso.");
			}
			else {
				ControllerUtil.errorMessage(req, "Usuário '" + cargo.getNomeCargo() + "' não pode ser deletado.");
			}
		} catch (ModelException e) {
			// log no servidor
			e.printStackTrace();
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}
}
