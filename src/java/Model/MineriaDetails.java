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
@Table(name = "mineria_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MineriaDetails.findAll", query = "SELECT m FROM MineriaDetails m"),
    @NamedQuery(name = "MineriaDetails.findByMineralId", query = "SELECT m FROM MineriaDetails m WHERE m.mineralId = :mineralId"),
    @NamedQuery(name = "MineriaDetails.findByExpectedMineral", query = "SELECT m FROM MineriaDetails m WHERE m.expectedMineral = :expectedMineral"),
    @NamedQuery(name = "MineriaDetails.findByQuantity", query = "SELECT m FROM MineriaDetails m WHERE m.quantity = :quantity"),
    @NamedQuery(name = "MineriaDetails.findByCost", query = "SELECT m FROM MineriaDetails m WHERE m.cost = :cost")})
public class MineriaDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mineral_id")
    private Integer mineralId;
    @Basic(optional = false)
    @Column(name = "expected_mineral")
    private String expectedMineral;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "cost")
    private float cost;
    @JoinColumn(name = "mine_id", referencedColumnName = "mine_id")
    @ManyToOne(optional = false)
    private ProjectDetails mineId;

    public MineriaDetails() {
    }

    public MineriaDetails(Integer mineralId) {
        this.mineralId = mineralId;
    }

    public MineriaDetails(Integer mineralId, String expectedMineral, int quantity, float cost) {
        this.mineralId = mineralId;
        this.expectedMineral = expectedMineral;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Integer getMineralId() {
        return mineralId;
    }

    public void setMineralId(Integer mineralId) {
        this.mineralId = mineralId;
    }

    public String getExpectedMineral() {
        return expectedMineral;
    }

    public void setExpectedMineral(String expectedMineral) {
        this.expectedMineral = expectedMineral;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
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
        hash += (mineralId != null ? mineralId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MineriaDetails)) {
            return false;
        }
        MineriaDetails other = (MineriaDetails) object;
        if ((this.mineralId == null && other.mineralId != null) || (this.mineralId != null && !this.mineralId.equals(other.mineralId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.MineriaDetails[ mineralId=" + mineralId + " ]";
    }
    
}
