package pl.anikiel.testing;

import java.io.*;

public class OrderBackup {
    private Writer writer;

    public Writer getWriter() {
        return writer;
    }

    void createFile() throws FileNotFoundException {
        File file = new File("orderBackup.txt");
        FileOutputStream fileInputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileInputStream);

        writer = new BufferedWriter(outputStreamWriter);
    }

    void backupOrder(Order order) throws IOException {
        writer.append(order.toString());
    }

    void closeFile() throws IOException {
        writer.close();
    }
}
