package com.example.a24802.demo.Model;


public class UserV2 extends User {
    public UserV2(){}

        public UserV2(int _id, String _name, String _lang){
            super(_id,_name);
            this.lang = _lang;
            postsURL();
            editUser();
        }

        private String lang;
        public String getLang() {
            return lang;
        }
        public void setLang(String lang) {
            this.lang = lang;
        }

        private String postsURL;
        
        
       public void postsURL() {
        this.postsURL = "http://localhost:9090/posts?userId=" + getId();
       }

       public String getPostsURL() {
           return postsURL;
       }

       public void setPostsURL(String postsURL) {
           this.postsURL = postsURL;
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
