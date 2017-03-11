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
@Table(name = "task_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaskDetails.findAll", query = "SELECT t FROM TaskDetails t"),
    @NamedQuery(name = "TaskDetails.findByTaskId", query = "SELECT t FROM TaskDetails t WHERE t.taskId = :taskId"),
    @NamedQuery(name = "TaskDetails.findByDueDate", query = "SELECT t FROM TaskDetails t WHERE t.dueDate = :dueDate"),
    @NamedQuery(name = "TaskDetails.findByDepth", query = "SELECT t FROM TaskDetails t WHERE t.depth = :depth"),
    @NamedQuery(name = "TaskDetails.findByPoints", query = "SELECT t FROM TaskDetails t WHERE t.points = :points")})
public class TaskDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "task_id")
    private Integer taskId;
    @Basic(optional = false)
    @Column(name = "due_date")
    private String dueDate;
    @Basic(optional = false)
    @Column(name = "depth")
    private float depth;
    @Basic(optional = false)
    @Column(name = "points")
    private int points;
    @JoinColumn(name = "mine_id", referencedColumnName = "mine_id")
    @ManyToOne(optional = false)
    private ProjectDetails mineId;
    @JoinColumn(name = "user_id_to", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private LoginInfo userIdTo;
    @JoinColumn(name = "user_id_from", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private LoginInfo userIdFrom;

    public TaskDetails() {
    }

    public TaskDetails(Integer taskId) {
        this.taskId = taskId;
    }

    public TaskDetails(Integer taskId, String dueDate, float depth, int points) {
        this.taskId = taskId;
        this.dueDate = dueDate;
        this.depth = depth;
        this.points = points;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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

    public LoginInfo getUserIdFrom() {
        return userIdFrom;
    }

    public void setUserIdFrom(LoginInfo userIdFrom) {
        this.userIdFrom = userIdFrom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskDetails)) {
            return false;
        }
        TaskDetails other = (TaskDetails) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.TaskDetails[ taskId=" + taskId + " ]";
    }
    
}
