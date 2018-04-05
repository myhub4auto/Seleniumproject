// program 12-11-2017


public class citi02 implements bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		citi02 face = new citi02();
		
		face.online();
		
		face.credit();
		
		face.debit();
		
		face.transfer();
		
		hdfc01 facee = new hdfc01();
		
		facee.credit();
		
		facee.debit();
		
	}

	@Override
	public void credit() {
		// TODO Auto-generated method stub
		
		System.out.println("Creidt the amount in other acc");
	}

	@Override
	public void debit() {
		// TODO Auto-generated method stub
		
		System.out.println("Debit the amount in the other acc");
	}

	@Override
	public void transfer() {
		// TODO Auto-generated method stub
		
		System.out.println("Transfer the amount in other acc");
	}

	
	  public void online()
	  {
		  
		  System.out.println("online babking");
	  }
}
