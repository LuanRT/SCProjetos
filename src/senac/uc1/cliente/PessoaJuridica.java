package senac.uc1.cliente;

public class PessoaJuridica extends Cliente {
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	@Override
        public String toString(){
            return super.toString() + "\nPessoaJuridica" + "CNPJ: " + cnpj;
        }
	
}
