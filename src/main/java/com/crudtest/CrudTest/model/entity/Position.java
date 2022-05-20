package com.crudtest.CrudTest.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t1_position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id", length = 11, nullable = false)
    private int idP;

    @Column (name = "code", length = 50, nullable = false)
    private String code;

    @Column (name = "name", length = 100, nullable = false)
    private String name;

    @Column (name = "is_delete", length = 11, nullable = false)
    private int isDelete;

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
