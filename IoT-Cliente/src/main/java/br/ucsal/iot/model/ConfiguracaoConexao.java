package br.ucsal.iot.model;

public class ConfiguracaoConexao {

	private String ip;
	private String porta;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	@Override
	public String toString() {
		return "ConfiguracaoConexao [ip=" + ip + ", porta=" + porta + "]";
	}

}
