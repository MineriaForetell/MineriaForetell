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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author raxton
 */
@Entity
@Table(name = "MiningDrillDataToExport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MiningDrillDataToExport.findAll", query = "SELECT m FROM MiningDrillDataToExport m"),
    @NamedQuery(name = "MiningDrillDataToExport.findByPointZ", query = "SELECT m FROM MiningDrillDataToExport m WHERE m.pointZ = :pointZ"),
    @NamedQuery(name = "MiningDrillDataToExport.findByPointY", query = "SELECT m FROM MiningDrillDataToExport m WHERE m.pointY = :pointY"),
    @NamedQuery(name = "MiningDrillDataToExport.findByPointX", query = "SELECT m FROM MiningDrillDataToExport m WHERE m.pointX = :pointX"),
    @NamedQuery(name = "MiningDrillDataToExport.findByMaterial", query = "SELECT m FROM MiningDrillDataToExport m WHERE m.material = :material"),
    @NamedQuery(name = "MiningDrillDataToExport.findByReadingid", query = "SELECT m FROM MiningDrillDataToExport m WHERE m.readingid = :readingid")})
public class MiningDrillDataToExport implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PointZ")
    private Double pointZ;
    @Column(name = "PointY")
    private Double pointY;
    @Column(name = "PointX")
    private Double pointX;
    @Column(name = "Material")
    private String material;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Reading_id")
    private Integer readingid;

    public MiningDrillDataToExport() {
    }

    public MiningDrillDataToExport(Integer readingid) {
        this.readingid = readingid;
    }

    public Double getPointZ() {
        return pointZ;
    }

    public void setPointZ(Double pointZ) {
        this.pointZ = pointZ;
    }

    public Double getPointY() {
        return pointY;
    }

    public void setPointY(Double pointY) {
        this.pointY = pointY;
    }

    public Double getPointX() {
        return pointX;
    }

    public void setPointX(Double pointX) {
        this.pointX = pointX;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getReadingid() {
        return readingid;
    }

    public void setReadingid(Integer readingid) {
        this.readingid = readingid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (readingid != null ? readingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MiningDrillDataToExport)) {
            return false;
        }
        MiningDrillDataToExport other = (MiningDrillDataToExport) object;
        if ((this.readingid == null && other.readingid != null) || (this.readingid != null && !this.readingid.equals(other.readingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.MiningDrillDataToExport[ readingid=" + readingid + " ]";
    }
    
}
