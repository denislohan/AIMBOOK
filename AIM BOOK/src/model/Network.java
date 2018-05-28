package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Network {
	List <Node> nodes = new ArrayList<Node>();
	HashMap <String,Node> map = new HashMap <>(); 
	Node root = new Node();
	Node tempNodeLeft,tempNodeRight;
	String rootCode;
	Node currNode;//parentNode;
	int curIndex =-1;


	public Node getNetwork(String code, String dbName) {
		rootCode = code;
		Node currNode = null;
		currNode = getNode(code, dbName);
		return map.get(rootCode);
	}

	public Node getNode(String upLineCode, String dbName) {
		currNode = new Node();
		nodes.add(currNode);
		Distributor dist = new Distributor();
		Distributor currDist = dist.getDistributor(upLineCode, dbName);
		currNode.setFirstName(currDist.getFirstName());		
		currNode.setUpline(currDist.getUpLineCode());
		currNode.setCode(currDist.getCode());

		map.put(currDist.getCode(), currNode);

		if (currDist.getLeftSL() != null) {
			tempNodeLeft = getNode(currDist.getLeftSL(), dbName);
			map.get(currDist.getCode()).setLeft(tempNodeLeft);
			
		}

		if (currDist.getRightSL() != null) {
			tempNodeRight =getNode(currDist.getRightSL(), dbName);
			map.get(currDist.getCode()).setRight(tempNodeRight);
		}
		return map.get(currDist.getCode());
	}

	public void printNetwork() {

	}
}
