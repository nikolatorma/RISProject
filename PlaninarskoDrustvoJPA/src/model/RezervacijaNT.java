package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the RezervacijaNT database table.
 * 
 */
@Entity
@NamedQuery(name="RezervacijaNT.findAll", query="SELECT r FROM RezervacijaNT r")
public class RezervacijaNT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRezervacija;

	@Temporal(TemporalType.DATE)
	private Date datumDo;

	@Temporal(TemporalType.DATE)
	private Date datumOd;

	//bi-directional many-to-one association to DomNT
	@ManyToOne
	@JoinColumn(name="Dom_idDom")
	private DomNT domNt;

	//bi-directional many-to-one association to PlaninarNT
	@ManyToOne
	@JoinColumn(name="Planinar_idPlaninar")
	private PlaninarNT planinarNt;

	public RezervacijaNT() {
	}

	public int getIdRezervacija() {
		return this.idRezervacija;
	}

	public void setIdRezervacija(int idRezervacija) {
		this.idRezervacija = idRezervacija;
	}

	public Date getDatumDo() {
		return this.datumDo;
	}

	public void setDatumDo(Date datumDo) {
		this.datumDo = datumDo;
	}

	public Date getDatumOd() {
		return this.datumOd;
	}

	public void setDatumOd(Date datumOd) {
		this.datumOd = datumOd;
	}

	public DomNT getDomNt() {
		return this.domNt;
	}

	public void setDomNt(DomNT domNt) {
		this.domNt = domNt;
	}

	public PlaninarNT getPlaninarNt() {
		return this.planinarNt;
	}

	public void setPlaninarNt(PlaninarNT planinarNt) {
		this.planinarNt = planinarNt;
	}

}