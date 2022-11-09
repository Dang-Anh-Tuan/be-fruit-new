package tvnh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tvnh.dto.CaseTest;
import tvnh.entity.Cases;
import tvnh.entity.Color;
import tvnh.entity.Fruit;
import tvnh.entity.Odor;
import tvnh.entity.Quality;
import tvnh.entity.Size;
import tvnh.entity.Weight;
import tvnh.logic.CBR;
import tvnh.service.CasesService;
import tvnh.service.ColorService;
import tvnh.service.FruitService;
import tvnh.service.GuessQualityService;
import tvnh.service.OdorService;
import tvnh.service.SizeService;
import tvnh.service.WeightService;

@Service
public class GuessQualityServiceImpl implements GuessQualityService {

	@Autowired
	CasesService casesService;

	@Autowired
	FruitService fruitService;

	@Autowired
	private SizeService sizeService;

	@Autowired
	private WeightService weightService;

	@Autowired
	private ColorService colorService;

	@Autowired
	private OdorService orOdorService;

	@Override
	public Quality guessQuality(Cases c) {
		Fruit currentFruit = c.getFruit();
		List<Cases> cases = casesService.getByFruit(currentFruit);

		return CBR.logicCBR(cases, c);

	}

	@Override
	public void checkTestCase(List<CaseTest> listCaseTest) {
		int countCorrectCase = 0;
		
		for(int i = 0; i < listCaseTest.size(); i++ ) {
			Fruit fruit = fruitService.getById(Integer.valueOf(getIntegerNum(listCaseTest.get(i).getIdFruit().toString())));
			Size size = sizeService.getById(Integer.valueOf(getIntegerNum(listCaseTest.get(i).getIdSize().toString())));
			Weight weight = weightService.getById(Integer.valueOf(getIntegerNum(listCaseTest.get(i).getIdWeight().toString())));
			Color color = colorService.getByID(Integer.valueOf(getIntegerNum(listCaseTest.get(i).getIdColor().toString())));
			Odor odor = orOdorService.getById(Integer.valueOf(getIntegerNum(listCaseTest.get(i).getIdOdor().toString())));

			Cases c = new Cases();
			c.setFruit(fruit);
			c.setSize(size);
			c.setWeight(weight);
			c.setOdor(odor);
			c.setColor(color);
			List<Cases> cases = casesService.getByFruit(fruit);

			Quality quality = CBR.logicCBR(cases, c);
			
			
			if(quality.getId() == Integer.valueOf(getIntegerNum(listCaseTest.get(i).getIdQuality().toString()))){
				countCorrectCase += 1;
			}
		}
		
		System.out.println("Cases correct : " + countCorrectCase);
		System.out.println("Total case test : " + listCaseTest.size());
		System.out.println("% correct : " + ((double)countCorrectCase/listCaseTest.size()) * 100 + "%") ;
	}

	public static String getIntegerNum(String s) {
		String[] parts = s.toString().split("\\.");
		return parts[0];
	}
}
