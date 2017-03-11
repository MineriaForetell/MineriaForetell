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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "project_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectDetails.findAll", query = "SELECT p FROM ProjectDetails p"),
    @NamedQuery(name = "ProjectDetails.findByMineId", query = "SELECT p FROM ProjectDetails p WHERE p.mineId = :mineId"),
    @NamedQuery(name = "ProjectDetails.findByMineArea", query = "SELECT p FROM ProjectDetails p WHERE p.mineArea = :mineArea"),
    @NamedQuery(name = "ProjectDetails.findByDueDate", query = "SELECT p FROM ProjectDetails p WHERE p.dueDate = :dueDate"),
    @NamedQuery(name = "ProjectDetails.findByCompanyName", query = "SELECT p FROM ProjectDetails p WHERE p.companyName = :companyName"),
    @NamedQuery(name = "ProjectDetails.findByPoints", query = "SELECT p FROM ProjectDetails p WHERE p.points = :points"),
    @NamedQuery(name = "ProjectDetails.findByTasks", query = "SELECT p FROM ProjectDetails p WHERE p.tasks = :tasks"),
    @NamedQuery(name = "ProjectDetails.findByProjectName", query = "SELECT p FROM ProjectDetails p WHERE p.projectName = :projectName"),
    @NamedQuery(name = "ProjectDetails.findByMineLocation", query = "SELECT p FROM ProjectDetails p WHERE p.mineLocation = :mineLocation"),
    @NamedQuery(name = "ProjectDetails.findByTasksRemaining", query = "SELECT p FROM ProjectDetails p WHERE p.tasksRemaining = :tasksRemaining")})
public class ProjectDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mine_id")
    private Integer mineId;
    @Basic(optional = false)
    @Column(name = "mine_area")
    private String mineArea;
    @Basic(optional = false)
    @Column(name = "due_date")
    private String dueDate;
    @Basic(optional = false)
    @Column(name = "company_name")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "points")
    private int points;
    @Basic(optional = false)
    @Column(name = "tasks")
    private int tasks;
    @Basic(optional = false)
    @Column(name = "project_name")
    private String projectName;
    @Basic(optional = false)
    @Column(name = "mine_location")
    private String mineLocation;
    @Basic(optional = false)
    @Column(name = "tasks_remaining")
    private int tasksRemaining;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mineId")
    private Collection<TaskDetails> taskDetailsCollection;
    @JoinColumn(name = "user_id_from", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private LoginInfo userIdFrom;

    public ProjectDetails() {
    }

    public ProjectDetails(Integer mineId) {
        this.mineId = mineId;
    }

    public ProjectDetails(Integer mineId, String mineArea, String dueDate, String companyName, int points, int tasks, String projectName, String mineLocation, int tasksRemaining) {
        this.mineId = mineId;
        this.mineArea = mineArea;
        this.dueDate = dueDate;
        this.companyName = companyName;
        this.points = points;
        this.tasks = tasks;
        this.projectName = projectName;
        this.mineLocation = mineLocation;
        this.tasksRemaining = tasksRemaining;
    }

    public Integer getMineId() {
        return mineId;
    }

    public void setMineId(Integer mineId) {
        this.mineId = mineId;
    }

    public String getMineArea() {
        return mineArea;
    }

    public void setMineArea(String mineArea) {
        this.mineArea = mineArea;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTasks() {
        return tasks;
    }

    public void setTasks(int tasks) {
        this.tasks = tasks;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getMineLocation() {
        return mineLocation;
    }

    public void setMineLocation(String mineLocation) {
        this.mineLocation = mineLocation;
    }

    public int getTasksRemaining() {
        return tasksRemaining;
    }

    public void setTasksRemaining(int tasksRemaining) {
        this.tasksRemaining = tasksRemaining;
    }

    @XmlTransient
    public Collection<TaskDetails> getTaskDetailsCollection() {
        return taskDetailsCollection;
    }

    public void setTaskDetailsCollection(Collection<TaskDetails> taskDetailsCollection) {
        this.taskDetailsCollection = taskDetailsCollection;
    }

    public LoginInfo getUserIdFrom() {
        return userIdFrom;
    }

    public void setUserIdFrom(LoginInfo userIdFrom) {
        this.userIdFrom = userIdFrom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mineId != null ? mineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectDetails)) {
            return false;
        }
        ProjectDetails other = (ProjectDetails) object;
        if ((this.mineId == null && other.mineId != null) || (this.mineId != null && !this.mineId.equals(other.mineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ProjectDetails[ mineId=" + mineId + " ]";
    }
    
}
