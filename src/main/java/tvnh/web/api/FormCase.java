package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.dto.InfoFormCaseDTO;
import tvnh.dto.ResultFormCaseDTO;
import tvnh.entity.Cases;
import tvnh.entity.Color;
import tvnh.entity.Fruit;
import tvnh.entity.Odor;
import tvnh.entity.Quality;
import tvnh.entity.Size;
import tvnh.entity.Weight;
import tvnh.service.CasesService;
import tvnh.service.ColorService;
import tvnh.service.FruitService;
import tvnh.service.OdorService;
import tvnh.service.QualityService;
import tvnh.service.SizeService;
import tvnh.service.WeightService;

@RestController
@RequestMapping(path = "/api/form-case", produces = "application/json")
@CrossOrigin(origins = "*")
public class FormCase {

	
	@Autowired
	private FruitService fruitService;
	
	@Autowired
	private SizeService sizeService;
	
	@Autowired
	private WeightService weightService;
	
	@Autowired
	private ColorService colorService;
	
	@Autowired
	private OdorService orOdorService;
	
	@Autowired 
	private QualityService qualityService;
	
	@Autowired 
	private CasesService casesService;
	
	@GetMapping("/get-info")
	public InfoFormCaseDTO getAll(){
		List<Fruit> fruit = fruitService.getAll();
		List<Size> size = sizeService.getAll();
		List<Weight> weight = weightService.getAll();
		List<Color> color = colorService.getAll();
		List<Odor> odor = orOdorService.getAll();
		List<Quality> quality = qualityService.getAll();
		
		InfoFormCaseDTO infoFormCaseDTO = new InfoFormCaseDTO();
		infoFormCaseDTO.setFruit(fruit);
		infoFormCaseDTO.setColor(color);
		infoFormCaseDTO.setOdor(odor);
		infoFormCaseDTO.setQuality(quality);
		infoFormCaseDTO.setSize(size);
		infoFormCaseDTO.setWeight(weight);
		
		return infoFormCaseDTO;
	}
	
	
	@GetMapping("/create")
	public ResultFormCaseDTO getinfo()
	{
		ResultFormCaseDTO a = new ResultFormCaseDTO();
		a.setIdFruit(1);
		a.setIdColor(1);
		a.setIdSize(1);
		a.setIdWeight(1);
		a.setIdOdor(1);
		a.setIdQuality(1);

		return a;
	}
	
	@PostMapping("/create")
	public Boolean create(@RequestBody ResultFormCaseDTO resultFormCaseDTO) {
		Fruit fruit = fruitService.getById(resultFormCaseDTO.getIdFruit());
		Size size = sizeService.getById(resultFormCaseDTO.getIdSize());
		Weight weight = weightService.getById(resultFormCaseDTO.getIdWeight());
		Color color = colorService.getByID(resultFormCaseDTO.getIdColor());
		Odor odor = orOdorService.getById(resultFormCaseDTO.getIdOdor());
		Quality quality = qualityService.getById(resultFormCaseDTO.getIdQuality());
		
		Cases c = new Cases();
		c.setFruit(fruit);
		c.setSize(size);
		c.setWeight(weight);
		c.setOdor(odor);
		c.setColor(color);
		c.setQuality(quality);
		
		Boolean result = casesService.create(c);
		
		return result;
	}
}
