package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MapaNT database table.
 * 
 */
@Entity
@NamedQuery(name="MapaNT.findAll", query="SELECT m FROM MapaNT m")
public class MapaNT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMapa;

	private String putanjaM;

	//bi-directional many-to-one association to StazaNT
	@ManyToOne
	@JoinColumn(name="Staza_idStaza")
	private StazaNT stazaNt;

	public MapaNT() {
	}

	public int getIdMapa() {
		return this.idMapa;
	}

	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
	}

	public String getPutanjaM() {
		return this.putanjaM;
	}

	public void setPutanjaM(String putanjaM) {
		this.putanjaM = putanjaM;
	}

	public StazaNT getStazaNt() {
		return this.stazaNt;
	}

	public void setStazaNt(StazaNT stazaNt) {
		this.stazaNt = stazaNt;
	}

}