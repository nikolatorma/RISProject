package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PlaninarNT database table.
 * 
 */
@Entity
@NamedQuery(name="PlaninarNT.findAll", query="SELECT p FROM PlaninarNT p")
public class PlaninarNT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPlaninar;

	private String imePlaninara;

	private String korisnickoPlaninar;

	private String prezimePlaninara;

	private String sifraPlaninara;

	//bi-directional many-to-one association to KomentarNT
	@OneToMany(mappedBy="planinarNt")
	private List<KomentarNT> komentarNts;

	//bi-directional many-to-one association to PostNT
	@OneToMany(mappedBy="planinarNt")
	private List<PostNT> postNts;

	//bi-directional many-to-one association to RezervacijaNT
	@OneToMany(mappedBy="planinarNt")
	private List<RezervacijaNT> rezervacijaNts;

	//bi-directional many-to-one association to TerminNT
	@OneToMany(mappedBy="planinarNt")
	private List<TerminNT> terminNts;

	public PlaninarNT() {
	}

	public int getIdPlaninar() {
		return this.idPlaninar;
	}

	public void setIdPlaninar(int idPlaninar) {
		this.idPlaninar = idPlaninar;
	}

	public String getImePlaninara() {
		return this.imePlaninara;
	}

	public void setImePlaninara(String imePlaninara) {
		this.imePlaninara = imePlaninara;
	}

	public String getKorisnickoPlaninar() {
		return this.korisnickoPlaninar;
	}

	public void setKorisnickoPlaninar(String korisnickoPlaninar) {
		this.korisnickoPlaninar = korisnickoPlaninar;
	}

	public String getPrezimePlaninara() {
		return this.prezimePlaninara;
	}

	public void setPrezimePlaninara(String prezimePlaninara) {
		this.prezimePlaninara = prezimePlaninara;
	}

	public String getSifraPlaninara() {
		return this.sifraPlaninara;
	}

	public void setSifraPlaninara(String sifraPlaninara) {
		this.sifraPlaninara = sifraPlaninara;
	}

	public List<KomentarNT> getKomentarNts() {
		return this.komentarNts;
	}

	public void setKomentarNts(List<KomentarNT> komentarNts) {
		this.komentarNts = komentarNts;
	}

	public KomentarNT addKomentarNt(KomentarNT komentarNt) {
		getKomentarNts().add(komentarNt);
		komentarNt.setPlaninarNt(this);

		return komentarNt;
	}

	public KomentarNT removeKomentarNt(KomentarNT komentarNt) {
		getKomentarNts().remove(komentarNt);
		komentarNt.setPlaninarNt(null);

		return komentarNt;
	}

	public List<PostNT> getPostNts() {
		return this.postNts;
	}

	public void setPostNts(List<PostNT> postNts) {
		this.postNts = postNts;
	}

	public PostNT addPostNt(PostNT postNt) {
		getPostNts().add(postNt);
		postNt.setPlaninarNt(this);

		return postNt;
	}

	public PostNT removePostNt(PostNT postNt) {
		getPostNts().remove(postNt);
		postNt.setPlaninarNt(null);

		return postNt;
	}

	public List<RezervacijaNT> getRezervacijaNts() {
		return this.rezervacijaNts;
	}

	public void setRezervacijaNts(List<RezervacijaNT> rezervacijaNts) {
		this.rezervacijaNts = rezervacijaNts;
	}

	public RezervacijaNT addRezervacijaNt(RezervacijaNT rezervacijaNt) {
		getRezervacijaNts().add(rezervacijaNt);
		rezervacijaNt.setPlaninarNt(this);

		return rezervacijaNt;
	}

	public RezervacijaNT removeRezervacijaNt(RezervacijaNT rezervacijaNt) {
		getRezervacijaNts().remove(rezervacijaNt);
		rezervacijaNt.setPlaninarNt(null);

		return rezervacijaNt;
	}

	public List<TerminNT> getTerminNts() {
		return this.terminNts;
	}

	public void setTerminNts(List<TerminNT> terminNts) {
		this.terminNts = terminNts;
	}

	public TerminNT addTerminNt(TerminNT terminNt) {
		getTerminNts().add(terminNt);
		terminNt.setPlaninarNt(this);

		return terminNt;
	}

	public TerminNT removeTerminNt(TerminNT terminNt) {
		getTerminNts().remove(terminNt);
		terminNt.setPlaninarNt(null);

		return terminNt;
	}

}