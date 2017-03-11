/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author raxton
 */
@Entity
@Table(name = "user_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserInfo.findAll", query = "SELECT u FROM UserInfo u"),
    @NamedQuery(name = "UserInfo.findByUserLoginId", query = "SELECT u FROM UserInfo u WHERE u.userLoginId = :userLoginId"),
    @NamedQuery(name = "UserInfo.findByUserFirstName", query = "SELECT u FROM UserInfo u WHERE u.userFirstName = :userFirstName"),
    @NamedQuery(name = "UserInfo.findByUserLastName", query = "SELECT u FROM UserInfo u WHERE u.userLastName = :userLastName"),
    @NamedQuery(name = "UserInfo.findByUserContactNumber", query = "SELECT u FROM UserInfo u WHERE u.userContactNumber = :userContactNumber"),
    @NamedQuery(name = "UserInfo.findByUserAddedBy", query = "SELECT u FROM UserInfo u WHERE u.userAddedBy = :userAddedBy")})
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_login_id")
    private Integer userLoginId;
    @Column(name = "user_first_name")
    private String userFirstName;
    @Column(name = "user_last_name")
    private String userLastName;
    @Column(name = "user_contact_number")
    private String userContactNumber;
    @Column(name = "user_added_by")
    private Integer userAddedBy;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private LoginInfo userId;

    public UserInfo() {
    }

    public UserInfo(Integer userLoginId) {
        this.userLoginId = userLoginId;
    }

    public Integer getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(Integer userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserContactNumber() {
        return userContactNumber;
    }

    public void setUserContactNumber(String userContactNumber) {
        this.userContactNumber = userContactNumber;
    }

    public Integer getUserAddedBy() {
        return userAddedBy;
    }

    public void setUserAddedBy(Integer userAddedBy) {
        this.userAddedBy = userAddedBy;
    }

    public LoginInfo getUserId() {
        return userId;
    }

    public void setUserId(LoginInfo userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userLoginId != null ? userLoginId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserInfo)) {
            return false;
        }
        UserInfo other = (UserInfo) object;
        if ((this.userLoginId == null && other.userLoginId != null) || (this.userLoginId != null && !this.userLoginId.equals(other.userLoginId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.UserInfo[ userLoginId=" + userLoginId + " ]";
    }
    
}
