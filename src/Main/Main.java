package Main;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import CargoTrain.*;
import Util.*;


public class Main{
	
	
	public static void main(String arg[])  {
		
		
		
		
		
		
		
//		EminTrain.toString();
//		Station istasyon=new Station();
//		
//		Queue<Cargo> cargoQueue;
//		cargoQueue=new LinkedList<>();
//		
//		EminTrain.load(cargoQueue);
//		cargoQueue.add(new Cargo(10));
//		cargoQueue.add(new Cargo(3));
//		cargoQueue.add(new Cargo(7));
//		cargoQueue.add(new Cargo(9));
//		cargoQueue.add(new Cargo(1));
//		cargoQueue.add(new Cargo(1));
//		cargoQueue.add(new Cargo(1));
//		cargoQueue.add(new Cargo(1));
//		cargoQueue.add(new Cargo(1));
//		
//		
//		EminTrain.load(cargoQueue);
//		
//		
//	System.out.println();
		
	
	}
	
 static void readAndInitialize() throws FileNotFoundException {
		
	 File input=new File("input.txt");
		
		Scanner scanner=new Scanner(input);
		
		File output = new File("output.txt");
		
		PrintStream  writer=new PrintStream(output);
		
		
		
		int trainLength= scanner.nextInt();		
		int carriageCapacity=scanner.nextInt();
		int stationNumber=scanner.nextInt();
		
		Train EminTrain=new Train(trainLength,carriageCapacity);
		
		Station[] stations=new Station[stationNumber];

		for(int i=0;i<stationNumber;i++) {
			stations[i]=new Station(i);
			
		}
		
		//Cargos
		while(scanner.hasNextInt()) {
			int idOfCargo=scanner.nextInt();
			int initialStation=scanner.nextInt();
			int targetStation=scanner.nextInt();
			int size=scanner.nextInt();
			stations[initialStation].addCargo(idOfCargo, stations[initialStation], size, stations[targetStation]);
			
		}
		
	}
	
static void execute() {
	
	
	
	
	
	
	
	
}
	


	
	
}