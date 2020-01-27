package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PlaninaNT database table.
 * 
 */
@Entity
@NamedQuery(name="PlaninaNT.findAll", query="SELECT p FROM PlaninaNT p")
public class PlaninaNT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPlanina;

	private String nazivPlanine;

	//bi-directional many-to-one association to DomNT
	@OneToMany(mappedBy="planinaNt")
	private List<DomNT> domNts;

	//bi-directional many-to-one association to PostNT
	@OneToMany(mappedBy="planinaNt")
	private List<PostNT> postNts;

	//bi-directional many-to-one association to StazaNT
	@OneToMany(mappedBy="planinaNt")
	private List<StazaNT> stazaNts;

	public PlaninaNT() {
	}

	public int getIdPlanina() {
		return this.idPlanina;
	}

	public void setIdPlanina(int idPlanina) {
		this.idPlanina = idPlanina;
	}

	public String getNazivPlanine() {
		return this.nazivPlanine;
	}

	public void setNazivPlanine(String nazivPlanine) {
		this.nazivPlanine = nazivPlanine;
	}

	public List<DomNT> getDomNts() {
		return this.domNts;
	}

	public void setDomNts(List<DomNT> domNts) {
		this.domNts = domNts;
	}

	public DomNT addDomNt(DomNT domNt) {
		getDomNts().add(domNt);
		domNt.setPlaninaNt(this);

		return domNt;
	}

	public DomNT removeDomNt(DomNT domNt) {
		getDomNts().remove(domNt);
		domNt.setPlaninaNt(null);

		return domNt;
	}

	public List<PostNT> getPostNts() {
		return this.postNts;
	}

	public void setPostNts(List<PostNT> postNts) {
		this.postNts = postNts;
	}

	public PostNT addPostNt(PostNT postNt) {
		getPostNts().add(postNt);
		postNt.setPlaninaNt(this);

		return postNt;
	}

	public PostNT removePostNt(PostNT postNt) {
		getPostNts().remove(postNt);
		postNt.setPlaninaNt(null);

		return postNt;
	}

	public List<StazaNT> getStazaNts() {
		return this.stazaNts;
	}

	public void setStazaNts(List<StazaNT> stazaNts) {
		this.stazaNts = stazaNts;
	}

	public StazaNT addStazaNt(StazaNT stazaNt) {
		getStazaNts().add(stazaNt);
		stazaNt.setPlaninaNt(this);

		return stazaNt;
	}

	public StazaNT removeStazaNt(StazaNT stazaNt) {
		getStazaNts().remove(stazaNt);
		stazaNt.setPlaninaNt(null);

		return stazaNt;
	}

}