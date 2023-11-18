package pack;
import java.sql.*;
public class MyBean {
	private String email;
	private String pass;
	private String nam;
	boolean valid = false;
	PreparedStatement ps;
	Connection con;
	ResultSet rs;
	public void setEmail(String email){
		this.email = email;
	}
	public void setPass(String pass){
		this.pass = pass;
	}
	public void setNam(String nam){
		this.nam = nam;
	}
	
	public String getEmail(){
	return email;
	}
	public String getPass(){
		return pass;
	}
	
	public String getNam(){
		return nam;
	}
	public boolean getUser(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///11ambatch","root","abcd");
			ps = con.prepareStatement("select email from emailcontent");
			rs = ps.executeQuery();
			while(rs.next()){
				if(email.equals(rs.getString("email"))){
					valid = true;
					break;
				}
			}
			if(!valid){
				ps = con.prepareStatement("insert into emailcontent values(?, ?, ?)");
				ps.setString(1,email);
				ps.setString(2,pass);
				ps.setString(3,nam);
				ps.executeUpdate();
			}
			}
			catch(Exception e){}
			return valid;
		}
	public boolean getLogin(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///11ambatch","root","abcd");
			ps =con.prepareStatement("select email, pass from emailcontent");
		    rs =ps.executeQuery();
		   while(rs.next())
		   {
			if(email.equals(rs.getString("email"))&& pass.equals(rs.getString("pass")))
			{
			    valid=true;
				break;
			}
			
		   }	
		}
		catch (Exception ae) {}
		
		return valid;
	}
}

		
		