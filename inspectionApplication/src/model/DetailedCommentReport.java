package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detailedCommentReport database table.
 * 
 */
@Entity
@NamedQuery(name="DetailedCommentReport.findAll", query="SELECT d FROM DetailedCommentReport d")
public class DetailedCommentReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DETAILEDCOMMENTREPORT_DETAILEDCOMMENTID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DETAILEDCOMMENTREPORT_DETAILEDCOMMENTID_GENERATOR")
	@Column(name="detailedcomment_id")
	private int detailedcommentId;

	@Lob
	private String comment1;

	@Lob
	private String comment2;

	@Lob
	private String comment3;

	@Lob
	private String comment4;

	@Lob
	private String othercomment;

	//bi-directional many-to-one association to Report
	@ManyToOne
	@JoinColumn(name="report_id")
	private Report report;

	public DetailedCommentReport() {
	}

	public int getDetailedcommentId() {
		return this.detailedcommentId;
	}

	public void setDetailedcommentId(int detailedcommentId) {
		this.detailedcommentId = detailedcommentId;
	}

	public String getComment1() {
		return this.comment1;
	}

	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}

	public String getComment2() {
		return this.comment2;
	}

	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}

	public String getComment3() {
		return this.comment3;
	}

	public void setComment3(String comment3) {
		this.comment3 = comment3;
	}

	public String getComment4() {
		return this.comment4;
	}

	public void setComment4(String comment4) {
		this.comment4 = comment4;
	}

	public String getOthercomment() {
		return this.othercomment;
	}

	public void setOthercomment(String othercomment) {
		this.othercomment = othercomment;
	}

	public Report getReport() {
		return this.report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

}