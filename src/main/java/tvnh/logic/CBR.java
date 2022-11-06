package tvnh.logic;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import tvnh.entity.Cases;
import tvnh.entity.Quality;

public class CBR {
	public static Quality logicCBR(List<Cases> cases, Cases cInput) {
		int wOdor = 3;
		int wColor = 2;
		int wSize = 1;
		int wWeight = 1;
		
		HashMap<Cases, Double> similarResults = new HashMap<>();

		cases.forEach((caseItem) -> {
			double similarSize = similarSizeWeight(convertToWSize(caseItem.getSize().getId()),
					convertToWSize(cInput.getSize().getId()));

			double similarWeight = similarSizeWeight(convertToWSize(caseItem.getWeight().getId()),
					convertToWSize(cInput.getWeight().getId()));

			double similarColor = similarColorOdor(caseItem.getColor().getId(), cInput.getColor().getId());

			double similarOdor = similarColorOdor(caseItem.getOdor().getId(), cInput.getOdor().getId());

			double similar = ( (similarOdor * wOdor) + (similarColor * wColor) + (similarSize * wSize)+ (similarWeight * wWeight) )
					          / (wColor + wOdor + wSize + wWeight);
			
			similarResults.put(caseItem, similar);
		});
		
		LinkedHashMap<Cases, Double> similarResultsSort = new LinkedHashMap<>();
		
		similarResults.entrySet().stream().sorted(Map.Entry.<Cases, Double>comparingByValue(Comparator.reverseOrder()))
		.forEach(x -> similarResultsSort.put(x.getKey(), x.getValue()));
		
		System.out.println("-------------- SORT ---------------------");
		similarResultsSort.forEach((key, value) -> System.out.println(key.getId() + " " + value));
		
		Cases result = (Cases) similarResultsSort.entrySet().iterator().next().getKey();
		
		if(result != null) return result.getQuality();
		return null;
	}

	public static double convertToWSize(Integer id) {
		double small = 0;
		double medium = 0.5;
		double large = 1;

		if (id == 1)
			return small;
		if (id == 2)
			return medium;
		return large;
	}

	public static double similarSizeWeight(double sizeCasesDB, double sizeCasesInput) {
		double driff = Math.abs(sizeCasesDB - sizeCasesInput);
		if (driff == 0.5)
			return driff;
		if (driff == 0)
			return 1;
		return 0;
	}

	public static double similarColorOdor(Integer idCasesDB, Integer idCasesInput) {
		if (idCasesDB == idCasesInput)
			return 1;
		return 0;
	}
}
