package com.churrios.api.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    public String uuid;

    public String name;
    public String email;


}
