package br.com.les.viewhelper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.aplicacao.Resultado;
import br.com.les.dominio.impl.EntidadeDominio;

public interface IViewHelper {
		public EntidadeDominio getEntidade(HttpServletRequest request) throws ServletException, IOException;
		public void setView(Resultado resultado,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;
}
