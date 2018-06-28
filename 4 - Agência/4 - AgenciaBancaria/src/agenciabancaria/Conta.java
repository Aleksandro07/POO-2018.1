package agenciabancaria;

public class Conta {

	private float saldo;
	private int numero;
	private Repositorio<Operacao> extrato;
	private boolean ativa;
	static int cont;

	public Conta(int numero){
		this.numero  = numero;
		this.saldo   = saldo + saldo;
		this.extrato = new Repositorio<Operacao>("Operacação");
		this.ativa   = true;
	}

	public boolean depositar(float valor){

		if(ativa) {

			if(valor <= 0)
				throw new RuntimeException("Fail: valor invalido");

			this.extrato.add("" + cont, new Operacao("Deposito ", valor));
			this.saldo = saldo + valor;
			cont++;
			return true;
		}

		throw new RuntimeException("Fail: conta inativa");
	}

	public boolean sacar(float valor){

		if(valor <= 0){
			throw new RuntimeException("Fail: alor negativo");
		}

		if(valor > saldo){
			throw new RuntimeException("Fail: tentativa de saque maior do que o saldo!");
		}

		this.saldo = saldo - valor;
		this.extrato.add("" + cont,new Operacao("Saque ", valor));
		cont++;
		return true;
	}

	public boolean transferir(Conta other, float valor){
		if(!other.isAtiva()){
			throw new RuntimeException("Fail: conta destino está inativa");
		}

		if(this.sacar(valor)){
			other.depositar(valor);
			cont++;
			return true;
		}

		return false;
	}

	public void encerrar(){
		
		if(saldo > 0)
			throw new RuntimeException("Fail: conta " + getNumero() + " possui saldo ainda");
		
		if(this.ativa == false)
			throw new RuntimeException("Fail: conta " + getNumero() + " ja encerrada");
		
		this.ativa = false;
		cont --;
	}

	public float getSaldo() {
		return saldo;
	}

	public float setSaldo(float saldo) {
		return this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public Repositorio<Operacao> getExtrato() {
		return extrato;
	}

	public boolean isAtiva() {
		return ativa;
	}
}
