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
@Table(name = "file_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FileDetails.findAll", query = "SELECT f FROM FileDetails f"),
    @NamedQuery(name = "FileDetails.findByFileId", query = "SELECT f FROM FileDetails f WHERE f.fileId = :fileId"),
    @NamedQuery(name = "FileDetails.findByFilePath", query = "SELECT f FROM FileDetails f WHERE f.filePath = :filePath"),
    @NamedQuery(name = "FileDetails.findByStatus", query = "SELECT f FROM FileDetails f WHERE f.status = :status")})
public class FileDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "file_id")
    private Integer fileId;
    @Basic(optional = false)
    @Column(name = "file_path")
    private String filePath;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "point_id", referencedColumnName = "task_point_id")
    @ManyToOne(optional = false)
    private PointDetails pointId;

    public FileDetails() {
    }

    public FileDetails(Integer fileId) {
        this.fileId = fileId;
    }

    public FileDetails(Integer fileId, String filePath, String status) {
        this.fileId = fileId;
        this.filePath = filePath;
        this.status = status;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        hash += (fileId != null ? fileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FileDetails)) {
            return false;
        }
        FileDetails other = (FileDetails) object;
        if ((this.fileId == null && other.fileId != null) || (this.fileId != null && !this.fileId.equals(other.fileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.FileDetails[ fileId=" + fileId + " ]";
    }
    
}
