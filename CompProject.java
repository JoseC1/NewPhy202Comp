/*
	This class will store all the exercies required to fullfill the Physics 202 Comp Project
*/

import java.io.PrintWriter; //Used to Out put data
import java.io.FileNotFoundException;

public class CompProject
{

private double mass; //Mass of the object attached to the spring
private double springConst; 
private double initialPos; //amplitude of the System
private double initialVel; //Intial Velocity of the system
private int amount; //Amount of times to conduct the simulation
private final double deltaT; //DeltaTime StepSize
public static final double gravity = 9.8;
	public CompProject()
	{
		springConst =0;
		initialPos = 0;
		initialVel = 0;
		amount = 0;
		deltaT = 0.01;
		System.out.println("Building a Default Comp Project");
	}
	//Initializing Constructor
	public CompProject(double mass, double springConst, double initialPos, double initialVel, int amount)
	{
		this.mass = mass;
		this.springConst = springConst;
		this.initialPos = initialPos;
		this.initialVel = initialVel;
		this.amount = amount;
		this.deltaT = 0.01;
	}
	
	//Produces two Files containing the Position and velocity vs time using Eulers Method 
	public void exe1() throws FileNotFoundException
	{
		PrintWriter outPos = new PrintWriter("PosExe1.txt"); 
		PrintWriter outVel = new PrintWriter("VelExe1.txt");
		
		double dv = 0; 
		double yn = initialPos; //Initially it equals the Initial Position
		double vn = initialVel; //Initially it equals the Initial Velocity
		double time = 0; //x position
		try
		{
			for(int i = 0; i < amount; i++)
			{
	 			dv = (-springConst * yn) / mass; //Differential Equation that describes the accel of the System
				yn = yn + vn * deltaT; //Eulers Method Position First
				vn = vn + dv * deltaT; //Eulers Method Then Velocity 
				outPos.printf("%.2f , %.2f\n", time, yn);
				outVel.printf("%.2f , %.2f\n", time, vn);
				time += deltaT;
			}
		}
		finally
		{
			outPos.close();
			outVel.close();
		}
	}
	//Produces two Files Containing the Position and Velocity vs time using the accepted Solutions
	public void exe2() throws FileNotFoundException
	{
		PrintWriter outPos = new PrintWriter("PosExe2.txt");	
		PrintWriter outVel = new PrintWriter("VelExe2.txt");
		
		double time = 0;
		double yn = 0;
		double vn = 0;
		try
		{
			for(int i = 0; i < amount;i++)
			{
				yn = initialPos * Math.cos(Math.sqrt(springConst/mass) * time);
				vn = -Math.sqrt(springConst/mass) * initialPos * Math.sin(Math.sqrt(springConst/mass) * time);
				time += deltaT;
				outPos.printf("%.2f , %.2f\n", time, yn);
				outVel.printf("%.2f , %.2f\n", time, vn);
			}
		}
		finally
		{
			outPos.close();
			outVel.close();
		}
	}
	
	//Produces a File of the Total Energy Vs time Using Euler Method Values
	public void exe3() throws FileNotFoundException
	{
		PrintWriter outEnergy = new PrintWriter("EnergyExe3.txt");

		double time = 0;
		double yn = initialPos;
		double vn = initialVel;
		double dv = 0;
		double energy = 0;
		try
		{
			for(int i = 0; i < amount;i++)
			{
				//Energy = 1/2 mv^2 + mgyn
				energy = 1/2 * mass * vn * vn + mass * gravity * yn;
			
				//Eulers Method Stuff
				dv = (-springConst * yn) / mass; //Differential Equation that describes the accel of the System
				yn = yn + vn * deltaT; //Eulers Method Position First
				vn = vn + dv * deltaT; //Eulers Method Then Velocity 
				time += deltaT;
				outEnergy.printf("%.2f , %.2f\n", time, energy);
			}
		}
		finally
		{
			outEnergy.close();
		}
	}
	//Produces two txt files Pos and Velocity vs time Using Euler Cromer 
	public void exe4() throws FileNotFoundException
	{
		PrintWriter outPos = new PrintWriter("PosExe4.txt"); 
		PrintWriter outVel = new PrintWriter("VelExe4.txt");
		
		double dv = 0; 
		double yn = initialPos; //Initially it equals the Initial Position
		double vn = initialVel; //Initially it equals the Initial Velocity
		double time = 0; //x position
		try
		{
			for(int i = 0; i < amount; i++)
			{
	 			dv = (-springConst * yn) / mass; //Differential Equation that describes the accel of the System
				vn = vn + dv * deltaT; //Eulers Cromer Method Velocity First 
				yn = yn + vn * deltaT; //Eulers Cromer Method Then Position
				outPos.printf("%.2f , %.2f\n", time, yn);
				outVel.printf("%.2f , %.2f\n", time, vn);
				time += deltaT;
			}
		}
		finally
		{
			outPos.close();
			outVel.close();
		}
	}
	//Produces a txt file of Energy Vs time graph using Euler Cromer Method
	public void exe5() throws FileNotFoundException
	{
		PrintWriter outEnergy = new PrintWriter("EnergyExe5.txt");
		double time = 0;
		double yn = initialPos;
		double vn = initialVel;
		double dv = 0;
		double energy = 0;
		try
		{
			for(int i = 0; i < amount;i++)
			{
				//Energy = 1/2 mv^2 + mgyn
				energy = 1/2 * mass * vn * vn + mass * gravity * yn;
			
				//Eulers Cromer Method Stuff
				dv = (-springConst * yn) / mass; //Differential Equation that describes the accel of the System
				vn = vn + dv * deltaT; //Eulers Cromer Method First Velocity 
				yn = yn + vn * deltaT; //Eulers Cromer Method Then Position
				time += deltaT;
				outEnergy.printf("%.2f , %.2f\n", time, energy);
			}
		}
		finally
		{
			outEnergy.close();
		}
	}

}
