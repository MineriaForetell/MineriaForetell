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
@Table(name = "mineral_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MineralDetails.findAll", query = "SELECT m FROM MineralDetails m"),
    @NamedQuery(name = "MineralDetails.findByMineralId", query = "SELECT m FROM MineralDetails m WHERE m.mineralId = :mineralId"),
    @NamedQuery(name = "MineralDetails.findByMineId", query = "SELECT m FROM MineralDetails m WHERE m.mineId = :mineId"),
    @NamedQuery(name = "MineralDetails.findByExpectedMineral", query = "SELECT m FROM MineralDetails m WHERE m.expectedMineral = :expectedMineral"),
    @NamedQuery(name = "MineralDetails.findByQuantity", query = "SELECT m FROM MineralDetails m WHERE m.quantity = :quantity"),
    @NamedQuery(name = "MineralDetails.findByCost", query = "SELECT m FROM MineralDetails m WHERE m.cost = :cost")})
public class MineralDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mineral_id")
    private Integer mineralId;
    @Column(name = "mine_id")
    private Integer mineId;
    @Column(name = "expected_mineral")
    private Integer expectedMineral;
    @Column(name = "quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Double cost;

    public MineralDetails() {
    }

    public MineralDetails(Integer mineralId) {
        this.mineralId = mineralId;
    }

    public Integer getMineralId() {
        return mineralId;
    }

    public void setMineralId(Integer mineralId) {
        this.mineralId = mineralId;
    }

    public Integer getMineId() {
        return mineId;
    }

    public void setMineId(Integer mineId) {
        this.mineId = mineId;
    }

    public Integer getExpectedMineral() {
        return expectedMineral;
    }

    public void setExpectedMineral(Integer expectedMineral) {
        this.expectedMineral = expectedMineral;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
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
        if (!(object instanceof MineralDetails)) {
            return false;
        }
        MineralDetails other = (MineralDetails) object;
        if ((this.mineralId == null && other.mineralId != null) || (this.mineralId != null && !this.mineralId.equals(other.mineralId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.MineralDetails[ mineralId=" + mineralId + " ]";
    }
    
}
