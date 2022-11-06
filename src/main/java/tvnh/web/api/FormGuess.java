package tvnh.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.dto.InfoFormGuessDTO;
import tvnh.entity.Cases;
import tvnh.entity.Color;
import tvnh.entity.Fruit;
import tvnh.entity.Odor;
import tvnh.entity.Quality;
import tvnh.entity.Size;
import tvnh.entity.Weight;
import tvnh.service.ColorService;
import tvnh.service.FruitService;
import tvnh.service.GuessQualityService;
import tvnh.service.OdorService;
import tvnh.service.SizeService;
import tvnh.service.WeightService;

@RestController
@RequestMapping(path = "/api/form-guess", produces = "application/json")
@CrossOrigin(origins = "*")
public class FormGuess {

	
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
	private GuessQualityService guessQualityService;
	
	@PostMapping("/guess")
	public Quality guessQuality(@RequestBody InfoFormGuessDTO infoFormGuessDTO) {		
		Fruit fruit = fruitService.getById(infoFormGuessDTO.getIdFruit());
		Size size = sizeService.getById(infoFormGuessDTO.getIdSize());
		Weight weight = weightService.getById(infoFormGuessDTO.getIdWeight());
		Color color = colorService.getByID(infoFormGuessDTO.getIdColor());
		Odor odor = orOdorService.getById(infoFormGuessDTO.getIdOdor());
		
		Cases c = new Cases();
		c.setFruit(fruit);
		c.setSize(size);
		c.setWeight(weight);
		c.setOdor(odor);
		c.setColor(color);
		
		Quality result = guessQualityService.guessQuality(c);
		
		return result;
	}
}
