package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inspector database table.
 * 
 */
@Entity
@NamedQuery(name="Inspector.findAll", query="SELECT i FROM Inspector i")
public class Inspector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="insp_id")
	private int inspId;

	@Column(name="insp_firstname")
	private String inspFirstname;

	@Column(name="insp_lastname")
	private String inspLastname;
	
	@Column(name="insp_username")
	private String inspUsername;
	
	@Column(name="insp_password")
	private String inspPassword;
	
	//bi-directional many-to-one association to Report
	@OneToMany(mappedBy="inspector")
	private List<Report> reports;

	public Inspector() {
	}

	public int getInspId() {
		return this.inspId;
	}

	public void setInspId(int inspId) {
		this.inspId = inspId;
	}

	public String getInspFirstname() {
		return this.inspFirstname;
	}

	public void setInspFirstname(String inspFirstname) {
		this.inspFirstname = inspFirstname;
	}

	public String getInspLastname() {
		return this.inspLastname;
	}

	public void setInspLastname(String inspLastname) {
		this.inspLastname = inspLastname;
	}

	public List<Report> getReports() {
		return this.reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Report addReport(Report report) {
		getReports().add(report);
		report.setInspector(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setInspector(null);

		return report;
	}

	public String getInspUsername() {
		return inspUsername;
	}

	public void setInspUsername(String inspUsername) {
		this.inspUsername = inspUsername;
	}

	public String getInspPassword() {
		return inspPassword;
	}

	public void setInspPassword(String inspPassword) {
		this.inspPassword = inspPassword;
	}

}