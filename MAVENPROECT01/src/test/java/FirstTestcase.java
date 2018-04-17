import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class FirstTestcase {

	
	String name;
	
	String age;
	
	
	public FirstTestcase(String name, String age)
	
	
	{
		
		this.age=age;
		this.name=name;
		
	}
	
	
	@Test
	
	public void login()
	
	{
		
		System.out.println(name+"--------------------"+age);
	}
	
	
	@Parameters
	
	public static Collection<String[]> date()
	
	{
		
		String data [][]= new String [3][2];
		
		data[0][0]= "age1";
		data[0][1]= "name1";
		data[1][0]= "age2";
		data[1][1]= "name2";
		data[2][0]= "age3";
		data[2][1]= "name3";
		
		
		
		return Arrays.asList(data);
		
		
		
	}
	
	
}
