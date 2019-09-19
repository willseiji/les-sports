package br.com.les.strategies.impl;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.strategies.IStrategy;

public class StComplDataCadastro implements IStrategy {

	 private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	    @Override
	    public String processar(EntidadeDominio entidade) {
	        Date date = new Date();
	        entidade.setData_super(sdf.format(date));
	        return "";
	    }
}
