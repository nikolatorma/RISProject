package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SlikeNT database table.
 * 
 */
@Entity
@NamedQuery(name="SlikeNT.findAll", query="SELECT s FROM SlikeNT s")
public class SlikeNT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSlikeZnamenitosti;

	private String putanjaSZ;

	//bi-directional many-to-one association to ZnamenitostNT
	@ManyToOne
	@JoinColumn(name="Znamenitost_idZnamenitost")
	private ZnamenitostNT znamenitostNt;

	public SlikeNT() {
	}

	public int getIdSlikeZnamenitosti() {
		return this.idSlikeZnamenitosti;
	}

	public void setIdSlikeZnamenitosti(int idSlikeZnamenitosti) {
		this.idSlikeZnamenitosti = idSlikeZnamenitosti;
	}

	public String getPutanjaSZ() {
		return this.putanjaSZ;
	}

	public void setPutanjaSZ(String putanjaSZ) {
		this.putanjaSZ = putanjaSZ;
	}

	public ZnamenitostNT getZnamenitostNt() {
		return this.znamenitostNt;
	}

	public void setZnamenitostNt(ZnamenitostNT znamenitostNt) {
		this.znamenitostNt = znamenitostNt;
	}

}