package com.relia.network;

import java.util.ArrayList;

/**
 * This class represents a single node in a undirected graph. A Node contains an
 * unique id and an arrays of Nodes connected to it. There is a mutual
 * association between Nodes, that it, if this Node contains another one in its
 * array, that one also contains this one.
 * 
 * @author Rafael Rezende
 * 
 */
public class Component {
	
	/**
	 * Unique ID of the Node
	 */
	private String id;
	
	/**
	 * The failure rate of this component. Ranges from 0 to 1.
	 */
	private double failureRate;
	
	/**
	 * The repair rate of this component. Ranges from 0 to 1.
	 */
	private double repairRate;
	
	/**
	 * The epoch time of this component. In seconds.
	 */
	private int deploymentTime;
	
	/**
	 * Arrays of Nodes connected to this one
	 */
	private ArrayList<Component> neighbors;
	
	/**
	 * Constructor with availability parameters.
	 * @param id Unique ID of component.
	 * @param failureRate Failure rate of component.
	 * @param repairRate Repair rate of component.
	 * @param deploymentTime Epoch time of component.
	 */
	public Component(String id, double failureRate, double repairRate,
			int deploymentTime) {
		super();
		this.id = id;
		this.failureRate = failureRate;
		this.repairRate = repairRate;
		this.deploymentTime = deploymentTime;
		neighbors = new ArrayList<Component>();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @return the failureRate
	 */
	public double getFailureRate() {
		return failureRate;
	}

	/**
	 * @return the repairRate
	 */
	public double getRepairRate() {
		return repairRate;
	}

	/**
	 * @return the deploymentTime
	 */
	public int getDeploymentTime() {
		return deploymentTime;
	}

	/**
	 * @return the neighbor components
	 */
	public ArrayList<Component> getNeighbors() {
		return neighbors;
	}

	/**
	 * Connects this Node to another Node n. The connection is mutual, so that
	 * the connect function of Node n is automatically called here.
	 * 
	 * @param n Node to connect.
	 */
	public void connect(Component n){
		for (Component neighbor: neighbors) {
			if (neighbor.getId().equals(n.id)){
//				System.out.println("Nodes already connected: [" + this.id + "][" + n.id + "]");
				return;
			}
		}
//		System.out.println("Creating connection between nodes: [" + this.id + "][" + n.id + "]");
		neighbors.add(n);
		n.connect(this);
		
		// Workaround to make sure its deployment time is the same as the youngest component connected to it
		if ((this.deploymentTime < n.deploymentTime) && (this.getId().contains("_")))
			this.deploymentTime = n.deploymentTime;
	}
	
	/**
	 * Print list of neighbor nodes connected to this one.
	 */
	public void printNeighbors(){
		for (Component neighbor : neighbors) {
			System.out.println(this.id + " <--> " + neighbor.id);
		}
	}
	
	/**
	 * Get a copy of this component without neighbors.
	 * @return Copy of this component with a clear list of neighbors.
	 */
	public Component getCleanCopy(){
		return new Component(this.id, this.failureRate, this.repairRate, this.deploymentTime);
	}
	
	/**
	 * Identifies if node parameter is a neighbor or not.
	 * @param node Possible neighbor.
	 * @return True if node is neighbor, false otherwise.
	 */
	public boolean isConnectedTo(Component node){
		return neighbors.contains(node);
	}
	
	/**
	 * Get the neighbor by its name. Returns null if there is no neighbor with this name.
	 * @param node Neighbor name.
	 * @return Component neighbor with the desired name. Null if it is not a neighbor.
	 */
	public Component getNeighborByName(String nodeName){
		for (Component possibleNeighbor : this.neighbors) {
			if (possibleNeighbor.getId().equals(nodeName)) return possibleNeighbor;
		}
		return null;
	}
}
