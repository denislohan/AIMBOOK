package model;

public class Node {
    private String firstName;
    private String code;
    private Node left;
    private Node right;
    private String upline;
	

	public String getUpline() {
		return upline;
	}
	public void setUpline(String upline) {
		this.upline = upline;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}

    
    
}
