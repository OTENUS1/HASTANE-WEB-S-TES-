package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.kay�t;

import Randevular.KAYITLAR;



/**
 * Servlet implementation class SevrletHastane
 */
@WebServlet("/SevrletHastane")
public class SevrletHastane extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SevrletHastane() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		kay�t k�t = new kay�t();
		KAYITLAR ky = new KAYITLAR(request);	 
		/// �uan�n saatini al�p Paydos saati ile kar��la�t�r�yoruz ve ona g�re i�lem yapt�r�yoruz...
		String pattern2 = "kk";
		SimpleDateFormat simpleDate2Format = new SimpleDateFormat(pattern2);
		String saat = simpleDate2Format.format(new Date());
      
		   k�t.Dol(ky);
	       int dks = ky.getDolu();
	       System.out.println ("Dolu:" + dks );		    		 
		      if(ky.getPaydos() > Integer.parseInt(saat)) {
		    	 
		    	  ///Ba�ka sayfaya y�nlendirip duruma g�re a��klamas� yap�l�yor...
		    	  //Dolu:1 Bo�:0
		    	  if (dks == 1) {	
		 		     response.setContentType("text/html");
		 		    PrintWriter out = response.getWriter();
		 		    out.write("<html>"
		 		    + "<head><meta charset=\"UTF-8\"><title>Exception/Error Details</title>"
		 		    + "</head>"
		 		    + "<body>"+"<center><h1>Se�iginiz Doktor suanda Musait Degildir "
		 		    + "Daha sonra tekrar deneyiniz veya Baska Doktor se�iniz.<h1></center>"+
		 		    "</body></html>");	    	    	     
		 		}
		    	  else 
		  		{  	    	 
		    	  k�t.inster2(ky);
		    	  String dks2 =ky.getDoktorAD();
	 
		///Ba�ka sayfaya y�nlendirip duruma g�re a��klamas� yap�l�yor...
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.write("<html>"
		 + "<head><meta charset=\"UTF-8\"><title>Randevu Formu</title>"
		 + "</head>"+ "<body>"+"<center><h1>Tc NO: "+ky.getTCno()+"</h1><br><h1>Ad ve Soyad: "+ky.getHastaAd()
		 + "</h1><br><h1>Doktor: "+ dks2 +"</h1><br><h1>Randevu Saati: "+ ky.getRsaat2()+"</h1></center>"+"</body></html>");   		            	 	    		            	 
		 System.out.print("Kay�t Ba�ar�l�");
			    		   	     
		}
		}
		else
        {		    
		k�t.mson();
        response.setContentType("text/html");
        //E�er saat 18:00 ge�ti ise sisteme kay�t yap�lamaz ve sistemdeki KAYITLAR tablasu temizlenir ve Dolular bo�a ALINIR..
        
        PrintWriter out = response.getWriter();
        out.write("<html>"
        + "<head><meta charset=\\\"UTF-8\\\"><title>Randevu Formu</title>"
        + "</head>"+ "<body>"+"<center><h1>Saatin 18:00'i ge�ince Kayit edilemez... "
        + "Daha sonra tekrar deneyiniz.<h1></center>"+"</body></html>");
        System.out.print("Bu saate sisteme kayit Yapilamaz");
	    		   	          
}
				    	    	  
		
				            
		} 
		 
			}


