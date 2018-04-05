// program 12-11-2017


public class hdfc01 implements bank,banksupport  {

	// Will have the multiple interface by separting coma , 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		hdfc01 inter = new hdfc01();
		
		inter.credit();
		
		inter.debit();
		
		inter.transfer();
		
	}

	@Override
	public  void credit() {
		// TODO Auto-generated method stub
		System.out.println("Creidt the amount");
	}

	@Override
	public void debit() {
		// TODO Auto-generated method stub
		System.out.println("Debit the amount");
	}

	@Override
	public void transfer() {
		// TODO Auto-generated method stub
		System.out.println("Transfer the amount");
	}

	@Override
	public void support() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calls() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickets() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void issues() {
		// TODO Auto-generated method stub
		
	}

}
