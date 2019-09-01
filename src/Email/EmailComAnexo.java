package Email;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class EmailComAnexo {
	
	public static void main(String[] args) {
		
		//Enviando E-mail com anexo
		
		String meuEmail = "natur.suporte@gmail.com"; 																							 //Email que receberá a mensagem
		String minhaSenha = "naturentra21";																												 //Senha do email
		
		MultiPartEmail email = new MultiPartEmail(); 																									//Objeto 
		email.setHostName("smtp.gmail.com"); 																											  //Configurando o Host, no caso o gmail
		email.setSmtpPort(465); 																																		 //Configurando a porta desse Host
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));											 //Vai autenticar a conexão
	    email.setSSLOnConnect(true); 																															//Vai ativar a conexão de forma segura
	    
	    try {
	    	email.setFrom(meuEmail);   																																//Configura de quem é o e-mail; de onde ele está vindo
	    	email.setSubject("E-mail com anexo"); 																											//Titulo / Assunto
	    	email.setMsg("Enviando email com anexo, segue os anexos abaixo......");													 //Conteudo do email
	    	email.addTo(meuEmail); 																																	//Para onde será enviado a mensagem
	    	
	    	EmailAttachment anexo = new EmailAttachment();																				       //Objeto que envia arquivos em anexo
	    	anexo.setPath("C:/Users/Igor Assis/Pictures/Imagens/foto p linkedin.jpg");																							//Adiciona o caminho dos arquivos
	    	anexo.setName("Minha foto.jpg");																													//Adiciona o nome do arquivo e seu formato
	    	email.attach(anexo);																																				//attach (anexar) passa o objeto criado para o obj e-mail
	    	
	    	email.send(); 																																							//Envia a mensagem
	    	System.out.println("E-mail foi enviado com sucesso!");
	    	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

}
