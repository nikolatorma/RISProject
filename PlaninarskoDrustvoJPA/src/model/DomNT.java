package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DomNT database table.
 * 
 */
@Entity
@NamedQuery(name="DomNT.findAll", query="SELECT d FROM DomNT d")
public class DomNT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDom;

	private int brojSlobodnihMesta;

	private int kapacitetDoma;

	private String nazivDoma;

	//bi-directional many-to-one association to PlaninaNT
	@ManyToOne
	@JoinColumn(name="Planina_idPlanina")
	private PlaninaNT planinaNt;

	//bi-directional many-to-one association to RezervacijaNT
	@OneToMany(mappedBy="domNt")
	private List<RezervacijaNT> rezervacijaNts;

	public DomNT() {
	}

	public int getIdDom() {
		return this.idDom;
	}

	public void setIdDom(int idDom) {
		this.idDom = idDom;
	}

	public int getBrojSlobodnihMesta() {
		return this.brojSlobodnihMesta;
	}

	public void setBrojSlobodnihMesta(int brojSlobodnihMesta) {
		this.brojSlobodnihMesta = brojSlobodnihMesta;
	}

	public int getKapacitetDoma() {
		return this.kapacitetDoma;
	}

	public void setKapacitetDoma(int kapacitetDoma) {
		this.kapacitetDoma = kapacitetDoma;
	}

	public String getNazivDoma() {
		return this.nazivDoma;
	}

	public void setNazivDoma(String nazivDoma) {
		this.nazivDoma = nazivDoma;
	}

	public PlaninaNT getPlaninaNt() {
		return this.planinaNt;
	}

	public void setPlaninaNt(PlaninaNT planinaNt) {
		this.planinaNt = planinaNt;
	}

	public List<RezervacijaNT> getRezervacijaNts() {
		return this.rezervacijaNts;
	}

	public void setRezervacijaNts(List<RezervacijaNT> rezervacijaNts) {
		this.rezervacijaNts = rezervacijaNts;
	}

	public RezervacijaNT addRezervacijaNt(RezervacijaNT rezervacijaNt) {
		getRezervacijaNts().add(rezervacijaNt);
		rezervacijaNt.setDomNt(this);

		return rezervacijaNt;
	}

	public RezervacijaNT removeRezervacijaNt(RezervacijaNT rezervacijaNt) {
		getRezervacijaNts().remove(rezervacijaNt);
		rezervacijaNt.setDomNt(null);

		return rezervacijaNt;
	}

}