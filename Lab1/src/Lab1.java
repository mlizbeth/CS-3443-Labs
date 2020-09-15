
public class Lab1 {
	
	public static void main(String[] args) {
		
		
		School elem = new School( "Monroe_May_Elemn_School", 7 );
		
		Zone r = new Zone( "Cafeteria", 10 );
		Zone t = new Zone( "Playground", 2 );
		Zone b = new Zone( "Library", 20 );

		Student bl = new Student( "Lisa_Lawrence", "Pre-K", false );
		Student de = new Student( "Oliver_Qu", "K", false );
		Student ec = new Student( "Oscar_Smith", "K", false );
		Student re = new Student( "Freddie_Miller", "1st", false );
		Student lt = new Student( "Ada_Wilson", "2nd", true );
		Student sp = new Student( "Jasmine_Nadia", "3rd", true );
		Student bb = new Student( "Tanya_Henson", "4th", true );
		
		r.addStudent( bl );
		r.addStudent( de );
		r.addStudent( ec );
		t.addStudent( re );
		b.addStudent( lt );
		b.addStudent( sp );
		b.addStudent( bb );
		
		elem.addZone( r );
		elem.addZone( t );
		elem.addZone( b );
		
		System.out.println( elem );
		
	}

}
