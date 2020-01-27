package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SekretarNT database table.
 * 
 */
@Entity
@NamedQuery(name="SekretarNT.findAll", query="SELECT s FROM SekretarNT s")
public class SekretarNT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSekretar;

	private String imeSekretara;

	private String korisnickoSekretara;

	private String prezimeSekretar;

	private String sifraSekretara;

	public SekretarNT() {
	}

	public int getIdSekretar() {
		return this.idSekretar;
	}

	public void setIdSekretar(int idSekretar) {
		this.idSekretar = idSekretar;
	}

	public String getImeSekretara() {
		return this.imeSekretara;
	}

	public void setImeSekretara(String imeSekretara) {
		this.imeSekretara = imeSekretara;
	}

	public String getKorisnickoSekretara() {
		return this.korisnickoSekretara;
	}

	public void setKorisnickoSekretara(String korisnickoSekretara) {
		this.korisnickoSekretara = korisnickoSekretara;
	}

	public String getPrezimeSekretar() {
		return this.prezimeSekretar;
	}

	public void setPrezimeSekretar(String prezimeSekretar) {
		this.prezimeSekretar = prezimeSekretar;
	}

	public String getSifraSekretara() {
		return this.sifraSekretara;
	}

	public void setSifraSekretara(String sifraSekretara) {
		this.sifraSekretara = sifraSekretara;
	}

}