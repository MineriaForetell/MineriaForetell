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
@Table(name = "estimated_profit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstimatedProfit.findAll", query = "SELECT e FROM EstimatedProfit e"),
    @NamedQuery(name = "EstimatedProfit.findByEId", query = "SELECT e FROM EstimatedProfit e WHERE e.eId = :eId"),
    @NamedQuery(name = "EstimatedProfit.findByMiningCost", query = "SELECT e FROM EstimatedProfit e WHERE e.miningCost = :miningCost"),
    @NamedQuery(name = "EstimatedProfit.findByExpectedProfit", query = "SELECT e FROM EstimatedProfit e WHERE e.expectedProfit = :expectedProfit")})
public class EstimatedProfit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "e_id")
    private Integer eId;
    @Basic(optional = false)
    @Column(name = "mining_cost")
    private String miningCost;
    @Column(name = "expected_profit")
    private String expectedProfit;
    @JoinColumn(name = "mine_id", referencedColumnName = "mine_id")
    @ManyToOne(optional = false)
    private ProjectDetails mineId;

    public EstimatedProfit() {
    }

    public EstimatedProfit(Integer eId) {
        this.eId = eId;
    }

    public EstimatedProfit(Integer eId, String miningCost) {
        this.eId = eId;
        this.miningCost = miningCost;
    }

    public Integer getEId() {
        return eId;
    }

    public void setEId(Integer eId) {
        this.eId = eId;
    }

    public String getMiningCost() {
        return miningCost;
    }

    public void setMiningCost(String miningCost) {
        this.miningCost = miningCost;
    }

    public String getExpectedProfit() {
        return expectedProfit;
    }

    public void setExpectedProfit(String expectedProfit) {
        this.expectedProfit = expectedProfit;
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
        hash += (eId != null ? eId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstimatedProfit)) {
            return false;
        }
        EstimatedProfit other = (EstimatedProfit) object;
        if ((this.eId == null && other.eId != null) || (this.eId != null && !this.eId.equals(other.eId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.EstimatedProfit[ eId=" + eId + " ]";
    }
    
}
