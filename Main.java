/*
	Physics 202 Comp Project
*/

public class Main
{
	public static void main(String[] args)
	{
		
		double mass = 25;
		double springConst = 200;
		double initialPos = 5;
		double initialVel = 0;
		int amount = 1000;
		CompProject phy = new CompProject(mass, springConst, initialPos, initialVel, amount);
		
		try
		{
			phy.exe1();
			phy.exe2();
			phy.exe3();
			phy.exe4();
			phy.exe5();
		}	
		catch(Exception e)
		{
			System.out.println("Error: " + e);
		}
		System.out.println("DONE");
	}
}


