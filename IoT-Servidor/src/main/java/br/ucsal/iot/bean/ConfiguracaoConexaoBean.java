package br.ucsal.iot.bean;

import br.ucsal.iot.enums.ConfiguracaoConexaoEnum;
import br.ucsal.iot.model.ConfiguracaoConexao;
import br.ucsal.iot.utils.ConfServerUtil;
import br.ucsal.iot.utils.Util;

public class ConfiguracaoConexaoBean {

	public ConfiguracaoConexao confConnect;

	public ConfiguracaoConexaoBean() {
		confConnect = new ConfiguracaoConexao();
	}

	public ConfiguracaoConexaoEnum validarCamposConfiguracaoConexao(String Ip, String porta) {
		if (Util.isNullOrEmpty(Ip)) {
			return ConfiguracaoConexaoEnum.IP_OBRIGATORIO;
		}

		if (Util.isNullOrEmpty(porta)) {
			return ConfiguracaoConexaoEnum.PORTA_OBRIGATORIA;
		}

		if (!ConfServerUtil.validarIp(Ip.trim())) {
			return ConfiguracaoConexaoEnum.IP_INVALIDO;
		}

		if (!ConfServerUtil.validarPorta(porta.trim())) {
			return ConfiguracaoConexaoEnum.PORTA_INVALIDA;
		}

		return ConfiguracaoConexaoEnum.SUCESSO;
	}

}
