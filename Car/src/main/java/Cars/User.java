package Cars;

public class User {
private String email;
private String password;
private String username;

		public String username(String first_name, String last_name, String password, String email){
			this.password = password;
			return this.email = email;
		}
		public String getUsername(){
			return username;
		}
		public void setUsername(String username){
			this.username = username;
		}
		public String getPassword(){
			return password;
		}
		public void setPassword(String password){
			this.password = password;
		}
		public String getEmail(){
			return email;
		}
		public void setEmail(String email){
			this.email = email;
		}
		
		public int userpass(int password)
		{
			return password;
		}

		public int userpass(String string) {		
			return 0;
		}	
	}
