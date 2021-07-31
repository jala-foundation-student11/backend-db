/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diegodemo.backendapi.dao.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "cn_contact")
@NamedQueries({
    @NamedQuery(name = "CnContact.findAll", query = "SELECT c FROM CnContact c")})
public class CnContact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contact_id")
    private Integer contactId;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "seed")
    private String seed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactId", fetch = FetchType.LAZY)
    private Collection<CnRelation> cnRelationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private Collection<CnRelation> cnRelationCollection1;

    public CnContact() {
    }

    public CnContact(Integer contactId) {
        this.contactId = contactId;
    }

    public CnContact(Integer contactId, String firstName, String lastName, String userName, String email, Date dateOfBirth, String seed) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.seed = seed;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public Collection<CnRelation> getCnRelationCollection() {
        return cnRelationCollection;
    }

    public void setCnRelationCollection(Collection<CnRelation> cnRelationCollection) {
        this.cnRelationCollection = cnRelationCollection;
    }

    public Collection<CnRelation> getCnRelationCollection1() {
        return cnRelationCollection1;
    }

    public void setCnRelationCollection1(Collection<CnRelation> cnRelationCollection1) {
        this.cnRelationCollection1 = cnRelationCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CnContact)) {
            return false;
        }
        CnContact other = (CnContact) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.cirrus.it.dev.mavenproject2.CnContact[ contactId=" + contactId + " ]";
    }
    
}
