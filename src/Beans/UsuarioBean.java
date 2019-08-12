package Beans;

public class UsuarioBean {
	
	private String CPF;
	private String senha;
	
	public String getCPF(){
		return this.CPF;
	}
	
	public void setCPF(String CPF){
		this.CPF = CPF;
	}
	
	public String getSenha(){
		return this.senha;
	}
	
	public void setSenha(String senha){
		this.senha = senha;
	}
}
