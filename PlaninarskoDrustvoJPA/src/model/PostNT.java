package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PostNT database table.
 * 
 */
@Entity
@NamedQuery(name="PostNT.findAll", query="SELECT p FROM PostNT p")
public class PostNT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPost;

	@Lob
	private String izvestaj;

	private String putanjaSP;

	//bi-directional many-to-one association to PlaninaNT
	@ManyToOne
	@JoinColumn(name="Planina_idPlanina")
	private PlaninaNT planinaNt;

	//bi-directional many-to-one association to PlaninarNT
	@ManyToOne
	@JoinColumn(name="Planinar_idPlaninar")
	private PlaninarNT planinarNt;

	public PostNT() {
	}

	public int getIdPost() {
		return this.idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public String getIzvestaj() {
		return this.izvestaj;
	}

	public void setIzvestaj(String izvestaj) {
		this.izvestaj = izvestaj;
	}

	public String getPutanjaSP() {
		return this.putanjaSP;
	}

	public void setPutanjaSP(String putanjaSP) {
		this.putanjaSP = putanjaSP;
	}

	public PlaninaNT getPlaninaNt() {
		return this.planinaNt;
	}

	public void setPlaninaNt(PlaninaNT planinaNt) {
		this.planinaNt = planinaNt;
	}

	public PlaninarNT getPlaninarNt() {
		return this.planinarNt;
	}

	public void setPlaninarNt(PlaninarNT planinarNt) {
		this.planinarNt = planinarNt;
	}

}