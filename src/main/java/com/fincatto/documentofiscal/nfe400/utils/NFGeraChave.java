package com.fincatto.documentofiscal.nfe400.utils;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFNota;
import org.apache.commons.lang3.StringUtils;

import java.time.format.DateTimeFormatter;
import java.util.Random;

public class NFGeraChave {

    private final NFNota nota;

    public NFGeraChave(final NFNota nota) {
        this.nota = nota;
    }

    public String geraCodigoRandomico() {
        final Random random = new Random(this.nota.getInfo().getIdentificacao().getDataHoraEmissao().toInstant().toEpochMilli());
        return StringUtils.leftPad(String.valueOf(random.nextInt(100000000)), 8, "0");
    }

    public String getChaveAcesso() {
        return String.format("%s%s", this.geraChaveAcessoSemDV(), this.getDV());
    }

    public Integer getDV() {
    	final char[] valores = this.geraChaveAcessoSemDV()
    			.toUpperCase()
    			.toCharArray();
    	final int[] pesos = { 2, 3, 4, 5, 6, 7, 8, 9 };
    	int indicePeso = 0;
    	int soma = 0;
    	for (int i = valores.length - 1; i >= 0; i--) {
    		if (indicePeso >= pesos.length) {
    			indicePeso = 0;
    		}
    		int valorConvertido = valores[i] - 48;
    		soma += valorConvertido * pesos[indicePeso++];
    	}
    	int resto = soma % 11;
    	int dv = 11 - resto;
    	return (dv == 10 || dv == 11) ? 0 : dv;
    }

    private String geraChaveAcessoSemDV() {
        if (StringUtils.isBlank(this.nota.getInfo().getIdentificacao().getCodigoRandomico())) {
            throw new IllegalStateException("Codigo randomico deve estar presente para gerar a chave de acesso");
        }
        return StringUtils.leftPad(this.nota.getInfo().getIdentificacao().getUf().getCodigoIbge(), 2, "0") +
                StringUtils.leftPad(DateTimeFormatter.ofPattern("yyMM").format(this.nota.getInfo().getIdentificacao().getDataHoraEmissao()), 4, "0") +
                StringUtils.leftPad(this.nota.getInfo().getEmitente().getCnpj() == null ? this.nota.getInfo().getEmitente().getCpf() : this.nota.getInfo().getEmitente().getCnpj(), 14, "0") +
                StringUtils.leftPad(this.nota.getInfo().getIdentificacao().getModelo().getCodigo(), 2, "0") +
                StringUtils.leftPad(this.nota.getInfo().getIdentificacao().getSerie(), 3, "0") +
                StringUtils.leftPad(this.nota.getInfo().getIdentificacao().getNumeroNota(), 9, "0") +
                StringUtils.leftPad(this.nota.getInfo().getIdentificacao().getTipoEmissao().getCodigo(), 1, "0") +
                StringUtils.leftPad(this.nota.getInfo().getIdentificacao().getCodigoRandomico(), 8, "0");
    }
}
