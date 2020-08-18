package util;

import java.text.SimpleDateFormat;
import java.util.Random;
import DAO.purcahse_listDAO;

public class consoleUtil {
	purcahse_listDAO listDAO = new purcahse_listDAO();
	 public String barcode() {
	      Random rd = new Random();
	      String barcode = null;
	      for(int i=0; i<6; i++) {
	         int a = rd.nextInt(10)+1;
	         barcode = "" +a;
	      }
	      if(duplicate(barcode)) {
	         return barcode;
	      }
	      return barcode();
	   }
	 public boolean duplicate(String barcode) {
	      int dic = 
	    		  listDAO.getBarcode(barcode);
	      if(dic==1) {
	         return true;
	      }
	      else {
	         return false;
	      }
	   }
	 public String time() {
	      SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
	       SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");

	       return ""+date+time;
	   }
}
