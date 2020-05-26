//package com.lake.smartway.nosql.neo4j;
//
//import org.neo4j.ogm.annotation.GeneratedValue;
//import org.neo4j.ogm.annotation.Id;
//import org.neo4j.ogm.annotation.NodeEntity;
//import org.neo4j.ogm.annotation.Relationship;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@NodeEntity
//public class Neo4jAccount {
//
//    @Id @GeneratedValue
//    private Long id;
//
//    private String username;
//
//    private String email;
//
//    @Relationship(type = "has")
//    private Set<Neo4jRole> roles = new HashSet<>();
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
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
//
//    public Set<Neo4jRole> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Neo4jRole> roles) {
//        this.roles = roles;
//    }
//}
