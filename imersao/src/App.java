import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
	
	public static void main(String[] args) throws Exception {

	//fazer uma conexão HTTP e buscar os filmes
		
	String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
	ExtratorDeConteudo extrator = new ExtratorDeConteudo();
	
	var http = new ClientHttp();
	String json = http.buscaDados(url);
	
	
    //exibir e manipular os dados
   
	List<Conteudo> conteudos = extrator.extraiConteudos(json);
		
    var geradora = new GeradoraDeFigurinhas();

    for (int i = 0; i<7 ; i++) {
    	
    	Conteudo conteudo = conteudos.get(i);
    	
    	InputStream inputStream = new URL (conteudo.getUrlImagem()).openStream();
    	String nomeArquivo = conteudo.getTitulo() + ".png";
    	var nomeArquivoNovo = nomeArquivo.replaceAll(":", "-");
       	
    	geradora.cria(inputStream, nomeArquivoNovo);
    	
    	System.out.println(conteudo.getTitulo());
    	System.out.println();
    }    
 }
}

 



















