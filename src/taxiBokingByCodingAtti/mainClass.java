package taxiBokingByCodingAtti;
import java.util.*;
import java.util.Scanner;
public class mainClass {
	static ArrayList<Taxi> taxis=new ArrayList<>();
	static int customerCount=1;
	static Scanner sc=new Scanner(System.in);

	public static void main(String args[]) {
		int n=4;
		intializetaxi(n);
				while(true) {
			System.out.println("---------Welcome to Leo Taxi's-----------");
			System.out.println("Press any one Number in this List");
			System.out.println("1. Book Taxi ");
			System.out.println("2. Display Details ");
			System.out.println("3. Exit");
			int choice=sc.nextInt();
			switch(choice) {
			case 1: 
			{
				bookTaxi();
				break;
			}
			case 2:
			{
				displayTaxi();
				break;
			}
			case 3:
			{
				System.out.println("Thank you");
				System.exit(0);
			}
			default :
			{
				System.out.println("Invalid Choice. Please try again.");
			}
 			}
		}
		
	}
	
	
	public static void intializetaxi(int n) {
		for(int i=1;i<=n;i++) {
		taxis.add(new Taxi(i));
		}
	}
		
	public static void bookTaxi() {
		int customerId=customerCount++;
		System.out.println("Enter PickUp Location : ");
		char pickUp=sc.next().charAt(0);
		System.out.println("Enter drop Point : ");
		char drop=sc.next().charAt(0);
		System.out.println("Enter PickUpTime : ");
		int pickUpTime=sc.nextInt();
		
		Taxi selectedTaxi=null;
		int minDistance=Integer.MAX_VALUE;
		for(Taxi taxi:taxis) {
			if(taxi.isAvailable(pickUpTime)) {
			int distance=Math.abs(taxi.currentPoint-pickUp);
			if(distance<minDistance   || (distance==minDistance && taxi.totalEarnings<selectedTaxi.totalEarnings)) {
				selectedTaxi=taxi;
				minDistance=distance;
			}
			}
		}
		if(selectedTaxi==null) {
			System.out.println("No taxis are current available. please try later.");
			return;
		}
		
		int bookingId=selectedTaxi.bookings.size()+1;
		int dropTime=pickUpTime+Math.abs(drop-pickUp);
		int amount=selectedTaxi.calculateAmount(pickUp,drop);
		
		Booking booking=new Booking(bookingId,customerId,pickUpTime,dropTime,amount,pickUp,drop);
		selectedTaxi.addBooking(booking);
		System.out.println("Your booking is conformed");
		
		}
	public static void displayTaxi() {
		for(Taxi taxi :taxis){
			System.out.println("Taxi-"+taxi.id+"  Total Earnings = Rs."+taxi.totalEarnings);
			System.out.printf("%-10s %-11s %-11s %-9s %-5s %-3s %-6s%n","BookingId","CustomerId","PickUpTime","DropTime","From","To","Amount");
			for(Booking booking:taxi.bookings) {
			System.out.printf("%-10d %-10d %-11d %-9d %-5c %-5c %-6d%n",booking.bookingId,booking.customerId,booking.pickUpTime,booking.dropTime,booking.from,booking.to,booking.amount);
			}
		}

		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	static ArrayList<Taxi> taxis=new ArrayList<>();
//	static Scanner sc=new Scanner(System.in);
//	static int customerCounter=1;
//	public static void main(String[] args) {
//		int numTaxis=4;
//		intializeTaxis(numTaxis);
//		
//		while(true) {
//			System.out.println("---------Welcome to Lathish Taxi's-----------");
//			System.out.println("Press any one Number in this List");
//			System.out.println("1. Book Taxi \n2. Display Details \n3. Exit");
//			
//			int n=sc.nextInt();
//			switch(n){
//				case 1:{
//					bookTaxi();
//					break;
//				}
//				case 2:{
//					System.out.println("------Taxi Details------");
//					displayDetails();
//					break;
//				}
//				case 3:{
//					System.out.println("Thank you /n Exiting...");
//					System.exit(0);
//				}
//				default :
//					System.out.println("Invalid choice. Try again.");			}
//		}
//	}
//	public static void intializeTaxis(int n) {
//		for(int i=1;i<=n;i++) {
//			taxis.add(new Taxi(i));
//		}
//	}
//	public static void bookTaxi() {
//		int customerId=customerCounter++;
////		System.out.println("Enter Name :");
////		String name=sc.next();
//		System.out.println("Enter pickup Location :");
//		char pickup=sc.next().charAt(0);
//		System.out.println("Enter drop Location :");
//		char drop=sc.next().charAt(0);
//		System.out.println("Enter PickUp Time :");
//		int pickupTime =sc.nextInt();
//		
//		Taxi selectedTaxi=null;
//		int minDistance=Integer.MAX_VALUE;
//		for(Taxi taxi : taxis) {
//			if(taxi.isAvailable(pickupTime)){
//				int distance=Math.abs(taxi.currentPoint - pickup);
//				 if(distance < minDistance || (distance == minDistance && taxi.totalEarnings < selectedTaxi.totalEarnings)) {
//					 selectedTaxi = taxi;
//					 minDistance = distance;
//				 }
//			}
//		}
//		if(selectedTaxi==null) {
//			System.out.println("Booking rejected. No taxis available.");
//			return;
//		}
//		
//		int dropTime =pickupTime + Math.abs(drop -pickup);
//		int amount=selectedTaxi.calculateEarnings(pickup, drop);
//		int bookingId=selectedTaxi.bookings.size()+1;
//		
//		Booking booking=new Booking(bookingId, customerId,pickup,drop,pickupTime,dropTime,amount);
//		selectedTaxi.addBooking(booking);
//		System.out.println("Taxi-" +selectedTaxi.id+" is alloted");
//		
//	}
//	public static void displayDetails() {
//		for(Taxi taxi : taxis) {
//			System.out.println("Taxi-"+taxi.id+" TotalEarnings: Rs."+taxi.totalEarnings);
//			System.out.printf("%-10s %-10s %-5s %-5s %-12s %-9s %-6s%n","BookingId","CustomerId","From","To", "PickUpTime","DropTime","Amount");
//		
//		for(Booking booking : taxi.bookings) {
//			System.out.printf("%-10d %-10d %-5c %-5c %-12d %-9d %-6d%n",booking.bookingId,booking.customerId,booking.from,booking.to, booking.pickupTime,booking.dropTime,booking.amount);
//		}
//		}
//	}
}
