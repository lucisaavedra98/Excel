import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportarDatosExcel {

    private static final String NOMBRE_DEL_ARCHIVO ="alumnos.xlsx";

    public static void main(String[] args) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Exportar datos en Java");
        Object[][] tipoDeDatos = {
                {"ID", "PC", "NOMBRE", "APELLIDO"},
                {1, 1, "Pepe", "Laureano"},
                {2, 2, "Manuel", "Fernandez"},
                {3, 3, "María", "López"},
                {4, 4, "Gustavo", "Rubalcaba"},
                {5, 5, "Maria", "Hidalgo"},
                {6, 6, "Jose Antonio", "Muñoz"},
                {7, 7, "Manolo", "Perez"},
                {8, 8, "Clara", "Péres"},
                {9, 9, "Francisco", "Pérez"},
                {10, 10, "Rosario", "Bolivar"},
                {11, 11, "Luis", "Zuñiga"},
                {12, 12, "Manuel", "Pelayo"},
                {13, 13, "Rafael", "Montalván"},
                {14, 14, "Tamara", "Pradas"},
                {15, 15, "Antonio", "García"},
                {16, 16, "Javier", "Rosa"},
                {17, 17, "Pepe", "Cortes"},
                {18, 18, "Salvador", "Raya"},
                {19, 19, "Gonzalo", "Salomón"},
                {20, 20, "Antonio", "Colorado"},
                {21, 21, "Lucas", "Sainz"},
                {22, 22, "Mayra", "Torres"}
                
        };

        int numeroDeFila = 0;
        System.out.println("Creando Excel");

        for (Object[] tipoDeDato : tipoDeDatos) {
            Row row = sheet.createRow(numeroDeFila++);
            int colNum = 0;
            for (Object field : tipoDeDato) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(NOMBRE_DEL_ARCHIVO);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Listo");
    }
}