package com.example.lab5app;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Users implements Serializable {
    private int id;
    private String name;
    private String email;
    private String password;

    public Users(String name, String password, String email)
    {
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    public Users(String name, String password)
    {
        setPassword(password);
        setName(name);
    }

    public  Users (Users obj)
    {
        this.setName(obj.getName());
        this.setPassword(obj.getPassword());
        this.setEmail(obj.getEmail());
    }
    public Users() {}

    public int getId() { return id; }

    public void setId(int id) { this.id = id;}

    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public String getEmail() { return email;}

    public void setEmail(String email) { this.email = email;}

    public String getPassword() { return password;}

    public void setPassword(String password) {this.password = get_SHA_512_SecurePassword(password,"MinhNe"); }

    public String get_SHA_512_SecurePassword(String passwordToHash, String salt){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

}
