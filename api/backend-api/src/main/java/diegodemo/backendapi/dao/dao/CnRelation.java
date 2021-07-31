/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diegodemo.backendapi.dao.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "cn_relation")
@NamedQueries({
    @NamedQuery(name = "CnRelation.findAll", query = "SELECT c FROM CnRelation c")})
public class CnRelation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "relation_id")
    private Integer relationId;
    @Basic(optional = false)
    @Column(name = "acquaintance_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acquaintanceDate;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;
    @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CnContact contactId;
    @JoinColumn(name = "user_id", referencedColumnName = "contact_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CnContact userId;

    public CnRelation() {
    }

    public CnRelation(Integer relationId) {
        this.relationId = relationId;
    }

    public CnRelation(Integer relationId, Date acquaintanceDate, short status) {
        this.relationId = relationId;
        this.acquaintanceDate = acquaintanceDate;
        this.status = status;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Date getAcquaintanceDate() {
        return acquaintanceDate;
    }

    public void setAcquaintanceDate(Date acquaintanceDate) {
        this.acquaintanceDate = acquaintanceDate;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public CnContact getContactId() {
        return contactId;
    }

    public void setContactId(CnContact contactId) {
        this.contactId = contactId;
    }

    public CnContact getUserId() {
        return userId;
    }

    public void setUserId(CnContact userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relationId != null ? relationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CnRelation)) {
            return false;
        }
        CnRelation other = (CnRelation) object;
        if ((this.relationId == null && other.relationId != null) || (this.relationId != null && !this.relationId.equals(other.relationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.cirrus.it.dev.mavenproject2.CnRelation[ relationId=" + relationId + " ]";
    }
    
}
