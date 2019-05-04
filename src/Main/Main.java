package Main;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import CargoTrain.*;
import Util.*;


public class Main{
	
	

	
	
	
	
	
	public static void main(String arg[]) throws FileNotFoundException  {
		
		readAndInitialize();
	
	}
	
 static void readAndInitialize() throws FileNotFoundException {
		
	 File input=new File("input.txt");
		
		Scanner scanner=new Scanner(input);
		
		
		//moved to Train
		File output = new File("output.txt");
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
		

		
		execute(EminTrain,stations,stationNumber);
		
		
	}
	
static void execute(Train train,Station[] stations,int stationNumber) {
	
	for(int i=0;i<stationNumber;i++) {

		stations[i].process(train);		

	}
	
	
	
	
	
	
}
	


	
	
}