package tvnh.web.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tvnh.dto.CaseTest;
import tvnh.entity.Cases;
import tvnh.logic.ReadCasesTest;
import tvnh.service.CasesService;
import tvnh.service.GuessQualityService;


@RestController
@RequestMapping(path = "/api/test-cases", produces = "application/json")
@CrossOrigin(origins = "*")
public class TestCases {

	
	@Autowired
	private GuessQualityService guessQualityService;
	
	@GetMapping
	public void getAll() throws IOException {
		List<CaseTest> listCasesTest = ReadCasesTest.readExcel();
		
		guessQualityService.checkTestCase(listCasesTest);
	}
}
