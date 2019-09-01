package Beans;

public class PreTriagemTableBean {

	private int id_Fornecedor;
	private String nome_Fornecedor;
	private int id_material;
	private String material;
	private double preco_Kg;
	private double PesoMaterial;
	private double valor_total;

	
	public int getId_material() {
		return id_material;
	}

	public void setId_material(int id_material) {
		this.id_material = id_material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getId_Fornecedor() {
		return id_Fornecedor;
	}

	public void setId_Fornecedor(int id_Fornecedor) {
		this.id_Fornecedor = id_Fornecedor;
	}	
	public String getNome_Fornecedor() {
		return nome_Fornecedor;
	}

	public void setNome_Fornecedor(String nome_Fornecedor) {
		this.nome_Fornecedor = nome_Fornecedor;
	}

	public double getPreco_Kg() {
		return preco_Kg;
	}

	public void setPreco_Kg(double preco_Kg) {
		this.preco_Kg = preco_Kg;
	}

	public double getPesoMaterial() {
		return PesoMaterial;
	}

	public void setPesoMaterial(double pesoMaterial) {
		PesoMaterial = pesoMaterial;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
}
