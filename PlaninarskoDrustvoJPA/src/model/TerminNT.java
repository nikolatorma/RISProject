package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TerminNT database table.
 * 
 */
@Entity
@NamedQuery(name="TerminNT.findAll", query="SELECT t FROM TerminNT t")
public class TerminNT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTermin;

	@Temporal(TemporalType.DATE)
	private Date datumObilaska;

	//bi-directional many-to-one association to PlaninarNT
	@ManyToOne
	@JoinColumn(name="Planinar_idPlaninar")
	private PlaninarNT planinarNt;

	//bi-directional many-to-one association to ZnamenitostNT
	@ManyToOne
	@JoinColumn(name="Znamenitost_idZnamenitost")
	private ZnamenitostNT znamenitostNt;

	public TerminNT() {
	}

	public int getIdTermin() {
		return this.idTermin;
	}

	public void setIdTermin(int idTermin) {
		this.idTermin = idTermin;
	}

	public Date getDatumObilaska() {
		return this.datumObilaska;
	}

	public void setDatumObilaska(Date datumObilaska) {
		this.datumObilaska = datumObilaska;
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