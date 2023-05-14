import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class GeradoraDeFigurinhas {
		public void cria(InputStream inputStream, String nomeArquivo) throws Exception   {
			
			//leitura da imagem
			
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
			//BufferedImage imagemOriginal = ImageIO.read(new File("C:\\Users\\guilh\\OneDrive\\Área de Trabalho\\filme.jpg"));
			//*cria nova image em memoria com transparencia e tamanho novo
		
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		
			//Copiar a imagem original para nova imagem (em memoria)
			//graphics funciona como a "caneta" da iamgem, tudo que é manipulado se faz através dele
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
			//configurara a fonte
		var fonte = new Font(Font.SERIF, Font.BOLD, 73);
		graphics.setFont(fonte);
		graphics.setColor(Color.blue);
		
			//escrever frase na nova imagem
		graphics.drawString("TOPZERA", 70, novaAltura-110);
		
			//escrever a nova imagem em arquivo
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
		}
		


		
}














