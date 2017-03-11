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
@Table(name = "point_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PointDetails.findAll", query = "SELECT p FROM PointDetails p"),
    @NamedQuery(name = "PointDetails.findByTaskPointId", query = "SELECT p FROM PointDetails p WHERE p.taskPointId = :taskPointId"),
    @NamedQuery(name = "PointDetails.findByPointId", query = "SELECT p FROM PointDetails p WHERE p.pointId = :pointId"),
    @NamedQuery(name = "PointDetails.findByPointLocation", query = "SELECT p FROM PointDetails p WHERE p.pointLocation = :pointLocation")})
public class PointDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "task_point_id")
    private Integer taskPointId;
    @Basic(optional = false)
    @Column(name = "point_id")
    private int pointId;
    @Basic(optional = false)
    @Column(name = "point_location")
    private String pointLocation;
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    @ManyToOne(optional = false)
    private TaskDetails taskId;
    @JoinColumn(name = "mine_id", referencedColumnName = "mine_id")
    @ManyToOne(optional = false)
    private ProjectDetails mineId;

    public PointDetails() {
    }

    public PointDetails(Integer taskPointId) {
        this.taskPointId = taskPointId;
    }

    public PointDetails(Integer taskPointId, int pointId, String pointLocation) {
        this.taskPointId = taskPointId;
        this.pointId = pointId;
        this.pointLocation = pointLocation;
    }

    public Integer getTaskPointId() {
        return taskPointId;
    }

    public void setTaskPointId(Integer taskPointId) {
        this.taskPointId = taskPointId;
    }

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public String getPointLocation() {
        return pointLocation;
    }

    public void setPointLocation(String pointLocation) {
        this.pointLocation = pointLocation;
    }

    public TaskDetails getTaskId() {
        return taskId;
    }

    public void setTaskId(TaskDetails taskId) {
        this.taskId = taskId;
    }

    public ProjectDetails getMineId() {
        return mineId;
    }

    public void setMineId(ProjectDetails mineId) {
        this.mineId = mineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskPointId != null ? taskPointId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PointDetails)) {
            return false;
        }
        PointDetails other = (PointDetails) object;
        if ((this.taskPointId == null && other.taskPointId != null) || (this.taskPointId != null && !this.taskPointId.equals(other.taskPointId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.PointDetails[ taskPointId=" + taskPointId + " ]";
    }
    
}
