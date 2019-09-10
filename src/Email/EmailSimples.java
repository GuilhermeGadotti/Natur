package Email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

public class EmailSimples {

	public static boolean validarEmail(String Email) {

		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

		boolean emailStatus = false;
		Matcher matcher = pattern.matcher(Email);

		if (matcher.matches()) {
			emailStatus = true;
		} else {
			emailStatus = false;
		}
		return emailStatus;

	}

	public static boolean RecuperarConta(int chave, String Email) {

		String meuEmail = "natur.suporte@gmail.com"; // Email que receberá a mensagem
		String minhaSenha = ""; // Senha do email

		boolean operação = false;
		/*
		 * String meuEmail = "igorsemphoski@gmail.com"; // Email que receberá a mensagem
		 * String minhaSenha = "IgoR22554613"; // Senha do email
		 */
		SimpleEmail email = new SimpleEmail(); // Objeto
		email.setHostName("smtp.gmail.com"); // Configurando o Host, no caso o gmail
		email.setSmtpPort(465); // Configurando a porta desse Host
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha)); // Vai autenticar a conexão
		email.setSSLOnConnect(true); // Vai ativar a conexão de forma segura

		try {
			email.setFrom(meuEmail); // Configura de quem é o e-mail; de onde ele está vindo
			email.setSubject("Recuperação de conta."); // Titulo / Assunto
			email.setMsg("Insira o seguinte codigo para modificar sua senha: " + chave); // Conteudo do email
			email.addTo(Email); // Para onde será enviado a mensagem
			email.send(); // Envia a mensagem
			System.out.println("E-mail foi enviado com sucesso!");
			operação = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			operação = false;
		}
		return operação;
	}
}
