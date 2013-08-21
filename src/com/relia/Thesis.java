package com.relia;

import java.util.ArrayList;

import com.relia.discovery.PathDiscovery;
import com.relia.network.Component;
import com.relia.network.Constants;

/**
 * This is an example file to demonstrate how the network is built in the Java
 * context. First components are instantiated, then links are created between
 * them according to a reference topology. Every link is bidirectional.
 * 
 * @author Rafael Rezende
 * 
 */
public class Thesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Devices
		Component t1 = new Component("t1", Constants.F_COMP, Constants.R_COMP,1366043100);
		Component t2 = new Component("t2", Constants.F_COMP, Constants.R_COMP,1366024200);
		Component t3 = new Component("t3", Constants.F_COMP, Constants.R_COMP,1368788400);
		Component t4 = new Component("t4", Constants.F_COMP, Constants.R_COMP,1368896400);
		Component t5 = new Component("t5", Constants.F_COMP, Constants.R_COMP,1366013700);
		Component t6 = new Component("t6", Constants.F_COMP, Constants.R_COMP,1366459200);
		Component t7 = new Component("t7", Constants.F_COMP, Constants.R_COMP,1366545600);
		Component t8 = new Component("t8", Constants.F_COMP, Constants.R_COMP,1367778000);
		Component t9 = new Component("t9", Constants.F_COMP, Constants.R_COMP,1369040400);
		Component t10 = new Component("t10", Constants.F_COMP, Constants.R_COMP,1366016400);
		Component t11 = new Component("t11", Constants.F_COMP, Constants.R_COMP,1366026600);
		Component t12 = new Component("t12", Constants.F_COMP, Constants.R_COMP,1366026600);
		Component t13 = new Component("t13", Constants.F_COMP, Constants.R_COMP,1367073300);
		Component t14 = new Component("t14", Constants.F_COMP, Constants.R_COMP,1367073900);
		Component t15 = new Component("t15", Constants.F_COMP, Constants.R_COMP,1367247600);
		Component e1 = new Component("e1", Constants.F_HP2650, Constants.R_HP2650,1366038000);
		Component e2 = new Component("e2", Constants.F_HP2650, Constants.R_HP2650,1366013700);
		Component e3 = new Component("e3", Constants.F_HP2650, Constants.R_HP2650,1366016400);
		Component e4 = new Component("e4", Constants.F_HP2650, Constants.R_HP2650,1367073300);
		Component d1 = new Component("d1", Constants.F_C3750, Constants.R_C3750,1366038000);
		Component d2 = new Component("d2", Constants.F_C3750, Constants.R_C3750,1346511000);
		Component d3 = new Component("d3", Constants.F_C2960, Constants.R_C2960,1366027200);
		Component d4 = new Component("d4", Constants.F_C2960, Constants.R_C2960,1346511000);
		Component c1 = new Component("c1", Constants.F_C6500, Constants.R_C6500,1346511000);
		Component c2 = new Component("c2", Constants.F_C6500, Constants.R_C6500,1346511000);
		Component p1 = new Component("p1", Constants.F_PRINTER, Constants.R_PRINTER,1366027200);
		Component p2 = new Component("p2", Constants.F_PRINTER, Constants.R_PRINTER,1366099200);
		Component p3 = new Component("p3", Constants.F_PRINTER, Constants.R_PRINTER,1368361800);
		Component backup = new Component("backup", Constants.F_SERVER, Constants.R_SERVER,1368446400);
		Component db = new Component("db", Constants.F_SERVER, Constants.R_SERVER,1365850800);
		Component dns2 = new Component("dns2", Constants.F_SERVER, Constants.R_SERVER,1366027200);
		Component auth = new Component("auth", Constants.F_SERVER, Constants.R_SERVER,1366108200);
		Component email = new Component("email", Constants.F_SERVER, Constants.R_SERVER,1366050000);
		Component dns1 = new Component("dns1", Constants.F_SERVER, Constants.R_SERVER,1355572800);

		
		// Links
		Component e1_t1 = new Component("e1_t1", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component e1_t2 = new Component("e1_t2", Constants.F_WIRELESS, Constants.R_WIRELESS, 0);
		Component e1_t3 = new Component("e1_t3", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component e1_t4 = new Component("e1_t4", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component e2_t5 = new Component("e2_t5", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component e2_t6 = new Component("e2_t6", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component e2_t7 = new Component("e2_t7", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component e2_t8 = new Component("e2_t8", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component e3_t10 = new Component("e3_t10", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component e3_t11 = new Component("e3_t11", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component e3_t12 = new Component("e3_t12", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component e3_p2 = new Component("e3_p2", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component e4_t13 = new Component("e4_t13", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component e4_t14 = new Component("e4_t14", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component e4_t15 = new Component("e4_t15", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component e4_p3 = new Component("e4_p3", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component d1_e1 = new Component("d1_e1", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component d1_e2 = new Component("d1_e2", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component d1_t9 = new Component("d1_t9", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component d2_p1 = new Component("d2_p1", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component d2_e3 = new Component("d2_e3", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component d2_e4 = new Component("d2_e4", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component d3_auth = new Component("d3_auth", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component d3_dns2 = new Component("d3_dns2", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component d3_email = new Component("d3_email", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component d4_backup = new Component("d4_backup", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component d4_db = new Component("d4_db", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component d4_dns1 = new Component("d4_dns1", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component c1_d1 = new Component("c1_d1", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component c1_d2 = new Component("c1_d2", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component c1_d3 = new Component("c1_d3", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component c1_d4 = new Component("c1_d4", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component c2_d1 = new Component("c2_d1", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component c2_d2 = new Component("c2_d2", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component c2_d3 = new Component("c2_d3", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component c2_d4 = new Component("c2_d4", Constants.F_WIRE, Constants.R_WIRE, 0);
		Component c1_c2 = new Component("c1_c2", Constants.F_WIRE, Constants.R_WIRE, 0);
		
		// Direct connection between devices
//		e1.connect(t1);
//		e1.connect(t2);
//		e1.connect(t3);
//		e1.connect(t4);
//		
//		e2.connect(t5);
//		e2.connect(t6);
//		e2.connect(t7);
//		e2.connect(t8);
//		
//		e3.connect(t10);
//		e3.connect(t11);
//		e3.connect(t12);
//		e3.connect(p2);
//		
//		e4.connect(t13);
//		e4.connect(t14);
//		e4.connect(t15);
//		e4.connect(p3);
//		
//		d1.connect(e1);
//		d1.connect(e2);
//		d1.connect(t9);
//		
//		d2.connect(p1);
//		d2.connect(e3);
//		d2.connect(e4);
//		
//		d3.connect(db);
//		d3.connect(backup);
//		d3.connect(email);
//		
//		d4.connect(file1);
//		d4.connect(file2);
//		d4.connect(printS);
//		
//		c1.connect(d1);
//		c1.connect(d2);
//		c1.connect(d3);
//		c1.connect(d4);
//		
//		c2.connect(d1);
//		c2.connect(d2);
//		c2.connect(d3);
//		c2.connect(d4);
//		
//		c1.connect(c2);
		
		// Connection using links
		e1_t1.connect(e1);
		e1_t1.connect(t1);
		e1_t2.connect(e1);
		e1_t2.connect(t2);
		e1_t3.connect(e1);
		e1_t3.connect(t3);
		e1_t4.connect(e1);
		e1_t4.connect(t4);
		e2_t5.connect(e2);
		e2_t5.connect(t5);
		e2_t6.connect(e2);
		e2_t6.connect(t6);
		e2_t7.connect(e2);
		e2_t7.connect(t7);
		e2_t8.connect(e2);
		e2_t8.connect(t8);
		e3_t10.connect(e3);
		e3_t10.connect(t10);
		e3_t11.connect(e3);
		e3_t11.connect(t11);
		e3_t12.connect(e3);
		e3_t12.connect(t12);
		e3_p2.connect(e3);
		e3_p2.connect(p2);
		e4_t13.connect(e4);
		e4_t13.connect(t13);
		e4_t14.connect(e4);
		e4_t14.connect(t14);
		e4_t15.connect(e4);
		e4_t15.connect(t15);
		e4_p3.connect(e4);
		e4_p3.connect(p3);
		d1_e1.connect(d1);
		d1_e1.connect(e1);
		d1_e2.connect(d1);
		d1_e2.connect(e2);
		d1_t9.connect(d1);
		d1_t9.connect(t9);
		d2_p1.connect(d2);
		d2_p1.connect(p1);
		d2_e3.connect(d2);
		d2_e3.connect(e3);
		d2_e4.connect(d2);
		d2_e4.connect(e4);
		d3_auth.connect(d3);
		d3_auth.connect(auth);
		d3_dns2.connect(d3);
		d3_dns2.connect(dns2);
		d3_email.connect(d3);
		d3_email.connect(email);
		d4_backup.connect(d4);
		d4_backup.connect(backup);
		d4_db.connect(d4);
		d4_db.connect(db);
		d4_dns1.connect(d4);
		d4_dns1.connect(dns1);
		c1_d1.connect(c1);
		c1_d1.connect(d1);
		c1_d2.connect(c1);
		c1_d2.connect(d2);
		c1_d3.connect(c1);
		c1_d3.connect(d3);
		c1_d4.connect(c1);
		c1_d4.connect(d4);
		c2_d1.connect(c2);
		c2_d1.connect(d1);
		c2_d2.connect(c2);
		c2_d2.connect(d2);
		c2_d3.connect(c2);
		c2_d3.connect(d3);
		c2_d4.connect(c2);
		c2_d4.connect(d4);
		c1_c2.connect(c1);
		c1_c2.connect(c2);
		
		System.out.println("Atomic service 1");
		
		System.out.println("From p2 to dns1:");
		ArrayList<Component> components = PathDiscovery.DFSearch(p2, dns1);
		for (Component component : components) {
			System.out.printf("repeat " + component.getId() + "_AS1a instant_unavail(%1.20f, %3.20f, reference_time - %d + offset + AS1a)\n", 
					component.getFailureRate(), component.getRepairRate(), component.getDeploymentTime());
		}
		
		System.out.println("\nFrom p2 to dns2:");
		components = PathDiscovery.DFSearch(p2, dns2);
		for (Component component : components) {
			System.out.printf("repeat " + component.getId() + "_AS1b instant_unavail(%1.20f, %3.20f, reference_time - %d + offset + AS1b)\n", 
					component.getFailureRate(), component.getRepairRate(), component.getDeploymentTime());
		}
		
		System.out.println("\nAtomic service 2");
		System.out.println("From p2 to email:");
		components = PathDiscovery.DFSearch(p2, email);
		for (Component component : components) {
			System.out.printf("repeat " + component.getId() + "_AS2 instant_unavail(%1.20f, %3.20f, reference_time - %d + offset + AS2)\n", 
					component.getFailureRate(), component.getRepairRate(), component.getDeploymentTime());
		}
		

		System.out.println("\nAtomic service 3");
		System.out.println("From email to auth:");
		components = PathDiscovery.DFSearch(email, auth);
		for (Component component : components) {
			System.out.printf("repeat " + component.getId() + "_AS3 instant_unavail(%1.20f, %3.20f, reference_time - %d + offset + AS3)\n", 
					component.getFailureRate(), component.getRepairRate(), component.getDeploymentTime());
		}


		
		
//		try{
//    		File file =new File("javaio-appendfile.txt");
// 
//    		//if file doesnt exists, then create it
//    		if(!file.exists()){
//    			file.createNewFile();
//    		}
// 
//    		//true = append file
//    		FileWriter fileWritter = new FileWriter(file.getName(),true);
//	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
//	        
//	        for (int i = 1355569150; i < 1355969200; i++) {
//	        	bufferWritter.write(i + ": " + AvailabilityEvaluator.getInstantAvailability(t1, i) + "\n");
//			}
//	        bufferWritter.close();
// 
//    	}catch(IOException e){
//    		e.printStackTrace();
//    	}
	}
}
