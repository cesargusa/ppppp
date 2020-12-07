package com.example.a24802.demo.Model;

public class Post {
    public Post(){ }
        public Post(int _id, int _userId, String _text){
            this.id= _id;
            this.userId= _userId;
            this.text = _text;
        }

        private int id;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        private int userId;
        public int getUserId() {
            return userId;
        }
        public void setUserId(int userId) {
            this.userId = userId;
        }
        private String text;
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }

    }
    

