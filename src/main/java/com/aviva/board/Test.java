package com.aviva.board;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



public class Test {

	public static void main(String[] args) {

		String password = "123456"; 
		//$2a$10$Z55YQ9pNVpAoObfYCBk/fOB3ZipjB7RnFf3Cbta3FQ8ab6JVtelUO
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
	    String encodedPassword = passwordEncoder.encode(password);  
	    System.out.print(encodedPassword);		
		
		
		
//		// TODO Auto-generated method stub
//     for(int i=0;i<=10;i++) {
//    	 
//    	 System.out.println("i="+i);
//    	 System.out.println("i%5="+i%5);
//    	 if(i%5==4)
//    	 { i*=3;
//    	 i--;    
//    	 }
//    	  System.out.println(i);	 
//     }
//     
//   
//	
//	
	}

}
