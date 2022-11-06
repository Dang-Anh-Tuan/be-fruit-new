package tvnh.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tvnh.dto.CaseTest;


public class ReadCasesTest {

	public static List<CaseTest> readExcel() throws IOException {
		final String excelFilePath = "E:\\Mon hoc\\nam5_ki1_KBS_Develop\\test.xlsx";
		List<CaseTest> listCases = new ArrayList<>();

		// Get file
		InputStream inputStream = new FileInputStream(new File(excelFilePath));

		// Get workbook
		Workbook workbook = getWorkbook(inputStream, excelFilePath);

		// Get sheet
		Sheet sheet = workbook.getSheetAt(0);

		// Get all rows
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0) {
				// Ignore header
				continue;
			}

			// Get all cells
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			// Read cells and set value for book object
			CaseTest cases = new CaseTest();
			while (cellIterator.hasNext()) {
				// Read cell
				Cell cell = cellIterator.next();
				Object cellValue = getCellValue(cell);
				if (cellValue == null || cellValue.toString().isEmpty()) {
					continue;
				}

				int columnIndex = cell.getColumnIndex();
				switch (columnIndex) {
				case 0:

					break;
				case 1:
					cases.setIdFruit((Double) getCellValue(cell));
					break;
				case 2:
					cases.setIdSize((Double) getCellValue(cell));
					break;
				case 3:
					cases.setIdWeight((Double) getCellValue(cell));
					break;
				case 4:
					cases.setIdColor((Double) getCellValue(cell));
					break;
				case 5:
					cases.setIdOdor((Double) getCellValue(cell));
					break;
				case 6:
					cases.setIdQuality((Double) getCellValue(cell));
					break;
				default:
					break;
				}

			}
			listCases.add(cases);
		}

		workbook.close();
		inputStream.close();

		return listCases;
	}

	private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
		Workbook workbook = null;
		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}

		return workbook;
	}

	private static Object getCellValue(Cell cell) {
		CellType cellType = cell.getCellTypeEnum();
		Object cellValue = null;
		switch (cellType) {
		case BOOLEAN:
			cellValue = cell.getBooleanCellValue();
			break;
		case FORMULA:
			Workbook workbook = cell.getSheet().getWorkbook();
			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			cellValue = evaluator.evaluate(cell).getNumberValue();
			break;
		case NUMERIC:
			cellValue = cell.getNumericCellValue();
			break;
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case _NONE:
		case BLANK:
		case ERROR:
			break;
		default:
			break;
		}

		return cellValue;
	}
}
