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
@Table(name = "point_readings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PointReadings.findAll", query = "SELECT p FROM PointReadings p"),
    @NamedQuery(name = "PointReadings.findByReadingId", query = "SELECT p FROM PointReadings p WHERE p.readingId = :readingId"),
    @NamedQuery(name = "PointReadings.findByDepth", query = "SELECT p FROM PointReadings p WHERE p.depth = :depth"),
    @NamedQuery(name = "PointReadings.findByExpectedMineral", query = "SELECT p FROM PointReadings p WHERE p.expectedMineral = :expectedMineral"),
    @NamedQuery(name = "PointReadings.findByBackForce", query = "SELECT p FROM PointReadings p WHERE p.backForce = :backForce")})
public class PointReadings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reading_id")
    private Integer readingId;
    @Basic(optional = false)
    @Column(name = "depth")
    private float depth;
    @Column(name = "expected_mineral")
    private String expectedMineral;
    @Basic(optional = false)
    @Column(name = "back_force")
    private float backForce;
    @JoinColumn(name = "point_id", referencedColumnName = "task_point_id")
    @ManyToOne(optional = false)
    private PointDetails pointId;

    public PointReadings() {
    }

    public PointReadings(Integer readingId) {
        this.readingId = readingId;
    }

    public PointReadings(Integer readingId, float depth, float backForce) {
        this.readingId = readingId;
        this.depth = depth;
        this.backForce = backForce;
    }

    public Integer getReadingId() {
        return readingId;
    }

    public void setReadingId(Integer readingId) {
        this.readingId = readingId;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public String getExpectedMineral() {
        return expectedMineral;
    }

    public void setExpectedMineral(String expectedMineral) {
        this.expectedMineral = expectedMineral;
    }

    public float getBackForce() {
        return backForce;
    }

    public void setBackForce(float backForce) {
        this.backForce = backForce;
    }

    public PointDetails getPointId() {
        return pointId;
    }

    public void setPointId(PointDetails pointId) {
        this.pointId = pointId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (readingId != null ? readingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PointReadings)) {
            return false;
        }
        PointReadings other = (PointReadings) object;
        if ((this.readingId == null && other.readingId != null) || (this.readingId != null && !this.readingId.equals(other.readingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.PointReadings[ readingId=" + readingId + " ]";
    }
    
}
