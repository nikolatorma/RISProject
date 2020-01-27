package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the StazaNT database table.
 * 
 */
@Entity
@NamedQuery(name="StazaNT.findAll", query="SELECT s FROM StazaNT s")
public class StazaNT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStaza;

	@Lob
	private String opisStaze;

	private String tezinaStaze;

	//bi-directional many-to-one association to MapaNT
	@OneToMany(mappedBy="stazaNt")
	private List<MapaNT> mapaNts;

	//bi-directional many-to-one association to PlaninaNT
	@ManyToOne
	@JoinColumn(name="Planina_idPlanina")
	private PlaninaNT planinaNt;

	//bi-directional many-to-one association to ZnamenitostNT
	@OneToMany(mappedBy="stazaNt")
	private List<ZnamenitostNT> znamenitostNts;

	public StazaNT() {
	}

	public int getIdStaza() {
		return this.idStaza;
	}

	public void setIdStaza(int idStaza) {
		this.idStaza = idStaza;
	}

	public String getOpisStaze() {
		return this.opisStaze;
	}

	public void setOpisStaze(String opisStaze) {
		this.opisStaze = opisStaze;
	}

	public String getTezinaStaze() {
		return this.tezinaStaze;
	}

	public void setTezinaStaze(String tezinaStaze) {
		this.tezinaStaze = tezinaStaze;
	}

	public List<MapaNT> getMapaNts() {
		return this.mapaNts;
	}

	public void setMapaNts(List<MapaNT> mapaNts) {
		this.mapaNts = mapaNts;
	}

	public MapaNT addMapaNt(MapaNT mapaNt) {
		getMapaNts().add(mapaNt);
		mapaNt.setStazaNt(this);

		return mapaNt;
	}

	public MapaNT removeMapaNt(MapaNT mapaNt) {
		getMapaNts().remove(mapaNt);
		mapaNt.setStazaNt(null);

		return mapaNt;
	}

	public PlaninaNT getPlaninaNt() {
		return this.planinaNt;
	}

	public void setPlaninaNt(PlaninaNT planinaNt) {
		this.planinaNt = planinaNt;
	}

	public List<ZnamenitostNT> getZnamenitostNts() {
		return this.znamenitostNts;
	}

	public void setZnamenitostNts(List<ZnamenitostNT> znamenitostNts) {
		this.znamenitostNts = znamenitostNts;
	}

	public ZnamenitostNT addZnamenitostNt(ZnamenitostNT znamenitostNt) {
		getZnamenitostNts().add(znamenitostNt);
		znamenitostNt.setStazaNt(this);

		return znamenitostNt;
	}

	public ZnamenitostNT removeZnamenitostNt(ZnamenitostNT znamenitostNt) {
		getZnamenitostNts().remove(znamenitostNt);
		znamenitostNt.setStazaNt(null);

		return znamenitostNt;
	}

}