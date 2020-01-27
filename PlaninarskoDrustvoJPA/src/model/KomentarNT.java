package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the KomentarNT database table.
 * 
 */
@Entity
@NamedQuery(name="KomentarNT.findAll", query="SELECT k FROM KomentarNT k")
public class KomentarNT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKomentar;

	@Lob
	private String komentar;

	//bi-directional many-to-one association to PlaninarNT
	@ManyToOne
	@JoinColumn(name="Planinar_idPlaninar")
	private PlaninarNT planinarNt;

	//bi-directional many-to-one association to ZnamenitostNT
	@ManyToOne
	@JoinColumn(name="Znamenitost_idZnamenitost")
	private ZnamenitostNT znamenitostNt;

	public KomentarNT() {
	}

	public int getIdKomentar() {
		return this.idKomentar;
	}

	public void setIdKomentar(int idKomentar) {
		this.idKomentar = idKomentar;
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public PlaninarNT getPlaninarNt() {
		return this.planinarNt;
	}

	public void setPlaninarNt(PlaninarNT planinarNt) {
		this.planinarNt = planinarNt;
	}

	public ZnamenitostNT getZnamenitostNt() {
		return this.znamenitostNt;
	}

	public void setZnamenitostNt(ZnamenitostNT znamenitostNt) {
		this.znamenitostNt = znamenitostNt;
	}

}