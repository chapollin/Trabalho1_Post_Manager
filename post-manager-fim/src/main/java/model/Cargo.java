package model;

public class Cargo {
	private int idCargo;
	private String nomeCargo;
	private String descricaoCargo;
	private double salarioCargo;
	private double cargaHorariaSemanalCargo;
	
	public Cargo() {
		this(0);
	}
	
	public Cargo(int id) {
		this.idCargo = id;
		setNomeCargo("");
		setDescricaoCargo("");
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public String getDescricaoCargo() {
		return descricaoCargo;
	}

	public void setDescricaoCargo(String descricaoCargo) {
		this.descricaoCargo = descricaoCargo;
	}

	public double getSalarioCargo() {
		return salarioCargo;
	}

	public void setSalarioCargo(double salarioCargo) {
		this.salarioCargo = salarioCargo;
	}

	public double getCargaHorariaSemanalCargo() {
		return cargaHorariaSemanalCargo;
	}

	public void setCargaHorariaSemanalCargo(double cargaHorariaSemanalCargo) {
		this.cargaHorariaSemanalCargo = cargaHorariaSemanalCargo;
	}

	
}
