package ru.gkislin.voting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;
//import javax.persistence.Version;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity extends AbstractPersistable<Integer> {

    public BaseEntity() {
    }

    protected BaseEntity(Integer id) {
        setId(id);
    }


/*
//  added ETag, https://objectpartners.com/2015/06/02/etags-and-spring-data-rest/

    @Version
    public Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
*/

    @JsonIgnore
    public boolean isNew() {
        return super.isNew();
    }
}
