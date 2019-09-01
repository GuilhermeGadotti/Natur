package Email;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class EmailSimples {

	public static void main(String[] args) {
		String meuEmail = "natur.suporte@gmail.com"; 																	//Email que receberá a mensagem
		String minhaSenha = "naturentra21";																				//Senha do email
		
		SimpleEmail email = new SimpleEmail(); 																			//Objeto 
		email.setHostName("smtp.gmail.com"); 																			//Configurando o Host, no caso o gmail
		email.setSmtpPort(465); 																						//Configurando a porta desse Host
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));											//Vai autenticar a conexão
	    email.setSSLOnConnect(true); 																					//Vai ativar a conexão de forma segura
	    
	    try {
	    	email.setFrom(meuEmail);   																					//Configura de quem é o e-mail; de onde ele está vindo
	    	email.setSubject("TESTANTO ESSA BAGAÇA"); 																	//Titulo / Assunto
	    	email.setMsg("ADO ADO ADO QUEM TA LENDO É VIADO"); 							//Conteudo do email
	    	email.addTo(meuEmail); 																						//Para onde será enviado a mensagem
	    	email.send(); 																								//Envia a mensagem
	    	System.out.println("E-mail foi enviado com sucesso!");
	    	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}		
	}
}
