package com.relia.discovery;

import java.util.ArrayList;

import com.relia.network.Component;

/**
 * This Class contains a recursive depth-first search (DFS) algorithm with trace
 * tracking to avoid live-locks into graph loops.
 * 
 * @author Cristina Murillo, Rafael Rezende
 * 
 */
public final class PathDiscovery {
	
	public static ArrayList<Component> DFSearch(Component start, Component target) {
		
		ArrayList<Component> mergedPath = new ArrayList<Component>();
		
		DFSearch(start, target, new ArrayList<Component>(), mergedPath);
		
		return mergedPath;
	}

	/**
	 * This recursive function start by checking if the Node is already in the
	 * accumulator, in order to avoid live-locks. If not, check if it is the
	 * target. If positive, the search considers it as a leaf and starts going
	 * back through previous Nodes looking for another path.
	 * 
	 * The loops are checked by the Nodes in the accumulator. In theory, this
	 * could lead to low performance for big graphs, because the accumulator may
	 * get proportionally big and it is traversed every time the search
	 * reaches a Node.
	 * 
	 * Alternatively, there should be boolean flags on each Node to indicate if
	 * it is part of the path or not. The side-effect is that every time the
	 * target is reached, the whole graph must be traversed again to reveal
	 * which Nodes are in the path.
	 * 
	 * The optimal solution could be the hybrid of both approaches.
	 * 
	 * @param start
	 *            Starting Node in the graph.
	 * @param target
	 *            Target Node in the graph.
	 * @param accPath
	 *            Accumulated Nodes to indicate the path.
	 */
	public static void DFSearch(Component start, Component target, ArrayList<Component> accPath, ArrayList<Component> mergedPath) {

		// check if the Node has already been visited.
		if (accPath.contains(start))
			return;

		// add Node to the accumulated path.
		accPath.add(start);

		// check if the current Node is the target Node.
		if (start.getId().equals(target.getId())) {
			// print the accumulated path.
			printPath(accPath);
			mergePath(accPath, mergedPath);
			// remove Node from the accumulated path.
			accPath.remove(start);
			// return to previous Node.
			return;
		}

		// run the recursive method for every neighbor.
		// NOTE: unidirectional graph. previous Node is also a neighbor.
		ArrayList<Component> nodes = start.getNeighbors();
		for (Component node : nodes) {
			DFSearch(node, target, accPath, mergedPath);
		}
		// finished checking every child.

		// remove the Node the accumulator.
		// then, return to previous Node.
		accPath.remove(start);
	}

	/**
	 * Print the list of accumulated Nodes.
	 * @param path Array of Nodes belonging to this path.
	 */
	public static void printPath(ArrayList<Component> path) {
		String found = "";
		for (Component node : path) {
			found += " -> ";
			found += node.getId();
		}
		System.out.println(found);
	}
	
	public static void mergePath(ArrayList<Component> accPath, ArrayList<Component> mergedPath) {
		
		// Auxiliary component to keep the last inserted node.
		Component previous = null;
		Component current = null;
		// For every node of the found path...
		for (Component node : accPath) {
			
			// Get the equivalent node reference from the existing merged path
			for (Component nodeFromMergedPath : mergedPath) {
				if (node.getId() == nodeFromMergedPath.getId())
					current = nodeFromMergedPath;
			}

			// Node not found in the existing merged path, so...
			if (current == null){
				// ...get a copy of the node without neighbors...
				current = node.getCleanCopy();
				// ...and add to the merged path. 
				mergedPath.add(current);
			}
			
			// Connect the previous node to the current one
			if (previous!=null)
				previous.connect(current);
			
			// The current node is referenced as the previous one for the next iteration and reset
			previous = current;
			current = null;
		}
	}
}