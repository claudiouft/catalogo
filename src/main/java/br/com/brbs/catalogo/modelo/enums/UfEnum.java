package br.com.brbs.catalogo.modelo.enums;

public enum UfEnum {

	ACRE(1,"ACRE","AC"),
	ALAGOAS(2,"ALAGOAS","AL"),
	AMAZONAS(3,"AMAZONAS","AM"),
	AMAPA(4,"AMAPÁ","AP"),
	BAHIA(5,"BAHIA","BA"),
	CEARA(6,"CEARÁ","CE"),
	DISTRITO_FEDERAL(7,"DISTRITO FEDERAL","DF"),
	ESPIRITO_SANTO(8,"ESPÍRITO SANTO","ES"),
	GOIAS(9,"GOIÁS","GO"),
	MARANHAO(10,"MARANHÃO","MA"),
	MINAS_GERAIS(11,"MINAS GERAIS","MG"),
	MATO_GROSSO_SUL(12,"MATO GROSSO DO SUL","MS"),
	MATO_GROSSO(13,"MATO GROSSO","MT"),
	PARA(14,"PARÁ","PA"),
	PARAIBA(15,"PARAÍBA","PB"),
	PERNAMBUCO(16,"PERNAMBUCO","PE"),
	PIAUI(17,"PIAUÍ","PI"),
	PARANA(18,"PARANÁ","PR"),
	RIO_JANEIRO(19,"RIO DE JANEIRO","RJ"),
	RIO_GRANDE_NORTE(20,"RIO GRANDE DO NORTE","RN"),
	RONDONIA(21,"RONDÔNIA","RO"),
	RORAIMA(22,"RORAIMA","RR"),
	RIO_GRANDE_SUL(23,"RIO GRANDE DO SUL","RS"),
	SANTA_CATARINA(24,"SANTA CATARINA","SC"),
	SERGIPE(25,"SERGIPE","SE"),
	SAO_PAULO(26,"SÃO PAULO","SP"),
	TOCANTINS(27,"TOCANTINS","TO");
	
	private Integer id;
	
	private String nome;
	
	private String sigla;
	
	private UfEnum(Integer id,String nome,String sigla) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}
}
