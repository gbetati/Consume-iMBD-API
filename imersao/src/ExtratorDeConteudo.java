import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudo {

	public List<Conteudo> extraiConteudos(String json) {
	
		
	//extrair só os dados que interessam	

	var parser = new JsonParser();
	List<Map<String, String>> listaDeAtributos = parser.parse(json);
	
	List<Conteudo> conteudos = new ArrayList <Conteudo>();

    //popular a lista de conteudoS
    
    for (Map<String, String> atributos : listaDeAtributos) {
	    String titulo = atributos.get("title");
    	String urlImagem = atributos.get("image");

 	    var conteudo = new Conteudo(titulo, urlImagem);
 	      
 	    conteudos.add(conteudo);
	}
    return conteudos;
	}
}	

