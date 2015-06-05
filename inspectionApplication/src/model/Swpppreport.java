package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SWPPPREPORT database table.
 * 
 */
@Entity
@NamedQuery(name="Swpppreport.findAll", query="SELECT s FROM Swpppreport s")
public class Swpppreport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SWPPPREPORT_SWPPPREPORTID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SWPPPREPORT_SWPPPREPORTID_GENERATOR")
	@Column(name="SWPPP_REPORTID")
	private int swpppReportid;

	@Column(name="swppp_line1")
	private String swpppLine1;

	@Column(name="swppp_line10")
	private String swpppLine10;

	@Column(name="swppp_line11")
	private String swpppLine11;

	@Column(name="swppp_line2")
	private String swpppLine2;

	@Column(name="swppp_line3")
	private String swpppLine3;

	@Column(name="swppp_line4")
	private String swpppLine4;

	@Column(name="swppp_line5")
	private String swpppLine5;

	@Column(name="swppp_line6")
	private String swpppLine6;

	@Column(name="swppp_line7")
	private String swpppLine7;

	@Column(name="swppp_line8")
	private String swpppLine8;

	@Column(name="swppp_line9")
	private String swpppLine9;

	//bi-directional many-to-one association to Report
	@ManyToOne
	@JoinColumn(name="report_id")
	private Report report;

	public Swpppreport() {
	}

	public int getSwpppReportid() {
		return this.swpppReportid;
	}

	public void setSwpppReportid(int swpppReportid) {
		this.swpppReportid = swpppReportid;
	}

	public String getSwpppLine1() {
		return this.swpppLine1;
	}

	public void setSwpppLine1(String swpppLine1) {
		this.swpppLine1 = swpppLine1;
	}

	public String getSwpppLine10() {
		return this.swpppLine10;
	}

	public void setSwpppLine10(String swpppLine10) {
		this.swpppLine10 = swpppLine10;
	}

	public String getSwpppLine11() {
		return this.swpppLine11;
	}

	public void setSwpppLine11(String swpppLine11) {
		this.swpppLine11 = swpppLine11;
	}

	public String getSwpppLine2() {
		return this.swpppLine2;
	}

	public void setSwpppLine2(String swpppLine2) {
		this.swpppLine2 = swpppLine2;
	}

	public String getSwpppLine3() {
		return this.swpppLine3;
	}

	public void setSwpppLine3(String swpppLine3) {
		this.swpppLine3 = swpppLine3;
	}

	public String getSwpppLine4() {
		return this.swpppLine4;
	}

	public void setSwpppLine4(String swpppLine4) {
		this.swpppLine4 = swpppLine4;
	}

	public String getSwpppLine5() {
		return this.swpppLine5;
	}

	public void setSwpppLine5(String swpppLine5) {
		this.swpppLine5 = swpppLine5;
	}

	public String getSwpppLine6() {
		return this.swpppLine6;
	}

	public void setSwpppLine6(String swpppLine6) {
		this.swpppLine6 = swpppLine6;
	}

	public String getSwpppLine7() {
		return this.swpppLine7;
	}

	public void setSwpppLine7(String swpppLine7) {
		this.swpppLine7 = swpppLine7;
	}

	public String getSwpppLine8() {
		return this.swpppLine8;
	}

	public void setSwpppLine8(String swpppLine8) {
		this.swpppLine8 = swpppLine8;
	}

	public String getSwpppLine9() {
		return this.swpppLine9;
	}

	public void setSwpppLine9(String swpppLine9) {
		this.swpppLine9 = swpppLine9;
	}

	public Report getReport() {
		return this.report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

}