package br.ucsal.iot.enums;

public enum ConfiguracaoConexaoEnum {

	SUCESSO("Configuração salva com sucesso."), IP_OBRIGATORIO("Favor, preencher o campo \"IP\"."),
	PORTA_OBRIGATORIA("Favor, preencher o campo \"Porta\"."),
	IP_INVALIDO("O valor digitado no campo \"IP\" não obedece aos critérios de um \"IP\" válido."),
	PORTA_INVALIDA("O valor digitado no campo \"Porta\" não obedece aos critérios de um \"Porta\" válida.");
	;

	private String descricao;

	private ConfiguracaoConexaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
