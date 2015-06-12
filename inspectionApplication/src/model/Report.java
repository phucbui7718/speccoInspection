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

	//bi-directional many-to-one association to Swpppreport
	@OneToMany(mappedBy="report")
	private List<Swpppreport> swpppreports;

	//bi-directional many-to-one association to Bmpreport
	@OneToMany(mappedBy="report")
	private List<BmpReport> bmpreports;

	//bi-directional many-to-one association to DetailedCommentReport
	@OneToMany(mappedBy="report")
	private List<DetailedCommentReport> detailedCommentReports;

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

	public List<Swpppreport> getSwpppreports() {
		return this.swpppreports;
	}

	public void setSwpppreports(List<Swpppreport> swpppreports) {
		this.swpppreports = swpppreports;
	}

	public Swpppreport addSwpppreport(Swpppreport swpppreport) {
		getSwpppreports().add(swpppreport);
		swpppreport.setReport(this);

		return swpppreport;
	}

	public Swpppreport removeSwpppreport(Swpppreport swpppreport) {
		getSwpppreports().remove(swpppreport);
		swpppreport.setReport(null);

		return swpppreport;
	}

	public List<BmpReport> getBmpReports() {
		return this.bmpreports;
	}

	public void setBmpreports(List<BmpReport> bmpreports) {
		this.bmpreports = bmpreports;
	}

	public BmpReport addBmpreport(BmpReport bmpreport) {
		getBmpReports().add(bmpreport);
		bmpreport.setReport(this);

		return bmpreport;
	}

	public BmpReport removeBmpreport(BmpReport bmpreport) {
		getBmpReports().remove(bmpreport);
		bmpreport.setReport(null);

		return bmpreport;
	}

	public List<DetailedCommentReport> getDetailedCommentReports() {
		return this.detailedCommentReports;
	}

	public void setDetailedCommentReports(List<DetailedCommentReport> detailedCommentReports) {
		this.detailedCommentReports = detailedCommentReports;
	}

	public DetailedCommentReport addDetailedCommentReport(DetailedCommentReport detailedCommentReport) {
		getDetailedCommentReports().add(detailedCommentReport);
		detailedCommentReport.setReport(this);

		return detailedCommentReport;
	}

	public DetailedCommentReport removeDetailedCommentReport(DetailedCommentReport detailedCommentReport) {
		getDetailedCommentReports().remove(detailedCommentReport);
		detailedCommentReport.setReport(null);

		return detailedCommentReport;
	}

}