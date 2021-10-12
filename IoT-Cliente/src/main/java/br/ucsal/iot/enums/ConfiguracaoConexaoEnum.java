package br.ucsal.iot.enums;

public enum ConfiguracaoConexaoEnum {

	SUCESSO("Configura��o salva com sucesso."), IP_OBRIGATORIO("Favor, preencher o campo \"IP\"."),
	PORTA_OBRIGATORIA("Favor, preencher o campo \"Porta\"."),
	IP_INVALIDO("O valor digitado no campo \"IP\" n�o obedece aos crit�rios de um \"IP\" v�lido."),
	PORTA_INVALIDA("O valor digitado no campo \"Porta\" n�o obedece aos crit�rios de um \"Porta\" v�lida.");
	;

	private String descricao;

	private ConfiguracaoConexaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
