/**
 * 
 */
package com.relia.testsuite;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.relia.discovery.PathDiscovery;
import com.relia.network.Component;

/**
 * @author Rafael Rezende
 *
 */
public class MergedPaths {

	@Test
	public void MergedFoundPaths() {

		// Devices
		Component t1 = new Component("t1",0.000336021505376344,0.0416666666666667,1355569200);
		Component t2 = new Component("t2",0.000336021505376344,0.0416666666666667,1355569200);
		Component t3 = new Component("t3",0.000336021505376344,0.0416666666666667,1355569200);
		Component t4 = new Component("t4",0.000336021505376344,0.0416666666666667,1355569200);
		Component t5 = new Component("t5",0.000336021505376344,0.0416666666666667,1357815600);
		Component t6 = new Component("t6",0.000336021505376344,0.0416666666666667,1357815600);
		Component t7 = new Component("t7",0.000336021505376344,0.0416666666666667,1357815600);
		Component t8 = new Component("t8",0.000336021505376344,0.0416666666666667,1357815600);
		Component t9 = new Component("t9",0.000336021505376344,0.0416666666666667,1355569200);
		Component t10 = new Component("t10",0.000336021505376344,0.0416666666666667,1357815600);
		Component t11 = new Component("t11",0.000336021505376344,0.0416666666666667,1357815600);
		Component t12 = new Component("t12",0.000336021505376344,0.0416666666666667,1357815600);
		Component t13 = new Component("t13",0.000336021505376344,0.0416666666666667,1349085600);
		Component t14 = new Component("t14",0.000336021505376344,0.0416666666666667,1349085600);
		Component t15 = new Component("t15",0.000336021505376344,0.0416666666666667,1349085600);
		Component e1 = new Component("e1",0.00000502513825411622,2,1355569200);
		Component e2 = new Component("e2",0.00000502513825411622,2,1357815600);
		Component e3 = new Component("e3",0.00000502513825411622,2,1357815600);
		Component e4 = new Component("e4",0.00000502513825411622,2,1349085600);
		Component d1 = new Component("d1",0.00000530294392932236,2,1355569200);
		Component d2 = new Component("d2",0.00000530294392932236,2,1349085600);
		Component d3 = new Component("d3",0.00000544966552677829,2,1366020000);
		Component d4 = new Component("d4",0.00000544966552677829,2,1349085600);
		Component c1 = new Component("c1",0.0000163080259949934,2,1349085600);
		Component c2 = new Component("c2",0.0000163080259949934,2,1349085600);
		Component p1 = new Component("p1",0.000347342827370615,1,1349085600);
		Component p2 = new Component("p2",0.000347342827370615,1,1357815600);
		Component p3 = new Component("p3",0.000347342827370615,1,1349085600);
		Component file1 = new Component("file1",0.0000166666944444907,10,1349085600);
		Component file2 = new Component("file2",0.0000166666944444907,10,1349085600);
		Component backup = new Component("backup",0.0000166666944444907,10,1366020000);
		Component db = new Component("db",0.0000166666944444907,10,1366020000);
		Component email = new Component("email",0.0000166666944444907,10,1366020000);
		Component printS = new Component("printS",0.0000166666944444907,10,1349085600);
		
		// Links
		Component e1_t1 = new Component("e1_t1",0.00000769372807287499,0.0416666666666667,1355569200);
		Component e1_t2 = new Component("e1_t2",0.00000769372807287499,0.0416666666666667,1355569200);
		Component e1_t3 = new Component("e1_t3",0.00000769372807287499,0.0416666666666667,1355569200);
		Component e1_t4 = new Component("e1_t4",0.00000769372807287499,0.0416666666666667,1355569200);
		Component e2_t5 = new Component("e2_t5",0.00000769372807287499,0.0416666666666667,1357815600);
		Component e2_t6 = new Component("e2_t6",0.00000769372807287499,0.0416666666666667,1357815600);
		Component e2_t7 = new Component("e2_t7",0.00000769372807287499,0.0416666666666667,1357815600);
		Component e2_t8 = new Component("e2_t8",0.00000769372807287499,0.0416666666666667,1357815600);
		Component e3_t10 = new Component("e3_t10",0.00000769372807287499,0.0416666666666667,1357815600);
		Component e3_t11 = new Component("e3_t11",0.00000769372807287499,0.0416666666666667,1357815600);
		Component e3_t12 = new Component("e3_t12",0.00000769372807287499,0.0416666666666667,1357815600);
		Component e3_p2 = new Component("e3_p2",0.00000769372807287499,0.0416666666666667,1357815600);
		Component e4_t13 = new Component("e4_t13",0.00000769372807287499,0.0416666666666667,1349085600);
		Component e4_t14 = new Component("e4_t14",0.00000769372807287499,0.0416666666666667,1349085600);
		Component e4_t15 = new Component("e4_t15",0.00000769372807287499,0.0416666666666667,1349085600);
		Component e4_p3 = new Component("e4_p3",0.00000769372807287499,0.0416666666666667,1349085600);
		Component d1_e1 = new Component("d1_e1",0.00000769372807287499,0.0416666666666667,1355569200);
		Component d1_e2 = new Component("d1_e2",0.00000769372807287499,0.0416666666666667,1357815600);
		Component d1_t9 = new Component("d1_t9",0.00000769372807287499,0.0416666666666667,1355569200);
		Component d2_p1 = new Component("d2_p1",0.00000769372807287499,0.0416666666666667,1349085600);
		Component d2_e3 = new Component("d2_e3",0.00000769372807287499,0.0416666666666667,1357815600);
		Component d2_e4 = new Component("d2_e4",0.00000769372807287499,0.0416666666666667,1349085600);
		Component d3_db = new Component("d3_db",0.00000769372807287499,0.0416666666666667,1366020000);
		Component d3_backup = new Component("d3_backup",0.00000769372807287499,0.0416666666666667,1366020000);
		Component d3_email = new Component("d3_email",0.00000769372807287499,0.0416666666666667,1366020000);
		Component d4_file1 = new Component("d4_file1",0.00000769372807287499,0.0416666666666667,1349085600);
		Component d4_file2 = new Component("d4_file2",0.00000769372807287499,0.0416666666666667,1349085600);
		Component d4_printS = new Component("d4_printS",0.00000769372807287499,0.0416666666666667,1349085600);
		Component c1_d1 = new Component("c1_d1",0.00000769372807287499,0.0416666666666667,1355569200);
		Component c1_d2 = new Component("c1_d2",0.00000769372807287499,0.0416666666666667,1349085600);
		Component c1_d3 = new Component("c1_d3",0.00000769372807287499,0.0416666666666667,1366020000);
		Component c1_d4 = new Component("c1_d4",0.00000769372807287499,0.0416666666666667,1349085600);
		Component c2_d1 = new Component("c2_d1",0.00000769372807287499,0.0416666666666667,1355569200);
		Component c2_d2 = new Component("c2_d2",0.00000769372807287499,0.0416666666666667,1349085600);
		Component c2_d3 = new Component("c2_d3",0.00000769372807287499,0.0416666666666667,1366020000);
		Component c2_d4 = new Component("c2_d4",0.00000769372807287499,0.0416666666666667,1349085600);
		Component c1_c2 = new Component("c1_c2",0.00000769372807287499,0.0416666666666667,1349085600);
				
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
		d3_db.connect(d3);
		d3_db.connect(db);
		d3_backup.connect(d3);
		d3_backup.connect(backup);
		d3_email.connect(d3);
		d3_email.connect(email);
		d4_file1.connect(d4);
		d4_file1.connect(file1);
		d4_file2.connect(d4);
		d4_file2.connect(file2);
		d4_printS.connect(d4);
		d4_printS.connect(printS);
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
		
		ArrayList<Component> mergeT15PrintS = PathDiscovery.DFSearch(t15, printS);
		
		for (Component component : mergeT15PrintS) {
			if (component.getId().equals("d1"))
				d1 = component;
		}
		
		assertNull(d1.getNeighborByName("t1"));
		assertNull(d1.getNeighborByName("t2"));
		assertNull(d1.getNeighborByName("t3"));
		assertNull(d1.getNeighborByName("t4"));
		assertNull(d1.getNeighborByName("t5"));
		assertNull(d1.getNeighborByName("t6"));
		assertNull(d1.getNeighborByName("t7"));
		assertNull(d1.getNeighborByName("t8"));
		assertNull(d1.getNeighborByName("t9"));
		assertNull(d1.getNeighborByName("t10"));
		assertNull(d1.getNeighborByName("t11"));
		assertNull(d1.getNeighborByName("t12"));
		assertNull(d1.getNeighborByName("t13"));
		assertNull(d1.getNeighborByName("t14"));
		assertNull(d1.getNeighborByName("t15"));
		assertNull(d1.getNeighborByName("e1"));
		assertNull(d1.getNeighborByName("e2"));
		assertNull(d1.getNeighborByName("e3"));
		assertNull(d1.getNeighborByName("e4"));
		assertNull(d1.getNeighborByName("d1"));
		assertNull(d1.getNeighborByName("d2"));
		assertNull(d1.getNeighborByName("d3"));
		assertNull(d1.getNeighborByName("d4"));
		assertNull(d1.getNeighborByName("c1"));
		assertNull(d1.getNeighborByName("c2"));
		assertNull(d1.getNeighborByName("p1"));
		assertNull(d1.getNeighborByName("p2"));
		assertNull(d1.getNeighborByName("p3"));
		assertNull(d1.getNeighborByName("file1"));
		assertNull(d1.getNeighborByName("file2"));
		assertNull(d1.getNeighborByName("backup"));
		assertNull(d1.getNeighborByName("db"));
		assertNull(d1.getNeighborByName("email"));
		assertNull(d1.getNeighborByName("printS"));
		assertNull(d1.getNeighborByName("e1_t1"));
		assertNull(d1.getNeighborByName("e1_t2"));
		assertNull(d1.getNeighborByName("e1_t3"));
		assertNull(d1.getNeighborByName("e1_t4"));
		assertNull(d1.getNeighborByName("e2_t5"));
		assertNull(d1.getNeighborByName("e2_t6"));
		assertNull(d1.getNeighborByName("e2_t7"));
		assertNull(d1.getNeighborByName("e2_t8"));
		assertNull(d1.getNeighborByName("e3_t10"));
		assertNull(d1.getNeighborByName("e3_t11"));
		assertNull(d1.getNeighborByName("e3_t12"));
		assertNull(d1.getNeighborByName("e3_p2"));
		assertNull(d1.getNeighborByName("e4_t13"));
		assertNull(d1.getNeighborByName("e4_t14"));
		assertNull(d1.getNeighborByName("e4_t15"));
		assertNull(d1.getNeighborByName("e4_p3"));
		assertNull(d1.getNeighborByName("d1_e1"));
		assertNull(d1.getNeighborByName("d1_e2"));
		assertNull(d1.getNeighborByName("d1_t9"));
		assertNull(d1.getNeighborByName("d2_p1"));
		assertNull(d1.getNeighborByName("d2_e3"));
		assertNull(d1.getNeighborByName("d2_e4"));
		assertNull(d1.getNeighborByName("d3_db"));
		assertNull(d1.getNeighborByName("d3_backup"));
		assertNull(d1.getNeighborByName("d3_email"));
		assertNull(d1.getNeighborByName("d4_file1"));
		assertNull(d1.getNeighborByName("d4_file2"));
		assertNull(d1.getNeighborByName("d4_printS"));
		assertNotNull(d1.getNeighborByName("c1_d1"));
		assertNull(d1.getNeighborByName("c1_d2"));
		assertNull(d1.getNeighborByName("c1_d3"));
		assertNull(d1.getNeighborByName("c1_d4"));
		assertNotNull(d1.getNeighborByName("c2_d1"));
		assertNull(d1.getNeighborByName("c2_d2"));
		assertNull(d1.getNeighborByName("c2_d3"));
		assertNull(d1.getNeighborByName("c2_d4"));
		assertNull(d1.getNeighborByName("c1_c2"));
	}
}
