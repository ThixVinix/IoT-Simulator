package br.ucsal.iot.model;

public class DadosLixeira {

	private String capacidade;

	private String sensorGas;

	private String tempo;

	public DadosLixeira() {
	}

	public DadosLixeira(String capacidade, String sensorGas, String tempo) {
		super();
		this.capacidade = capacidade;
		this.sensorGas = sensorGas;
		this.tempo = tempo;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public String getSensorGas() {
		return sensorGas;
	}

	public void setSensorGas(String sensorGas) {
		this.sensorGas = sensorGas;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
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
		return "DadosLixeira [capacidade=" + capacidade + ", sensorGas=" + sensorGas + ", tempo=" + tempo + "]";
	}

}
