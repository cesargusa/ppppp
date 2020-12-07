package com.example.a24802.demo.Model;

public class User {
    public User(){ }
        public User(int _id, String _name){
            this.id=_id;
            this.name=_name;
            editUser();
        }

    

    
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String editUser;

    public String getEditUser() {
        return editUser;
    }

    public void setEditUser(String editUser) {
        this.editUser = editUser;
    }
    public void editUser() {
     this.editUser = "http://localhost:9090/users/edit/" + getId();
    }
    
}
