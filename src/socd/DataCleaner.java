package socd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class DataCleaner {

    public String dataColector(String dirtyData, String referenceStart, String referenceEnd) {

        int inicio = dirtyData.indexOf(referenceStart) + referenceStart.length();
        int fim = dirtyData.indexOf(referenceEnd, inicio);
        String cleanData = dirtyData.substring(inicio, fim).trim();

        return cleanData;
    }

    public String dataOrganizer(String data1, String data2, String data3, String data4) {
        String fullText = "";
        fullText += data1;
        fullText = this.commaAdd(fullText);
        fullText += data2;
        fullText = this.commaAdd(fullText);
        fullText += data3;
        fullText = this.commaAdd(fullText);
        fullText += data4;
        return fullText;
    }

    public String fileReader(File file) {
        String linha;
        String texto = "";
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));

            while ((linha = input.readLine()) != null) {
                texto += linha + "\n";
            }
            input.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return texto;
    }

    public String commaAdd(String text) {
        text += ",";
        return text;
    }

    public String pointsFounder(String texto) {
        String pts = this.dataColector(texto, "Pontos...:", "\n");
        return pts;
    }

    public String solverFounder(String texto) {
        String solver = this.dataColector(texto, "(GPU)\n[0m[0;31m:::::::::::::::::::::::::::::::::::: ", "\n");
        return solver;
    }

    public String timeFounder(String texto) {
        float tempo1 = Float.parseFloat(this.dataColector(texto, "Tempo de gravacao da matriz em vetor em arquivo: [0;31m", "ms"));
        float tempo2 = Float.parseFloat(this.dataColector(texto, "Tempo de computacao do BiCGstab: [0;31m", "ms"));
        float tempoSec = (tempo1 + tempo2) / 1000;
        String time = Float.toString(tempoSec);
        
        return time;
    }
}
