package matcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReaderInputFileWithData {
    private final File path;
    private String[] in1;
    private String[] in2;

    public ReaderInputFileWithData(File path) throws Exception{
        this.path = path;
        setIn1In2();
    }

    public String[] getFirstPartData() {
        return in1;
    }

    public String[] getSecondPartData() {
        return in2;
    }

    private void setIn1In2 () throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        int size1 = Integer.parseInt(reader.readLine());
        in1 = new String[size1];
        for (int i = 0; i < size1; i++) {
            in1[i] = reader.readLine();
        }
        int size2 = Integer.parseInt(reader.readLine());
        in2 = new String[size2];
        for (int i = 0; i < size2; i++) {
            in2[i] = reader.readLine();
        }
    }
}
