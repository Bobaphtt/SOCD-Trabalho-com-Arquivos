package socd;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Atividade2 {

    public static void main(String[] args) throws IOException {

        File file = null;
        DataCleaner dc = new DataCleaner();
        Path path;

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
                
                File fileCopy = file;

                switch (dc.solverFounder(texto)) {
                    case "BICG_CLASSIC":
                        
                        path = Paths.get("Logs\\" + i + "\\BICG_CLASSIC");
                        if (!Files.exists(path)) {
                            try {
                                Files.createDirectories(path);
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                        }
                        
                                                
                        fileCopy.renameTo(new File("Logs\\" + i + "\\BICG_CLASSIC\\BICG_CLASSIC.log"));
                        
                        break;
                    case "BICGSTAB_CLASSIC":
                        path = Paths.get("Logs\\" + i + "\\BICGSTAB_CLASSIC");
                        if (!Files.exists(path)) {
                            try {
                                Files.createDirectories(path);
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                        }
                                                
                        file.renameTo(new File("Logs\\" + i + "\\BICGSTAB_CLASSIC\\BICGSTAB_CLASSIC.log"));
                        
                        break;
                    case "BICGSTAB_IMPROVED":
                        path = Paths.get("Logs\\" + i + "\\BICGSTAB_IMPROVED");
                        if (!Files.exists(path)) {
                            try {
                                Files.createDirectories(path);
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                        }
                        try {
                            file.renameTo(new File("Logs\\" + i + "\\BICGSTAB_IMPROVED\\BICGSTAB_IMPROVED.log"));
                        } catch(Error ioe){
                            System.out.println("Erro nesse");
                        }
                        
                        
                        break;
                        
                    case "CG_QUADRATICO":
                        path = Paths.get("Logs\\" + i + "\\CG_QUADRATICO");
                        if (!Files.exists(path)) {
                            try {
                                Files.createDirectories(path);
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                        }
                        
                        file.renameTo(new File("Logs\\" + i + "\\CG_QUADRATICO\\CG_QUADRATICO.log"));
                        
                        break;
                }

            }
        }

    }
}
