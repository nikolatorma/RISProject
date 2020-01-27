package com.project.pd.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.pd.repository.DomRepository;
import com.project.pd.repository.KomentarRepository;
import com.project.pd.repository.PlaninaRepository;
import com.project.pd.repository.PlaninarRepository;
import com.project.pd.repository.PostRepository;
import com.project.pd.repository.RezervacijaRepository;
import com.project.pd.repository.SekretarRepository;
import com.project.pd.repository.StazaRepository;
import com.project.pd.repository.TerminRepository;
import com.project.pd.repository.ZnamenitostRepository;

import model.DomNT;
import model.KomentarNT;
import model.PlaninaNT;
import model.PlaninarNT;
import model.PostNT;
import model.RezervacijaNT;
import model.StazaNT;
import model.TerminNT;
import model.ZnamenitostNT;

@Controller
@RequestMapping(value = "/PlaninarskoDrustvoController")
public class PlaninarskoDrustvoController {

	@Autowired
	RezervacijaRepository rr;

	@Autowired
	PlaninaRepository pr;

	@Autowired
	PlaninarRepository prr;

	@Autowired
	DomRepository dr;

	@Autowired
	TerminRepository tr;

	@Autowired
	KomentarRepository kr;

	@Autowired
	StazaRepository sr;

	@Autowired
	PostRepository por;

	@Autowired
	ZnamenitostRepository zr;

	@Autowired
	SekretarRepository ser;

	@RequestMapping(value = "/logIn", method = RequestMethod.POST)
	public String logPlaninar(String korisnickoPlaninar, String sifraPlaninara, HttpServletRequest request, Model m) {

		PlaninarNT p = prr.findByKorisnickoPlaninarSifraPlaninara(korisnickoPlaninar, sifraPlaninara);
		if (p == null) {
			m.addAttribute("poruka", "Pogresno uneto korisnicko ime ili lozinka, pokusajte ponovo.");
			return "index";
		}
		request.getSession().setAttribute("planinar", p);
		return "naslovna";
	}
	
	@RequestMapping(value = "/izlistajPlaninare", method = RequestMethod.GET)
	public String dobaviPlaninare(HttpServletRequest request) {

		List<PlaninarNT> planinari = prr.findAll();
		request.getSession().setAttribute("planinari", planinari);
		return "planinar";
	}

	@RequestMapping(value = "/izlistajPlanine", method = RequestMethod.GET)
	public String dobaviPlanine(HttpServletRequest request) {

		List<PlaninaNT> planine = pr.findAll();
		request.getSession().setAttribute("planine", planine);
		return "planine";
	}
	
	@RequestMapping(value = "/izlistajNaloge", method = RequestMethod.GET)
	public String dobaviNaloge(HttpServletRequest request) {

		return "nalozi";
	}
	
	@RequestMapping(value = "/izlistajPostove", method = RequestMethod.GET)
	public String dobaviPostove(String planinar, HttpServletRequest request) {

		PlaninarNT p = prr.findById(Integer.parseInt("planinar")).get();
		List<PostNT> postovi = por.findByPlaninarNt(p);
		request.getSession().setAttribute("postovi", postovi);
		return "postovi";
	}
	
	@RequestMapping(value = "/izlistajPostovePlanine", method = RequestMethod.GET)
	public String dobaviPostovePlanine(String planina, HttpServletRequest request) {

		PlaninaNT p = pr.findById(Integer.parseInt("planina")).get();
		List<PostNT> postovi = por.findByPlaninaNt(p);
		request.getSession().setAttribute("postovi", postovi);
		return "postovi";
	}
	
