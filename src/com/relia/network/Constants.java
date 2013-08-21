/**
 * 
 */
package com.relia.network;

/**
 * Failure and repair rates of components are declared as constant to facilitate
 * further topology instantiation.
 * 
 * @author Rafael Rezende
 * 
 */
public class Constants {
 
	// Failure rates
	public static double F_SERVER = 0.00001666666666666670 ;
	public static double F_C2960 = 0.00000544965067739158 ;
	public static double F_C6500 = 0.00001630789302022180 ;
	public static double F_HP2650 = 0.00000502512562814070 ;
	public static double F_C3750 = 0.00000530292986875249 ;
	public static double F_COMP = 0.00033333333333333300 ;
	public static double F_PRINTER = 0.00138888888888889000 ;
	public static double F_WIRE = 0.00000769230769230769 ;
	public static double F_WIRELESS = 0.08333333333333330000 ;
	
	// Repair rates
	public static double R_SERVER = 0.25000000000000000000 ;
	public static double R_C2960 = 0.50000000000000000000 ;
	public static double R_C6500 = 0.50000000000000000000 ;
	public static double R_HP2650 = 0.50000000000000000000 ;
	public static double R_C3750 = 0.50000000000000000000 ;
	public static double R_COMP = 0.04166666666666670000 ;
	public static double R_PRINTER = 2.00000000000000000000 ;
	public static double R_WIRE = 0.25000000000000000000 ;
	public static double R_WIRELESS = 33.33333333333330000000 ;

}
