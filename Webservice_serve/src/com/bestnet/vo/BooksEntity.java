package com.bestnet.vo;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class BooksEntity {

    @Id
    private String id;
    private String name;
    private Integer price;

    //  fetch=FetchType.EAGER，急加载，加载一个实体时，定义急加载的属性会立即从数据库中加载。
    //  全部级联操作，referencedColumnName显式设置数据库字段名cid，不写默认就是和name一样的。
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id")
    private StudentEntity studentEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BooksEntity that = (BooksEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
