package Main;

import java.io.*;
import java.util.Scanner;

import CargoTrain.*;
import Util.*;


public class Main{
	
	
	
	public static void main(String args[]) throws FileNotFoundException  {

	String	inputFile = args[0];
	String	outputFile=	args[1];
		
		

		
		
		readAndInitialize(inputFile,outputFile);
		
		
		
		
		
		
	
	}
	
 static void readAndInitialize(String inputFile,String outputFile) throws FileNotFoundException  {
		
	 
	 File input=new File(inputFile);
		
		Scanner scanner=new Scanner(input);
		
		File output = new File(outputFile);
//		
		PrintStream  writer=new PrintStream(output);
		
		
		
		int trainLength= scanner.nextInt();		
		int carriageCapacity=scanner.nextInt();
		int stationNumber=scanner.nextInt();
		
		Train EminTrain=new Train(trainLength,carriageCapacity);
		
		Station[] stations=new Station[stationNumber];

		for(int i=0;i<stationNumber;i++) {
			stations[i]=new Station(i,writer);
			
		}
		
		//Cargos
		while(scanner.hasNextInt()) {
			int idOfCargo=scanner.nextInt();
			int initialStation=scanner.nextInt();
			int targetStation=scanner.nextInt();
			int size=scanner.nextInt();
			stations[initialStation].addCargo(idOfCargo, stations[initialStation], size, stations[targetStation]);
			

			
		}
		
		scanner.close();
		
		execute(EminTrain,stations,stationNumber);
		
		
	}
	
static void execute(Train train,Station[] stations,int stationNumber) {
	
	for(int i=0;i<stationNumber;i++) {

		stations[i].process(train);		

	}
	
	
	
	
	
	
}
	


	
	
}