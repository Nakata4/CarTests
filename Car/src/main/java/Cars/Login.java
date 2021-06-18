package Cars;

import javax.swing.*;

public class Login {
   JLabel user_label, password_label, message;
   JTextField userName_text;
   JPasswordField password_text;
   JButton submit, cancel;
   Login() {

      user_label.setText("User Name :");
      userName_text = new JTextField();
      password_label = new JLabel();
      password_label.setText("Password :");
      password_text = new JPasswordField();
      submit = new JButton("SUBMIT");

   }
   public static void main(String[] args) {
      new Login();
   }
 {
      String userName = userName_text.getText();
      String password = password_text.getText();
      if (userName.trim().equals("admin") && password.trim().equals("admin")) {
         message.setText(" Hello " + userName + "");
      } else {
         message.setText(" Invalid user.. ");
      }
   }
}
