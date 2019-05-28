package socd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Atividade1 {

    public static void main(String[] args) throws IOException {
        File file = null;
        DataCleaner dc = new DataCleaner();
        String text1 = dc.dataOrganizer("DIM", "PONTOS", "SOLVER", "TEMPOTOTAL");
        System.out.println(text1 + "\n");
        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("Output.txt"))) {
            writer2.write(text1);
        }
        for (int i = 20; i <= 400; i += 20) {
            for (int j = 0; j < 4; j++) {
                switch (j) {
                    case 0:
                        file = new File("F7F8F9/main_" + i + "_SOLVERCLASS_BICG_CLASSIC_MLS.log");
                        break;
                    case 1:
                        file = new File("F7F8F9/main_" + i + "_SOLVERCLASS_BICGSTAB_CLASSIC_MLS.log");
                        break;
                    case 2:
                        file = new File("F7F8F9/main_" + i + "_SOLVERCLASS_BICGSTAB_IMPROVED_MLS.log");
                        break;
                    case 3:
                        file = new File("F7F8F9/main_" + i + "_SOLVERCLASS_CGS_MLS.log");
                        break;
                }
                
                String texto = dc.fileReader(file);
                String pts = dc.pointsFounder(texto);
                String solver = dc.solverFounder(texto);
                String time = dc.timeFounder(texto);

                String text = dc.dataOrganizer(Integer.toString(i), pts, solver,time);

                System.out.println(text);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Output.txt", true))) {
                    writer.append("\n");
                    writer.append(text);
                }
            }
        }
    }
}
