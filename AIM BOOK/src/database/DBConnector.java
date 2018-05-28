package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Distributor;

public class DBConnector implements InformationStore {

	private Connection myConnection;
	private PreparedStatement statement;
	String dbName;

	public DBConnector(String dbName) {
		try {
			this.dbName = dbName;
			Class.forName("com.mysql.jdbc.Driver");
			String db = "jdbc:mysql://18.219.86.137:3306/" + dbName;
			myConnection = DriverManager.getConnection(db, "username", "password");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public boolean register(Distributor distributor) {
		boolean success = true;
		String query = "INSERT INTO " + dbName
				+ ".distributor (`firstname`,`surname`,`tel`,`code`,`upline`,`uplineside`,`lSL`,`rSL`) VALUES (?,?,?,?,?,?,?,?);";
		try {
			statement = myConnection.prepareStatement(query);
			statement.setString(1, distributor.getFirstName());
			statement.setString(2, distributor.getSurname());
			statement.setString(3, distributor.getPhoneNumber());
			statement.setString(4, distributor.getCode());
			statement.setString(5, distributor.getUpLineCode());
			statement.setString(6, distributor.getUpLineSide().toLowerCase());
			statement.setString(7, distributor.getRightSL());
			statement.setString(8, distributor.getLeftSL());
			statement.executeUpdate();
			if(!distributor.getUpLineSide().equals(""));
			setUplineSide(distributor.getUpLineCode(), distributor.getCode(), distributor.getUpLineSide());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = false;
		} finally {
			try {
				if (myConnection != null)
					myConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return success;
	}
	
	
public void setUplineSide(String uplinecode, String distr_code,String side) {
		
		String sideToplace = side.equals("left")? "lSL" :"rSL";
		String query = "update distributor set "+sideToplace+" = ? where code = ? ";
		
		try {
			statement = myConnection.prepareStatement(query);
			statement.setString(1, distr_code);
			statement.setString(2, uplinecode);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	public boolean Login() {
		return false;
	}

	public Distributor getDistributor(String code) {
		Distributor distributor = new Distributor();
		ResultSet set = null;
		String query = "select * from " + dbName + ".distributor where code = ?";
		try {
			statement = myConnection.prepareStatement(query);
			statement.setString(1, code);
			set = statement.executeQuery();
			if (set.next()) {
				distributor.setCode(set.getString("code"));
				distributor.setFirstName(set.getString("firstname"));
				distributor.setSurname(set.getString("surname"));
				distributor.setUpLineCode(set.getString("upline"));
				distributor.setPhoneNumber(set.getString("tel"));
				distributor.setRightSL(set.getString("rSL"));
				distributor.setLeftSL(set.getString("lSL"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (myConnection != null)
					myConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return distributor;
	}

	public void createDB(String name) {
		// create db
		// set privileges

	}

}