	@RequestMapping(value = "/postovi", method = RequestMethod.POST)
	public String dodajPost(String planinar, String planina, String izvestaj, HttpServletRequest request, Model m, @RequestParam("picture") MultipartFile picture) {

		PlaninarNT p = prr.findById(Integer.parseInt(planinar)).get();
		PlaninaNT pl = pr.findById(Integer.parseInt(planina)).get();
		Path fileNameAndPath = Paths.get("src/main/webapp/slikePostova",picture.getOriginalFilename());
		try {
			Files.write(fileNameAndPath, picture.getBytes());
		}catch (IOException e){
			e.printStackTrace();
		}
		PostNT po = new PostNT();
		po.setIzvestaj(izvestaj);
		po.setPlaninaNt(pl);
		po.setPlaninarNt(p);
		po.setPutanjaSP("../slikePortal/"+picture.getOriginalFilename());
		por.save(po);
		p.getPostNts().add(po);
		pl.getPostNts().add(po);
		request.getSession().setAttribute("planinar", p);
		request.getSession().setAttribute("planina", pl);
		List<PostNT> postovi = por.findByPlaninarNt(p);
		request.getSession().setAttribute("postovi", postovi);
		return "postovi";
	}
	
	@RequestMapping(value = "/izlistajDomove", method = RequestMethod.GET)
	public String dobaviDomove(String planina, HttpServletRequest request, Model m) {

		Integer idDomNT = Integer.parseInt(planina);
		PlaninaNT p = pr.findById(idDomNT).get();
		List<DomNT> domovi = dr.findByPlaninaNt(p);
		request.getSession().setAttribute("domovi", domovi);
		request.getSession().setAttribute("planina", p);
		
		m.addAttribute("poruka", "Planine:" + p.getNazivPlanine());
	
		return "domovi";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,true));
	}

	
	@RequestMapping(value = "/izlistajRezervacije", method = RequestMethod.GET)
	public String dobaviRezervaciju(String dom, HttpServletRequest request) {

		DomNT d = dr.findById(Integer.parseInt(dom)).get();
		request.getSession().setAttribute("dom", d);
		return "rezervacija";
	}
	
	
	@RequestMapping(value = "/rezervacija", method = RequestMethod.POST)
	public String rezervisiMesto(Date datumOd, Date datumDo, HttpServletRequest request, Model m) {

		LocalDate localDate = LocalDate.now();
		Date dateNow = java.sql.Date.valueOf(localDate);
		if(datumOd.compareTo(dateNow) < 0 || datumDo.compareTo(dateNow) < 0 || datumDo.compareTo(datumOd) < 0) {
			m.addAttribute("poruka", "Uneli ste pogresan datum.");
			return "rezervacija";
		}
		
		DomNT d = (DomNT)request.getSession().getAttribute("dom");
		if(d.getBrojSlobodnihMesta()==0) {
			m.addAttribute("poruka","Rezervacija neuspesna. Popunjen kapacitet doma.");
			return "naslovna";
		}
		
		PlaninarNT p = (PlaninarNT) request.getSession().getAttribute("planinar");
		RezervacijaNT rezervacija = new RezervacijaNT();
		rezervacija.setDatumOd(datumOd);
		rezervacija.setDatumDo(datumDo);
		rezervacija.setDomNt(d);
		rezervacija.setPlaninarNt(p);
		RezervacijaNT rez = rr.save(rezervacija);
		p.getRezervacijaNts().add(rezervacija);
		if(rez != null) {
			dr.smanjiBrojSlobodnihMestaUDomu(d);
			d.setBrojSlobodnihMesta(d.getBrojSlobodnihMesta()-1);
			m.addAttribute("poruka", "Uspesno ste rezervisali mesto u domu: " + d.getNazivDoma() + "u terminu od: " + rezervacija.getDatumOd() + "do: " + rezervacija.getDatumDo());
			request.getSession().setAttribute("dom", d);
			request.getSession().setAttribute("planinar", p);
		} else {
			m.addAttribute("poruka", "Rezervacija nije uspela. Pokusajte ponovo.");
		}
		return "naslovna";
	}
	
	@RequestMapping(value = "/brisanjeRezervacije", method = RequestMethod.GET)
	public String obrisiRezervaciju(String rezervacija, HttpServletRequest request) {

		RezervacijaNT r = rr.findById(Integer.parseInt(rezervacija)).get();
		DomNT d = (DomNT) request.getSession().getAttribute("dom");
		rr.delete(r);
		dr.povecajBrojSlobodnihMestaUDomu(d);
		d.setBrojSlobodnihMesta(d.getBrojSlobodnihMesta()+1);
		PlaninarNT p = (PlaninarNT) request.getSession().getAttribute("planinar");
		p.setRezervacijaNts(rr.findByPlaninarNt(p));
		request.getSession().setAttribute("dom", d);
		request.getSession().setAttribute("planinar", p);
		
		return "planinar";
	}
	
	@RequestMapping(value = "/izlistajStaze", method = RequestMethod.GET)
	public String dobaviStaze(String planina, HttpServletRequest request) {

		PlaninaNT p = pr.findById(Integer.parseInt(planina)).get();
		List<StazaNT> staze = sr.findByPlaninaNt(p);
		request.getSession().setAttribute("planina", p);
		request.getSession().setAttribute("staze", staze);
		return "staze";
	}
	
	@RequestMapping(value = "/izlistajZnamenitosti", method = RequestMethod.GET)
	public String dobaviZnamenitosti(String staza, HttpServletRequest request) {

		StazaNT s = sr.findById(Integer.parseInt(staza)).get();
		List<ZnamenitostNT> znamenitosti = zr.findByStazaNt(s);
		request.getSession().setAttribute("znamenitost", znamenitosti);
		return "znamenitosti";
	}
	
	@RequestMapping(value = "/komentari", method = RequestMethod.POST)
	public String dodajKomentar(String komentar, String staza, String znamenitost, HttpServletRequest request) {

		KomentarNT k = new KomentarNT();
		ZnamenitostNT z = zr.findById(Integer.parseInt(znamenitost)).get();
		k.setKomentar(komentar);
		k.setPlaninarNt((PlaninarNT)request.getSession().getAttribute("planinar"));
		k.setZnamenitostNt(z);
		kr.save(k);
		
		StazaNT s = sr.findById(Integer.parseInt(staza)).get();
		List<ZnamenitostNT> znamenitosti = zr.findByStazaNt(s);
		request.getSession().setAttribute("znamenitost", znamenitosti);
		return "znamenitosti";
	}
	
	@RequestMapping(value = "/izlistajTermine", method = RequestMethod.GET)
	public String dobaviTermine(String znamenitost, HttpServletRequest request) {

		ZnamenitostNT z = zr.findById(Integer.parseInt(znamenitost)).get();
		request.getSession().setAttribute("znamenitost", z);
		return "obilazakZnamenitost";
	}
	
	@RequestMapping(value = "/rezervacijaTermina", method = RequestMethod.POST)
	public String zakaziTermin(Date datumObilaska, HttpServletRequest request, Model m) {

		LocalDate localDate = LocalDate.now();
		Date dateNow = java.sql.Date.valueOf(localDate);
		if(datumObilaska.compareTo(dateNow) < 0) {
			m.addAttribute("poruka", "Uneli ste pogresan datum.");
			return "obilazakZnamenitost";
		}
		ZnamenitostNT z = (ZnamenitostNT)request.getSession().getAttribute("znamenitost");
		PlaninarNT p = (PlaninarNT)request.getSession().getAttribute("planinar");
		TerminNT t = new TerminNT();
		t.setDatumObilaska(datumObilaska);
		t.setPlaninarNt(p);
		t.setZnamenitostNt(z);
		TerminNT ter = tr.save(t);
		p.getTerminNts().add(t);
		if(ter != null) {
			m.addAttribute("poruka", "Uspesno ste rezervisali termin za posetu znamenitosti: " + z.getTip() + "za datum: " + t.getDatumObilaska());
			request.getSession().setAttribute("planinar", p);
			request.getSession().setAttribute("znamenitost", z);
		}else {
			m.addAttribute("poruka", "Rezervacija termina neuspesna. Pokusajte ponovo.");
		}
		return "naslovna";
	}

}
