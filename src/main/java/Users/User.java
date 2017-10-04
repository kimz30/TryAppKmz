package Users;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    //ID
    private IntegerProperty id = new SimpleIntegerProperty();
    public int getId() { return id.get(); }
    public IntegerProperty idProperty() { return id; }
    public void setId(int id) { this.id.set(id); }


    //Username
    private StringProperty username = new SimpleStringProperty();
    public String getUsername() {
        return username.get();
    }
    public StringProperty usernameProperty() {
        return username;
    }
    public void setUsername(String username) {
        this.username.set(username);
    }

    //Password
    private StringProperty password = new SimpleStringProperty();
    public String getPassword() {return password.get();}
    public StringProperty passwordProperty() {return password;}
    public void setPassword(String password) {this.password.set(password);}

}
