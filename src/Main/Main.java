package Main;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import CargoTrain.*;
import Util.*;


public class Main{
	
	

	
	
	
	
	
	public static void main(String arg[]) throws FileNotFoundException  {
		
		
		
		
		
		
		
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
		readAndInitialize();
	
	}
	
 static void readAndInitialize() throws FileNotFoundException {
		
	 File input=new File("input.txt");
		
		Scanner scanner=new Scanner(input);
		
		
		//moved to Train
//		File output = new File("output.txt");
//		
//		PrintStream  writer=new PrintStream(output);
		
		
		
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
			
//			System.out.print("  id"+ idOfCargo);
//			System.out.print("  id"+ initialStation);
//			System.out.print("  id"+ targetStation);
//			System.out.print("  id"+ size);
//			System.out.println();
		
			
		}
		
//		for(int i=0;i<stationNumber)
//		System.out.println(stations[2].toString());
//		
		
		execute(EminTrain,stations,stationNumber);
		
		
	}
	
static void execute(Train train,Station[] stations,int stationNumber) {
	
	for(int i=0;i<stationNumber;i++) {
//		stations[i].getLen();
		//test start
//		System.out.println(i);
//		System.out.println("gggg" + stations[i].cargoQueue);
		
//		Station
		
		//test end
		stations[i].process(train);		
//		System.out.println(i);
	}
	
	
	
	
	
	
}
	


	
	
}