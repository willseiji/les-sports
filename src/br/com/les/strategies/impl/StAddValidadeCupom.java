package br.com.les.strategies.impl;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.les.dominio.impl.Cupom;
import br.com.les.dominio.impl.EntidadeDominio;
import br.com.les.strategies.IStrategy;

public class StAddValidadeCupom implements IStrategy {

	 private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	    @Override
	    public String processar(EntidadeDominio entidade) {
	        Date date = new Date();
	        Cupom cupom = (Cupom) entidade;
	        
	        Calendar c = Calendar.getInstance();
			try{
			   c.setTime(sdf.parse(sdf.format(date)));
			}catch(ParseException e){
				e.printStackTrace();
			 }
			c.add(Calendar.DAY_OF_MONTH, 7);  
			String newDate = sdf.format(c.getTime());
	        cupom.setDataValidade(newDate);
	        
	        return "";
	    }
	      
	    
}
