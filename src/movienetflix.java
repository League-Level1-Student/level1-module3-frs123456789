
public class movienetflix {

	
public static void main(String[] args) {
	Movie mov1 = new Movie("mov1" , 2);
	Movie mov2 = new Movie("mov2" , 5);
	Movie mov3 = new Movie("mov3" , 6);
	Movie mov4 = new Movie("mov4" , 1);
	Movie mov5 = new Movie("mov5", 4);
	NetflixQueue nq = new NetflixQueue();
	
	
	
	mov1.getTicketPrice();
nq.addMovie(mov1);
nq.addMovie(mov5);
nq.addMovie(mov4);
nq.addMovie(mov3);
nq.addMovie(mov2);
	
System.out.println(mov1.toString());
System.out.println(mov2.toString());
System.out.println(mov3.toString());
System.out.println(mov4.toString());
System.out.println(mov5.toString());

System.out.println("And the best movie is " + nq.getBestMovie());
System.out.println("And the second best movie is mov2 - 5 stars;");
}
}
