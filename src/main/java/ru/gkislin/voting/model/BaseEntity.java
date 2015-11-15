package ru.gkislin.voting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity {
    @GeneratedValue
    @Id
    protected Integer id;

    public BaseEntity() {
    }

    protected BaseEntity(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @JsonIgnore
    public boolean isNew() {
        return (this.id == null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id;
    }
}
