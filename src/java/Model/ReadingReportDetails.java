/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author raxton
 */
@Entity
@Table(name = "reading_report_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReadingReportDetails.findAll", query = "SELECT r FROM ReadingReportDetails r"),
    @NamedQuery(name = "ReadingReportDetails.findByReportId", query = "SELECT r FROM ReadingReportDetails r WHERE r.reportId = :reportId"),
    @NamedQuery(name = "ReadingReportDetails.findByReportPath", query = "SELECT r FROM ReadingReportDetails r WHERE r.reportPath = :reportPath"),
    @NamedQuery(name = "ReadingReportDetails.findByUploadDate", query = "SELECT r FROM ReadingReportDetails r WHERE r.uploadDate = :uploadDate")})
public class ReadingReportDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "report_id")
    private Integer reportId;
    @Basic(optional = false)
    @Column(name = "report_path")
    private String reportPath;
    @Basic(optional = false)
    @Column(name = "upload_date")
    @Temporal(TemporalType.DATE)
    private Date uploadDate;
    @JoinColumn(name = "mine_id", referencedColumnName = "mine_id")
    @ManyToOne(optional = false)
    private ProjectDetails mineId;

    public ReadingReportDetails() {
    }

    public ReadingReportDetails(Integer reportId) {
        this.reportId = reportId;
    }

    public ReadingReportDetails(Integer reportId, String reportPath, Date uploadDate) {
        this.reportId = reportId;
        this.reportPath = reportPath;
        this.uploadDate = uploadDate;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
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
        hash += (reportId != null ? reportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReadingReportDetails)) {
            return false;
        }
        ReadingReportDetails other = (ReadingReportDetails) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ReadingReportDetails[ reportId=" + reportId + " ]";
    }
    
}
