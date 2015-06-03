package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the REPORT database table.
 * 
 */
@Entity
@NamedQuery(name="Report.findAll", query="SELECT r FROM Report r")
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPORT_REPORTID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPORT_REPORTID_GENERATOR")
	@Column(name="report_id")
	private int reportId;

	@Column(name="report_date")
	private String reportDate;

	@Column(name="report_location")
	private String reportLocation;

	//bi-directional many-to-one association to Inspector
	@ManyToOne
	@JoinColumn(name="insp_id")
	private Inspector inspector;

	//bi-directional many-to-one association to SwpppReport
	@OneToMany(mappedBy="report")
	private List<SwpppReport> swpppReports;

	public Report() {
	}

	public int getReportId() {
		return this.reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportLocation() {
		return this.reportLocation;
	}

	public void setReportLocation(String reportLocation) {
		this.reportLocation = reportLocation;
	}

	public Inspector getInspector() {
		return this.inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

	public List<SwpppReport> getSwpppReports() {
		return this.swpppReports;
	}

	public void setSwpppReports(List<SwpppReport> swpppReports) {
		this.swpppReports = swpppReports;
	}

	public SwpppReport addSwpppReport(SwpppReport swpppReport) {
		getSwpppReports().add(swpppReport);
		swpppReport.setReport(this);

		return swpppReport;
	}

	public SwpppReport removeSwpppReport(SwpppReport swpppReport) {
		getSwpppReports().remove(swpppReport);
		swpppReport.setReport(null);

		return swpppReport;
	}

}