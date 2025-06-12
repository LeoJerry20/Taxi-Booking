package taxiBokingByCodingAtti;

class Booking{
	int bookingId,customerId,pickUpTime,dropTime,amount;
	char from,to;
	
	public Booking(int bookingId,int customerId,int pickUpTime,int dropTime,int amount,char from,char to) {
		this.bookingId=bookingId;
		this.customerId=customerId;
		this.pickUpTime=pickUpTime;
		this.dropTime=dropTime;
		this.amount=amount;
		this.from=from;
		this.to=to;
	}
}





























//class Booking {
//
//	int bookingId, customerId, pickupTime, dropTime, amount;
//	char from, to;
//	
//	public Booking(int bookingId,int customerId,char from, char to,int pickupTime,int dropTime,int amount) {
//		this.bookingId=bookingId;
//		this.customerId=customerId;
//		this.from=from;
//		this.to=to;
//		this.pickupTime=pickupTime;
//		this.dropTime=dropTime;
//		this.amount=amount;
//	}
//}
