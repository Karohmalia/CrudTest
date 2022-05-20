package com.crudtest.CrudTest.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table (name = "t2_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id", length = 11, nullable = false)
    private int id;

    @Column (name = "name", length = 100, nullable = false)
    private String name;

    @Column (name = "birth_date", nullable = false)
    @NotEmpty
    private Date birthDate;

    @ManyToOne
    @JoinColumn (name = "position_id", nullable = false)
    @NotEmpty
    private Position positionId;

    @Column (name = "gender", length = 11, nullable = false)
    @NotEmpty
    private int gender;

    @Column (name = "id_number", length = 11, unique = true, nullable = false)
    @NotEmpty
    @Size(min = 8, message = "id number should have at least 8 characters")
    private int idNumber;

    @Column (name = "is_delete", length = 11, nullable = false)
    private int isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
