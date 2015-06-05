package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bmpReport database table.
 * 
 */
@Entity
@NamedQuery(name="BmpReport.findAll", query="SELECT b FROM BmpReport b")
public class BmpReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BMPREPORT_BMP_REPORTID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BMPREPORT_BMP_REPORTID_GENERATOR")
	private int bmp_ReportID;

	@Column(name="bmp_line1")
	private String bmpLine1;

	@Column(name="bmp_line10")
	private String bmpLine10;

	@Column(name="bmp_line2")
	private String bmpLine2;

	@Column(name="bmp_line3")
	private String bmpLine3;

	@Column(name="bmp_line4")
	private String bmpLine4;

	@Column(name="bmp_line5")
	private String bmpLine5;

	@Column(name="bmp_line6")
	private String bmpLine6;

	@Column(name="bmp_line7")
	private String bmpLine7;

	@Column(name="bmp_line8")
	private String bmpLine8;

	@Column(name="bmp_line9")
	private String bmpLine9;

	//bi-directional many-to-one association to Report
	@ManyToOne
	@JoinColumn(name="report_id")
	private Report report;

	public BmpReport() {
	}

	public int getBmp_ReportID() {
		return this.bmp_ReportID;
	}

	public void setBmp_ReportID(int bmp_ReportID) {
		this.bmp_ReportID = bmp_ReportID;
	}

	public String getBmpLine1() {
		return this.bmpLine1;
	}

	public void setBmpLine1(String bmpLine1) {
		this.bmpLine1 = bmpLine1;
	}

	public String getBmpLine10() {
		return this.bmpLine10;
	}

	public void setBmpLine10(String bmpLine10) {
		this.bmpLine10 = bmpLine10;
	}

	public String getBmpLine2() {
		return this.bmpLine2;
	}

	public void setBmpLine2(String bmpLine2) {
		this.bmpLine2 = bmpLine2;
	}

	public String getBmpLine3() {
		return this.bmpLine3;
	}

	public void setBmpLine3(String bmpLine3) {
		this.bmpLine3 = bmpLine3;
	}

	public String getBmpLine4() {
		return this.bmpLine4;
	}

	public void setBmpLine4(String bmpLine4) {
		this.bmpLine4 = bmpLine4;
	}

	public String getBmpLine5() {
		return this.bmpLine5;
	}

	public void setBmpLine5(String bmpLine5) {
		this.bmpLine5 = bmpLine5;
	}

	public String getBmpLine6() {
		return this.bmpLine6;
	}

	public void setBmpLine6(String bmpLine6) {
		this.bmpLine6 = bmpLine6;
	}

	public String getBmpLine7() {
		return this.bmpLine7;
	}

	public void setBmpLine7(String bmpLine7) {
		this.bmpLine7 = bmpLine7;
	}

	public String getBmpLine8() {
		return this.bmpLine8;
	}

	public void setBmpLine8(String bmpLine8) {
		this.bmpLine8 = bmpLine8;
	}

	public String getBmpLine9() {
		return this.bmpLine9;
	}

	public void setBmpLine9(String bmpLine9) {
		this.bmpLine9 = bmpLine9;
	}

	public Report getReport() {
		return this.report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

}