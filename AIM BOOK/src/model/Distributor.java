package model;

import database.DBConnector;
import database.InformationStore;
import database.LocalFile;

public class Distributor {
    private String surname;
    private String firstName;
    private String code;
    private String upLineCode;
    private String upLineSide;
    private String title, bMTitle;

    public String getUpLineSide() {
		return upLineSide;
	}

	public void setUpLineSide(String upLineSide) {
		this.upLineSide = upLineSide;
	}

	private String phoneNumber;
    private String leftSL= null;
    private String rightSL=null;
    private String dbName=null;

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    public String getLeftSL() {
		return leftSL;
	}


	public void setLeftSL(String leftSL) {
		this.leftSL = leftSL;
	}


	public String getRightSL() {
		return rightSL;
	}


	public void setRightSL(String rightSL) {
		this.rightSL = rightSL;
	}


	public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUpLineCode() {
        return upLineCode;
    }

    public void setUpLineCode(String upLineCode) {
        this.upLineCode = upLineCode;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

//    private Distributor sLIneL;
//    private Distributor sLineR;
//    private Distributor upLine;

    public boolean register(String dbName){
        InformationStore informationStore = new DBConnector(dbName);
        boolean done = informationStore.register(this);
        if (!done){
            informationStore = new LocalFile();
            informationStore.register(this);
        }
        return false;
    }

    public boolean login(){
        return false;
    }

    public boolean registerSuccessLine(String upLineCode,String newDistCode, int side){ // both of the

        if(side == 1){
            //update upline's left with newDistCode
        }
        else{
            //update upline's Right with newDistCode

        }

        return false;
    }

    public Distributor getDistributor(String code,String dbName){
         Distributor  distributor= null;
        DBConnector db = new DBConnector(dbName);

        if (code !=null)
         distributor = db.getDistributor(code);

        return distributor;
    }



}
