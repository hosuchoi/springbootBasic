//package com.lake.smartway.nosql.mongodb;
//
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.persistence.Id;
//
//@Document(collection = "mongo") //각가의 Document 들이 collection으로 들어간다. ( colection이 relation DB에서 말하는 테이블이라고 보면됨 )
//public class MongoAccount {
//    @Id
//    private String id;
//
//    private String username;
//
//    private String email;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//}
