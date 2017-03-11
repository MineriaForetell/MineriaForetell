/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author raxton
 */
@Entity
@Table(name = "login_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoginInfo.findAll", query = "SELECT l FROM LoginInfo l"),
    @NamedQuery(name = "LoginInfo.findByUserId", query = "SELECT l FROM LoginInfo l WHERE l.userId = :userId"),
    @NamedQuery(name = "LoginInfo.findByUsername", query = "SELECT l FROM LoginInfo l WHERE l.username = :username"),
    @NamedQuery(name = "LoginInfo.findByPassword", query = "SELECT l FROM LoginInfo l WHERE l.password = :password"),
    @NamedQuery(name = "LoginInfo.findByRole", query = "SELECT l FROM LoginInfo l WHERE l.role = :role")})
public class LoginInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<UserInfo> userInfoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdTo")
    private Collection<TaskDetails> taskDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdFrom")
    private Collection<TaskDetails> taskDetailsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdTo")
    private Collection<ProjectUserDetails> projectUserDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdFrom")
    private Collection<ProjectDetails> projectDetailsCollection;

    public LoginInfo() {
    }

    public LoginInfo(Integer userId) {
        this.userId = userId;
    }

    public LoginInfo(Integer userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public Collection<UserInfo> getUserInfoCollection() {
        return userInfoCollection;
    }

    public void setUserInfoCollection(Collection<UserInfo> userInfoCollection) {
        this.userInfoCollection = userInfoCollection;
    }

    @XmlTransient
    public Collection<TaskDetails> getTaskDetailsCollection() {
        return taskDetailsCollection;
    }

    public void setTaskDetailsCollection(Collection<TaskDetails> taskDetailsCollection) {
        this.taskDetailsCollection = taskDetailsCollection;
    }

    @XmlTransient
    public Collection<TaskDetails> getTaskDetailsCollection1() {
        return taskDetailsCollection1;
    }

    public void setTaskDetailsCollection1(Collection<TaskDetails> taskDetailsCollection1) {
        this.taskDetailsCollection1 = taskDetailsCollection1;
    }

    @XmlTransient
    public Collection<ProjectUserDetails> getProjectUserDetailsCollection() {
        return projectUserDetailsCollection;
    }

    public void setProjectUserDetailsCollection(Collection<ProjectUserDetails> projectUserDetailsCollection) {
        this.projectUserDetailsCollection = projectUserDetailsCollection;
    }

    @XmlTransient
    public Collection<ProjectDetails> getProjectDetailsCollection() {
        return projectDetailsCollection;
    }

    public void setProjectDetailsCollection(Collection<ProjectDetails> projectDetailsCollection) {
        this.projectDetailsCollection = projectDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginInfo)) {
            return false;
        }
        LoginInfo other = (LoginInfo) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.LoginInfo[ userId=" + userId + " ]";
    }
    
}
