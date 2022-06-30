package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Randevular.KAYITLAR;

public class kay�t  {
	public void mson()
	{
		// Saat 18:00 da kay�t yapmaya �al���n�l�rsa kay�t yapmaz ve tablolar temizlenir...	
		try {
		String connUrl= "jdbc:sqlserver://localhost:1433;databaseName=Hastane;integratedSecurity=true;";
		Connection conn = DriverManager.getConnection(connUrl);
		 PreparedStatement pst3 = conn.prepareStatement("DELETE FROM KAYITLAR");
         PreparedStatement pst5 = conn.prepareStatement("UPDATE DoktorRandevu SET Dolu= 0");
         pst3.execute();
         pst5.execute();
		
	} catch (SQLException e) {
		System.out.print("Hata");
	}
	}
    public void inster2(KAYITLAR ky) {
        
		
        
        try {
        String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=Hastane;integratedSecurity=true;";
       	 Connection conn = DriverManager.getConnection(connUrl);
        	Statement stmt = conn.createStatement();
        
        	// Burada veritaban�na kay�t yap�l�yor  
        	// ve DoktorID'sine g�re doktorlar�n update edilip randevular� dolu g�steriliyor...
        	
    		   //Dolu update
        	  PreparedStatement pst5 = conn.prepareStatement("UPDATE DoktorRandevu SET Dolu= 1 WHERE DoktorID="+Integer.toString(ky.getDoktorID())+"");
		    	///KAYIT	   	         
	          PreparedStatement pst2 = conn.prepareStatement("INSERT INTO KAYITLAR VALUES (?,?,?,?,?,?)");
		    		    	  			
	            pst2.setString(1, ky.getTCno());
	            pst2.setString(2, ky.getHastaAd());
	            pst2.setInt(3, ky.getDoktorID());
	            pst2.setInt(4, ky.getRsaat());
	            pst2.setString(5, ky.getTel());
	            pst5.execute();
	          
	          
	       ////Her b�l�m�n doktoru ayr�d�r ve doktora g�re b�l�m belirlenir.
	       if (ky.getDoktorID() == 1 || ky.getDoktorID() == 2  ) {
	          pst2.setString(6,"Aile");
	        }
	        else if (ky.getDoktorID() == 3 || ky.getDoktorID() == 4  ) {
	          pst2.setString(6,"Cocuk");
	        }
	        else {
	          pst2.setString(6,"Dermatoloji");
	        }
	       
	         /// Ad�  a��klma sayfas� i�in �ekip y�nlendiriyoruz...
	          ResultSet rs2 = stmt.executeQuery("SELECT Ad FROM DoktorRandevu WHERE DoktorID = "+Integer.toString(ky.getDoktorID())+"");
	
	          rs2.next();
	          String dks2 = rs2.getString("Ad");
	          System.out.println ("Ad:" + dks2 );
	          pst2.execute();
	 
	   
	          ky.setDoktorAD(dks2);
          
            System.out.println("Kay�t ba�ar�l�.");
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
    }
	public void Dol(KAYITLAR ky)
	 {

	     try {
	    	//Dolu bo� i�in Select komutu ile ilgili sat�r� �ekip kontrol ediyoruz...
	     String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=Hastane;integratedSecurity=true;";
	     Connection conn = DriverManager.getConnection(connUrl);
	     Statement stmt = conn.createStatement();
	     ResultSet rs = stmt.executeQuery("SELECT Dolu FROM DoktorRandevu WHERE DoktorID = "+Integer.toString(ky.getDoktorID())+"");
	        rs.next(); 
	        ky.setDolu( rs.getInt ("Dolu"));

	     }catch(SQLException e) {
	      e.printStackTrace();
	     }
	 
	 }
}
