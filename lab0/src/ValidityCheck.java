/**
 * 
 */
/**
 * @author jkampe96
 * @author dhogberg
 *
 */
public class ValidityCheck {

	// Kontrollerar om längden stämmer, returnerar sedan true/false
	public static boolean isCorrectLength(
			/* Sträng som ska kontrolleras: */String inputstring,
			/* Rätt längd på strängen:      */Integer correctlength
			) {
		
		// Ta fram längden på ingående strängen
		Integer inputlength = inputstring.length();
	
		// Kontrollera om längden är samma som den korrekta längden
		if(inputlength == correctlength) {
			return true;
		}else {
			return false;
		}
	}
    
	// Kontrollerar om ett personnummer är giltigt
    public static void isValidPNR(String number, Integer correctlength)   {
    	// Kontrollerar om personnumret är inskrivet korrekt
    	if (isCorrectLength(number, correctlength)) {
    	
    		// Variabel som används för att summera ihop alla uträknade siffror
    		Integer temp_int_sum = 0;
    		
    		// Loopa 10 gånger, 0..9
    		for (int i = 0; i < 10; i++) {
    			// Om jämnt tal på loopen, kör nummertransformation, annars gör ingenting
    		    if(((i + 2) % 2) == 0){
    		    	// Addera det transformerade numret till vår temporära variabel
    		    	temp_int_sum = temp_int_sum + transformNumber( number.charAt(i) );
    		    }else{
    		    	// Addera numret som det är till vår temporära variabel
    		    	temp_int_sum = temp_int_sum + number.charAt(i);
    		    }
    		}

    		// Om numret är jämnt delbart med 10 (Resten == 0) så är det giltigt, annars ej giltigt
    		if((temp_int_sum % 10) == 0){
    			System.out.println("Giltigt nummer.");
    		}else{
    			System.out.println("Ej ett giltigt nummer.");
    		}
    		
    	}else {
    		System.out.println("Fel längd!");
    	}
    	
    }

    static Integer transformNumber(Character ch_digit){
    	
    	// Multiplicera med två
		Integer temp_digit = Character.digit(ch_digit, 10) * 2;
		
		// Om tvåsiffrigt, addera ihop siffrorna, annars gör ingenting
		if(temp_digit > 9){
		    String temp_string = String.valueOf(temp_digit);
		    temp_digit = Character.digit(temp_string.charAt(0),10) + Character.digit(temp_string.charAt(1), 10);
		}
	
		// Returnera den uträknade siffran
		return temp_digit;   
    }
    
    public static void main(String[] args) {
   
    	// Ta in argument 1
	    String personNumber = args[0];
    	// Ta in argument 2 som ett nummer
	    Integer correctlength = Integer.parseInt(args[1]);
	    
	    // Kontrollera personnumret
		isValidPNR(personNumber, correctlength);
    }
}
