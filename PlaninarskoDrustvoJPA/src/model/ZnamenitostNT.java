package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ZnamenitostNT database table.
 * 
 */
@Entity
@NamedQuery(name="ZnamenitostNT.findAll", query="SELECT z FROM ZnamenitostNT z")
public class ZnamenitostNT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZnamenitost;

	@Lob
	private String opisZnamenitosti;

	private String tip;

	//bi-directional many-to-one association to KomentarNT
	@OneToMany(mappedBy="znamenitostNt")
	private List<KomentarNT> komentarNts;

	//bi-directional many-to-one association to SlikeNT
	@OneToMany(mappedBy="znamenitostNt")
	private List<SlikeNT> slikeNts;

	//bi-directional many-to-one association to TerminNT
	@OneToMany(mappedBy="znamenitostNt")
	private List<TerminNT> terminNts;

	//bi-directional many-to-one association to StazaNT
	@ManyToOne
	@JoinColumn(name="Staza_idStaza")
	private StazaNT stazaNt;

	public ZnamenitostNT() {
	}

	public int getIdZnamenitost() {
		return this.idZnamenitost;
	}

	public void setIdZnamenitost(int idZnamenitost) {
		this.idZnamenitost = idZnamenitost;
	}

	public String getOpisZnamenitosti() {
		return this.opisZnamenitosti;
	}

	public void setOpisZnamenitosti(String opisZnamenitosti) {
		this.opisZnamenitosti = opisZnamenitosti;
	}

	public String getTip() {
		return this.tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public List<KomentarNT> getKomentarNts() {
		return this.komentarNts;
	}

	public void setKomentarNts(List<KomentarNT> komentarNts) {
		this.komentarNts = komentarNts;
	}

	public KomentarNT addKomentarNt(KomentarNT komentarNt) {
		getKomentarNts().add(komentarNt);
		komentarNt.setZnamenitostNt(this);

		return komentarNt;
	}

	public KomentarNT removeKomentarNt(KomentarNT komentarNt) {
		getKomentarNts().remove(komentarNt);
		komentarNt.setZnamenitostNt(null);

		return komentarNt;
	}

	public List<SlikeNT> getSlikeNts() {
		return this.slikeNts;
	}

	public void setSlikeNts(List<SlikeNT> slikeNts) {
		this.slikeNts = slikeNts;
	}

	public SlikeNT addSlikeNt(SlikeNT slikeNt) {
		getSlikeNts().add(slikeNt);
		slikeNt.setZnamenitostNt(this);

		return slikeNt;
	}

	public SlikeNT removeSlikeNt(SlikeNT slikeNt) {
		getSlikeNts().remove(slikeNt);
		slikeNt.setZnamenitostNt(null);

		return slikeNt;
	}

	public List<TerminNT> getTerminNts() {
		return this.terminNts;
	}

	public void setTerminNts(List<TerminNT> terminNts) {
		this.terminNts = terminNts;
	}

	public TerminNT addTerminNt(TerminNT terminNt) {
		getTerminNts().add(terminNt);
		terminNt.setZnamenitostNt(this);

		return terminNt;
	}

	public TerminNT removeTerminNt(TerminNT terminNt) {
		getTerminNts().remove(terminNt);
		terminNt.setZnamenitostNt(null);

		return terminNt;
	}

	public StazaNT getStazaNt() {
		return this.stazaNt;
	}

	public void setStazaNt(StazaNT stazaNt) {
		this.stazaNt = stazaNt;
	}

}