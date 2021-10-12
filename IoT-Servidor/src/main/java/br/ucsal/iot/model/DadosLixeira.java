package br.ucsal.iot.model;

public class DadosLixeira {

	private Integer capacidade;

	private Integer sensorGas;

	private Integer sensorTemperatura;

	private Integer sensorMagnetismo;

	private Integer periodo;

	public DadosLixeira() {
	}

	public DadosLixeira(Integer capacidade, Integer sensorGas, Integer sensorTemperatura, Integer sensorMagnetismo,  Integer periodo) {
		super();
		this.capacidade = capacidade;
		this.sensorGas = sensorGas;
		this.sensorTemperatura = sensorTemperatura;
		this.sensorMagnetismo = sensorMagnetismo;
		this.periodo = periodo;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Integer getSensorGas() {
		return sensorGas;
	}

	public void setSensorGas(Integer sensorGas) {
		this.sensorGas = sensorGas;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Integer getSensorTemperatura() {
		return sensorTemperatura;
	}

	public void setSensorTemperatura(Integer sensorTemperatura) {
		this.sensorTemperatura = sensorTemperatura;
	}

	public Integer getSensorMagnetismo() {
		return sensorMagnetismo;
	}

	public void setSensorMagnetismo(Integer sensorMagnetismo) {
		this.sensorMagnetismo = sensorMagnetismo;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "DadosLixeira [capacidade=" + capacidade + ", sensorGas=" + sensorGas + ", sensorTemperatura="
				+ sensorTemperatura + ", sensorMagnetismo=" + sensorMagnetismo + ", periodo=" + periodo + "]";
	}
	
}
