import java. util.Queue;
import java.util.*;
import java.sql.Timestamp;
public class Final2 {
	public static Scanner scan = new Scanner(System.in);
	public static Scanner scan2 = new Scanner(System.in);
	public static List<Boat> listBoat = new ArrayList<>();
	public static List<Ride> listRide = new ArrayList<>();
	public static Queue<Boat> qBoat = new LinkedList<>();
	
	
	public static void main(String [] args){
		listBoat.add(new Boat("FL978005A","256","Vannessa","001"));
		listBoat.add(new Boat("FL978004A","500","David","002"));
		listBoat.add(new Boat("RF756442F","350","Ange","003"));
		listBoat.add(new Boat("BR466677E","400","Flannella","004"));
		listBoat.add(new Boat("RAB0062A","155","Kesselle","005"));
		listBoat.add(new Boat("RAQ0036A","255","Ulrick","006"));
		listBoat.add(new Boat("UQ0036A","220","Alain Divin","007"));
		listBoat.add(new Boat("CAQ0037A","210","Elie","008"));
		listBoat.add(new Boat("DAQ0038A","290","Marcele","008"));

		String choice;
		do{
			System.out.print("1.Boat Registration \n2.View Boats\n3.Create Waiting list\n4.View Waiting List\n5.customer information\n6.View customers\n\nChoose other option you want:");
			choice=scan.nextLine();
			
			switch(choice){
				case "1":
					registerBoat();
				break;
				case "2":
					viewBoats();
				break;
			
				case "3":
					creatWaitingList();
				break;
				case "4":
					viewWaitingList();
				break;
				case "5":
					registerRide();
				break;
				case "6":
					viewRides();
				break;
				default:
					System.out.println("Invalid choice");
				break;
				}
				
			
			}while(choice!="");
		}
		
	public static void registerBoat(){
		String plate,driver,id,cap;
		System.out.print("Enter plate number:");
		plate=scan.nextLine();
		System.out.print("Sit capacity:");
		cap=scan.nextLine();
		System.out.print("Enter driver name:");
		driver=scan.nextLine();
		System.out.print("Enter driver id:");
		id=scan.nextLine();
		listBoat.add(new Boat(plate,cap,driver,id));
		
		}
	public static void viewBoats(){
		for(Boat boat:listBoat){
			System.out.println(boat);
			}
		}
	public static void creatWaitingList(){
		String plate;
		boolean found=false;
		System.out.print("Plate number to add: ");
		plate=scan.nextLine();
		for(Boat boat:listBoat){
			if(boat.getCrPlate().equals(plate)){
				found=true;
				qBoat.offer(boat);
				}
			}
		if(!found){
			System.out.println("Boat is not on the list");
			}
		}
	public static void viewWaitingList(){
		for(Boat boat:qBoat){
			System.out.println(boat);
			}
		}
	public static void registerRide(){
		if(qBoat.isEmpty()){
			System.out.println("No driver available");
			return;
			}
		System.out.println("The next driver is:"+qBoat.peek().getCrDriver()+"\t"+qBoat.peek().getCrPlate());
		String psName,psId,psDestination;
		float price;
		System.out.print("Passenger name:");
		psName=scan.nextLine();
		System.out.print("Passenger id:");
		psId=scan.nextLine();
		System.out.print("Passenger destination:");
		psDestination=scan.nextLine();
		System.out.print("Ride price:");
		price=scan2.nextFloat();
		Boat topBoat=qBoat.peek();
		listRide.add(new Ride(topBoat,psName,psId,psDestination,price,price*2/100,new Timestamp(System.currentTimeMillis())));
		qBoat.remove();
		}
	public static void viewRides(){
		for(Ride rd:listRide){
			System.out.println(rd);
			}
		}
	
		
	}
class Boat{
	String crPlate;
	String crSitSize;
	String crDriver;
	String crDriverId;
	//Constructor
	Boat(String crPlate, String crSitSize,String crDriver,String crDriverId){
		this.crPlate=crPlate;
		this.crSitSize=crSitSize;
		this.crDriver=crDriver;
		this.crDriverId=crDriverId;
		}
	public String getCrPlate(){
		return this.crPlate;
		}
	public String getcrSitSize(){
		return this.crSitSize;
		}
	public String getCrDriver(){
		return this.crDriver;
		}
	public String getCrDriverId(){
		return this.crDriverId;
		}
	public String toString(){
		return this.crPlate+"\t"+this.crSitSize+"\t"+this.crDriver+"\t"+this.crDriverId;
		}
	}
class Ride{
	Boat boat;
	String psName;
	String psId;
	String psDestination;
	float rdPrice;
	float com;
	Timestamp time;
	
	Ride(Boat boat, String psName,String psId, String psDestination,float rdPrice,float com, Timestamp time){
		this.boat = boat;
		this.psName=psName;
		this.psId=psId;
		this.rdPrice=rdPrice;
		this.com=com;
		this.psDestination=psDestination;
		this.time=time;

		}
	public String toString(){
		return this.boat+"\t"+this.psName+"\t"+this.psId+"\t"+this.psDestination+"\t"+this.rdPrice+"\t"+this.com+"\t"+this.time;
		}
	
	}


