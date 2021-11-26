package senac.uc1.cliente;

public class PessoaJuridica extends Cliente {
	private String cnpj;

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	@Override
        public String toString(){
            return "CNPJ: " + cnpj;
        }
	
}
