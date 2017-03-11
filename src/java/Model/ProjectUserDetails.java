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
@Table(name = "project_user_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectUserDetails.findAll", query = "SELECT p FROM ProjectUserDetails p"),
    @NamedQuery(name = "ProjectUserDetails.findByProjectUserId", query = "SELECT p FROM ProjectUserDetails p WHERE p.projectUserId = :projectUserId")})
public class ProjectUserDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_user_id")
    private Integer projectUserId;
    @JoinColumn(name = "mine_id", referencedColumnName = "mine_id")
    @ManyToOne(optional = false)
    private ProjectDetails mineId;
    @JoinColumn(name = "user_id_to", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private LoginInfo userIdTo;

    public ProjectUserDetails() {
    }

    public ProjectUserDetails(Integer projectUserId) {
        this.projectUserId = projectUserId;
    }

    public Integer getProjectUserId() {
        return projectUserId;
    }

    public void setProjectUserId(Integer projectUserId) {
        this.projectUserId = projectUserId;
    }

    public ProjectDetails getMineId() {
        return mineId;
    }

    public void setMineId(ProjectDetails mineId) {
        this.mineId = mineId;
    }

    public LoginInfo getUserIdTo() {
        return userIdTo;
    }

    public void setUserIdTo(LoginInfo userIdTo) {
        this.userIdTo = userIdTo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectUserId != null ? projectUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectUserDetails)) {
            return false;
        }
        ProjectUserDetails other = (ProjectUserDetails) object;
        if ((this.projectUserId == null && other.projectUserId != null) || (this.projectUserId != null && !this.projectUserId.equals(other.projectUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ProjectUserDetails[ projectUserId=" + projectUserId + " ]";
    }
    
}
