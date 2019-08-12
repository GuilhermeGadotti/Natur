package Beans;

public class PreTriagemBean {

	private int id_PreTriagem;
	private int id_Fornecedor;
	private int id_PrecoMaterial;
	private String material;
	private double PesoMaterial;

	public int getId_PreTriagem() {
		return id_PreTriagem;
	}

	public void setId_PreTriagem(int id_PreTriagem) {
		this.id_PreTriagem = id_PreTriagem;
	}

	public int getId_Fornecedor() {
		return id_Fornecedor;
	}

	public void setId_Fornecedor(int id_Fornecedor) {
		this.id_Fornecedor = id_Fornecedor;
	}

	public int getId_PrecoMaterial() {
		return id_PrecoMaterial;
	}

	public void setId_PrecoMaterial(int id_PrecoMaterial) {
		this.id_PrecoMaterial = id_PrecoMaterial;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getPesoMaterial() {
		return PesoMaterial;
	}

	public void setPesoMaterial(double pesoMaterial) {
		PesoMaterial = pesoMaterial;
	}

}
