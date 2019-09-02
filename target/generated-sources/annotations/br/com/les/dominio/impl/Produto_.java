package br.com.les.dominio.impl;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, Double> preco;
	public static volatile SingularAttribute<Produto, String> tamanho;
	public static volatile SingularAttribute<Produto, String> material;
	public static volatile SingularAttribute<Produto, Double> peso;
	public static volatile SingularAttribute<Produto, String> categoria;
	public static volatile SingularAttribute<Produto, String> nome;
	public static volatile SingularAttribute<Produto, Integer> id;
	public static volatile SingularAttribute<Produto, String> fabricante;
	public static volatile SingularAttribute<Produto, String> codigoProd;
	public static volatile SingularAttribute<Produto, Integer> quantidade;
	public static volatile SingularAttribute<Produto, String> descricao;
	public static volatile SingularAttribute<Produto, String> status;

	public static final String PRECO = "preco";
	public static final String TAMANHO = "tamanho";
	public static final String MATERIAL = "material";
	public static final String PESO = "peso";
	public static final String CATEGORIA = "categoria";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String FABRICANTE = "fabricante";
	public static final String CODIGO_PROD = "codigoProd";
	public static final String QUANTIDADE = "quantidade";
	public static final String DESCRICAO = "descricao";
	public static final String STATUS = "status";

}

